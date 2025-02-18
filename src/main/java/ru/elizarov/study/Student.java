package ru.elizarov.study;

import lombok.Data;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

@Data
public class Student implements Comparable<Student>{
    private String name;
    private int[] grades;
    private Predicate<Integer> gradeValidator;

    // Без правила проверки (все оценки допустимы)
    public Student(String name, int... grades) {
        this(name, grade -> true, grades); // По умолчанию все оценки допустимы
    }

    // С правилом проверки оценок
    public Student(String name, Predicate<Integer> gradeValidator, int... grades) {
        this.name = name;
        this.gradeValidator = gradeValidator;
        setGrades(grades);
    }

    public void setGrades(int[] grades) {
        if (grades != null) {
            for (int grade : grades) {
                if (!gradeValidator.test(grade)) {
                    throw new InvalidGradeException(
                            "Некорректная оценка " + grade + " для студента " + name
                    );
                }
            }
        }
        this.grades = grades != null ? Arrays.copyOf(grades, grades.length) : null;
    }

    public int[] getGrades() {
        return grades != null ? Arrays.copyOf(grades, grades.length) : null;
    }

    public void addGrade(int grade) {
        if (!gradeValidator.test(grade)) {
            throw new InvalidGradeException(
                    "Некорректная оценка " + grade + " для студента " + name
            );
        }
        if (grades == null) {
            grades = new int[]{grade};
        } else {
            grades = Arrays.copyOf(grades, grades.length + 1);
            grades[grades.length - 1] = grade;
        }
    }

    public double getAverageGrade() {
        return Arrays.stream(grades).average().orElse(0.0);
    }

    public boolean isExcellentStudent() {
        if (grades == null || grades.length == 0) {
            return false; // Если оценок нет, студент не отличник
        }
        for (int grade : grades) {
            if (grade != 5) {
                return false;
            }
        }
        return true; // Все оценки равны 5
    }

    public boolean isValidGrade(int grade) {
        return gradeValidator.test(grade);
    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Double.compare(student.getAverageGrade(), getAverageGrade()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getAverageGrade());
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.getAverageGrade(), other.getAverageGrade());
    }
}