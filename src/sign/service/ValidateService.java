package sign.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidateService {

    public LocalDate readDate(Scanner sc) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(sc.nextLine().strip(), formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Falha lendo o valor digitado.");
        }
    }

    public LocalTime readTime(Scanner sc) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return LocalTime.parse(sc.nextLine().strip(), formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Falha lendo o valor digitado.");
        }
    }

    public boolean checkUserAnswer(Scanner sc, String txt) {
        return this.validateUserAnswer(sc, txt);
    }

    private boolean validateUserAnswer(Scanner sc, String txt) {
        String answer;
        do {
            new ColorService().purple(txt);
            answer = sc.nextLine().toUpperCase();
        } while (!answer.startsWith("S") && !answer.startsWith("N"));

        return answer.startsWith("S");
    }

    public String readZone(Scanner sc) {
        return sc.nextLine().strip();
    }

    public String readName(Scanner sc) {
        return sc.nextLine().strip();
    }
}
