package application.service;

import application.domain.Address;
import application.domain.Person;

import java.util.List;
import java.util.Optional;

/**
 * Service class for {@link Address} related operations.
 */
public interface AddressService {

    /**
     * Get {@link Address} object from the database.
     * @param addressId is the address's id which will be searched for.
     * @return Address if exists.
     */
    Optional<Address> getAddress(Integer addressId);

    /**
     * Return uploaded addresses from the database.
     * @return addresses in a list.
     */
    List<Address> getAddresses();

    /**
     * Save a {@link Address} entity to database.
     * @param address will be the name of the entity
     * @param personId represent which Person it belongs.
     */
    void addAddress(Person personId, String address);

    /**
     * Modify an {@link Address} entity.
     * @param id is the address's id which will be searched for.
     * @param address will be the new address
     * @param person represents of the new persin where this address belongs to.
     */
    void modifyAddress(Integer id, String address, Person person);

    /**
     * Delete a {@link Address} entity from database.
     * @param id will be the identifier which entity should be deleted
     */
    void deleteAddress(Integer id);
}
