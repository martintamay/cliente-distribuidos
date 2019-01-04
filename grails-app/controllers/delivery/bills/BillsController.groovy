package delivery.bills



import com.sma.delivery.beans.bills.BillsB
import com.sma.delivery.service.bills.IBillsService
import com.sma.delivery.service.order.IOrderService

class BillsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    def IBillsService billsService
    def IOrderService orderService

    def index(){
        redirect(action: "list", id:1,)
    }
    def list(Integer max){
        def bills
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if(params['text']!=null){
            bills = billsService.find(params['text']);
        }else{
            bills= billsService.getAll(page)
        }
        def next = billsService.getAll(page+1).size();
        [billsInstanceList: bills, billsInstanceTotal: bills?.size(),page: page,next:next]
    }
    def create() {
        [billsInstance: new BillsB(params),order: orderService.getOrders()]


    }
    def save() {

        def order=orderService.getById(Integer.valueOf(params['order']))
        def newBills = new BillsB(params)
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
        if (!billsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'bills.label', default: 'Bills'),
                    id
            ])
            redirect(action: "list")
            return
        }


        [billsInstance: billsInstance,order:orderService.getOrders()]

    }

    def update(Long id, Long version) {
        def order=orderService.getById(Integer.valueOf(params['order']))
        def newBills = new BillsB(params)
        newBills.setOrder(order)
        billsService.save(newBills)

        redirect(action: "list")
    }

    def delete(Integer id){
        billsService.delete(id)
        redirect(action: "list")
    }

    def search(String text){
        def bills = billsService.find(text);
        render(view: "_list", model: [billsInstanceList: bills])
    }
}
