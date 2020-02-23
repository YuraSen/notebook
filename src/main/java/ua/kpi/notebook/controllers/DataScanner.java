package ua.kpi.notebook.controllers;

import ua.kpi.notebook.models.exception.DataUncorrectedRuntimeException;
import ua.kpi.notebook.models.Note;
import ua.kpi.notebook.views.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataScanner {

    private View view;
    private RegexContainer regexContainer;

    DataScanner(View view) {
        this.view = view;
        regexContainer = new RegexContainer();
    }

    Map<String, String> getNoteData(Scanner scanner) {
        checkEmptyScanner(scanner);

        String[] fields = Note.getFields();
        Map<String, String> regexes = regexContainer.getRegexes();
        Map<String, String> data = new HashMap<>();
        for (String field : fields) {
            data.put(field, getValidInput(scanner, regexes.get(field), field));
        }

        return data;
    }

    private String getValidInput(Scanner scanner, String regex, String field) {
        checkEmptyScanner(scanner);
        checkRegexAndFieldEmpty(regex, field);

        String input;
        while (true) {
            String regexWithRequirements = getRequirements(regex, field);
            view.printHint(regexWithRequirements, field);
            input = scanner.nextLine();
            if (input.matches(regexWithRequirements)) {
                return input;
            }
        }
    }

    private String getRequirements(String regex, String field) {
        checkRegexAndFieldEmpty(regex, field);

        for (String optionalField : Note.getOptionalFields()) {
            boolean isOptional = optionalField.equals(field);
            if (isOptional) {
                view.printSkipHint();
                return String.format("(%s)|(-)", regex);
            }
        }

        return regex;
    }

    private void checkEmptyScanner(Scanner scanner) {
        if (scanner == null) {
            throw new DataUncorrectedRuntimeException("Scanner is empty");
        }
    }

    private void checkRegexAndFieldEmpty(String regex, String field) {
        if(regex == null || field == null){
            throw new DataUncorrectedRuntimeException("Data is uncorrected");
        }
    }
}
