package delivery.packages



import com.sma.delivery.beans.packages.PackagesB
import com.sma.delivery.service.packages.IPackagesService

class PackagesController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", delete: "DELETE", delete: "GET"]

    //services
    IPackagesService packagesService

    def index(){
        redirect(action: "list", id:1,)
    }
    def list(Integer max){
        def packages
        def page = null == params['id'] ? 1 : Integer.valueOf(params['id'])
        if(params['text']!=null){
            packages = packagesService.find(params['text']);
        }else{
            packages = packagesService.getAll(page)
        }
        def next = packagesService.getAll(page+1).size();
        [packagesInstanceList: packages, packagesInstanceTotal: packages?.size(),page: page,next:next]
    }
    def create() {
        [packagesInstance: new PackagesB(params)]
    }
    def save() {
        def packagesInstance = new PackagesB(params)
        def newPackages = packagesService.save(packagesInstance)
        if (!newPackages?.getId()) {
            render(view: "create", model: [packagesInstance: packagesService])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'packages.label', default: 'Packages'),
                newPackages.getId()
        ])
        redirect(action: "list")
    }

    def edit(Integer id) {
        def packagesInstance = packagesService.getById(id)
        if (!packagesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'packages.label', default: 'Packages'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [packagesInstance: packagesInstance]
    }

    def update(Long id, Long version) {
        def packagesInstance = new PackagesB(params)
        packagesService.save(packagesInstance)
        redirect(action: "list")
    }

    def delete(Integer id){
        packagesService.delete(id)
        redirect(action: "list")
    }

    def search(String text){
        def packages = packagesService.find(text);
        render(view: "_list", model: [packagesInstanceList: packages])
    }
    def show(Integer id){
        def packagesInstance = packagesService.getById(id)
        [packagesInstance: packagesInstance]
    }
}

