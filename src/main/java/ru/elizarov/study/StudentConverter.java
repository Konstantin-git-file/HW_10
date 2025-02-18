package ru.elizarov.study;

import java.util.ArrayList;
import java.util.List;

public class StudentConverter {

    public static List<Student> convert(List<String> constructorArgs, List<String> addArgs) {
        List<Student> students = new ArrayList<>();
        for (String name : constructorArgs) {
            try {
                Student student = new Student(name, grade -> grade >= 2 && grade <= 5);

                addGradesToStudent(student, addArgs);
                students.add(student);

            } catch (InvalidGradeException e) {
                throw new InvalidGradeException("Ошибка добавления оценки для студента " + name + ": " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Студента " + name + " создать невозможно: " + e.getMessage());
            }
        }
        return students;
    }

    private static void addGradesToStudent(Student student, List<String> addArgs) throws InvalidGradeException {
        for (String arg : addArgs) {
            try {
                int grade = Integer.parseInt(arg);
                student.addGrade(grade);
            } catch (NumberFormatException e) {
                // Игнорируем нечисловые строки
                System.out.println("Некорректный формат оценки: " + arg + ". Пропускаем.");
            }
        }
    }
}
