package delivery.bills

import delivery.billsDetails.BillsDetails
import delivery.order.Order

class Bills {
    String total;
    Integer iva10;
    static belongsTo = [order: Order]
    static hasMany = [billsDetails: BillsDetails]
    static constraints = {
    }
}
