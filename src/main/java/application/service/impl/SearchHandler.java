package application.service.impl;

import application.repository.AddressRepository;
import application.repository.ContactRepository;
import application.repository.PersonRepository;
import application.service.InputService;
import application.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Service class for search operation.
 */
@Service
public class SearchHandler implements SearchService {
    private AddressRepository addressRepository;
    private ContactRepository contactRepository;
    private PersonRepository personRepository;
    private InputService inputService;


    public SearchHandler(AddressRepository addressRepository, ContactRepository contactRepository,
                         PersonRepository personRepository, InputService inputService) {
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
        this.personRepository = personRepository;
        this.inputService = inputService;
    }

    @Override
    public List<Object> search(String criteria) {
        Set<Object> result = new HashSet<>();
        if (inputService.isNumeric(criteria)) {
            result.addAll(contactRepository.findContactByPhoneNumber(criteria));
        }
        result.addAll(addressRepository.findAddressByAddressName(criteria));
        result.addAll(personRepository.findPersonByPersonName(criteria));
        return new ArrayList<>(result);
    }
}
