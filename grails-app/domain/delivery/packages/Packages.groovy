package delivery.packages

import delivery.orderDetail.OrderDetail
import delivery.productHasPackages.ProductHasPackages
import delivery.products.Products

class Packages {
    String name;
    Integer cost;
    static hasMany = [orderDetail: OrderDetail, product: Products, productHasPackages: ProductHasPackages]
    static constraints = {
    }
}
