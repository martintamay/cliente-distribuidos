package delivery.promotion


import com.sma.delivery.beans.promotions.PromotionsB
import com.sma.delivery.service.products.IProductsService
import com.sma.delivery.service.promotions.IPromotionsService
import delivery.productHasPromotions.ProductHasPromotions
import delivery.products.Products

class PromotionController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    def IPromotionsService promotionsService
    def IProductsService productsService


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
        List<ProductHasPromotions> productHasPromotions = new ArrayList<>()
        [promotionInstance: new PromotionsB(params), productHasPromotions: productHasPromotions, action: 'save']
    }

    def save() {
        def parametros = new HashMap<String, String>()
        parametros.put("promotion", request.JSON.toString())
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
        Map<String, String> p = new HashMap<>()
        if (!promotionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'promotion.label', default: 'Promotion'),
                    id
            ])
            redirect(action: "list")
            return
        }
        def action = "update"
        [promotionInstance: promotionInstance, action: action]

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