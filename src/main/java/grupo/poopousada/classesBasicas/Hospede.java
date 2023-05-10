package grupo.poopousada.classesBasicas;

/**
 *
 * @author user
 */

import java.util.*;

import grupo.poopousada.repositorio.GerenciadorArquivos;

public class Hospede extends GerenciadorArquivos {
    private static Scanner scanner = new Scanner(System.in);
    // Construtor da classe Hospede
    public Hospede(String nomeArquivo) {
        super(nomeArquivo);
    }

    
    public void listarDados() {
        // Carrega os dados já existentes do arquivo
        List<String> dados = carregarDados();
        // Imprime os dados na tela
        for (String linha : dados) {
            String[] campos = linha.split(";");
            System.out.println("Nome " + campos[0] + " CPF: " + campos[1] + " Telefone: " + campos[3]);
        }
    }


   
    public void cadastrarHospede() {
        List<String> dados = new ArrayList<String>();

        System.out.print("Digite o nome do hóspede: ");
        dados.add(scanner.nextLine());
    

        System.out.print("Digite o CPF do hóspede: ");
        dados.add(scanner.nextLine());

        System.out.print("Digite o telefone do hóspede: ");
        dados.add(scanner.nextLine());

        salvarDados(dados);
        System.out.println("Hóspede cadastrado com sucesso!");
    }
}
