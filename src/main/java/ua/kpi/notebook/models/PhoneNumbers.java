package ua.kpi.notebook.models;

import java.util.StringJoiner;

public class PhoneNumbers {

    private String homePhoneNumber;
    private String mobilePhoneNumber1;
    private String mobilePhoneNumber2;

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public void setMobilePhoneNumber1(String mobilePhoneNumber1) {
        this.mobilePhoneNumber1 = mobilePhoneNumber1;
    }

    public void setMobilePhoneNumber2(String mobilePhoneNumber2) {
        this.mobilePhoneNumber2 = mobilePhoneNumber2;
    }

    public void setPhoneNumbersData(
            String homePhoneNumber,
            String mobilePhoneNumber1,
            String mobilePhoneNumber2
    ) {
        setHomePhoneNumber(homePhoneNumber);
        setMobilePhoneNumber1(mobilePhoneNumber1);
        setMobilePhoneNumber2(mobilePhoneNumber2);
    }

    @Override
    public String toString() {
        String delimiter = "\n\t\t\t";
        return new StringJoiner(delimiter, delimiter + PhoneNumbers.class.getSimpleName() + delimiter + "[", "]")
                .add("homePhoneNumber='" + homePhoneNumber + "'")
                .add("mobilePhoneNumber1='" + mobilePhoneNumber1 + "'")
                .add("mobilePhoneNumber2='" + mobilePhoneNumber2 + "'")
                .toString();
    }
}
