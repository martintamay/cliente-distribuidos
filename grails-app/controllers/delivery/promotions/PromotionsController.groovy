package delivery.promotions

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PromotionsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Promotions.list(params), model:[promotionsCount: Promotions.count()]
    }

    def show(Promotions promotions) {
        respond promotions
    }

    def create() {
        respond new Promotions(params)
    }

    @Transactional
    def save(Promotions promotions) {
        if (promotions == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (promotions.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond promotions.errors, view:'create'
            return
        }

        promotions.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'promotions.label', default: 'Promotions'), promotions.id])
                redirect promotions
            }
            '*' { respond promotions, [status: CREATED] }
        }
    }

    def edit(Promotions promotions) {
        respond promotions
    }

    @Transactional
    def update(Promotions promotions) {
        if (promotions == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (promotions.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond promotions.errors, view:'edit'
            return
        }

        promotions.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'promotions.label', default: 'Promotions'), promotions.id])
                redirect promotions
            }
            '*'{ respond promotions, [status: OK] }
        }
    }

    @Transactional
    def delete(Promotions promotions) {

        if (promotions == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        promotions.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'promotions.label', default: 'Promotions'), promotions.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'promotions.label', default: 'Promotions'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
