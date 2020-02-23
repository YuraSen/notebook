package ua.kpi.notebook.models;

import java.util.StringJoiner;

public class Contacts {

    private PhoneNumbers phoneNumbers;
    private Address address;
    private String email;
    private String skype;

    public Contacts() {
        phoneNumbers = new PhoneNumbers();
        address = new Address();
    }

    public void setContactsData(
            String homePhoneNumber,
            String mobilePhoneNumber1,
            String mobilePhoneNumber2,
            String email,
            String skype,
            String index,
            String city,
            String street,
            String houseNumber,
            String flatNumber
    ) {
        setEmail(email);
        setSkype(skype);
        phoneNumbers.setPhoneNumbersData(
                homePhoneNumber,
                mobilePhoneNumber1,
                mobilePhoneNumber2
        );
        address.setAddressData(
                index,
                city,
                street,
                houseNumber,
                flatNumber
        );
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    @Override
    public String toString() {
        String delimiter = "\n\t\t";
        return new StringJoiner(delimiter, delimiter + Contacts.class.getSimpleName() + delimiter + "[", "]")
                .add("phoneNumbers=" + phoneNumbers)
                .add("address=" + address)
                .add("email='" + email + "'")
                .add("skype='" + skype + "'")
                .toString();
    }
}
