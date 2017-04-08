package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Submission {
    private String student_number;
    private int week;
    private int hours;
    private boolean a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12;
    private List<Integer> completed;
    private int maxExercises;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public void countCompleted() {
        completed = new ArrayList<>();
        if (a1) {
            completed.add(1);
        }
        if (a2) {
            completed.add(2);
        }
        if (a3) {
            completed.add(3);
        }
        if (a4) {
            completed.add(4);
        }
        if (a5) {
            completed.add(5);
        }
        if (a6) {
            completed.add(6);
        }
        if (a7) {
            completed.add(7);
        }
        if (a8) {
            completed.add(8);
        }
        if (a9) {
            completed.add(9);
        }
        if (a10) {
            completed.add(10);
        }
        if (a11) {
            completed.add(11);
        }
        if (a12) {
            completed.add(12);
        }
    }

    public String printCompleted() {
        String print = "";
        for (Integer exercise : completed) {
            print += exercise + " ";
        }
        return print;
    }

    public int getWeek() {
        return week;
    }

    @Override
    public String toString() {
        countCompleted();
        return "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + completed.size() + ", aikaa kului " + hours + ", tehdyt tehtävät: " + printCompleted();
    }

}