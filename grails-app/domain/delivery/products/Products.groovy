package delivery.products

import delivery.establishments.Establishments

class Products {
    String name;
    String description;
    Integer cost;
    static belongsTo = [establishments: Establishments]
    static constraints = {
    }
}
