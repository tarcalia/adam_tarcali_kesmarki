package application.service.impl;

import application.domain.Address;
import application.domain.Contact;
import application.repository.ContactRepository;
import application.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class to handle {@link Contact} related operations.
 */
@Service
public class ContactHandler implements ContactService {
    private ContactRepository contactRepository;

    public ContactHandler(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Optional<Contact> getContact(Integer contactID) {
        if (contactID == null) {
            return Optional.empty();
        }
        if (contactRepository.findById(contactID).isPresent()) {
            return Optional.of(contactRepository.findById(contactID).get());
        } return Optional.empty();
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @Override
    public void addContact(Address addressId, Integer contact) {
        if(addressId == null || contact == null) {
            System.out.println("Null parameter given");
        } else {
            contactRepository.save(new Contact(contact, addressId));
        }
    }

    @Override
    public void modifyContact(Integer id, Integer contact, Address address) {
        if (id == null || contact == null || address == null) {
            System.out.println("Null parameter given");
        }
        if (getContact(id).isEmpty()) {
            System.out.println("No contact found");
        } else {
            Contact tempContact = getContact(id).get();
            tempContact.setPhoneNumber(contact);
            tempContact.setAddressId(address);
            contactRepository.save(tempContact);
        }

    }

    @Override
    public void deleteContact(Integer id) {
        if (id == null) {
            System.out.println("Null parameter given");
        }
        if (getContact(id).isEmpty()) {
            System.out.println("No contact found");
        } else {
            contactRepository.delete(getContact(id).get());
        }
    }
}
