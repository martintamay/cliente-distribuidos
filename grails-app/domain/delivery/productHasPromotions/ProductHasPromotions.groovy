package delivery.productHasPromotions

import com.sma.delivery.beans.products.ProductsB
import com.sma.delivery.beans.promotions.PromotionsB

class ProductHasPromotions {
    Integer quantity
    Integer cost
    String comment
    static belongsTo = [product: ProductsB, promotion: PromotionsB]
    static constraints = {
    }
}
