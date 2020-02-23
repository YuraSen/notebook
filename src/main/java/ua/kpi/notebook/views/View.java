package ua.kpi.notebook.views;

import ua.kpi.notebook.models.exception.DataUncorrectedRuntimeException;

public class View {

    private TextConstantsContainer container;

    public View() {
        container = new TextConstantsContainer();
    }

    public void printMessage(String message) {
        checkData(message);
        System.out.println(message);

    }

    public void printHint(String regex, String field) {
        checkRegexAndFieldEmpty(regex, field);
        printMessage(container.buildHintMessage(regex, field));
    }

    public void printSkipHint() {
        printMessage(container.getSkipHint());
    }

    public void printResult(String result) {
        checkData(result);
        printMessage(container.buildResultMessage(result));
    }

    private void checkData(String message) {
        if(message == null){
            throw new DataUncorrectedRuntimeException("Uncorrected data");
        }
    }

    private void checkRegexAndFieldEmpty(String regex, String field) {
        if (regex == null || field == null) {
            throw new DataUncorrectedRuntimeException("Data is uncorrected");
        }
    }
}
