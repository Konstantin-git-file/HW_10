package ru.elizarov.main;

import ru.elizarov.geometry.Point;
import ru.elizarov.job.Department;
import ru.elizarov.job.Employee;
import ru.elizarov.math.Fraction;
import ru.elizarov.math.MathUtils;
import ru.elizarov.network.*;
import ru.elizarov.study.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.elizarov.math.StringCalculator.divideFirstByOthers;

public class Main {
    public static void main(String[] args) {
        System.out.println("3.1.3");
        /*
        3.1.3 Сложение из пакетов. С использованием метода из задачи 2.3.1 выполните следующее сложение:
7+113+3.21+12345678912345678912
Обратите внимание, что последнее число не может быть представлено
как примитив, в связи с чем необходимо воспользоваться для его представления
классом BigInteger из состава пакета java.math.
         */
        int a = 7;
        Fraction fraction = new Fraction(11, 3);
        double c = 3.21;
        BigInteger bigNumber = new BigInteger("12345678912345678912");
        double result = MathUtils.sum(a, fraction, c, bigNumber);
        System.out.println("Результат сложения: " + result);
        System.out.println("----------------");

        System.out.println("3.1.4");
        /*
        3.1.4 Возведение в степень. Создайте метод принимающий две строки, в которых будут
        записаны числа X и Y. Возвращает метод результат возведения X в степень Y. Для
        преобразования строки в число следует использовать метод Integer.parseInt, а
        для возведения в степень метод Math.pow. Вызовите разработанный метод передав туда
        параметры командной строки полученные точкой входа в программу. Реализуйте метод
        так, что бы для возведения в степень и преобразования строки использовались короткие
        имена статических методов.
         */
//        if (args.length < 2) {
//            System.out.println("нужно два числа ");
//            return;
//        }
//        String xStr = args[0];
//        String yStr = args[1];
//        try {
//            double result2 = PowerCalculator.calculatePower(xStr, yStr);
//            System.out.println(xStr + " в степени " + yStr + " = " + result2);
//        } catch (NumberFormatException e) {
//            System.out.println(" некорректные числа");
//        }
        System.out.println("----------------");

        System.out.println("3.1.5");
        /*
        3.1.5 Простые имена. Создайте и вывести на экран экземпляры двух классов: Точки
        координат из пакета ru.ermakov.geometry (задача 2.1.5), и точки координат
        из пакета java.awt.Point. Напишите код так, чтобы как минимум один из классов
        был доступен по простому имени.
         */
        Point myPoint = new Point(3, 4);
        System.out.println("Точка из ru.elizarov.geometry: " + myPoint.getTextRepresentation());
        System.out.println("Описание: " + myPoint.getDescription());
        java.awt.Point awtPoint = new java.awt.Point(5, 6);
        System.out.println("Точка из java.awt.Point: " + awtPoint);
        System.out.println("----------------");

        System.out.println("3.2.1");
        /*
        3.2.1 Отделы доверяют начальникам. Данная задача предполагает, что в результате
         выполнения 3.1.1, сущности Отдел и Сотрудник (задача 1.6.10) попали в один
         и тот же пакет. Ранее было выдвинуто требование о том, что Начальник отдела всегда
         работает в том же Отделе в котором он руководит. При реализации инкапсуляции на
         уровне класса это требование приводит к неэффективному и запутанному коду. Упростите
         решение, предполагая что инкапсуляция необходима только на уровне пакета.
         */
        Department itDepartment = new Department();
        itDepartment.setName("IT");
        Employee alice = new Employee();
        alice.setName("Алиса");
        Employee bob = new Employee();
        bob.setName("Боб");
        itDepartment.setManager(alice);
        System.out.println(itDepartment);
        itDepartment.addEmployee(bob);
        System.out.println(bob);
        itDepartment.removeEmployee(alice);
        System.out.println(itDepartment);
        System.out.println(alice);
        System.out.println("----------------");

        System.out.println("4.1.1.");
        /*
        4.1.1 Неправильные оценки. Необходимо изменить сущность Студент (2.3.9).
        В имеющемся решении, если студенту добавляется неправильная оценка, выбрасывается
        какая-то ошибка. Создайте исключение специально для этого случая и бросайте именно его.
        Такое исключение должно соответствовать следующим требованиям:
Тип исключения unchecked (не проверяемое)
Конструкторы: пустой, и со строкой
При выбрасывании исключения в строковом параметре указывайте имя студента, для которого
выброшена данная ошибка.

         */
        Student student1 = new Student("Аня", grade -> grade >= 2 && grade <= 5, 3, 4, 5);
        System.out.println(student1);
        student1.addGrade(5);
        System.out.println("После добавления: " + student1);
        try {
            student1.addGrade(6);
        } catch (InvalidGradeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        //с неправильной оценкой
        try {
            Student student2 = new Student("Ваня", grade -> grade >= 2 && grade <= 5, 3, 6, 4);
        } catch (InvalidGradeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("----------------");

        System.out.println("4.1.2.");
        /*
        4.1.2 Потеря связи. Необходимо разработать исключение, описывающее ситуацию потери
        сетевой связи. Такое исключение должно соответствовать следующим требованиям:
    Тип исключения checked (проверяемое)
    Конструкторы:
    Пустой
    Со строкой
    С причиной
    Комбинация строки и причины.

    это NetworkConnectionException в network
         */
        System.out.println("----------------");

        System.out.println("4.1.3.");
        /*
        4.1.3 Уже закрыто. Необходимо разработать исключение, описывающее ситуацию попытки
        использования закрытого ресурса. Такое исключение должно соответствовать следующим требованиям:
Тип исключения unchecked (не проверяемое)
Создается без параметров
         */
        Resource resource = new Resource();
        try {
            resource.close();
            resource.use(); // попытка использовать закрытый ресурс
        } catch (ResourceAlreadyClosedException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("----------------");

        System.out.println("4.1.4.");
        /*
        4.1.4 Подключение к сети. Необходимо разработать сущность Подключение, которое будет описывать связь с удаленным компьютером. Такая сущность имеет следующие характеристики:
Создается с указанием строки (фактически это адрес для связи)
После создания связь считается открытой.
Связь может быть закрыта
У Подключения можно запросить данные (в виде строки). При каждом запросе, случайным образом,
либо возвращайте текст “test connection”, либо выбрасывайте исключение разработанное в 4.1.2. Если подключение было закрыто, то при попытке запросить данные – бросайте исключение из 4.1.3.
         */
        Connection connection = new Connection("792.168.1.8");
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("Данные: " + connection.fetchData());
                } catch (NetworkConnectionException e) {
                    System.err.println("Ошибка сети: " + e.getMessage());
                }
            }
        } catch (ResourceAlreadyClosedException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            connection.close();
        }
        // запрашиваем после закрытия соединения
        try {
            connection.fetchData();
        } catch (ResourceAlreadyClosedException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (NetworkConnectionException e) {
            System.err.println("Ошибка сети: " + e.getMessage());
        }
        System.out.println("----------------");

        System.out.println("4.2.1.");
        /*
        4.2.1 Читаем данные. Разработайте метод, который ничего не принимает и не возвращает, при этом выполняет следующие действия:
Шаг 1. Создаем подключение по адресу ermakov.edu
Шаг 2. Считываем и выводим на экран десять строк.
Шаг 3. Закрываем соединение.
Гарантируйте, что третий шаг будет выполнен вне зависимости от того, были ли брошены какие-либо исключения на втором шаге.
         */
        DataReader.readData();
        System.out.println("----------------");

        System.out.println("4.2.2.");
        /*
        4.2.2 Складываем строки. Разработайте метод, который принимает набор строк.
        Все числа в списке необходимо преобразовать к числу, и поделить первое число
         в списке на остальные числа в списке. Любую строку, не являющуюся числом,
         следует игнорировать. Результат деления верните из метода.
         */
        List<String> input = List.of("10", "abc", "2", "3.5", "0", "5", "xyz");
        double result9 = divideFirstByOthers(input);
        System.out.println("Результат деления: " + result9);
        System.out.println("----------------");

        System.out.println("4.2.3.");
        /*
        4.2.3 Добавляем оценки. Разработайте метод, который принимает список Студентов
        (из задачи 4.1.1) и добавляет каждому из них случайную оценку в диапазоне от 1 до 10. В случае, если кому-то из студентов нельзя добавить оценку - она не добавляется никому, а метод возвращает информацию об этой ситуации.
Обратите внимание на особенности инкапсуляции студента: для каждого студента,
на этапе создания объекта, задано индивидуальное правило проверки корректности оценки.
Такое правило не может меняться в течении жизни объекта Студента, на него нельзя получить
 ссылку из объекта Студента либо как-либо вызывать проверку из вне объекта Студента.
         */
        List<Student> students = new ArrayList<>();
        students.add(new Student("Аня", grade -> grade >= 2 && grade <= 5, 3, 4, 5));
        students.add(new Student("Ваня", grade -> grade >= 2 && grade <= 5, 4, 5));
        students.add(new Student("Петя", grade -> grade >= 1 && grade <= 10, 2, 3));

        try {
            StudentService.addRandomGrades(students);
            System.out.println("Оценки успешно добавлены:");
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (GradeAdditionException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("----------------");

        System.out.println("4.2.4.");
        /*
        4.2.4 Восстановление студентов. Предположим имеется метод, указанный на рисунке 4.1.
Рис. 4.1. Метод преобразования строк к студенту
Суть этого метода сводится к тому, что он получает два списка строковых значений, и каким-то
(не важно каким) образом преобразует их к объектам типа Студент (из задачи 4.1.1). Первый список содержит параметры, с которыми вызывается конструктор, второй список содержит параметры для метода добавления оценок. В процессе преобразования может оказаться так, что этот метод падает с исключением, разработанным в задаче 4.1.1.
Реализуйте вызов этого метода и обработку результатов его выполнения следующим образом:
В качестве параметров передайте списки случайно выбранных строк.
Если преобразование прошло без ошибок, то на экран выводятся все студенты из списка
Если ошибка произошла в конструкторе – на экран выводится текст “студента Х создать невозможно”, где вместо Х указывается имя студента, для которого произошла ошибка.
Если ошибка произошла в методе добавления оценок студенту – необходимо вызывать метод convert
еще раз, передав в качестве второго параметра пустой список.  Полученный после этого список студентов необходимо вывести на экран.
Обратите внимание, что для данной задачи запрещено вносить изменения в классы исключения и Студента разработанные в 4.1.1.
         */

        List<String> constructorArgs = Arrays.asList("Срегей", "Мария", "Виктор");
        List<String> addArgs = Arrays.asList("5", "4", "6", "отлично");

        try {
            List<Student> students1 = StudentConverter.convert(constructorArgs, addArgs);
            System.out.println("Список студентов:");
            students1.forEach(System.out::println);

        } catch (InvalidGradeException e) {
            System.out.println("Ошибка добавления оценки: " + e.getMessage());
            System.out.println("Попытка повторного вызова convert без дополнительных аргументов...");
            // повторный вызов convert с пустым списком оценок
            List<Student> students2 = StudentConverter.convert(constructorArgs, new ArrayList<>());
            System.out.println("Список студентов после повторной попытки:");
            students2.forEach(System.out::println);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания студента: " + e.getMessage());
        }
    }
}
