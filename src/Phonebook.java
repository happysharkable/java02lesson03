import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, HashMap<String, ArrayList<String>>> phoneBook = new HashMap<>();

    /*
    При вызове метода происходит проверка на существование ключа (проверка на совпадение фамилии).
    Если записи не существует, то она создается в виде пар фамилия String  - список телефонов или почт ArrayList
    Если запись существует, то в соответствующие ArrayList'ы добавляются значения телефона и почты.
    Так как элементы ArrayList упорядочены по индексам, то всегда можно вывести данные по нужной фамилии.
     */
    public void addEntry(String lastname, String phone, String email) {
        ArrayList<String> phones = new ArrayList<>();
        ArrayList<String> emails = new ArrayList<>();
        if (phoneBook.containsKey(lastname)) {
            phoneBook.get(lastname).get("phone").add(phone);
            phoneBook.get(lastname).get("email").add(email);
        } else {
            HashMap<String, ArrayList<String>> entry = new HashMap<>();
            phones.add(phone);
            emails.add(email);
            entry.put("phone", phones);
            entry.put("email", emails);
            phoneBook.put(lastname, entry);
        }
    }

    public ArrayList<String> searchPhoneByLastname(String lastname) {
        ArrayList<String> phoneList = new ArrayList<>();
        if (phoneBook.containsKey(lastname)) {
            phoneList = phoneBook.get(lastname).get("phone");
        }
        return phoneList;
    }

    public ArrayList<String> searchEmailByLastname(String lastname) {
        ArrayList<String> phoneList = new ArrayList<>();
        if (phoneBook.containsKey(lastname)) {
            phoneList = phoneBook.get(lastname).get("email");
        }
        return phoneList;
    }
}
