package dao;

import model.Person;

import java.util.List;

/**
 * Interface de Pessoa
 */
public interface IPersonDAO {
    public List<Person> listPerson();
    public Person findPersonById(Integer id);
    public void addPerson(Person person);
    public void updatePerson(Person person);
    public void deletePerson(Integer id);
}
