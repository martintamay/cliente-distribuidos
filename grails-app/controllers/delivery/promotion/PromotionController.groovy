package delivery.promotion


import com.sma.delivery.beans.promotions.PromotionsB
import com.sma.delivery.service.promotions.IPromotionsService
class PromotionController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    def IPromotionsService promotionsService


    def index() {
        redirect(action: "list", id: 1,)
    }

    def list(Integer max) {
        def promotion
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if (params['text'] != null) {
            promotion = promotionsService.find(params['text']);
        } else {
            promotion = promotionsService.getAll(page)
        }
        def next = promotionsService.getAll(page + 1).size();
        [promotionInstanceList: promotion, promotionInstanceTotal: promotion?.size(), page: page, next: next]
    }

    def create() {
        [promotionInstance: new PromotionsB(params)]


    }

    def save() {
        def newPromotion = new PromotionsB(params)

        def promotionInstance = promotionsService.save(newPromotion)
        if (!newPromotion?.getId()) {
            render(view: "create", model: [promotionInstance: promotionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'promotion.label', default: 'Promotion'),
                newPromotion.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def promotionInstance = promotionsService.getById(id)
        if (!promotionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'promotion.label', default: 'Promotion'),
                    id
            ])
            redirect(action: "list")
            return
        }


        [promotionInstance: promotionInstance]

    }

    def update(Long id, Long version) {

        def newPromotion = new PromotionsB(params)

        promotionsService.save(newPromotion)

        redirect(action: "list")
    }

    def delete(Integer id) {
        promotionsService.delete(id)
        redirect(action: "list")
    }

    def search(String text) {
        def promotion = promotionsService.find(text);
        render(view: "_list", model: [promotionInstanceList: promotion])
    }

    def show(Integer id) {
        def promotionInstance = promotionsService.getById(id)
        [promotionInstance: promotionInstance]
    }
}