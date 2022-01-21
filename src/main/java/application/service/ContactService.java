package application.service;

import application.domain.Address;
import application.domain.Contact;

import java.util.List;
import java.util.Optional;

/**
 * Service class for {@link Contact} related operations.
 */
public interface ContactService {

    /**
     * Get {@link Contact} object from the database.
     * @param contactID is the contact's id which will be searched for.
     * @return Contact if exists.
     */
    Optional<Contact> getContact(Integer contactID);

    /**
     * Get uploaded contacts
     * @return contacts in a list
     */
    List<Contact> getContacts();

    /**
     * Save a {@link Contact} entity to database.
     * @param contact will be the phone number of the entity
     * @param addressId represent which address it belongs.
     */
    void addContact(Address addressId, Integer contact);

    /**
     * Modify an {@link Contact} entity.
     * @param id is the address's id which will be searched for.
     * @param contact will be the new contact
     * @param address represents of the new address where this address belongs to.
     */
    void modifyContact(Integer id, Integer contact, Address address);

    /**
     * Delete a {@link Contact} entity from database.
     * @param id will be the identifier which entity should be deleted
     */
    void deleteContact(Integer id);
}