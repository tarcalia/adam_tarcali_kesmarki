package application.service.impl;

import application.domain.Address;
import application.domain.Person;
import application.repository.AddressRepository;
import application.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Address> getAddress(Integer addressId) {
        if (addressId == null) {
            return Optional.empty();
        }
        if (addressRepository.findById(addressId).isPresent()) {
            return addressRepository.findById(addressId);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void addAddress(Person personId, String address) {
        if(personId == null || address == null) {
            System.out.println("Null parameter given");
        }
        addressRepository.save(new Address(address, personId));
    }

    @Override
    public void modifyAddress(Integer id, String address, Person person) {
        if(address == null || id == null || person == null) {
            System.out.println("Null parameter given");
        } else {
            Address tempAddress = getAddress(id).get();
            tempAddress.setAddressName(address);
            tempAddress.setPersonId(person);
            addressRepository.save(tempAddress);
        }
    }

    @Override
    public void deleteAddress(Integer id) {
        if (id == null) {
            System.out.println("Null parameter given");
        }
        if (getAddress(id).isEmpty()) {
            System.out.println("No person found");
        } else {
            addressRepository.delete(getAddress(id).get());
        }
    }
}
