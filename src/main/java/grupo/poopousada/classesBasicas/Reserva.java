package grupo.poopousada.classesBasicas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import grupo.poopousada.repositorio.GerenciadorArquivos;

public class Reserva{
    private static Scanner scanner = new Scanner(System.in);
    public GerenciadorArquivos gerenciadorArquivos;

    // Construtor da classe Reserva
    public Reserva() {
        gerenciadorArquivos = new GerenciadorArquivos("dados/reservas.txt");
    }

    // Método para obter todas as reservas de um determinado hóspede
    
    public List<String> obterReservasPorHospede(String nomeHospede) {
        List<String> reservasHospede = new ArrayList<>();
        List<String> dados = gerenciadorArquivos.carregarDados();
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
        List<String> dados = gerenciadorArquivos.carregarDados();
        // Itera sobre as linhas do arquivo e adiciona à lista as reservas do quarto especificado
        for (String linha : dados) {
            String[] campos = linha.split(";");
            if (Integer.parseInt(campos[1]) == numQuarto) {
                reservasQuarto.add(linha);
            }
        }
        return reservasQuarto;
    }

    public void listarDados() {
        // Carrega os dados já existentes do arquivo
        List<String> dados = gerenciadorArquivos.carregarDados();
        // Imprime os dados na tela
        for (String linha : dados) {
            String[] campos = linha.split(";");
            System.out.println("Nome " + campos[0] + " número do quarto: " + campos[1] + " data de início: " + campos[3] + " data de fim: " + campos[4]);
        }
    }

    
    public void fazerReserva() {
        List<String> dados = new ArrayList<String>();
        System.out.print("O hospede é um estudante (s/n) : ");
        String isEstudante = scanner.nextLine();

        while(!isEstudante.equals("s") && !isEstudante.equals("n") ){
            System.out.println("Apenas 's' ou 'n'");
            System.out.print("O hospede é um estudante (s/n) : ");
            isEstudante = scanner.nextLine();
        }

        dados.add(verificaHospede());

        String numeruQuarto = verificaNumeroQuarto();
        dados.add(numeruQuarto);

        String data1 = validarData("Digite a data de início (dd/mm/aaaa): ",null);
        dados.add(data1);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dados.add(validarData("Digite a data de fim (dd/mm/aaaa): ",sdf.parse(data1))); 
            
            String valor ;

            if (isEstudante.equals("s")){
                HospedeEstudante estudante = new HospedeEstudante();
                valor = estudante.valorCobrado(numeruQuarto);
                dados.add(valor);
            }else{
                Hospede hospede = new Hospede();
                valor = hospede.valorCobrado(numeruQuarto);
                dados.add(valor);
            }
            gerenciadorArquivos.salvarDados(dados);

            System.out.println("O valor foi R$ " + valor);
            System.out.println("Reserva realizada com sucesso!");
        } catch (ParseException e) {
            System.out.println("Houver um erro com as datas tente novamente");
        }
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

    
    private String verificaNumeroQuarto(){
        Quarto quartos = new Quarto();
        String numeroQuarto;
        System.out.print("Digite o número do quarto: ");
        numeroQuarto = scanner.nextLine();

        while(true){
            try{
            int num = Integer.parseInt(numeroQuarto);  
                if (quartos.buscarQuarto(num) == null){
                    System.out.println("O quarto com o numero " + num + " não existe");
                    System.out.print("Digite o número do quarto novamente: ");
                    numeroQuarto = scanner.nextLine();
                    continue;
                }
                break;
            }catch(NumberFormatException e){
                System.out.println("O valor digitado não é um numero");
                System.out.print("Digite o número do quarto novamente: ");
                numeroQuarto = scanner.nextLine();
                continue;

            }
        }
       
        return numeroQuarto; 
    }

    private String verificaHospede(){
        Hospede hospedes = new Hospede();
        System.out.print("Digite o nome do hóspede: ");
        String nomeHospedes = scanner.nextLine();

        if(hospedes.buscaHospede(nomeHospedes) == null){
            System.out.println("O hospede com o nome " + nomeHospedes + " não foi cadastrado ");
            System.out.println(" Por favor termine o cadastro para continuar");
            List<String> dados = new ArrayList<String>();

            dados.add(nomeHospedes);
            
            System.out.print("Digite o CPF do hóspede: ");
            dados.add(scanner.nextLine()); 
        
            dados.add(hospedes.verificaTelefone("Digite o telefone do hóspede:"));

            hospedes.gerenciadorArquivos.salvarDados(dados);
            System.out.println("Hóspede cadastrado com sucesso!");
        }
        return nomeHospedes;
    }

    public static String validarData(String texto,Date data1) {
        if (data1 == null) {
            LocalDate dataAtual = LocalDate.now();
            data1 = Date.from(dataAtual.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }

        String dataString;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Não permitir datas inválidas, como 31/02/2023

        System.out.print(texto);
        dataString = scanner.nextLine();


        while(true){
            try {
                Date data = sdf.parse(dataString);

                if (data.after(data1) || data.equals(data1)) {
                    return dataString; // A data é válida e é no futuro ou hoje
                } else {
                    System.out.println("A data invalidade");
                    System.out.print(texto);
                    dataString = scanner.nextLine();
                    continue;
                }
            } catch (ParseException e) {
                System.out.println("Formato da data invalido");
                System.out.print(texto);
                dataString = scanner.nextLine();
                continue; 
            }
        }
        
    }

   
}
