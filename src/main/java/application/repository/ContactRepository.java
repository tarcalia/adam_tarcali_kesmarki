package application.repository;

import application.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for JPA operators for {@link Contact} objects.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findContactByPhoneNumber(String criteria);
}