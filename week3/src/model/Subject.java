package model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Subject {
    private static int nextInt = 1;
    public String id;
    private String subjectName;
    private LocalDateTime updateIn;
    private Teacher updateBy;

    public Subject(String subjectName) {
        setId(null);
        this.subjectName = subjectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null) {
            this.id = "" + nextInt;
            nextInt++;
        } else {
            this.id = id;
        }
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setUpdateIn() {
        this.updateIn = updateIn.now();
    }

    public String getUpdateIn() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (updateIn == null){
            return "null";
        }
        return updateIn.format(dateTimeFormatter);
    }

    public void setUpdateBy(Teacher teacher) {
        this.updateBy = teacher;
    }

    public Teacher getUpdateBy() {
        if (updateBy == null){
            return new Teacher("null","01/01/1970");
        }
        return updateBy;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Subject subject = (Subject) object;
        return Objects.equals(id, subject.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", updateIn=" + updateIn +
                ", updateBy=" + updateBy +
                '}';
    }
}
