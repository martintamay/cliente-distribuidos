package delivery.promotion

import delivery.orderDetail.OrderDetail
import delivery.products.Products


class Promotion {
    String name;
    String available;
    Date end_date;
    static hasMany = [orderDetail: OrderDetail, product: Products]
    static constraints = {
    }
}