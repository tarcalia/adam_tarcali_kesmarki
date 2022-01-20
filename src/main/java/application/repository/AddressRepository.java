package application.repository;

import application.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for JPA operators for {@link Address} objects.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findAddressByAddressName(String criteria);
}