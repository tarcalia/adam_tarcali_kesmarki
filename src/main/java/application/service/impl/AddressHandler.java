package application.service.impl;

import application.domain.Address;
import application.domain.Person;
import application.repository.AddressRepository;
import application.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service class to handle {@link Address} related operations.
 */
@Service
public class AddressHandler implements AddressService {
    private AddressRepository addressRepository;

    public AddressHandler(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;

    }

    @Override
    public Address getAddress(Integer addressId) {
        if (addressRepository.findById(addressId).isPresent()) {
            return addressRepository.findById(addressId).get();
        } else {
            throw new NoSuchElementException("No address with this id found");
        }
    }

    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void addAddress(Person personId, String address) {
        addressRepository.save(new Address(address, personId));
    }

    @Override
    public void modifyAddress(Integer id, String address, Person person) {
        Address tempAddress = getAddress(id);
        tempAddress.setAddressName(address);
        tempAddress.setPersonId(person);
        addressRepository.save(tempAddress);
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepository.delete(getAddress(id));
    }
}
