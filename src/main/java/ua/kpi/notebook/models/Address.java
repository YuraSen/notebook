package ua.kpi.notebook.models;

import java.util.StringJoiner;

public class Address {

    private String index;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer flatNumber;

    public void setAddressData(
            String index,
            String city,
            String street,
            String houseNumber,
            String flatNumber
    ) {
        setIndex(index);
        setCity(city);
        setStreet(street);
        setHouseNumber(Integer.parseInt(houseNumber));
        setFlatNumber(Integer.parseInt(flatNumber));
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        String delimiter = "\n\t\t\t";
        return new StringJoiner(delimiter, delimiter + Address.class.getSimpleName() + delimiter + "[", "]")
                .add("index='" + index + "'")
                .add("city='" + city + "'")
                .add("street='" + street + "'")
                .add("houseNumber=" + houseNumber)
                .add("flatNumber=" + flatNumber)
                .toString();
    }
}
