// Place your Spring DSL code here


import com.sma.delivery.rest.bills.BillsResourceImpl
import com.sma.delivery.rest.billsDetails.BillsDetailsResourceImpl
import com.sma.delivery.rest.comments.CommentsResourceImpl
import com.sma.delivery.rest.contacts.ContactsResourceImpl
import com.sma.delivery.rest.establishments.EstablishmentsResourceImpl
import com.sma.delivery.rest.ingredients.IngredientsResourceImpl
import com.sma.delivery.rest.ingredientsProducts.IngredientsProductsResourceImpl
import com.sma.delivery.rest.order.OrderResourceImpl
import com.sma.delivery.rest.orderDetails.OrderDetailsResourceImpl
import com.sma.delivery.rest.packages.PackagesResourceImpl
import com.sma.delivery.rest.productHasPromotions.ProductHasPromotionsResourceImpl
import com.sma.delivery.rest.products.ProductsResourceImpl
import com.sma.delivery.rest.promotions.PromotionsResourceImpl
import com.sma.delivery.rest.user.UserResourceImpl
import com.sma.delivery.service.auth.AuthServiceImpl
import com.sma.delivery.service.bills.BillsServiceImpl
import com.sma.delivery.service.billsDetails.BillsDetailsServiceImpl
import com.sma.delivery.service.comments.CommentsServiceImpl
import com.sma.delivery.service.contacts.ContactsServiceImpl
import com.sma.delivery.service.establishments.EstablishmentsServiceImpl
import com.sma.delivery.service.ingredients.IngredientsServiceImpl
import com.sma.delivery.service.ingredientsProducts.IngredientsProductsServiceImpl
import com.sma.delivery.service.order.OrderServiceImpl
import com.sma.delivery.service.orderDetails.OrderDetailServiceImpl
import com.sma.delivery.service.packages.PackagesServiceImpl
import com.sma.delivery.service.productHasPromotions.ProductHasPromotionsServiceImpl
import com.sma.delivery.service.products.ProductsServiceImpl
import com.sma.delivery.service.promotions.PromotionsServiceImpl
import com.sma.delivery.service.user.UserServiceImpl
import login.MyAuthenticationProvider
import org.springframework.web.servlet.i18n.SessionLocaleResolver

beans = {
    myAuthenticationProvider(MyAuthenticationProvider) {
    }
    ingredientsProductsResource(IngredientsProductsResourceImpl)
    ingredientsProductsService(IngredientsProductsServiceImpl)
    ingredientsResource(IngredientsResourceImpl)
    ingredientsService(IngredientsServiceImpl)
    userResource(UserResourceImpl)
    userService(UserServiceImpl)
    orderResource(OrderResourceImpl)
    orderService(OrderServiceImpl)
    orderDetailsResource(OrderDetailsResourceImpl)
    orderDetailsService(OrderDetailServiceImpl)
    authService(AuthServiceImpl)
    commentsResource(CommentsResourceImpl)
    commentsService(CommentsServiceImpl)
    establishmentsResource(EstablishmentsResourceImpl)
    establishmentsService(EstablishmentsServiceImpl)
    productsResource(ProductsResourceImpl)
    productsService(ProductsServiceImpl)
    billsResource(BillsResourceImpl)
    billsService(BillsServiceImpl)
    billsDetailsResource(BillsDetailsResourceImpl)
    billsDetailsService(BillsDetailsServiceImpl)
    packagesResource(PackagesResourceImpl)
    packagesService(PackagesServiceImpl)
    promotionsResource(PromotionsResourceImpl)
    promotionsService(PromotionsServiceImpl)
    productHasPromotiosResource(ProductHasPromotionsResourceImpl)
    productHasPromotionsService(ProductHasPromotionsServiceImpl)
    contactsResource(ContactsResourceImpl)
    contactsService(ContactsServiceImpl)
    localeResolver(SessionLocaleResolver) {
        defaultLocale= new java.util.Locale('es')
        importBeans('classpath:/cache/cacheConfig.xml')
    }
}
