package delivery.comments
import delivery.user.User
import delivery.establishments.Establishments
class Comments {
    String content;
    Boolean deleted;
    String title;
static belongsTo = [user:User,establishments:Establishments]


    static constraints = {
    }
}
