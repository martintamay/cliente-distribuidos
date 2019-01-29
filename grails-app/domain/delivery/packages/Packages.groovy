package delivery.packages

import delivery.orderDetail.OrderDetail

class Packages {
    String name;
    Integer cost;
    static hasMany = [orderDetail: OrderDetail]
    static constraints = {
    }
}
