package delivery.promotions

import delivery.orderDetail.OrderDetail

import java.sql.Time

class Promotions {
    String name;
    String   available;
    Time end_date;
    static hasMany = [orderDetail: OrderDetail]
    static constraints = {
    }
}

