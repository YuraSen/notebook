package ua.kpi.notebook.views;

import java.util.ResourceBundle;

public class TextConstantsContainer {

    private final String PREFIX = "input.text.";

    private final ResourceBundle bundle;

    TextConstantsContainer() {
        bundle = ResourceBundle.getBundle("messages");
    }

    String buildResultMessage(String result){
        return String.format("%s: %s", getCreatedNoteMessage(), result);
    }

    private String getCreatedNoteMessage() {
        return bundle.getString(getKey("createdNote"));
    }

    String buildHintMessage(String regex, String field) {
        return String.format("%s '%s' %s %s :",
                getStartHint(), getFieldName(field), getInFormat(), regex);
    }

    private String getStartHint() {
        return String.format("%s %s", bundle.getString(getKey("startHint")), getField());
    }

    private String getField() {
        return bundle.getString(getKey("field"));
    }

    private String getInFormat() {
        return bundle.getString(getKey("inFormat"));
    }

    private String getFieldName(String field) {
        return bundle.getString(getKey(field));
    }

    private String getKey(String field) {
        return PREFIX + field;
    }

    String getSkipHint() {
        return bundle.getString(getKey("skipHint"));
    }
}
