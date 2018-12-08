package delivery.order


import com.sma.delivery.service.order.IOrderService
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OrderController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    //services
    def IOrderService orderService
    @Secured
    def index() {
        redirect(action: "list", params: params)
    }

    @Secured
    def list(Integer max) {
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        def orders = orderService.getAll(page)

        [orderInstanceList: orders, orderInstanceTotal: orders?.size()]
    }
}
