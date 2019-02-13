package delivery.products

import com.sma.delivery.beans.products.ProductsB
import com.sma.delivery.service.products.IProductsService
import com.sma.delivery.service.establishments.IEstablishmentsService
import grails.plugin.springsecurity.annotation.Secured


class ProductsController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    def IProductsService productsService
    def IEstablishmentsService establishmentsService
    def index(){
        redirect(action: "list", id:1,)
    }

    @Secured(["ROLE_Admin"])
    def list(Integer max){
        def products
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        products = productsService.getAll(page)
        def next = productsService.getAll(page+1).size();
        [productsInstanceList: products, productsInstanceTotal: products?.size(),page: page,next:next]
    }
    def create() {
        [productsInstance: new ProductsB(params),establishments: establishmentsService.getEstablishments()]


    }
    def save() {

        def establishments = establishmentsService.getById(Integer.valueOf(params['establishments']))
        def newProducts = new ProductsB(params)
        newProducts.setEstablishments(establishments)
        def productsInstance = productsService.save(newProducts)
        if (!newProducts?.getId()) {
            render(view: "create", model: [productsInstance: productsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'products.label', default: 'Products'),
                newProducts.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def productsInstance = productsService.getById(id)
        if (!productsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'products.label', default: 'Products'),
                    id
            ])
            redirect(action: "list")
            return
        }


        [productsInstance: productsInstance, establishments: establishmentsService.getEstablishments()]

    }

    def update(Long id, Long version) {
        def establishments = establishmentsService.getById(Integer.valueOf(params['establishments']))
        def newProducts = new ProductsB(params)
        newProducts.setEstablishments(establishments)
        productsService.save(newProducts)

        redirect(action: "list")
    }

    def delete(Integer id){
        productsService.delete(id)
        redirect(action: "list")
    }

    def search(String text){
        def products = productsService.find(text);
        render(view: "_list", model: [productsInstanceList: products])
    }
    def show(Integer id){
        def productsInstance = productsService.getById(id)
        [productsInstance: productsInstance]
    }
}