package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacher {
    private static int nextInt = 100;
    private String id;
    private String name;
    private Date dayOfBirth;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Teacher(String name, String dayOfBirth) {
        setId(null);
        this.name = name;
        setDayofBirth(dayOfBirth);
    }

    public static int getNextInt() {
        return nextInt;
    }

    public static void setNextInt(int nextInt) {
        Teacher.nextInt = nextInt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null) {
            this.id = "T" + nextInt;
            nextInt++;
        } else {
            this.id = id;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayofBirth(String dayofBirth) {
        try {
            this.dayOfBirth = dateFormat.parse(dayofBirth);
        } catch (ParseException e) {
            e.getMessage();
        }
    }
}
