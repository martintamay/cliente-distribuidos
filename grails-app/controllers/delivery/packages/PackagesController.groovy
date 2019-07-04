package delivery.packages

import com.sma.delivery.beans.packages.PackagesB
import com.sma.delivery.service.packages.IPackagesService
import com.sma.delivery.service.productHasPackages.IProductHasPackagesService
import com.sma.delivery.service.products.IProductsService
import delivery.productHasPackages.ProductHasPackages

class PackagesController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    IPackagesService packagesService
    IProductHasPackagesService productHasPackagesService
    IProductsService productsService


    def index() {
        redirect(action: "list", id: 1,)
    }

    def list(Integer max) {
        def packages
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if (params['text'] != null) {
            packages = packagesService.find(params['text'])
        } else {
            packages = packagesService.getAll(page)
        }
        def next = packagesService.getAll(page + 1).size()
        [packagesInstanceList: packages, packagesInstanceTotal: packages?.size(), page: page, next: next]
    }

    def create() {
        List<ProductHasPackages> productHasPromotions = new ArrayList<>()
        [packagesInstance: new PackagesB(params), products: productsService.getProducts(), productHasPackages: productHasPromotions, action: 'save']
    }

    def save() {
        def parametros = new HashMap<String, String>()
        parametros.put("packages", request.JSON.toString())
        def newPackages = new PackagesB(parametros)
        def packagesInstance = packagesService.save(newPackages)
        if (!newPackages?.getId()) {
            render(view: "create", model: [packagesInstance: packagesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'packages.label', default: 'Packages'),
                newPackages.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def packagesInstance = packagesService.getById(id)
        Map <String,String> p = new HashMap<>()
        p.put("packagesId", id.toString())
        packagesInstance.setProductHasPromotions(productHasPackagesService.getAllBy(p))
        if (!packagesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'packages.label', default: 'Packages'),
                    id
            ])
            redirect(action: "list")
            return
        }
        def action = "update"
        [packagesInstance: packagesInstance, products: productsService.getProducts(), action: action]

    }

    def update(Long id, Long version) {
        def parametros = new HashMap<String,String>()
        parametros.put("packages", request.JSON.toString())
        def newPackages = new PackagesB(parametros)
        newPackages.setId(Integer.valueOf(params['id']))
        packagesService.save(newPackages)
        redirect(action: "list")
    }

    def delete(Integer id) {
        packagesService.delete(id)
        redirect(action: "list")
    }

    def search(String text) {
        def packages = packagesService.find(text)
        render(view: "_list", model: [packagesInstanceList: packages])
    }

    def show(Integer id) {
        def packagesInstance = packagesService.getById(id)
        [packagesInstance: packagesInstance]
    }
}

