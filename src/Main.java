import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    /**К нам снова обратились за помощью, но теперь уже для того, чтобы написать алгоритм,
     * разбивающий одну строку с Ф. И. О. на три — на фамилию, имя и отчество.
     В качестве исходных данных используйте:
     Ф. И. О. сотрудника: “Ivanov Ivan Ivanovich”;
     строка fullName— для хранения Ф. И. О. сотрудника в формате фамилия - имя - отчество;
     переменная firstName — для хранения имени;
     переменная middleName — для хранения отчества;
     переменная lastName — для хранения фамилии.
     Решите задание с помощью метода substring().
     Результат программы выведите в формате:
     “Имя сотрудника — …”
     “Фамилия сотрудника — …”
     “Отчество сотрудника — ...”

     *Важно**: «в голове» высчитывать позиции пробелов и параметров для обрезания строки запрещено.
     Их должен вычислить компьютер.

     - **Подсказка**
     Определить индексы символов помогут методы indexOf() и lastIndexOf().
     *
     */
    public static void task1() {
        System.out.println("Задача 1");
        String fullName = "Ivanov Ivan Ivanovich";
        String firstName = fullName.substring(fullName.indexOf(" ")+1, fullName.lastIndexOf(" "));
        System.out.println("Имя сотрудника — " + firstName);
        String middleName = fullName.substring(fullName.lastIndexOf(" ")+1);
        System.out.println("Отчество сотрудника — " + middleName);
        String lastName = fullName.substring(0, fullName.indexOf(" "));
        System.out.println("Фамилия сотрудника — " + lastName);
    }

    /**Периодически данные в наших регистрах заполняются неверно,
     и Ф. И. О. сотрудников записывают со строчных букв.
     Такую оплошность нужно исправить, написав программу, которая преобразует написанное сострочных букв Ф. И. О.
     в правильный формат.
     В качестве исходных данных используйте строку fullName c данными “ivanov ivan ivanovich“,
     которые нужно преобразовать в “Ivanov Ivan Ivanovich”.

     Выведите результат программы в консоль в формате: “Верное написание Ф. И. О. сотрудника с заглавных букв —  …”
     - **Подсказка 1**
     Метод toCharArray() может быть полезен.

     - **Подсказка 2**
     Для преобразования символа в верхний регистр следует использовать метод Character.toUpperCase(c),
     где c — символ.
     */
    public static void task2() {
        System.out.println("Задача 2");
        String fullName = "ivanov ivan ivanovich";
        char[] full = fullName.toCharArray();
        full[0] = Character.toUpperCase(full[0]);
        for (int i = 1; i < full.length; i++) {
            if (full[i] == ' ') {
                full[i+1] = Character.toUpperCase(full[i+1]);
            }
        }
        String result = new String(full);
        System.out.println("Верное написание Ф. И. О. сотрудника с заглавных букв — " + result);
    }
    /**Имеется две строки.
     Первая: "135"
     Вторая: "246"
     Соберите из двух строк одну, содержащую данные "123456".
     Использовать сортировку нельзя.
     Набор чисел задан для понимания позиций, которые они должны занять в итоговой строке.
     Выведите результат в консоль в формате: “Данные строки — ….”

     - **Подсказка**
     Следует использовать StringBuilder.
     */
    public static void task3(){
        System.out.println("Задача 3");
        String first = "135";
        String second = "246";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < first.length(); i++){
            result.append(first.charAt(i));
            result.append(second.charAt(i));
        }
        System.out.println("Данные строки — " + result);
    }
    /**Дана строка из букв английского алфавита "aabccddefgghiijjkk".
    Нужно найти и напечатать буквы, которые дублируются в строке.
    Обратите внимание, что строка отсортирована, т.е. дубли идут друг за другом.
    В итоге в консоль должен быть выведен результат программы: "acdgijk".
    */
    public static void task4() {
        System.out.println("Задача 4");
        String letters = "aabccddefgghiijjkk";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < letters.length()-1; i++) {
            if (letters.charAt(i) == letters.charAt(i+1)) {
                result.append(letters.charAt(i));
            }
        }
        System.out.println(result);
    }
    /**
     * Напишите метод, который получает на вход массив и переставляет все его элементы в обратном порядке.
     * Подобное задание вы решали в домашнем задании по массивам.
     * В метод приходит массив, допустим:
     * {3, 2, 1, 6, 5}.
     * Нужно без вспомогательного массива переместить элементы так, чтобы поданный массив стал: {5, 6, 1, 2, 3}.
     * Рекомендуем написать этот метод без возвращаемого значения. Вы будете приятно удивлены, что даже если мы не вернем массив, первоначальный массив изменится, когда мы будем модернизировать пришедший в виде параметра массив внутри метода.
     * Причину такого поведения ссылочных типов (объектов) вы узнаете на следующем уроке или на QA-вебинаре.
     */
    public static void sortArray (int[] array) {
        for(int i = 0; i < array.length/2; i++) {
            int number = array[i];
            int newIndexOfNumber = (array.length-1) - i;
            int newNumber = array[newIndexOfNumber];
            array[newIndexOfNumber] = number;
            array[i] = newNumber;
        }
        System.out.println(Arrays.toString(array));
    }
    public static void task5(){
        System.out.println("Задача 5");
        int[] numbers = {3, 2, 1, 6, 5};
        sortArray(numbers);
    }
    /**
     * Вернемся к задаче о валидаторе текста из урока по строкам.
     * - Условие задачи из урока 1.7
     *     Дана строка из букв английского алфавита "aabccddefgghiijjkk".
     *     Нужно найти и напечатать буквы, которые дублируются в строке.
     *     Обратите внимание, что строка отсортирована, т.е. дубли идут друг за другом.
     *     В итоге в консоль должен быть выведен результат программы: "acdgijk".

     Напишите метод, который в виде параметра принимает отсортированную строку.
     * Например, aabccddefgghiijjkk.
     * С помощью цикла проверьте, что в строке нет дублей, и выведите в консоль сообщение об этом.
     * Если дубль найден, нужно прервать поиск по остальным символам и вывести сообщение о присутствии дубля,
     * причем с указанием, какой именно символ задублирован. Затем сразу же прервать выполнение метода.
     * Сам метод ничего возвращать не должен (void).
     */
    public static void checkDoubles(String letters) {
        int sum = 0;
        for (int i = 0; i < letters.length() - 1; i++) {
            if (letters.charAt(i) != letters.charAt(i + 1)) {
                sum++;
            } else {
                System.out.println("В строке есть дубль - " + letters.charAt(i));
                return;
            }
        }
        if (sum == letters.length()) {
            System.out.println("В строке нет дублей");
        }
    }
    public static void task6() {
        System.out.println("Задача 6");
        String word = "aabccddefgghiijjkk";
        checkDoubles(word);
    }
    /**Снова вспоминаем домашнее задание по массивам.
     * В нем была задача, которая требовала высчитать среднюю выплату за день.
     Был дан сгенерированный массив из 30 значений от 100 до 200 тысяч,
     для его генерации допускается использовать метод из прошлого домашнего задания.

     - Текст прошлого задания
     Нам нужно понять, какую в среднем сумму наша компания тратила в течение данных 30 дней.
     Нужно написать программу, которая посчитает среднее значение трат за месяц (то есть сумму всех трат за месяц поделить на количество дней),
     и вывести в консоль результат в формате: «Средняя сумма трат за месяц составила … рублей».
     **Важно помнить:** подсчет среднего значения может иметь остаток (то есть быть не целым, а дробным числом).
     *
     Нужно сгенерировать массив, подать его в наш метод, а внутри метода подсчитать сумму элементов
     и вычислить среднее значение, которое нужно вернуть из метода в виде результата.

     Сложность в том, что метод нужно не просто написать, но еще и декомпозировать.
     То есть для работы этого метода нужно будет создать еще методы (1 или более),
     которые его будут обслуживать и вычислять промежуточные результаты. Среднее значение нужно вычислять в дробном виде, так как результат должен быть точным.
     */
    public static int[] generateRandomArray() {
        Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
    public static int calculateExpensesOfMonth(int[] array) {
        int sum = 0;
        for (int element: array) {
            sum += element;
        }
        return sum;
    }
    public static double calculateAveragePerMonth(int total, int days){
        return (double) total/days;
    }
    public static void printAveragePerMonth(double resultAverage){
        System.out.println("Средняя сумма трат за месяц составила " + resultAverage + " рублей");
    }
    public static void task7(){
        System.out.println("Задача 7");
        int[] costs = generateRandomArray();
        int sumMonth = calculateExpensesOfMonth(costs);
        double averageMonth = calculateAveragePerMonth(sumMonth, costs.length);
        printAveragePerMonth(averageMonth);
    }
}