package application;

import Utils.Impressao;
import dao.PersonDAO;
import model.Person;
import service.PersonService;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Person person = null;
        PersonDAO personDAO = null;
        PersonService personService = new PersonService();
        Scanner scanner = new Scanner(System.in);

        // --- Cabeçalho ---
        System.out.println(Impressao.header());

        // --- Menu ---
        System.out.println(Impressao.menu());

        // --- Captura seleção do Menu ---
        int numberSelected = scanner.nextInt();

        switch (numberSelected) {
            case 1:
                personService.listPeople();
                break;
            case 2:
                personService.listOnePerson(null, null);
                break;
            case 3:
                personService.updateAPerson(null, null, null);
                break;
            case 4:
                personService.deleteAPerson(null, null);
                break;
            default:
                System.out.println("Nenhuma das Opções Escolhidas!");
                break;
        }
    }
}
