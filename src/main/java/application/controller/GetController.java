package application.controller;

import application.service.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Controller for GET operations with database.
 */
@Controller
public class GetController {
    private final String SUCCESS = "Uploaded successfully";
    private InputService inputService;
    private PersonService personService;
    private AddressService addressService;
    private ContactService contactService;
    private SearchService searchService;

    public GetController(InputService inputService, PersonService personService,
                         AddressService addressService, ContactService contactService,
                         SearchService searchService) {
        this.inputService = inputService;
        this.personService = personService;
        this.addressService = addressService;
        this.contactService = contactService;
        this.searchService = searchService;
    }

    public void getQuery(Integer userAnswer) {
        switch (userAnswer) {
            case 1 -> getPersons();
            case 2 -> getAddresses();
            case 3 -> getContacts();
            case 4 -> search(inputService.getStringInput());
            case 5 -> System.out.println("Cancelling upload process");
        }
    }

    private void getPersons(){
        System.out.println("All Persons:");
        System.out.println(personService.getUploadedPersons());
    }

    private void getAddresses() {
        System.out.println("All Addresses:");
        System.out.println(addressService.getAddresses());
    }

    private void getContacts() {
        System.out.println("All Contacts");
        System.out.println(contactService.getContacts());
    }

    private void search(String criteria) {
        System.out.println("Please time search criteria");
        List<Object> result = searchService.search(criteria);
        if (result.isEmpty()) {
            System.out.println("No result found");
        } else {
            System.out.println("Found results:");
            result.forEach(System.out::println);
        }

    }
}
