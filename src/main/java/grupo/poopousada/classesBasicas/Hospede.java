package grupo.poopousada.classesBasicas;

/**
 *
 * @author user
 */

import java.util.*;

import grupo.poopousada.repositorio.GerenciadorArquivos;
import grupo.poopousada.repositorio.ModeloClasse;

public class Hospede implements ModeloClasse{
    private static Scanner scanner = new Scanner(System.in);
    public GerenciadorArquivos gerenciadorArquivos; 
    // Construtor da classe Hospede
    public Hospede() {
        gerenciadorArquivos = new GerenciadorArquivos("dados/hospedes.txt");
    }

    
    @Override
    public void listarDados() {
        // Carrega os dados já existentes do arquivo
        List<String> dados = gerenciadorArquivos.carregarDados();
        // Imprime os dados na tela
        for (String linha : dados) {
            String[] campos = linha.split(";");
            System.out.println("Nome " + campos[0] + " CPF: " + campos[1] + " Telefone: " + campos[2]);
        }
    }

    public String verificaTelefone(String texto){
        System.out.print(texto);
        String numero = scanner.nextLine();

        while (numero.length() != 11) { 
            System.out.println("O telefone precisa tem 2 digitos para o DD e mais 9 para o numero ");
            System.out.print(texto);
            numero = scanner.nextLine();
        }
        return numero;
    }

    public String buscaHospede(String nome){
        List<String> dados = gerenciadorArquivos.carregarDados(); 
        
        for (String linha : dados) {
            String[] parte = linha.split(";");
            if (parte[0].equals(String.valueOf(nome))) {
                return linha;
            }
        }
        return null;
    }


    @Override
    public void cadastrar() {
        List<String> dados = new ArrayList<String>();

        System.out.print("Digite o nome do hóspede: ");
        dados.add(scanner.nextLine());
    
       
        System.out.print("Digite o CPF do hóspede: ");
        dados.add(scanner.nextLine()); 
        
        dados.add(verificaTelefone("Digite o telefone do hóspede:"));

        gerenciadorArquivos.salvarDados(dados);
        System.out.println("Hóspede cadastrado com sucesso!");
    }

    public String valorCobrado(String numeroQuarto){
        GerenciadorArquivos dadosQuartos = new GerenciadorArquivos("dados/quartos.txt");
        List<String> quartos = dadosQuartos.carregarDados();

         for (String quarto : quartos) {
            String[] campos = quarto.split(";");
            if (campos[0].equals(numeroQuarto)) {
                return campos[2];
            }
        }
        return null;
    }

     
}
