package delivery.comments

import com.sma.delivery.beans.comments.CommentsB
import com.sma.delivery.service.comments.ICommentsService
import com.sma.delivery.service.establishments.IEstablishmentsService
import com.sma.delivery.service.user.IUserService


class CommentsController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    def ICommentsService commentsService
    def IEstablishmentsService establishmentsService
    def IUserService userService

    def index() {
        redirect(action: "list", id: 1,)
    }

    def list(Integer max) {
        def comments
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if (params['text'] != null) {
            comments = commentsService.find(params['text']);
        } else {
            comments = commentsService.getAll(page)
        }
        def next = commentsService.getAll(page + 1).size();
        [commentsInstanceList: comments, commentsInstanceTotal: comments?.size(), page: page, next: next]
    }

    def create() {
        [commentsInstance: new CommentsB(params), user: userService.getUsers(), establishments: establishmentsService.getEstablishments()]


    }

    def save() {

        def establishments = establishmentsService.getById(Integer.valueOf(params['establishments']))
        def user = userService.getById(Integer.valueOf(params['user']))
        def newComments = new CommentsB(params)
        newComments.set_establishments(establishments)
        newComments.set_user(user)
        def commentsInstance = commentsService.save(newComments)
        if (!newComments?.getId()) {
            render(view: "create", model: [commentsInstance: commentsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'comments.label', default: 'Comments'),
                newComments.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def commentsInstance = commentsService.getById(id)
        if (!commentsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'comments.label', default: 'Comments'),
                    id
            ])
            redirect(action: "list")
            return
        }


        [commentsInstance: commentsInstance, user: userService.getUsers(), establishments: establishmentsService.getEstablishments()]

    }

    def update(Long id, Long version) {
        def establishments = establishmentsService.getById(Integer.valueOf(params['establishments']))
        def user = userService.getById(Integer.valueOf(params['user']))
        def newComments = new CommentsB(params)
        newComments.set_establishments(establishments)
        newComments.set_user(user)
        commentsService.save(newComments)

        redirect(action: "list")
    }

    def delete(Integer id) {
        commentsService.delete(id)
        redirect(action: "list")
    }

    def search(String text) {
        def comments = commentsService.find(text);
        render(view: "_list", model: [commetsInstanceList: comments])
    }

    def show(Integer id) {
        def commentsInstance = commentsService.getById(id)
        [commentsInstance: commentsInstance]
    }
}