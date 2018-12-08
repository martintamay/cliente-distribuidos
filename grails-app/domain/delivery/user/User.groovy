package delivery.user
import delivery.comments.Comments
class User {
    String email;
    String firstName;
    String lastName;
    String phoneNumber;
    String password;
    String address;
    static hasMany = [comments:Comments];

    static constraints = {
    }
}
