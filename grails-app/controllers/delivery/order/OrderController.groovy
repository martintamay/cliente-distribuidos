package delivery.order

import com.sma.delivery.beans.billsDetails.BillsDetailsB
import com.sma.delivery.beans.order.OrderB
import com.sma.delivery.beans.orderDetails.OrdersDetailsB
import com.sma.delivery.beans.packages.PackagesB
import com.sma.delivery.beans.products.ProductsB
import com.sma.delivery.beans.promotions.PromotionsB
import com.sma.delivery.service.establishments.IEstablishmentsService
import com.sma.delivery.service.order.IOrderService
import com.sma.delivery.service.orderDetails.IOrderDetailService
import com.sma.delivery.service.packages.IPackagesService
import com.sma.delivery.service.products.IProductsService
import com.sma.delivery.service.promotions.IPromotionsService
import com.sma.delivery.service.user.IUserService
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject

class OrderController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET", options: "GET"]

    //services
    IOrderService orderService
    IOrderDetailService orderDetailsService
    IEstablishmentsService establishmentsService
    IUserService userService
    IProductsService productsService
    IPackagesService packagesService
    IPromotionsService promotionsService

    def index(){
        redirect(action: "list", id:1,)
    }

    def list(Integer max){
        getPrincipal().properties.each{ k, v -> println "${k}:${v}" }
        def orders
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if(params['text']!=null){
            orders = orderService.find(params['text'])
        }else{
            orders = orderService.getAll(page)
        }
        def next = orderService.getAll(page+1).size()
        [orderInstanceList: orders, orderInstanceTotal: orders?.size(),page: page,next:next]
    }


    def options(String q){
        JSONArray lista = new JSONArray()
        promotionsAsJSON(promotionsService.find(q, 1), lista)
        packagesAsJSON(packagesService.find(q, 1), lista)
        productsAsJSON(productsService.find(q, 1), lista)
        render lista.toString()
    }

    def packagesAsJSON(packages, lista){
        for(PackagesB packagesB : packages){
            JSONObject jsonObject = new JSONObject()
            jsonObject.put("value", "3:"+packagesB.getId())
            jsonObject.put("text", packagesB.getName())
            jsonObject.put("cost", packagesB.getCost())
            lista.add(jsonObject)
        }
    }
    def promotionsAsJSON(promotions, lista){
        for(PromotionsB promotion : promotions){
            JSONObject jsonObject = new JSONObject()
            jsonObject.put("value", "2:"+promotion.getId())
            jsonObject.put("text", promotion.getName())
            jsonObject.put("cost", "0")
            lista.add(jsonObject)
        }
    }
    def productsAsJSON(products, lista){
        for(ProductsB product : products){
            JSONObject jsonObject = new JSONObject()
            jsonObject.put("value", "1:"+product.getId())
            jsonObject.put("text", product.getName())
            jsonObject.put("cost", product.getCost())
            lista.add(jsonObject)
        }
    }

    def create() {
        def action = "create"
        [orderInstance: new OrderB(params),user: userService.getUsers(),establishments: establishmentsService.getEstablishments(), action: action]
    }

    def save() {
        def data = request.JSON


        def parametros = new HashMap<String,String>()
        parametros.put("order", data.toString())

        def establishments = establishmentsService.getById(Integer.valueOf(data.order.establishments))
        def user=userService.getById(Integer.valueOf(data.order.user))
        def newOrder = new OrderB(parametros)
        newOrder.setEstablishments(establishments)
        newOrder.setUser(user)
        newOrder.setDetails(orderDetails(parametros))
        System.out.println("Cant detail: "+newOrder.getDetails().size())
        def orderInstance = orderService.save(newOrder)
        System.out.println("paso el save")

        if (!newOrder?.getId()) {
            render(view: "create", model: [orderInstance: orderInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'order.label', default: 'Order'),
                newOrder.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def orderInstance = orderService.getById(id)
        orderInstance.setDetails(orderDetailsService.getOrderDetailsByOrderId(id))
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'order.label', default: 'Order'),
                    id
            ])
            redirect(action: "list")
            return
        }

        def action = "update"
        [orderInstance: orderInstance,user:userService.getUsers(), establishments: establishmentsService.getEstablishments(), action: action]
    }

    def update(Long id, Long version) {
        System.out.println("\nid: ${id}")

        def data = request.JSON


        def parametros = new HashMap<String,String>()
        parametros.put("order", data.toString())

        def establishments = establishmentsService.getById(Integer.valueOf(data.order.establishments))
        def user=userService.getById(Integer.valueOf(data.order.user))
        def newOrder = new OrderB(parametros)
        newOrder.setEstablishments(establishments)
        newOrder.setUser(user)
        newOrder.setDetails(orderDetails(parametros))
        System.out.println("Cant detail: "+newOrder.getDetails().size())
        orderService.save(newOrder)
        System.out.println("paso el save")
        redirect(action: "list")
    }

    def delete(Integer id){
        orderService.delete(id)
        redirect(action: "list")
    }

    def search(String text,Integer page){
        def orders = orderService.find(text,page)
        def next = orderService.find(text,page+1).size()
        render(view: "_list", model: [orderInstanceList: orders ,next: next,page: page])
    }
    def show(Integer id){
        def orderInstance = orderService.getById(id)
        [orderInstance: orderInstance]
    }

    def orderDetails(params){
        List<OrdersDetailsB> details = new ArrayList<>()
        if(params.get("order")!=null) {
            JSONObject json = new JSONObject(params.get("order"))
            if (json.containsKey("details")) {
                JSONArray jsonArray = new JSONArray(json.getString("details"))
                for (Object o : jsonArray) {
                    Map<String, String> detailData = new HashMap<>()
                    JSONObject detail = (JSONObject) o
                    if (detail.containsKey("id"))
                        detailData.put("id", detail.getString("id"))


                    detailData.put("cost", detail.getString("cost"))
                    detailData.put("quantity", detail.getString("quantity"))
                    detailData.put("comment", detail.getString("comment"))


                    OrdersDetailsB detailsB = new OrdersDetailsB(detailData)


                    if (detail.containsKey("productId"))
                        detailsB.setProduct(productsService.getById(detail.getInt("productId")))
                    if (detail.containsKey("promotionId"))
                        detailsB.setPromotion(promotionsService.getById(detail.getInt("promotionId")))
                    if (detail.containsKey("packageId"))
                        detailsB.setPackageB(packagesService.getById(detail.getInt("packageId")))

                    details.add(detailsB)
                }
            }
        }
        return details

    }
}
