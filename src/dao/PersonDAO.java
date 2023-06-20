package dao;

import factory.ConnectionFactory;
import model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe PersonDAO implementando Métodos definidos na Interface IPersonDAO
 */
public class PersonDAO implements IPersonDAO {
    private Connection connection = null;
    private ResultSet resultSet;
    private PreparedStatement pstm;

    /**
     * Lista de Pessoas
     * @return Lista Pessoas
     **************************/
    @Override
    public List<Person> listPerson() {
        Person person = null;
        List<Person> listPerson = null;

        try {
            connection = ConnectionFactory.connect();
            pstm = connection.prepareStatement("SELECT * FROM Person");
            resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                person = new Person();
                person.setId(resultSet.getInt(1));
                person.setName(resultSet.getString(2));
                person.setCpf(resultSet.getString(3));
                person.setEmail(resultSet.getString(4));
                person.setPhone(resultSet.getString(5));

                listPerson = new ArrayList<>();
                listPerson.add(person);
            }

            connection.close();
            pstm.close();
            resultSet.close();

            return listPerson;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Retorna uma Pessoa pelo ID
     * @param id
     * @return Pessoa
     **************************/
    @Override
    public Person findPersonById(Integer id) {
        Person person = new Person();

        try {
            connection = ConnectionFactory.connect();
            pstm = connection.prepareStatement("SELECT * FROM Person WHERE id = ?");
            pstm.setInt(1, id);
            resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                person.setName(resultSet.getString(2));
                person.setCpf(resultSet.getString(3));
                person.setEmail(resultSet.getString(4));
                person.setPhone(resultSet.getString(5));
            }

            connection.close();
            pstm.close();

            return person;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Adiciona uma Pessoa
     * @param person
     **************************/
    @Override
    public void addPerson(Person person) {
        try {
            connection = ConnectionFactory.connect();
            pstm = connection.prepareStatement("INSERT INTO Person (name, cpf, email, phone) VALUES (?, ?, ?, ?)");
            pstm.setString(1, person.getName());
            pstm.setString(2, person.getCpf());
            pstm.setString(3, person.getEmail());
            pstm.setString(4, person.getPhone());
            pstm.executeUpdate();

            pstm.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Atualiza uma Pessoa
     * @param person
     **************************/
    @Override
    public void updatePerson(Person person) {
        try {
            connection = ConnectionFactory.connect();
            pstm = connection.prepareStatement("UPDATE Person SET name = ?, cpf = ?, email = ?, phone = ?");
            pstm.setString(1, person.getName());
            pstm.setString(2, person.getCpf());
            pstm.setString(3, person.getEmail());
            pstm.setString(4, person.getPhone());
            pstm.executeUpdate();

            connection.close();
            pstm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta uma Pessoa
     * @param id
     **************************/
    @Override
    public void deletePerson(Integer id) {
        try {
            connection = ConnectionFactory.connect();
            pstm = connection.prepareStatement("DELETE FROM Person WHERE id = ?");
            pstm.setInt(1, id);
            pstm.executeUpdate();

            connection.close();
            pstm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
