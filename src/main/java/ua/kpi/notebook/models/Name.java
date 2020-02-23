package ua.kpi.notebook.models;

import java.util.StringJoiner;

public class Name {

    private String firstName;
    private String lastName;
    private String patronymic;

    public void setNameData(
            String firstName,
            String lastName,
            String patronymic
    ) {
        setFirstName(firstName);
        setLastName(lastName);
        setPatronymic(patronymic);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        String delimiter = "\n\t\t\t";
        return new StringJoiner(delimiter, delimiter + Name.class.getSimpleName() + delimiter + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("patronymic='" + patronymic + "'")
                .toString();
    }
}
