package delivery.products

import com.sma.delivery.beans.products.ProductsB
import com.sma.delivery.service.ingredients.IIngredientsService
import com.sma.delivery.service.ingredientsProducts.IIngredientsProductsService
import com.sma.delivery.service.products.IProductsService
import com.sma.delivery.service.establishments.IEstablishmentsService
import delivery.ingredientsProducts.IngredientsProducts


class ProductsController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    IProductsService productsService
    IIngredientsService ingredientsService
    IIngredientsProductsService ingredientsProductsService
    IEstablishmentsService establishmentsService
    def index(){
        redirect(action: "list", id:1,)
    }
    def list(Integer max){
        def products
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        products = productsService.getAll(page)
        def next = productsService.getAll(page+1).size();
        [productsInstanceList: products, productsInstanceTotal: products?.size(),page: page,next:next]
    }

    def create() {
        List<IngredientsProducts> ingredientsProducts = new ArrayList<>()
        [productsInstance: new ProductsB(params),establishments: establishmentsService.getEstablishments(),ingredients: ingredientsService.getAll(1), ingredientesProducts:ingredientsProducts, action:'save']
    }

    def save() {
        def parametros = new HashMap<String,String>();
        parametros.put("product", request.JSON.toString());
        def establishments=establishmentsService.getById(Integer.valueOf(request.JSON.Product.establishments))
        def newProducts = new ProductsB(parametros);
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
        Map <String,String> p = new HashMap<>();
        p.put("productId", id.toString())
        productsInstance.setIngredientsProducts(ingredientsProductsService.getAllBy(p))
        if (!productsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'products.label', default: 'Products'),
                    id
            ])
            redirect(action: "list")
            return
        }


        [productsInstance: productsInstance,ingredients: ingredientsService.getIngredients(), establishments: establishmentsService.getEstablishments(), action:'update']

    }

    def update(Long id, Long version) {
        def parametros = new HashMap<String,String>();
        parametros.put("product", request.JSON.toString());
        def establishments=establishmentsService.getById(Integer.valueOf(request.JSON.Product.establishments))
        def newProduct = new ProductsB(parametros);
        newProduct.setId(Integer.valueOf(params['id']));
        newProduct.setEstablishments(establishments)
        productsService.save(newProduct);
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