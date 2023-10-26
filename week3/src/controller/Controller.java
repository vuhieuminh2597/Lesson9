package controller;

import model.Student;
import model.Subject;
import model.Teacher;
import model.Text;
import model.database.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Controller {
    private static Scanner input = new Scanner(in);

    public static void functions() {
        List<Student> students = new ArrayList<>(DataBase.students());
        List<Teacher> teachers = new ArrayList<>(DataBase.teachers());
        List<Subject> subjects = new ArrayList<>(DataBase.subjects());
        int choice = 0;

        do {
            choice = Text.choiceUse();
            switch (choice) {
                case 1 -> {
                    choice = Text.studentFunction();
                    switch (choice) {
                        case 1 -> ShowResult.showInfor(students);
                        case 2 -> ShowResult.showSubject(subjects);
                        case 3 -> {
                            ShowResult.showInfor(students);
                            out.println("Add student id:");
                            var idStu = input.nextLine();
                            var stu = checkIdStudent(students, idStu);
                            if (stu != null) {
                                ShowResult.showSubject(subjects);
                                out.println("Add subject id:");
                                String idSub = input.nextLine();
                                var sub = checkIdSubject(subjects, idSub);
                                if (sub != null) {
                                    stu.setSubjectMap(sub, 0d);
                                } else {
                                    out.println("Id is incorrect or does not exist!");
                                }
                            } else {
                                out.println("Id is incorrect or does not exist!");
                            }
                        }
                        case 4 -> {
                            ShowResult.showInfor(students);
                            out.println("Add student id:");
                            var idStu = input.nextLine();
                            var stu = checkIdStudent(students, idStu);
                            if (stu != null) {
                                if (!stu.getSubjectMap().isEmpty()) {
                                    ShowResult.showTranScripts(stu.getSubjectMap());
                                } else {
                                    out.println("Student have not registered for subject yet!");
                                }
                            } else {
                                out.println("Id is incorrect or does not exist!");
                            }
                        }
                    }
                }

                case 2 -> {
                    switch (choice){
                        
                    }
                }
                default -> out.println("Invalid input!");
            }
        } while (choice != 0);

    }

    private static Student checkIdStudent(List<Student> students, String idStu) {
        if (!students.isEmpty()) {
            for (var read :
                    students) {
                if (read.getId().equals(idStu)) {
                    return read;
                }
            }
        }
        return null;
    }

    public static Subject checkIdSubject(List<Subject> subjects, String id) {
        if (!subjects.isEmpty()) {
            for (var read :
                    subjects) {
                if (read.getId().equals(id)) {
                    return read;
                }
            }
        }
        return null;
    }
}
