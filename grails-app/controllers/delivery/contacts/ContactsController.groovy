package delivery.contacts

import com.sma.delivery.beans.contacts.ContactB
import com.sma.delivery.service.contacts.IContactsService
import org.springframework.beans.factory.annotation.Autowired

class ContactsController {

    static allowedMethods = [save: "POST"]

    @Autowired
    def IContactsService contactService

    def index(){
        redirect(action: "create")
    }
    def create() {
        [contactsInstance: new ContactB(params)]
    }
    def save() {
        def contactsInstance = new ContactB(params)
        def newContacts = contactService.save(contactsInstance)
        if (!newContacts?.getId()) {
            render(view: "create", model: [contactsInstance: contactsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'contacts.label', default: 'Contacts'),
                newContacts.getId()
        ])
        redirect(action: "create")
    }
}
