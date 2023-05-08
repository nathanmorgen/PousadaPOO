package grupo.test;


import java.util.Scanner;

import grupo.poopousada.Hospede;
import grupo.poopousada.Quarto;
import grupo.poopousada.Reserva;

public class POOPousada {
    private static Scanner scanner = new Scanner(System.in);
    private static Hospede hospede = new Hospede("hospedes.txt");
    private static Quarto quarto = new Quarto("quartos.txt");
    private static Reserva reserva = new Reserva("reservas.txt");
    private static int opcao = 0;
    public static void main(String[] args) {
        do {
            menu();
        } while (opcao != 6);
    }

    private static void menu(){
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
                hospede.cadastrarHospede();
                break;
            case 2:
                quarto.cadastrarQuarto();
                break;
            case 3:
                reserva.fazerReserva();
                break;
            case 4:
                reserva.consultarReservasPorHospede();
                break;
            case 5:
                reserva.consultarReservasPorQuarto();
                break;
            case 6:
                System.out.println("Encerrando o programa...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }
}