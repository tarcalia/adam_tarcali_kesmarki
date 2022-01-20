package application.service.impl;

import application.domain.Address;
import application.domain.Contact;
import application.repository.ContactRepository;
import application.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
    public Contact getContact(Integer contactID) {
        if (contactRepository.findById(contactID).isPresent()) {
            return contactRepository.findById(contactID).get();
        } else throw new NoSuchElementException("No contact with this id found");
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @Override
    public void addContact(Address addressId, Integer contact) {
        contactRepository.save(new Contact(contact, addressId));

    }

    @Override
    public void modifyContact(Integer id, Integer contact, Address address) {
        Contact tempContact = getContact(id);
        tempContact.setPhoneNumber(contact);
        tempContact.setAddressId(address);
        contactRepository.save(tempContact);
    }

    @Override
    public void deleteContact(Integer id) {
        contactRepository.delete(getContact(id));
    }
}
