package delivery.comments

import com.sma.delivery.beans.comments.CommentsB
import com.sma.delivery.service.comments.ICommentsService

class CommentsController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    def ICommentsService commentsService

    def index(){
        redirect(action: "list", id:1,)
    }
    def list(Integer max){
        def comments
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if(params['text']!=null){
            comments = commentsService.find(params['text']);
        }else{
            comments = commentsService.getAll(page)
        }
        def next = commentsService.getAll(page+1).size();
        [commentsInstanceList: comments, commentsInstanceTotal: comments?.size(),page: page,next:next]
    }
    def create() {
        [commentsInstance: new CommentsB(params)]
    }
    def save() {
        def commentsInstance = new CommentsB(params)
        def newComments = commentsService.save(commentsInstance)
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

        [commentsInstance: commentsInstance]
    }

    def update(Long id, Long version) {
        def commentsInstance = new CommentsB(params)
        commentsService.save(commentsInstance)
        redirect(action: "list")
    }

    def delete(Integer id){
        commentsService.delete(id)
        redirect(action: "list")
    }

    def search(String text){
        def comments = commentsService.find(text);
        render(view: "_list", model: [commetsInstanceList: comments])
    }
}