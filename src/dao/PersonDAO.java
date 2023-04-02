package dao;

import model.Person;

import java.util.List;

/**
 * Classe PersonDAO implementando Métodos definidos na interface IPersonDAO
 */
public class PersonDAO implements IPersonDAO {

    /**
     * Retorna lista de Pessoas
     * @return
     */
    @Override
    public List<Person> listPerson() {
        return null;
    }

    /**
     * Retorna uma Pessoa pelo ID
     * @param id
     * @return
     */
    @Override
    public Person findPersonById(Integer id) {
        return null;
    }

    /**
     * Adiciona uma Pessoa
     * @param person
     */
    @Override
    public void addPerson(Person person) {

    }

    /**
     * Atualiza uma Pessoa
     * @param person
     */
    @Override
    public void updatePerson(Person person) {

    }

    /**
     * Deleta uma Pessoa
     * @param id
     */
    @Override
    public void deletePerson(Integer id) {

    }
}
