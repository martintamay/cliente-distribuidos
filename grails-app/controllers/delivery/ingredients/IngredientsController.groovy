package delivery.ingredients

import com.sma.delivery.beans.ingredients.IngredientsB
import com.sma.delivery.service.ingredients.IIngredientsService

class IngredientsController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    def IIngredientsService ingredientsService

    def index(){
        redirect(action: "list", id:1,)
    }
    def list(Integer max){
        def ingredients
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if(params['text']!=null){
            ingredients = ingredientsService.find(params['text']);
        }else{
            ingredients = ingredientsService.getAll(page)
        }
        def next = ingredientsService.getAll(page+1).size();
        [ingredientsInstanceList: ingredients, ingredientsInstanceTotal: ingredients?.size(),page: page,next:next]
    }
    def create() {
        [ingredientsInstance: new IngredientsB(params)]
    }
    def save() {
        def ingredientsInstance = new IngredientsB(params)
        def newEstablishments = ingredientsService.save(ingredientsInstance)
        if (!newEstablishments?.getId()) {
            render(view: "create", model: [ingredientsInstance: ingredientsService])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'ingredients.label', default: 'Establishments'),
                newEstablishments.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def ingredientsInstance = ingredientsService.getById(id)
        if (!ingredientsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'ingredients.label', default: 'Establishments'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [ingredientsInstance: ingredientsInstance]
    }

    def update(Long id, Long version) {
        def ingredientsInstance = new IngredientsB(params)
        ingredientsService.save(ingredientsInstance)
        redirect(action: "list")
    }

    def delete(Integer id){
        ingredientsService.delete(id)
        redirect(action: "list")
    }

    def search(String text){
        def ingredients = ingredientsService.find(text);
        render(view: "_list", model: [ingredientsInstanceList: ingredients])
    }
    def show(Integer id){
        def ingredientsInstance = ingredientsService.getById(id)
        [ingredientsInstance: ingredientsInstance]
    }
}

