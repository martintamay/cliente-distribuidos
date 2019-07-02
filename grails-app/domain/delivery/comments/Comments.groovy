package delivery.comments

import delivery.establishments.Establishments
import delivery.user.User

class Comments {
    String content
    Boolean deleted
    String title
static belongsTo = [user:User,establishments:Establishments]


    static constraints = {
    }
}
