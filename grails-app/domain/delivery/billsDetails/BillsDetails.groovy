package delivery.billsDetails

import delivery.bills.Bills

class BillsDetails {
    Integer amount;
    Integer iva10;
    static belongsTo = [bills: Bills]
    static constraints = {
    }
}
