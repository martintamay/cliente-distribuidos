package delivery.establishments
import delivery.comments.Comments
class Establishments {
    String address;
    String  description;
    String email;
    String name;
    String phone_number;
    String schedule;
static hasMany = [comments:Comments]
    static constraints = {
    }
}
