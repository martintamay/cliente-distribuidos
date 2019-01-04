package delivery.bills

import delivery.order.Order

class Bills {
    String total;
    Integer iva10;
    static belongsTo = [order: Order]
    static constraints = {
    }
}
