package ru.elizarov.study;

import java.util.List;
import java.util.Random;

public class StudentService {
    private static final Random random = new Random();

    public static void addRandomGrades(List<Student> students) {
        int randomGrade = random.nextInt(10) + 1; // Оценка от 1 до 10

        for (Student student : students) {
            if (!student.isValidGrade(randomGrade)) {
                throw new GradeAdditionException(
                        "нельзя добавить оценку " + randomGrade + " студенту " + student.getName()
                );
            }
        }

        for (Student student : students) {
            student.addGrade(randomGrade);
        }
    }
}
