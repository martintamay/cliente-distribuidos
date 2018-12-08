package delivery.user

import com.sma.delivery.beans.user.UserB
import com.sma.delivery.service.user.IUserService

class UserController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    def IUserService userService

    def index(){
        redirect(action: "list", id:1,)
    }

    def list(Integer max){
        getPrincipal().properties.each{ k, v -> println "${k}:${v}" }
        def users
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if(params['text']!=null){
            users = userService.find(params['text']);
        }else{
            users = userService.getAll(page)
        }
        def next = userService.getAll(page+1).size();
        [userInstanceList: users, userInstanceTotal: users?.size(),page: page,next:next]
    }

    def create() {
        [userInstance: new UserB(params)]
    }

    def save() {
        def userInstance = new UserB(params)
        def newUser = userService.save(userInstance)
        if (!newUser?.getId()) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'user.label', default: 'User'),
                newUser.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def userInstance = userService.getById(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'user.label', default: 'User'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def update(Long id, Long version) {
        def userInstance = new UserB(params)
        userService.save(userInstance)
        redirect(action: "list")
    }

    def delete(Integer id){
        userService.delete(id)
        redirect(action: "list")
    }

    def search(String text){
        def users = userService.find(text);
        render(view: "_list", model: [userInstanceList: users])
    }
    def show(Integer id){
        def userInstance = userService.getById(id)
        [userInstance: userInstance]
    }
}
