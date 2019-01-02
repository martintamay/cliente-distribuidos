package delivery.order

import com.sma.delivery.beans.order.OrderB
import com.sma.delivery.service.order.IOrderService

class OrderController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    def IOrderService orderService

    def index(){
        redirect(action: "list", id:1,)
    }

    def list(Integer max){
        getPrincipal().properties.each{ k, v -> println "${k}:${v}" }
        def orders
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if(params['text']!=null){
            orders = orderService.find(params['text']);
        }else{
            orders = orderService.getAll(page)
        }
        def next = orderService.getAll(page+1).size();
        [orderInstanceList: orders, orderInstanceTotal: orders?.size(),page: page,next:next]
    }

    def create() {
        [orderInstance: new OrderB(params)]
    }

    def save() {
        def orderInstance = new OrderB(params)
        def newOrder = orderService.save(orderInstance)
        if (!newOrder?.getId()) {
            render(view: "create", model: [orderInstance: orderInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'order.label', default: 'Order'),
                newOrder.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def orderInstance = orderService.getById(id)
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'order.label', default: 'Order'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [orderInstance: orderInstance]
    }

    def update(Long id, Long version) {
        def orderInstance = new OrderB(params)
        orderService.save(orderInstance)
        redirect(action: "list")
    }

    def delete(Integer id){
        orderService.delete(id)
        redirect(action: "list")
    }

    def search(String text){
        def orders = orderService.find(text);
        render(view: "_list", model: [orderInstanceList: orders])
    }

}
