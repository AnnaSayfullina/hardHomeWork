import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
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
        int[] numbers = {3, 2, 1, 6, 5};
        sortArray(numbers);
    }

}