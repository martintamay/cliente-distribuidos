package delivery.orderDetail

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OrderDetailController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond OrderDetail.list(params), model:[orderDetailCount: OrderDetail.count()]
    }

    def show(OrderDetail orderDetail) {
        respond orderDetail
    }

    def create() {
        respond new OrderDetail(params)
    }

    @Transactional
    def save(OrderDetail orderDetail) {
        if (orderDetail == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (orderDetail.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond orderDetail.errors, view:'create'
            return
        }

        orderDetail.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'orderDetail.label', default: 'OrderDetail'), orderDetail.id])
                redirect orderDetail
            }
            '*' { respond orderDetail, [status: CREATED] }
        }
    }

    def edit(OrderDetail orderDetail) {
        respond orderDetail
    }

    @Transactional
    def update(OrderDetail orderDetail) {
        if (orderDetail == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (orderDetail.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond orderDetail.errors, view:'edit'
            return
        }

        orderDetail.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'orderDetail.label', default: 'OrderDetail'), orderDetail.id])
                redirect orderDetail
            }
            '*'{ respond orderDetail, [status: OK] }
        }
    }

    @Transactional
    def delete(OrderDetail orderDetail) {

        if (orderDetail == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        orderDetail.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'orderDetail.label', default: 'OrderDetail'), orderDetail.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderDetail.label', default: 'OrderDetail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
