package ru.elizarov;

import ru.elizarov.generalized_methods.FunctionProcessor;
import ru.elizarov.generic.*;
import ru.elizarov.generic.Stack;
import ru.elizarov.geometry.Line;
import ru.elizarov.geometry.Point3D;
import ru.elizarov.study.Student;

import java.util.*;
import java.util.stream.Collectors;

import static ru.elizarov.generalized_methods.FunctionProcessor.applyFunction;
import static ru.elizarov.geometry.LineUtils.shiftLine;

public class Main {
    public static void main(String[] args) {
        System.out.println("6.1.1.");
        /*
        6.1.1 Обобщенная коробка. Создайте сущность Коробка, которая обладает следующими характеристиками:
Может хранить один произвольный объект в один момент времени.
Объект можно получить и разместить на хранение в любой момент времени.
Если объект забирают из коробки – ссылку на этот объект необходимо обнулить.
Если объект кладут в коробку, но она не пуста – необходимо выкинуть исключение.
Имеет метод проверки на заполненность.
Методы класса должны работать с тем типом данных, который был указан во время создания объекта
Создайте Коробку которая может хранить целочисленное значение, разместите туда число 3.
 Передайте Коробку в какой-либо метод, извлеките значение, и выведите его на экран.
         */
        try {
            Box<Integer> box = new Box<>();
            box.put(3);
            BoxUtils.processBox(box);
            BoxUtils.processBox(box);
        } catch (BoxNotEmptyException | BoxEmptyException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("--------------");

        System.out.println("6.1.2.");
        /*
        6.1.2 Без null. Создайте сущность Хранилище, которая обладает следующими характеристиками:
Может хранить один произвольный объект в один момент времени.
Хранилище неизменяемо.
Объект кладется в Хранилище при его создании. В качестве объекта может быть сохранено также и значение null.
Хранилище может вернуть ссылку на Объект.
Если вместо объекта хранится null, необходимо вернуть какое-либо альтернативное значение.
Метод получения значения должен работать с тем типом данных, который был указан во время создания объекта
Выполните следующие задания:
Создайте Хранилище чисел, положите туда значение null. Передайте Хранилище в какой-либо метод, извлеките значение, и выведите его на экран. Альтернативой должно быть число 0.
Создайте Хранилище чисел, положите туда значение 99. Передайте Хранилище в какой-либо метод, извлеките значение, и выведите его на экран. Альтернативой должно быть число -1.
Создайте Хранилище строк, положите туда значение null. Передайте Хранилище в какой-либо метод, извлеките значение, и выведите его на экран. Альтернативой должна быть строка “default”.
Создайте Хранилище строк, положите туда значение “hello”. Передайте Хранилище в какой-либо метод, извлеките значение, и выведите его на экран. Альтернативой должна быть строка “hello world”.
         */
        Storage<Integer> numberStorage1 = new Storage<>(null);
        System.out.println(numberStorage1.getValue(0));

        Storage<Integer> numberStorage2 = new Storage<>(99);
        System.out.println(numberStorage2.getValue(-1));
        Storage<String> stringStorage1 = new Storage<>(null);
        System.out.println(stringStorage1.getValue("default"));
        Storage<String> stringStorage2 = new Storage<>("hello");
        System.out.println(stringStorage2.getValue("hello world"));

        System.out.println("--------------");

        System.out.println("6.1.3.");
        /*
        6.1.3 Сравнимое. Создайте ссылочный тип Сравнимое, гарантирующий наличие по данной ссылке метода со следующими характеристиками:
Называется “сравнить” Принимает объект. Тип принимаемого объекта может быть изменен без изменения самого Сравнимого.
Возвращает целое число.
         */
        // Comparable в папке generic
        System.out.println("--------------");

        System.out.println("6.1.4.");
        /*
        6.1.4 Сравнимый студент. Создайте сущность Студент из задачи 5.1.6. Выполните реализацию Студентом метода “сравнить” из задачи 6.1.3. таким образом, чтобы:
Если средняя оценка текущего студента больше, чем у того с которым выполняется сравнение – возвращается 1.
Если средние оценки сравниваемых студентов одинаковы – возвращается 0.
Если средняя оценка текущего студента меньше, чем у того с которым выполняется сравнение – возвращается -1
Создайте двух студентов и сравните их между собой.
         */
        Student student1 = new Student("Петя", new int[]{5, 4, 3});
        Student student2 = new Student("Вася", new int[]{5, 5, 5});
        System.out.println(student1.compareTo(student2));
        System.out.println("--------------");

        System.out.println("6.1.5.");
        /*
        6.1.5 Обобщенная линия. Измените сущность Линия из задачи 5.1.3, таким образом, чтобы
При создании её объекта можно было точно указать тип точки, на которой расположена линия: двухмерная или трехмерная (из задачи 2.1.5).
Методы получения и установки значения Точки также могли работать с типом указанным при создании объекта.
Граница стирания не может быть хуже двумерной точки.
Создайте и выведите на экран произвольную линию в трехмерном пространстве.
         */
        Point3D p1 = new Point3D(1, 2, 3);
        Point3D p2 = new Point3D(4, 5, 6);
        Line<Point3D> line3D = new Line<>(p1, p2);
        System.out.println(line3D);
        System.out.println("Length: " + line3D.getLength());
        System.out.println("--------------");

        System.out.println("6.1.6.");
        /*

6.1.6 Стек. Реализуйте стандартную структуру данных типа стек.
Необходимо реализовать методы: push (положить элемент сверху),
pop (забрать элемент сверху), peek (просмотреть верхний элемент, не забирая его).
Обобщите эту структуру так, чтобы положить можно было элементы любого типа.
         */
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("Извлеченный элемент: " + stack.pop());
        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("--------------");

        System.out.println("6.2.1.");
        /*

6.2.1 Сдвинуть линию. Создайте метод, принимающий Линию из задачи 6.1.5
(с любой допустимой параметризацией) сдвигающей точку начала на 10 единиц по оси X.
Например, если X был 5, то должен стать 15, если X был -7 то должен стать -17.
         */
        Line<Point3D> line = new Line<>(new Point3D(5, 3, 2), new Point3D(10, 8, 6));
        System.out.println("До сдвига: " + line);
        shiftLine(line);
        System.out.println("После сдвига: " + line);
        System.out.println("--------------");

        System.out.println("6.2.2.");
        /*

6.2.2 Поиск максимума. Создайте метод, принимающий набор Коробок из задачи 6.1.1 и
возвращающий максимальное из их значений в формате double. Принимаемые методом Коробки
могут быть параметризованы любыми видами чисел.
         */
        try {
            Box<Integer> box1 = new Box<>();
            box1.put(5);
            Box<Double> box2 = new Box<>();
            box2.put(3.14);
            Box<Integer> box3 = new Box<>();
            box3.put(42);

            List<Box<? extends Number>> boxes = List.of(box1, box2, box3);
            double max = BoxUtils.findMax(boxes);
            System.out.println("Максимальное значение: " + max);
        } catch (BoxEmptyException | BoxNotEmptyException e) {
            e.printStackTrace();
        }
        System.out.println("--------------");

        System.out.println("6.2.3.");
        /*
6.2.3 Начало отсчета. Создайте метод, принимающий Коробку из задачи 6.1.1,
и кладет в неё трехмерную точку координат (из задачи 2.1.5) с произвольными значениями.
Метод должен позволять передавать Коробку с более чем одним видом параметризации.
         */
        try {
            Box<Point3D> pointBox = new Box<>();
            BoxUtils.putRandomPoint(pointBox);
            pointBox.extractAndPrint();
        } catch (BoxNotEmptyException | BoxEmptyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("--------------");

        System.out.println("6.2.4.");
        /*
6.2.4 Заполнение списка. Создайте метод, который принимает список чисел и заполняет
его значениями от 1 до 100. Метод должен принимать список с более чем одной параметризацией.
         */
        List<Integer> intList = new ArrayList<>();
        FunctionProcessor.fillList(intList);
        System.out.println("Заполненный List<Integer>: " + intList);

        // из-за <? super Integer>
        List<Number> numberList = new ArrayList<>();
        FunctionProcessor.fillList(numberList);
        System.out.println("Заполненный List из Number: " + numberList);
        System.out.println("--------------");

        System.out.println("6.3.1.");
        /*
6.3.1 Функция. Разработайте такой метод, который будет принимать список значений типа T, и объект имеющий единственный метод apply. Данный метод надо применить к каждому элементу списка, и вернуть новый список значений типа P, при этом типы T и P могут совпадать, а могут не совпадать.
Используйте разработанный метод следующим образом:
Передайте в метод список со значениями: “qwerty”, “asdfg”, “zx”, а получите список чисел, где каждое число соответствует длине каждой строки.
Передайте в метод список со значениями: 1,-3,7, а получите список в котором все отрицательные числа стали положительными, а положительные остались без изменений
Передайте в метод список состоящий из массивов целых чисел, а получите список в котором будут только максимальные значения каждого из исходных массивов

         */
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<Integer> lengths = applyFunction(strings, String::length);
        System.out.println("Длины строк: " + lengths);

        List<Integer> numbers = List.of(1, -3, 7);
        List<Integer> absoluteValues = applyFunction(numbers, Math::abs);
        System.out.println("Модули чисел: " + absoluteValues);

        List<int[]> arrays = List.of(new int[]{3, 7, 1}, new int[]{10, 2, 8}, new int[]{5, 9, 4});
        List<Integer> maxValues = applyFunction(arrays, arr ->
                Arrays.stream(arr).max().orElseThrow()
        );
        System.out.println("Максимальные значения массивов: " + maxValues);
        System.out.println("--------------");

        System.out.println("6.3.2.");
        /*
6.3.2 Фильтр. Разработайте такой метод, который будет принимать список значений типа T и объект имеющий единственный метод test (принимает T и возвращает boolean). Верните новый список типа T, из которого удалены все значения не прошедшие проверку условием.
Используйте разработанный метод следующим образом:
Передайте в метод список со значениями: “qwerty”, “asdfg”, “zx”, и отфильтруйте все строки имеющие менее трех символов
Передайте в метод список со значениями: 1,-3,7, и отфильтруйте все положительные элементы
Передайте в метод список состоящий из массивов целых чисел, а получите список в котором будут только те массивы, в которых нет ни одного положительного элемента
         */
        List<String> words = List.of("qwerty", "asdfg", "zx");
        List<String> filteredWords = FunctionProcessor.filterList(words, s -> s.length() >= 3);
        System.out.println(filteredWords);

        List<Integer> numbers3 = List.of(1, -3, 7);
        List<Integer> filteredNumbers = FunctionProcessor.filterList(numbers3, n -> n <= 0);
        System.out.println(filteredNumbers);


        List<int[]> arrays4 = List.of(new int[]{-1, -2, -3}, new int[]{0, 2, -4}, new int[]{-5, -6, -7});
        List<int[]> filteredArrays = FunctionProcessor.filterList(arrays4, arr ->
                Arrays.stream(arr).allMatch(n -> n <= 0)
        );
        System.out.println(filteredArrays.size());
        System.out.println("--------------");

        System.out.println("6.3.3.");
        /*
6.3.3 Сокращение. Разработайте такой метод, который будет принимать список значений типа T и способ с помощью которого список значений можно свести к одному значению типа T, которое и возвращается из метода.
Используйте разработанный метод следующим образом:
Передайте в метод список со значениями:  “qwerty”, “asdfg”, “zx”, и сформируйте одну большую строку, которая состоит из всех строк исходного списка.
Передайте в метод список со значениями: 1,-3,7, и верните сумму всех значений исходного списка.
Имеется список,  состоящий из списков целых чисел, получите общеe количество элементов во всех списках. Подсказка: решить задачу можно в одно действие или последовательно использовать методы из 6.3.1 и 6.3.3.
Далее необходимо изменить разработанный метод таким образом, чтобы данный метод гарантированно не возвращал null и не выбрасывал ошибок в том случае, если исходный список пуст.
         */
        List<String> strings4 = List.of("qwerty", "asdfg", "zx");
        String concatenatedString = FunctionProcessor.reduce(strings4, "", (acc, str) -> acc + str);
        System.out.println("Объединённая строка: " + concatenatedString);

        List<Integer> numbers7 = List.of(1, -3, 7);
        Integer sum = FunctionProcessor.reduce(numbers7, 0, Integer::sum);
        System.out.println("Сумма чисел: " + sum);

        List<List<Integer>> nestedLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6)
        );

        long totalElements = nestedLists
                .stream()
                .flatMap(List::stream)
                .count();

        System.out.println("Общее количество элементов: " + totalElements);
        System.out.println("--------------");

        System.out.println("6.3.4.");
        /*
6.3.4 Коллекционирование. Разработайте такой метод, который будет возвращать коллекцию типа P со значениями типа T. Данный метод будет принимать:
Список исходных значений
Способ создания результирующей коллекции
Способ передачи значений исходного списка в результирующую коллекцию.
Используйте разработанный метод следующим образом:
Передайте в метод список со значениями: 1,-3,7, и верните их разбитыми на два подсписка, в одном из которых будут только положительные числа, а в другом только отрицательные.
Передайте в метод список со значениями:  “qwerty”, “asdfg”, “zx”, “qw” и верните их разбитыми на подсписки таким образом, чтобы в любом подсписке были строки только одинаковой длины
Передайте в метод список со значениями:  “qwerty”, “asdfg”, “qwerty”, “qw” и верните набор такого вида, который не может содержать одинаковые объекты.
         */
        // разбивка на + и -
        List<Integer> numbers12 = List.of(1, -3, 7);
        Map<Boolean, List<Integer>> partitionedNumbers = FunctionProcessor.collect(
                numbers12,
                HashMap::new,
                list -> list.stream().collect(Collectors.partitioningBy(n -> n > 0))
        );
        System.out.println("Разделение чисел: " + partitionedNumbers);

        // разбивка по длине
        List<String> strings12 = List.of("qwerty", "asdfg", "zx", "qw");
        Map<Integer, List<String>> groupedByLength = FunctionProcessor.collect(
                strings12,
                HashMap::new,
                list -> list.stream().collect(Collectors.groupingBy(String::length))
        );
        System.out.println("Разделение строк по длине: " + groupedByLength);

        // юник строки
        List<String> uniqueStrings1 = List.of("qwerty", "asdfg", "qwerty", "qw");
        Set<String> uniqueStrings2 = FunctionProcessor.collect(
                uniqueStrings1,
                HashSet::new,
                list -> new HashSet<>(list)
        );
        System.out.println("Уникальные строки: " + uniqueStrings2);
        System.out.println("--------------");
    }
}

