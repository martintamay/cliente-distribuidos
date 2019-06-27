package delivery.promotion

import delivery.orderDetail.OrderDetail
import delivery.productHasPromotions.ProductHasPromotions
import delivery.products.Products


class Promotion {
    String name;
    String available;
    Date end_date;
    static hasMany = [orderDetail: OrderDetail, product: Products, productHasPromotions: ProductHasPromotions]
    static constraints = {
    }
}