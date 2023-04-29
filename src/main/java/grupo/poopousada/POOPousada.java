package grupo.poopousada;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class POOPousada {

    private static Scanner scanner = new Scanner(System.in);
    private static Hospede hospede = new Hospede("hospedes.txt");
    private static Quarto quarto = new Quarto("quartos.txt", 0, 0, 0);
    private static Reserva reserva = new Reserva("reservas.txt");

    public static void main(String[] args) {
        int opcao = 0;

        do {
            System.out.println("========== POOPOUSADA2 ==========");
            System.out.println("1 - Cadastrar hóspede");
            System.out.println("2 - Cadastrar quarto");
            System.out.println("3 - Fazer reserva");
            System.out.println("4 - Consultar reservas por hóspede");
            System.out.println("5 - Consultar reservas por quarto");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarHospede();
                    break;
                case 2:
                    cadastrarQuarto();
                    break;
                case 3:
                    fazerReserva();
                    break;
                case 4:
                    consultarReservasPorHospede();
                    break;
                case 5:
                    consultarReservasPorQuarto();
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 6);
    }

    private static void cadastrarHospede() {
        scanner.nextLine();
        System.out.print("Digite o nome do hóspede: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do hóspede: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o telefone do hóspede: ");
        String telefone = scanner.nextLine();
        hospede.criarHospede(nome, cpf, telefone);
        System.out.println("Hóspede cadastrado com sucesso!");
    }

    private static void cadastrarQuarto() {
        System.out.print("Digite o número do quarto: ");
        int numero = scanner.nextInt();
        System.out.print("Digite a capacidade do quarto: ");
        int capacidade = scanner.nextInt();
        System.out.print("Digite o valor da diária: ");
        double valorDiaria = scanner.nextDouble();
        quarto = new Quarto("quartos.txt", numero, capacidade, valorDiaria);
        quarto.criarQuarto();
        System.out.println("Quarto cadastrado com sucesso!");
    }

    private static void fazerReserva() {
        scanner.nextLine();
        System.out.print("Digite o nome do hóspede: ");
        String nomeHospede = scanner.nextLine();
        System.out.print("Digite o número do quarto: ");
        int numQuarto = scanner.nextInt();
        System.out.print("Digite a data de início (dd-mm-aaaa): ");
        LocalDate dataInicio = LocalDate.parse(scanner.next());
        System.out.print("Digite a data de fim (dd-mm-aaaa): ");
        LocalDate dataFim = LocalDate.parse(scanner.next());
        reserva.criarReserva(nomeHospede, numQuarto, dataInicio, dataFim);
        System.out.println("Reserva realizada com sucesso!");
    }

   
    private static void consultarReservasPorHospede() {
        scanner.nextLine();
        System.out.print("Digite o nome do hóspede: ");
        String nomeHospede = scanner.nextLine();
        List<String> reservas = reserva.obterReservasPorHospede(nomeHospede);
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada para o hospede " + nomeHospede);
        } else {
            System.out.println("Reservas encontradas para o hospede " + nomeHospede + ":");
            for (String reserva : reservas) {
                String[] campos = reserva.split(";");
                System.out.println("Quarto: " + campos[1] + " | Data de inicio: " + campos[2] + " | Data de fim: " + campos[3]);
            }
        }
    }

    private static void consultarReservasPorQuarto() {
        System.out.print("Digite o número do quarto: ");
        int numQuarto = scanner.nextInt();
        List<String> reservas = reserva.obterReservasPorQuarto(numQuarto);
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada para o quarto " + numQuarto);
        } else {
            System.out.println("Reservas encontradas para o quarto " + numQuarto + ":");
            for (String reserva : reservas) {
                String[] campos = reserva.split(";");
                System.out.println("Hóspede: " + campos[0] + " | Data de inicio: " + campos[2] + " | Data de fim: " + campos[3]);
            }
        }
    }


}