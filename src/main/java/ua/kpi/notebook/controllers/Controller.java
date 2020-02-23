package ua.kpi.notebook.controllers;

import ua.kpi.notebook.models.Note;
import ua.kpi.notebook.views.View;

import java.util.Scanner;

public class Controller {

    private DataScanner dataScanner;
    private DataPrinter dataPrinter;
    private Note note;

    public Controller(Note note, View view) {
        this.note = note;
        dataScanner = new DataScanner(view);
        dataPrinter = new DataPrinter(view);
    }

    public void start() {
        setNotData();
        dataPrinter.printNote(note);
    }

    private void setNotData() {
        try (Scanner scanner = new Scanner(System.in)) {
            note.setNoteData(dataScanner.getNoteData(scanner));
        }catch (Exception e){
            System.err.println("Scanner don`t created");
            start();
        }
    }
}
