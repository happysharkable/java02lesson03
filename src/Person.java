public class Person {

    Person(Phonebook phonebook, String lastname, String phone, String email) {
        phonebook.addEntry(lastname, phone, email);
    }

}
