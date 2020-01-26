import java.util.HashMap;
import java.util.HashSet;

public class Main {

    private static HashSet listOfWords (String[] array) {
        HashSet consistsOf = new HashSet();

        for (String s : array)
            consistsOf.add(s);

        return consistsOf;
    }

    private static HashMap wordCount (String[] array) {
        HashMap<String, Integer> howManyWords = new HashMap<>();

        for (String s : array)
            howManyWords.put(s, howManyWords.containsKey(s) ? howManyWords.get(s) + 1 : 1);

        return howManyWords;
    }

    public static void main(String[] args) {
        String[] alphabet = {
            "Альфа", "Альфа", "Альфа",
            "Бета", "Бета",
            "Гамма",
            "Дельта", "Дельта", "Дельта", "Дельта",
            "Эпсилон", "Эпсилон", "Эпсилон",
            "Дзета", "Дзета", "Дзета", "Дзета", "Дзета",
            "Эта", "Эта", "Эта"
        };

        System.out.println(listOfWords(alphabet));
        System.out.println(wordCount(alphabet));

        Phonebook phonebook = new Phonebook();
        Person man1 = new Person(phonebook, "Ivanov", "+74951111111", "ivanov@email.com");
        Person man2 = new Person(phonebook,"Petrov", "+74951111112", "petrov@email.com");
        Person man3 = new Person(phonebook, "Sidorov", "+74951111113", "sidorov@email.com");
        Person man4 = new Person(phonebook,"Ivanov", "+74951111114", "ivanov@pochta.ru");

        // результат - один телефон и одна почта
        System.out.println(phonebook.searchPhoneByLastname("Petrov"));
        System.out.println(phonebook.searchEmailByLastname("Petrov"));

        // результат - два телефона и две почты, в порядке соответствия двум Ивановым
        System.out.println(phonebook.searchPhoneByLastname("Ivanov"));
        System.out.println(phonebook.searchEmailByLastname("Ivanov"));
    }
}
