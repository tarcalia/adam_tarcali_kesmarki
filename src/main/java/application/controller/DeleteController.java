package application.controller;

import application.service.AddressService;
import application.service.ContactService;
import application.service.InputService;
import application.service.PersonService;
import org.springframework.stereotype.Controller;

/**
 * Service class for delete operations.
 */
@Controller
public class DeleteController {
    private final String SUCCESS = "Deleted successfully";
    private InputService inputService;
    private PersonService personService;
    private AddressService addressService;
    private ContactService contactService;

    public DeleteController(InputService inputService, PersonService personService, AddressService addressService, ContactService contactService) {
        this.inputService = inputService;
        this.personService = personService;
        this.addressService = addressService;
        this.contactService = contactService;
    }

    public void deleteElement(Integer userAnswer) {
        switch (userAnswer) {
            case 1 -> deletePerson();
            case 2 -> deleteAddress();
            case 3 -> deleteContact();
            case 4 -> System.out.println("Cancelling upload process");
        }
    }

    private void deletePerson()  {
        System.out.println("Give id of the person you want to delete:");
        personService.deletePerson(inputService.getNumericInput());
        System.out.println(SUCCESS);
    }

    private void deleteAddress() {
        System.out.println("Give id of the address you want to delete:");
        addressService.deleteAddress((inputService.getNumericInput()));
        System.out.println(SUCCESS);
    }

    private void deleteContact() {
        System.out.println("Give id of the contact you want to delete:");
        contactService.deleteContact((inputService.getNumericInput()));
        System.out.println(SUCCESS);
    }
}
