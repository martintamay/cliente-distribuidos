package delivery.user
import delivery.comments.Comments
import delivery.order.Order

class User {
    String email;
    String firstName;
    String lastName;
    String phoneNumber;
    String password;
    String address;
    static hasMany = [comments:Comments,order: Order];

    static constraints = {
    }
}
