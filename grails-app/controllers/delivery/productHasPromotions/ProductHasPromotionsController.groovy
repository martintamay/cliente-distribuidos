package delivery.productHasPromotions

import com.sma.delivery.service.productHasPromotions.IProductHasPromotionsService

class ProductHasPromotionsController {
    IProductHasPromotionsService productHasPromotionsService
    def delete(Integer id){
        productHasPromotionsService.delete(id)
    }
}
