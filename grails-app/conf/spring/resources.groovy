// Place your Spring DSL code here
import com.sma.delivery.rest.user.UserResourceImpl
import com.sma.delivery.service.auth.AuthServiceImpl
import com.sma.delivery.service.user.UserServiceImpl
import com.sma.delivery.rest.order.OrderResourceImpl
import com.sma.delivery.service.order.OrderServiceImpl
import com.sma.delivery.rest.comments.CommentsResourceImpl
import com.sma.delivery.service.comments.CommentsServiceImpl
import com.sma.delivery.rest.establishments.EstablishmentsResourceImpl
import com.sma.delivery.service.establishments.EstablishmentsServiceImpl
import login.MyAuthenticationProvider
import org.springframework.web.servlet.i18n.SessionLocaleResolver

beans = {
    myAuthenticationProvider(MyAuthenticationProvider) {
    }

    userResource(UserResourceImpl)
    userService(UserServiceImpl)
    orderResource(OrderResourceImpl)
    orderService(OrderServiceImpl)
    authService(AuthServiceImpl)
    commentsResource(CommentsResourceImpl)
    commentsService(CommentsServiceImpl)
    establishmentsResource(EstablishmentsResourceImpl)
    establishmentsService(EstablishmentsServiceImpl)

    localeResolver(SessionLocaleResolver) {
        defaultLocale= new java.util.Locale('es');
    }
}
