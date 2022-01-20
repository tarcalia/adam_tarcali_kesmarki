package application.controller;

import application.service.AddressService;
import application.service.ContactService;
import application.service.InputService;
import application.service.PersonService;
import org.springframework.stereotype.Controller;

/**
 * Service for PUT operations with database.
 */
@Controller
public class PutController {
    private final String SUCCESS = "Modified successfully";
    private InputService inputService;
    private PersonService personService;
    private AddressService addressService;
    private ContactService contactService;

    public PutController(InputService inputService, PersonService personService, AddressService addressService, ContactService contactService) {
        this.inputService = inputService;
        this.personService = personService;
        this.addressService = addressService;
        this.contactService = contactService;
    }

    public void modifyElement(Integer userAnswer) {
        switch (userAnswer) {
            case 1 -> modifyPerson();
            case 2 -> modifyAddress();
            case 3 -> modifyContact();
            case 4 -> System.out.println("Cancelling upload process");
        }
    }

    private void modifyPerson() {
        System.out.println("Give id of the person you want to modify");
        Integer tempId = inputService.getNumericInput();
        System.out.println("Give new name of the person:");
        personService.modifyPerson(tempId, inputService.getStringInput());
        System.out.println(SUCCESS);
    }

    private void modifyAddress() {
        System.out.println("Give id of the address you want to modify");
        Integer tempId = inputService.getNumericInput();
        System.out.println("Give address");
        String tempAddress = inputService.getStringInput();
        System.out.println("Give person id where this address belongs to:");
        addressService.modifyAddress(tempId, tempAddress, personService.getPerson(inputService.getNumericInput()));
        System.out.println(SUCCESS);
    }

    private void modifyContact() {
        System.out.println("Give id of the contact you want to modify");
        Integer tempId = inputService.getNumericInput();
        System.out.println("Give phone number");
        Integer tempContact = inputService.getNumericInput();
        System.out.println("Give address id where this contact belongs to:");
        contactService.modifyContact(tempId, tempContact, addressService.getAddress(inputService.getNumericInput()));
        System.out.println(SUCCESS);
    }
}
