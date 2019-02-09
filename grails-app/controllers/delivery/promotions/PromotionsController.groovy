package delivery.promotions

import com.sma.delivery.beans.promotions.PromotionsB
import com.sma.delivery.service.promotions.IPromotionsService


class PromotionsController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    def IPromotionsService promotionsService


    def index() {
        redirect(action: "list", id: 1,)
    }

    def list(Integer max) {
        def promotions
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if (params['text'] != null) {
            promotions = promotionsService.find(params['text']);
        } else {
            promotions = promotionsService.getAll(page)
        }
        def next = promotionsService.getAll(page + 1).size();
        [promotionsInstanceList: promotions, promotionsInstanceTotal: promotions?.size(), page: page, next: next]
    }

    def create() {
        [promotionsInstance: new PromotionsB(params)]


    }

    def save() {


        def newPromotions = new PromotionsB(params)

        def promotionsInstance = promotionsService.save(newPromotions)
        if (!newPromotions?.getId()) {
            render(view: "create", model: [promotionsInstance: promotionsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'promotions.label', default: 'Promotions'),
                newPromotions.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def promotionsInstance = promotionsService.getById(id)
        if (!promotionsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'promotions.label', default: 'Promotions'),
                    id
            ])
            redirect(action: "list")
            return
        }


        [promotionsInstance: promotionsInstance]

    }

    def update(Long id, Long version) {

        def newPromotions = new PromotionsB(params)

        promotionsService.save(newPromotions)

        redirect(action: "list")
    }

    def delete(Integer id) {
        promotionsService.delete(id)
        redirect(action: "list")
    }

    def search(String text) {
        def promotions = promotionsService.find(text);
        render(view: "_list", model: [promotionsInstanceList: promotions])
    }

    def show(Integer id) {
        def promotionsInstance = promotionsService.getById(id)
        [promotionsInstance: promotionsInstance]
    }
}