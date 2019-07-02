package delivery.bills

import com.sma.delivery.beans.bills.BillsB
import com.sma.delivery.service.bills.IBillsService
import com.sma.delivery.service.billsDetails.IBillsDetailsService
import com.sma.delivery.service.order.IOrderService
import delivery.billsDetails.BillsDetails

class BillsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    IBillsService billsService
    IOrderService orderService
    IBillsDetailsService billsDetailsService

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
        List<BillsDetails> billsDetails = new ArrayList<>()
        [billsInstance: new BillsB(params),order: orderService.getOrders(), billsDetails: billsDetails, action:'save']
    }
    def save() {
        def parametros = new HashMap<String,String>()
        parametros.put("bill", request.JSON.toString())
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
        billsInstance.setDetails(billsDetailsService.getAllBy(p))
        if (!billsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'bills.label', default: 'Bills'),
                    id
            ])
            redirect(action: "list")
            return
        }
        def action = "update"
        [billsInstance: billsInstance, order:orderService.getOrders(), action:action]
    }

    def update(Long id, Long version) {
        def parametros = new HashMap<String,String>()
        parametros.put("bill", request.JSON.toString())
        def order=orderService.getById(Integer.valueOf(request.JSON.bill.order))
        def newBills = new BillsB(parametros)
        newBills.setId(Integer.valueOf(params['id']))
        newBills.setOrder(order)
        System.out.println(".................................... "+ params['id'])
        billsService.save(newBills)

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
        [billsInstance: billsInstance]
    }
}
