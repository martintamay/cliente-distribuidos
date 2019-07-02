package delivery.bills

import delivery.billsDetails.BillsDetails
import delivery.order.Order

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
    String direccion;
    static belongsTo = [order: Order]
    static hasMany = [billsDetails: BillsDetails]
    static constraints = {
    }
}
