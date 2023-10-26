package controller;

import model.Student;
import model.Subject;
import model.Teacher;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShowResult {

    public static void showInfor(List<Student> students) {
        System.out.println("Information:");
        System.out.printf("%-15s%-20s%-15s\n", "Id", "Name", "DayOfBirth");
        for (var read : students) {
            showStu(read);
        }
    }

    public static void showStu(Student student) {
        System.out.printf("%-15s%-20s%-15s\n", student.getId(), student.getName(), student.getDayOfBirth());
    }

    public static void showSubject(List<Subject> subjects) {
        System.out.println("List subject:");
        System.out.printf("%-10s%-12s\n", "Id", "Subject Name");
        for (var read :
                subjects) {
            showSub(read);
        }
    }
    public static void showSubject(Set<Subject> subjects) {
        System.out.println("List subject:");
        System.out.printf("%-10s%-12s\n", "Id", "Subject Name");
        for (var read :
                subjects) {
            showSub(read);
        }
    }
    public static void showSubject(Map<Subject,Double> subjects) {
        System.out.println("List subject:");
        System.out.printf("%-10s%-12s\n", "Id", "Subject Name");
        for (var read :
                subjects.entrySet()) {
            System.out.printf("%-10s%-12s\n", read.getKey().getId(),read.getKey().getSubjectName());
        }
    }

    private static void showSub(Subject subject) {
        System.out.printf("%-10s%-12s\n", subject.getId(), subject.getSubjectName());
    }

    public static void showTranScripts(Map<Subject, Double> subjectDoubleMap) {
        System.out.println("List score subjects:");
        System.out.printf("%-12s%-12s%-15s%-15s\n", "Subject", "Score", "UpdateIn", "UpdateBy");
        for (var map :
                subjectDoubleMap.entrySet()) {
            showTra(map.getKey(), map.getValue());
        }
    }

    private static void showTra(Subject key, Double value) {
        System.out.printf("%-12s%-12.1f%-15s%-15s\n", key.getSubjectName(), value, key.getUpdateIn(), key.getUpdateBy().getName());
    }

    public static void showTeacher(List<Teacher> teachers) {
        System.out.println("Information:");
        System.out.printf("%-15s%-20s%-15s\n", "Id", "Name", "DayOfBirth");
        for (var read : teachers) {
            showTea(read);
        }
    }

    public static void showTea(Teacher teacher) {
        System.out.printf("%-15s%-20s%-15s\n", teacher.getId(), teacher.getName(), teacher.getDayOfBirth());
    }
}
