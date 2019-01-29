package delivery.orderDetail

import delivery.order.Order
import delivery.packages.Packages
import delivery.products.Products
import delivery.promotions.Promotions

class OrderDetail {
    int cost;
    int cuantity;
    String comment;
    static belongsTo = [order: Order, products: Products, packages: Packages, promotions: Promotions]
    static constraints = {
    }
}
