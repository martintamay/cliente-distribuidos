package delivery.bills

import com.sma.delivery.beans.bills.BillsB
import com.sma.delivery.service.bills.IBillsService
import com.sma.delivery.service.billsDetails.IBillsDetailsService
import com.sma.delivery.service.order.IOrderService
import com.sma.delivery.service.products.IProductsService
import delivery.billsDetails.BillsDetails
import grails.converters.JSON
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject

class BillsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services

    IBillsService billsService
    IOrderService orderService
    IBillsDetailsService billsDetailsService
    IProductsService productsService
    def index(){
        redirect(action: "list", id:1,)
    }
    def list(Integer max){
        def bills
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        bills= billsService.getAll(page)
        def next = billsService.getAll(page+1).size()
        [billsInstanceList: bills, billsInstanceTotal: bills?.size(),page: page,next:next]
    }
    def create() {
        List<BillsDetails> billsDetails = new ArrayList<>();
        def json = productsService.getProducts() as JSON
        [json: json,billsInstance: new BillsB(params),order: orderService.getOrders(), billsDetails: billsDetails, action:'save']
    }
    def save() {
        redirect(action: "list")
        def parametros = new HashMap<String,String>();
        parametros.put("bill", request.JSON.toString());
        def order=orderService.getById(Integer.valueOf(request.JSON.bill.order))
        def newBills = new BillsB(parametros)
        newBills.setOrder(order)
        def billsInstance = billsService.save(newBills)
        if (!newBills?.getId()) {
            render(view: "create", model: [billsInstance: billsInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args: [
                message(code: 'bills.label', default: 'Bills'),
                newBills.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def billsInstance = billsService.getById(id)
        Map <String,String> p = new HashMap<>()
        p.put("billId", id.toString())
        billsInstance.setBillsDetails(billsDetailsService.getAllBy(p))
        if (!billsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'bills.label', default: 'Bills'),
                    id
            ])
            redirect(action: "list")
            return
        }
        def action = "update"
        def json = productsService.getProducts() as JSON
        [json: json, products: productsService.getProducts(), billsInstance: billsInstance, order:orderService.getOrders(), action:action]
    }

    def update(Long id, Long version) {
        def parametros = new HashMap<String,String>()
        parametros.put("bill", request.JSON.toString())
        def order=orderService.getById(Integer.valueOf(request.JSON.bill.order))
        def newBills = new BillsB(parametros);
        newBills.setBillsDetails(billsDetails(parametros))
        newBills.setId(Integer.valueOf(params['id']));
        newBills.setOrder(order);
        billsService.save(newBills);
        redirect(action: "list")
    }

    def delete(Integer id){
        billsService.delete(id)
        redirect(action: "list")
    }

    def search(String text,Integer page){
        def bills = billsService.find(text,page)
        def next = billsService.find(text,page+1).size()
        render(view: "_list", model: [billsInstanceList: bills ,next: next,page: page])
    }
    def show(Integer id){
        def billsInstance = billsService.getById(id)
        Map <String,String> p = new HashMap<>();
        p.put("billId", id.toString())
        billsInstance.setBillsDetails(billsDetailsService.getAllBy(p))
        [billsInstance: billsInstance]
    }
    def billsDetails(params){
        Set<BillsDetailsB> b = new HashSet<>();
        if(params.get("bill")!=null) {
            JSONObject json = new JSONObject(params.get("bill"));
            if (json.containsKey("BillsDetails")) {
                JSONArray jsonArray = new JSONArray(json.getString("BillsDetails"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject a = (JSONObject) jsonArray.get(i);
                    Map<String, String> p = new HashMap<>();
                    if (a.containsKey("id"))
                        p.put("id", a.getString("id"));
                    p.put("iva10", a.getString("iva10"));
                    p.put("amount", a.getString("amount"));
                    p.put("iva5", a.getString("iva5"));
                    p.put("quantity", a.getString("quantity"));
                    p.put("unitary", a.getString("unitary"));
                    p.put("exenta", a.getString("exenta"));
                    BillsDetailsB detailsB = new BillsDetailsB(p);
                    detailsB.setProduct(productsService.getById(Integer.parseInt(a.get("product"))))
                    b.add(detailsB);
                }
            }
        }
        return b;
    }
}
