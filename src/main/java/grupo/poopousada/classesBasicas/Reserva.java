package grupo.poopousada.classesBasicas;

import java.util.*;

import grupo.poopousada.repositorio.GerenciadorArquivos;

public class Reserva extends GerenciadorArquivos {
    private static Scanner scanner = new Scanner(System.in);

    // Construtor da classe Reserva
    public Reserva(String nomeArquivo) {
        super(nomeArquivo);
    }

    // Método para obter todas as reservas de um determinado hóspede
    
    public List<String> obterReservasPorHospede(String nomeHospede) {
        List<String> reservasHospede = new ArrayList<>();
        List<String> dados = carregarDados();
        // Itera sobre as linhas do arquivo e adiciona à lista as reservas do hóspede especificado
        for (String linha : dados) {
            String[] campos = linha.split(";");
            if (campos[0].equals(nomeHospede)) {
                reservasHospede.add(linha);
            }
        }
        return reservasHospede;
    }


    // Método para obter todas as reservas de um determinado quarto
    public List<String> obterReservasPorQuarto(int numQuarto) {
        List<String> reservasQuarto = new ArrayList<>();
        List<String> dados = carregarDados();
        // Itera sobre as linhas do arquivo e adiciona à lista as reservas do quarto especificado
        for (String linha : dados) {
            String[] campos = linha.split(";");
            if (Integer.parseInt(campos[1]) == numQuarto) {
                reservasQuarto.add(linha);
            }
        }
        return reservasQuarto;
    }

    
    public void fazerReserva() {
        List<String> dados = new ArrayList<String>();

        System.out.print("Digite o nome do hóspede: ");
        dados.add(scanner.nextLine());

        System.out.print("Digite o número do quarto: ");
        dados.add(scanner.nextLine());

        System.out.print("Digite a data de início (dd-mm-aaaa): ");
        dados.add(scanner.nextLine());

        System.out.print("Digite a data de fim (dd-mm-aaaa): ");
        dados.add(scanner.nextLine());

        salvarDados(dados);
        System.out.println("Reserva realizada com sucesso!");
    }

    public void consultarReservasPorHospede() {
        System.out.print("Digite o nome do hóspede: ");
        String nomeHospede = scanner.nextLine();
        List<String> reservas = obterReservasPorHospede(nomeHospede);
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

    
    public void consultarReservasPorQuarto() {
        System.out.print("Digite o número do quarto: ");
        int numQuarto = scanner.nextInt();
        List<String> reservas = obterReservasPorQuarto(numQuarto);
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
