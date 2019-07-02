package delivery.billsDetails

import delivery.bills.Bills
import delivery.products.Products

class BillsDetails {
    Integer amount
    Integer iva10
    Integer bill
    Integer iva5
    Integer exenta
    Integer unitary
    Integer quantity
    static belongsTo = [bills: Bills, product: Products]
    static constraints = {
    }
}
