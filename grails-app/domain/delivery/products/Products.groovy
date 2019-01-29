package delivery.products

import delivery.establishments.Establishments
import delivery.orderDetail.OrderDetail

class Products {
    String name;
    String description;
    Integer cost;
    static belongsTo = [establishments: Establishments]
    static hasMany = [orderDetail: OrderDetail]
    static constraints = {
    }
}
