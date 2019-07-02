package delivery.productHasPackages

import com.sma.delivery.service.productHasPackages.IProductHasPackagesService

class ProductHasPackagesController {
    IProductHasPackagesService productHasPackagesService
    def delete(Integer id){
        productHasPackagesService.delete(id)
    }
}
