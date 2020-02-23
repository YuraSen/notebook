package ua.kpi.notebook.controllers;

import ua.kpi.notebook.models.Note;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class RegexContainer {

    private final String PREFIX = "input.regex.";

    private final ResourceBundle bundle;

    RegexContainer() {
        bundle = ResourceBundle.getBundle("regex");
    }

    Map<String, String> getRegexes() {
        String[] fields = Note.getFields();
        Map<String, String> pairs = new HashMap<>();
        for (String field : fields) {
            pairs.put(field, bundle.getString(getKey(field)));
        }
        return pairs;
    }

    private String getKey(String field){
        return PREFIX + field;
    }
}
