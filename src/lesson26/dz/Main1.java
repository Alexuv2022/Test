package lesson26.dz;

public class Main1 {
    public static void main(String[] args) {
        MultiMapImpt<String, String> phoneBook = new MultiMapImpt<>();

        phoneBook.put("Слава", "+798734838438");
        phoneBook.put("Слава", "+98734384444");
        phoneBook.put("Слава", "+33333333");
        phoneBook.put("Петя", "+7985-533-43-22");
        phoneBook.put("Слава", "+98836667890");
        phoneBook.put("Слава", "+98811111111");

        System.out.println("Заполненная телефонная книга");
        phoneBook.print();

        System.out.println();
        // Подсчёт количества значений по ключу
        System.out.println("Количество значений по ключу \"Слава\": " + phoneBook.countValues("Слава"));
        System.out.println("Количество значений по ключу \"Петя\": " + phoneBook.countValues("Петя"));
        System.out.println();

        // Итерация по ключу
        System.out.println("Итерация по ключу \"Слава\"");
        phoneBook.valuesIterator("Слава");
        phoneBook.valuesIterator("Слава");
        phoneBook.valuesIterator("Слава");
        phoneBook.valuesIterator("Слава");
        phoneBook.valuesIterator("Слава");
        System.out.println();

        // проверка итератора на null, если null, то Yes
        System.out.println("Проверка итератора на null, если null, то Yes");
        if (phoneBook.valuesIterator("Слава") == null) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println();
        System.out.println("Последний добавленный элемент по ключу \"Слава\"");
        System.out.println(phoneBook.get("Слава"));

        System.out.println();
        // Удаление всех значений по ключу "Слава"
        phoneBook.remove("Слава");

        System.out.println("Заполненная телефонная книга после удаления значений по ключу \"Слава\"");
        phoneBook.print();
        System.out.println();

        System.out.println("Последний добавленный элемент по ключу \"Слава\" без значений");
        System.out.println(phoneBook.get("Слава"));
        System.out.println();

        // проверка итератора по ключу без значений на null, если null, то Yes
        System.out.println("Проверка итератора по ключу без значений на null, если null, то Yes");
        if (phoneBook.valuesIterator("Слава") == null) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println();
    }
}
