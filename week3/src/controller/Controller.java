package controller;

import model.Student;
import model.Subject;
import model.Teacher;
import model.Text;
import model.database.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
                case 0 -> out.println("GoodBye!");
                case 1 -> {
                    choice = Text.studentFunction();
                    switch (choice) {
                        case 0 -> out.println("GoodBye!");
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
                                    out.println("Subject of " + stu.getName());
                                    ShowResult.showSubject(stu.getSubjectMap());
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
                                    out.println("Student " + stu.getName());
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
                    choice = Text.teacherFunction();
                    switch (choice) {
                        case 0 -> out.println("GoodBye!");
                        case 1 -> ShowResult.showTeacher(teachers);
                        case 2 -> {
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
                        case 3 -> {
                            ShowResult.showTeacher(teachers);
                            out.println("Add teacher id:");
                            var idTea = input.nextLine();
                            var tea = checkIdTeacher(teachers, idTea);
                            if (tea != null) {
                                ShowResult.showSubject(subjects);
                                out.println("Add subject id:");
                                String idSub = input.nextLine();
                                var sub = checkIdSubject(subjects, idSub);
                                if (sub != null) {
                                    tea.setTeaching(sub);
                                    out.println("Teaching subject of " + tea.getName());
                                    ShowResult.showSubject(tea.getTeaching());
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
                                if (stu.getSubjectMap().isEmpty()) {
                                    out.println("Student has not registered for any subject.");
                                    break;
                                }
                                ShowResult.showTeacher(teachers);
                                out.println("Grading teacher id:");
                                var idTea = input.nextLine();
                                var tea = checkIdTeacher(teachers, idTea);
                                if (tea != null) {
                                    if (tea.getTeaching().isEmpty()) {
                                        out.println("Teacher has not registered for any subject.");
                                        break;
                                    }
                                    out.println("Subject of " + stu.getName());
                                    ShowResult.showSubject(stu.getSubjectMap());
                                    out.println("Student subject id needs to be graded:");
                                    String idSub = input.nextLine();
                                    var sub = checkIdSubject(stu.getSubjectMap(), idSub);
                                    if (stu != null) {
                                        var result = checkSubjectOfTea(tea, sub);
                                        if (result) {
                                            var resultGrading = updateScore(stu.getSubjectMap(), tea, idSub);
                                            if (resultGrading) {
                                                out.println("Student " + stu.getName());
                                                ShowResult.showTranScripts(stu.getSubjectMap());
                                            } else {
                                                out.println("Please retry!");
                                            }
                                        } else {
                                            out.println("Teacher has never registered for this subject." +
                                                    "Try again");
                                        }
                                    } else {
                                        out.println("Id is incorrect or does not exist!");
                                    }

                                } else {
                                    out.println("Id is incorrect or does not exist!");
                                }
                            } else {
                                out.println("Id is incorrect or does not exist!");
                            }
                        }
                        case 5 -> {
                            ShowResult.showTeacher(teachers);
                            out.println("Add teacher id:");
                            var idTea = input.nextLine();
                            var tea = checkIdTeacher(teachers, idTea);
                            if (tea != null) {
                                out.println("Teacher " + tea.getName());
                                ShowResult.showSubject(tea.getTeaching());
                            } else {
                                out.println("Id is incorrect or does not exist!");
                            }
                        }
                    }
                }
                default -> out.println("Invalid input!");
            }
        } while (choice != 0);

    }

    private static boolean updateScore(Map<Subject, Double> subjectMap, Teacher teacher, String idSub) {
        for (var read : subjectMap.entrySet()) {
            if (read.getKey().getId().equals(idSub)) {
                read.setValue(inputValue());
                read.getKey().setUpdateIn();
                read.getKey().setUpdateBy(teacher);
                return true;
            }
        }

        return false;
    }

    private static Double inputValue() {
        out.println("Add score |0 - 10|:");
        var number = Text.checkInputDouble();
        if (number < 0) {
            number = 0d;
        }
        if (number > 10) {
            number = 10d;
        }
        return number;
    }

    private static boolean checkSubjectOfTea(Teacher tea, Subject subject) {
        if (tea.getTeaching().contains(subject)) {
            return true;
        }
        return false;
    }


    private static Teacher checkIdTeacher(List<Teacher> teachers, String idTea) {
        if (!teachers.isEmpty()) {
            for (var read : teachers) {
                if (read.getId().equals(idTea)) {
                    return read;
                }
            }
        }
        return null;
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

    private static Subject checkIdSubject(List<Subject> subjects, String id) {
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

    private static Subject checkIdSubject(Map<Subject, Double> subjects, String id) {
        if (!subjects.isEmpty()) {
            for (var read :
                    subjects.entrySet()) {
                if (read.getKey().getId().equals(id)) {
                    return read.getKey();
                }
            }
        }
        return null;
    }

}
