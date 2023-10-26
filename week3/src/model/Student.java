package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Student {
    private static int nextInt = 100000;
    private String id;
    private String name;
    private Date dayOfBirth;
    private Map<Subject, Double> subjectMap = new HashMap<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Student(String name, String dayOfBirth){
        setId(null);
        this.name = name;
        setDayOfBirth(dayOfBirth);
    }

    public static int getNextInt() {
        return nextInt;
    }

    public static void setNextInt(int nextInt) {
        Student.nextInt = nextInt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null) {
            this.id = "S" + nextInt;
            nextInt++;
        } else {
            this.id = id;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if (dayOfBirth == null){
            return "null";
        }
        return format.format(dayOfBirth);
    }

    public void setDayOfBirth(String dayOfBirth)  {
        try {
            this.dayOfBirth = dateFormat.parse(dayOfBirth);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Map<Subject, Double> getSubjectMap() {
        return subjectMap;
    }

    public void setSubjectMap(Subject key, Double score) {
        this.subjectMap.put(key, score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dayofBirth=" + dateFormat.format(getDayOfBirth()) +
                ", subjectMap=" + subjectMap +
                '}';
    }
}
