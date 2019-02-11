package delivery.promotion

import delivery.orderDetail.OrderDetail


class Promotion {
    String name;
    String available;
    Date end_date;
    static hasMany = [orderDetail: OrderDetail]
    static constraints = {
    }
}