package service;


import dao.PersonDAO;
import model.Person;

import java.util.List;

public class PersonService {
    PersonDAO personDAO = new PersonDAO();

    public List<Person> listPeople() {
        return personDAO.listPerson();
    }

    public Person listOnePerson(PersonDAO personDAO, Integer id) {
        return personDAO.findPersonById(id);
    }

    public void updateAPerson(Person person, PersonDAO personDAO, Integer id) {
        personDAO.updatePerson(person);
    }

    public void deleteAPerson(PersonDAO personDAO, Integer id) {
        personDAO.deletePerson(id);
    }
}
