import model.Person;
import model.enums.Generation;
import sign.Sign;
import sign.factory.SignFactory;
import sign.service.ColorService;
import sign.service.SignService;
import sign.service.ValidateService;
import sign.ui.UI;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SignService signService = new SignService();
        ColorService colorService = new ColorService();
        ValidateService validateService = new ValidateService();

        List<Person> people = new ArrayList<>();

        boolean stop;
        do {
            try {
                UI.clearConsole();
                UI.printBanner();

                colorService.yellow("Digite o seu nome: ");
                String name = validateService.readName(sc);

                colorService.yellow("Digite a data do seu nascimento (dd/MM/yyyy): ");
                LocalDate localDate = validateService.readDate(sc);

                colorService.yellow("Digite a hora do seu nascimento (HH:mm): ");
                LocalTime localTime = validateService.readTime(sc);

                colorService.yellow("Digite o seu estado de nascimento: ");
                String zone = validateService.readZone(sc);

                LocalDateTime localDateTime = LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), localTime.getHour(), localTime.getMinute(), localTime.getSecond());

                Sign sign = new SignFactory().create(MonthDay.of(localDateTime.getMonth(), localDateTime.getDayOfMonth()));

                people.add(new Person(name, zone, localDate, sign, sign.getRisingSign(localTime), signService.getAge(localDateTime), signService.generation(Year.of(localDateTime.getYear()))));

                System.out.println();

            } catch (IllegalArgumentException e) {
                colorService.red("\n" + e.getMessage());
                colorService.red("\nAperte ENTER para continuar");
                sc.nextLine();
            }

            stop = validateService.checkUserAnswer(sc, "\nVocê deseja continuar? (S/N) ");

        } while (stop);

        sc.close();

        //Obter a lista de pessoas que são do signo X e tem mais de Y anos.
        System.out.println("Pessoas do signo Câncer e maior de 20 anos: " + people.stream().filter(person -> person.getSign().toString().equals("Câncer")).filter(person -> person.getAge() > 20).collect(Collectors.toList()));

        //Obter a lista e a quantidade de pessoas que são menor e maior de idade
        System.out.println("Pessoas menores de idade: " + people.stream().filter(person -> person.getAge() < 18).collect(Collectors.toList()));

        //Obter a lista de pessoas que pertencem a geração {}
        System.out.println("Pessoas da geracão Z: " + people.stream().filter(person -> person.getGeneration() == Generation.Z).collect(Collectors.toList()));

        //Obter a lista de todas as pessoas e informar a idade delas na próxima copa do mundo
        people.forEach(person -> System.out.println(person.getName() + " terá " + (person.getAge() + 4) + " anos"));

        //Obter a pessoa mais velha e mais nova
        System.out.println("Pessoa mais nova: " + people.stream().mapToInt(Person::getAge).min().orElse(-1));
        System.out.println("Pessoa mais velha: " + people.stream().mapToInt(Person::getAge).max().orElse(-1));

        //Calcular a idade média e total das pessoas
        int total = people.size();
        System.out.println("Média das idades: " + people.stream().mapToInt(Person::getAge).average().orElse(-1));
        System.out.println("Total de pessoas: " + total);

    }
}