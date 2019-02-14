package delivery.products

import delivery.establishments.Establishments
import delivery.ingredientsProducts.IngredientsProducts
import delivery.orderDetail.OrderDetail

class Products {
    String name
    String description
    Integer cost
    static belongsTo = [establishments: Establishments]
    static hasMany = [orderDetail: OrderDetail, ingredientsProducts: IngredientsProducts]
    static constraints = {
    }
}
