package ua.marchenko.springcourse.dao;

import org.springframework.stereotype.Component;
import ua.marchenko.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 45, "bob@yahho.com"));
        people.add(new Person(++PEOPLE_COUNT, "Sam", 18, "sam@sfd.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 87, "dsfds@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 33, "katy@perry.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(i -> i.getId() == id);
    }
}
