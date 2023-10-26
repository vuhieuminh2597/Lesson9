package model.database;

import model.Student;
import model.Subject;
import model.Teacher;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBase {

    public static List<Student> students() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Vũ Minh Hiếu", "25/09/1997"));
        studentList.add(new Student("Ngô Kiến Huy", "10/04/1995"));
        studentList.add(new Student("Lâm Văn Vũ", "07/04/1988"));
        studentList.add(new Student("Trịnh Thị Mỹ Kim", "09/09/1999"));
        return studentList;
    }

    public static List<Teacher> teachers() {
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher("Nguyễn Tuấn Phúc", "26/05/1991"));
        teacherList.add(new Teacher("Trần Văn Minh", "18/02/1995"));
        teacherList.add(new Teacher("Nguyễn Thu Hà", "10/01/1996"));
        return teacherList;
    }

    public static List<Subject> subjects() {
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(new Subject("Html"));
        subjectList.add(new Subject("Python"));
        subjectList.add(new Subject("C++"));
        subjectList.add(new Subject("C#"));
        subjectList.add(new Subject("Java OOP"));
        return subjectList;
    }

}
