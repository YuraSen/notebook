package ua.kpi.notebook;

import ua.kpi.notebook.controllers.Controller;
import ua.kpi.notebook.models.Note;
import ua.kpi.notebook.views.View;

import java.util.Locale;

public class Main {

    public static void main(String... args) {
        //Locale.setDefault(new Locale("en"));
        Locale.setDefault(new Locale("uk", "UA"));
        Controller controller = new Controller(new Note(), new View());
        controller.start();
    }
}
