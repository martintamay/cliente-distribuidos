package delivery.packages

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PackagesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Packages.list(params), model:[packagesCount: Packages.count()]
    }

    def show(Packages packages) {
        respond packages
    }

    def create() {
        respond new Packages(params)
    }

    @Transactional
    def save(Packages packages) {
        if (packages == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (packages.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond packages.errors, view:'create'
            return
        }

        packages.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'packages.label', default: 'Packages'), packages.id])
                redirect packages
            }
            '*' { respond packages, [status: CREATED] }
        }
    }

    def edit(Packages packages) {
        respond packages
    }

    @Transactional
    def update(Packages packages) {
        if (packages == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (packages.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond packages.errors, view:'edit'
            return
        }

        packages.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'packages.label', default: 'Packages'), packages.id])
                redirect packages
            }
            '*'{ respond packages, [status: OK] }
        }
    }

    @Transactional
    def delete(Packages packages) {

        if (packages == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        packages.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'packages.label', default: 'Packages'), packages.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'packages.label', default: 'Packages'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
