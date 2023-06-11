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
            System.out.println("Nome " + campos[0] + " CPF: " + campos[1] + " Telefone: " + campos[2]);
        }
    }

    private String verificaTelefone(String texto){
        System.out.print(texto);
        String numero = scanner.nextLine();

        while (numero.length() != 11) { 
            System.out.println("O telefone precisa tem 2 digitos para o DD e mais 9 para o numero ");
            System.out.print(texto);
            numero = scanner.nextLine();
        }
        return numero;
    }


   
    public void cadastrarHospede() {
        List<String> dados = new ArrayList<String>();

        System.out.print("Digite o nome do hóspede: ");
        dados.add(scanner.nextLine());
    
       
        System.out.print("Digite o CPF do hóspede: ");
        dados.add(scanner.nextLine()); 
        
        dados.add(verificaTelefone("Digite o telefone do hóspede:"));

        salvarDados(dados);
        System.out.println("Hóspede cadastrado com sucesso!");
    }
}
