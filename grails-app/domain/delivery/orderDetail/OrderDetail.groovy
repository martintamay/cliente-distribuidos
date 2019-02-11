package delivery.orderDetail

import delivery.order.Order
import delivery.packages.Packages
import delivery.products.Products
import delivery.promotion.Promotion

class OrderDetail {
    int cost;
    int cuantity;
    String comment;
    static belongsTo = [order: Order, products: Products, packages: Packages, promotion: Promotion]
    static constraints = {
    }
}
