package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Teacher {
    private static int nextInt = 100;
    private String id;
    private String name;
    private Date dayOfBirth;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Set<Subject> teaching = new HashSet<>();

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

    public String getDayOfBirth() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(dayOfBirth);
    }

    public void setDayofBirth(String dayofBirth) {
        try {
            this.dayOfBirth = dateFormat.parse(dayofBirth);
        } catch (ParseException e) {
            e.getMessage();
        }
    }

    public Set<Subject> getTeaching() {
        return teaching;
    }

    public void setTeaching(Subject teaching) {
        this.teaching.add(teaching);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Teacher teacher = (Teacher) object;
        return Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                '}';
    }
}
