package delivery.order

import com.sma.delivery.beans.order.OrderB
import com.sma.delivery.service.establishments.IEstablishmentsService
import com.sma.delivery.service.order.IOrderService
import com.sma.delivery.service.orderDetails.IOrderDetailService
import com.sma.delivery.service.user.IUserService

class OrderController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    IOrderService orderService
    IOrderDetailService orderDetailsService
    IEstablishmentsService establishmentsService
    IUserService userService

    def index(){
        redirect(action: "list", id:1,)
    }

    def list(Integer max){
        getPrincipal().properties.each{ k, v -> println "${k}:${v}" }
        def orders
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if(params['text']!=null){
            orders = orderService.find(params['text'])
        }else{
            orders = orderService.getAll(page)
        }
        def next = orderService.getAll(page+1).size()
        [orderInstanceList: orders, orderInstanceTotal: orders?.size(),page: page,next:next]
    }

    def create() {
        def action = "create"
        [orderInstance: new OrderB(params),user: userService.getUsers(),establishments: establishmentsService.getEstablishments(), action: action]
    }

    def save() {
        def establishment = establishmentsService.getById(Integer.valueOf(params['establishments']))
        def user=userService.getById(Integer.valueOf(params['user']))
        def newOrder = new OrderB(params)
        newOrder.setEstablishments(establishment)
        newOrder.setUser(user)
        def orderInstance = orderService.save(newOrder)
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
        orderInstance.setDetails(orderDetailsService.getOrderDetailsByOrderId(id))
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'order.label', default: 'Order'),
                    id
            ])
            redirect(action: "list")
            return
        }

        def action = "update"
        [orderInstance: orderInstance,user:userService.getUsers(), establishments: establishmentsService.getEstablishments(), action: action]
    }

    def update(Long id, Long version) {
        System.out.println("\nid: ${id}")

        def data = request.JSON
        System.out.println("params: "+ data.toString())


        def parametros = new HashMap<String,String>()
        parametros.put("order", data.toString())

        def establishments = establishmentsService.getById(Integer.valueOf(data.order.establishments))
        def user=userService.getById(Integer.valueOf(data.order.user))
        def newOrder = new OrderB(parametros)
        newOrder.setEstablishments(establishments)
        newOrder.setUser(user)
        orderService.save(newOrder)

        redirect(action: "list")
    }

    def delete(Integer id){
        orderService.delete(id)
        redirect(action: "list")
    }

    def search(String text,Integer page){
        def orders = orderService.find(text,page)
        def next = orderService.find(text,page+1).size()
        render(view: "_list", model: [orderInstanceList: orders ,next: next,page: page])
    }
    def show(Integer id){
        def orderInstance = orderService.getById(id)
        [orderInstance: orderInstance]
    }
}
