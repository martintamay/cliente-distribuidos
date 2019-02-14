package delivery.ingredientsProducts

import com.sma.delivery.service.ingredientsProducts.IIngredientsProductsService

class IngredientsProductsController {
    IIngredientsProductsService ingredientsProductsService

    def index(){
        redirect(action: "list", id:1,)
    }
    def list(Integer max){
    }

    def delete(Integer id){
        ingredientsProductsService.delete(id)
        redirect(action: "list")
    }
}
