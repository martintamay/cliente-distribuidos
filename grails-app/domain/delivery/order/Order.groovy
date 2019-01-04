package delivery.order

import delivery.bills.Bills
import delivery.establishments.Establishments
import delivery.user.User

class Order {
    int orderNumber;
    String address;
    String state;
    String contactNumber;
    int totalCost;
    static belongsTo = [user: User, establishments: Establishments]
    static hasMany = [bills: Bills]
    static constraints = {
    }
}
