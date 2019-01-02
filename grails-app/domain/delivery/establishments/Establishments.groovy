package delivery.establishments
import delivery.comments.Comments
import delivery.order.Order

class Establishments {
    String address;
    String  description;
    String email;
    String name;
    String phone_number;
    String schedule;
static hasMany = [comments:Comments,order: Order]
    static constraints = {
    }
}
