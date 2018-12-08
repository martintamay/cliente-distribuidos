package delivery.establishments

import com.sma.delivery.beans.establishments.EstablishmentsB
import com.sma.delivery.service.establishments.IEstablishmentsService

class EstablishmentsController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    def IEstablishmentsService establishmentsService

    def index(){
        redirect(action: "list", id:1,)
    }
    def list(Integer max){
        def establishments
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if(params['text']!=null){
            establishments = establishmentsService.find(params['text']);
        }else{
            establishments = establishmentsService.getAll(page)
        }
        def next = establishmentsService.getAll(page+1).size();
        [establishmentsInstanceList: establishments, establishmentsInstanceTotal: establishments?.size(),page: page,next:next]
    }
    def create() {
        [establishmentsInstance: new EstablishmentsB(params)]
    }
    def save() {
        def establishmentsInstance = new EstablishmentsB(params)
        def newEstablishments = establishmentsService.save(establishmentsInstance)
        if (!newEstablishments?.getId()) {
            render(view: "create", model: [establishmentsInstance: establishmentsService])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'establishments.label', default: 'Establishments'),
                newEstablishments.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def establishmentsInstance = establishmentsService.getById(id)
        if (!establishmentsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'establishments.label', default: 'Establishments'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [establishmentsInstance: establishmentsInstance]
    }

    def update(Long id, Long version) {
        def establishmentsInstance = new EstablishmentsB(params)
        establishmentsService.save(establishmentsInstance)
        redirect(action: "list")
    }

    def delete(Integer id){
        establishmentsService.delete(id)
        redirect(action: "list")
    }

    def search(String text){
        def establishments = establishmentsService.find(text);
        render(view: "_list", model: [establishmentsInstanceList: establishments])
    }
}
