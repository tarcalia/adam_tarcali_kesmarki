package application.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

/**
 * Domain class for {@link Contact} objects.
 */
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactId;
    private Integer phoneNumber;

    @ManyToOne
    @JoinColumn(referencedColumnName = "addressID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Address addressId;

    public Contact() {
    }

    public Contact(Integer phoneNumber, Address addressId) {
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactId, contact.contactId) && Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, phoneNumber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
