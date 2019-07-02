package delivery.billsDetails

import com.sma.delivery.beans.billsDetails.BillsDetailsB
import com.sma.delivery.service.billsDetails.IBillsDetailsService
import com.sma.delivery.service.bills.IBillsService

class BillsDetailsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    IBillsDetailsService billsDetailsService
    IBillsService billsService

    def index(){
        redirect(action: "list", id:1,)
    }
    def list(Integer max){
        def billsDetails
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if(params['text']!=null){
            billsDetails = billsDetailsService.find(params['text']);
        }else{
            billsDetails= billsDetailsService.getAll(page)
        }
        def next = billsDetailsService.getAll(page+1).size();
        [billsDetailsInstanceList: billsDetails, billsDetailsInstanceTotal: billsDetails?.size(),page: page,next:next]
    }
    def create() {
        [billsDetailsInstance: new BillsDetailsB(params),bills: billsService.getBills()]


    }
    def save() {

        def bills=billsService.getById(Integer.valueOf(params['bills']))
        def newBillsDetails = new BillsDetailsB(params)
        newBillsDetails.setBills(bills)
        def billsDetailsInstance = billsDetailsService.save(newBillsDetails)
        if (!newBillsDetails?.getId()) {
            render(view: "create", model: [billsDetailsInstance: billsDetailsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'billsDetails.label', default: 'BillsDetails'),
                newBillsDetails.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def billsDetailsInstance = billsDetailsService.getById(id)
        if (!billsDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'billsDetails.label', default: 'BillsDetails'),
                    id
            ])
            redirect(action: "list")
            return
        }


        [billsDetailsInstance: billsDetailsInstance,bills:billsService.getBills()]

    }

    def update(Long id, Long version) {
        def bills=billsService.getById(Integer.valueOf(params['bills']))
        def newBillsDetails = new BillsDetailsB(params)
        newBillsDetails.setBills(bills)
        billsDetailsService.save(newBillsDetails)

        redirect(action: "list")
    }

    def delete(Integer id){
        billsDetailsService.delete(id)
        redirect(action: "list")
    }

    def search(String text){
        def billsDetails = billsDetailsService.find(text);
        render(view: "_list", model: [billsDetailsInstanceList: billsDetails])
    }
    def show(Integer id){
        def billsDetailsInstance = billsDetailsService.getById(id)
        [billsDetailsInstance: billsDetailsInstance]
    }
}
