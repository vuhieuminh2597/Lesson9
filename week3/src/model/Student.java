package model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private static int key = 1;
    private Map<Integer, Subject> subjectScores = new HashMap<>();


    public Student(String id, String name, LocalDate birthDay) {
        super(id, name, birthDay);
    }

    public Map<Integer, Subject> getSubjectScores() {
        return subjectScores;
    }

    public void setSubjectScores(Subject subject) {
        if (!this.subjectScores.isEmpty()) {
            for (var read :
                    this.subjectScores.entrySet()) {
                if (!read.getValue().equals(subject)) {
                    subjectScores.put(key,subject);
                    key++;
                }
            }
        }
    }
}
