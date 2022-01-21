package application.service;

import java.util.List;

import application.domain.Person;
import application.domain.Address;
import application.domain.Contact;

/**
 * Service interface for search operation.
 */
public interface SearchService {

    /**
     * Return a list of {@link Person}, {@link Address}, {@link Contact} entites matches search criteria
     * @param criteria will be the search criteria
     * @return the search result in a list.
     */
    List<Object> search(String criteria);
}
