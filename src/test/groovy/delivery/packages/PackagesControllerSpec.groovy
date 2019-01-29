package delivery.packages

import grails.test.mixin.*
import spock.lang.*

@TestFor(PackagesController)
@Mock(Packages)
class PackagesControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.packagesList
            model.packagesCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.packages!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def packages = new Packages()
            packages.validate()
            controller.save(packages)

        then:"The create view is rendered again with the correct model"
            model.packages!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            packages = new Packages(params)

            controller.save(packages)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/packages/show/1'
            controller.flash.message != null
            Packages.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def packages = new Packages(params)
            controller.show(packages)

        then:"A model is populated containing the domain instance"
            model.packages == packages
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def packages = new Packages(params)
            controller.edit(packages)

        then:"A model is populated containing the domain instance"
            model.packages == packages
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/packages/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def packages = new Packages()
            packages.validate()
            controller.update(packages)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.packages == packages

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            packages = new Packages(params).save(flush: true)
            controller.update(packages)

        then:"A redirect is issued to the show action"
            packages != null
            response.redirectedUrl == "/packages/show/$packages.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/packages/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def packages = new Packages(params).save(flush: true)

        then:"It exists"
            Packages.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(packages)

        then:"The instance is deleted"
            Packages.count() == 0
            response.redirectedUrl == '/packages/index'
            flash.message != null
    }
}
