package grupo.poopousada.Tela;
import java.util.Scanner;

import grupo.poopousada.Fachada.Fachada;


public class TelaPrincipal {
    private static Fachada fachada = new Fachada(); 
    private static Scanner scanner = new Scanner(System.in);
    private static int opcao = 0;

    public static void main(String[] args) {
        do {
            menu();
        } while (opcao != 6);
    }

    private static void menu(){
        System.out.println("");
        System.out.println("========== POOPOUSADA2 ==========");
        System.out.println("1 - Opções dos hóspede");
        System.out.println("2 - Opções dos quarto");
        System.out.println("3 - Opções dos reserva");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");
       
        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                muneHospede();
                break;
            case 2:
                muneQuartos();
                break;
            case 3:
                muneReserva();
                break;
            case 6:
                System.out.println("Encerrando o programa...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    private static void muneHospede(){
        System.out.println("");
        System.out.println("1 - Cadastrar hóspede");
        System.out.println("2 - Lista todos os hóspede");
        System.out.println("3 - Voltar");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");

        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                fachada.hospede.cadastrarHospede();
                break;
            case 2:
                fachada.hospede.listarDados();
                break;
            case 3:
                System.out.println("Voltar para menu principal");
                break;
            case 6:
                System.out.println("Encerrando o programa...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    private static void muneQuartos(){
        System.out.println("");
        System.out.println("1 - Cadastrar Quarto");
        System.out.println("2 - Lista todos os Quarto");
        System.out.println("3 - Excluir Quarto");
        System.out.println("4 - Voltar");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");

        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                fachada.quarto.cadastrarQuarto();
                break;
            case 2:
                fachada.quarto.listarDados();
                break;
            case 3:
                System.out.println("Você tem certeza que quer excluir um quarto? (s/n)");
                String tex = scanner.nextLine();
                if(tex.equals("s")){
                    System.out.println("Digite o numero do quarto a ser excluido");
                    int numero = scanner.nextInt();
                    fachada.quarto.excluirQuarto(numero);
                }
                break;
            case 4:
                System.out.println("Voltar para menu principal");
                break;
            case 6:

                System.out.println("Encerrando o programa...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    private static void muneReserva(){
        System.out.println("");
        System.out.println("1 - Fazer reserva");
        System.out.println("2 - Consultar reservas por hóspede");
        System.out.println("3 - Consultar reservas por quarto");
        System.out.println("3 - Lista reservas");
        System.out.println("5 - Voltar");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");

        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                fachada.reserva.fazerReserva();
                break;
            case 2:
                fachada.reserva.consultarReservasPorHospede();
                break;
            case 3:
                fachada.reserva.consultarReservasPorQuarto();
                break;
            case 4:
               fachada.reserva.listarDados();
                break;
            case 5:
                System.out.println("Voltar para menu principal");
                break;
            case 6:
                System.out.println("Encerrando o programa...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }
}
