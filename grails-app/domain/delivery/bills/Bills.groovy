package delivery.bills

import delivery.billsDetails.BillsDetails
import delivery.order.Order
import delivery.user.User

class Bills {
    String total;
    Integer iva10;
    Integer num1;
    Integer num2;
    Integer num3;
    String ruc;
    String timbrado;
    Integer iva5;
    String fecha;
    String nombre;
    static belongsTo = [order: Order]
    static hasMany = [billsDetails: BillsDetails]
    static constraints = {
    }
}
