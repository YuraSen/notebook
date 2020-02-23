package ua.kpi.notebook.controllers;

import ua.kpi.notebook.models.Note;
import ua.kpi.notebook.models.exception.DataUncorrectedRuntimeException;
import ua.kpi.notebook.views.View;

public class DataPrinter {

    private View view;

    DataPrinter(View view) {
        this.view = view;
    }

    void printNote(Note note) {
        checkNote(note);
        view.printResult(note.toString());
    }

    private void checkNote(Note note) {
        if(note == null){
            throw new DataUncorrectedRuntimeException("Note can`t be null");
        }
    }
}
