package grupo.poopousada;

/**
 *
 * @author user
 */

import java.util.*;

public class Hospede extends GerenciadorArquivos {
    private static Scanner scanner = new Scanner(System.in);
    // Construtor da classe Hospede
    public Hospede(String nomeArquivo) {
        super(nomeArquivo);
    }

    // Método para criar um novo hóspede
    private void criarHospede(String nome, String cpf, String telefone) {
        // Carrega os dados já existentes do arquivo
        List<String> dados = carregarDados();
        // Cria uma nova linha para o hóspede
        String novaLinha = nome + ";" + cpf + ";" + telefone;
        // Adiciona a nova linha aos dados já existentes
        dados.add(novaLinha);
        // Salva os dados atualizados no arquivo
        salvarDados(dados);
    }

    
    public void cadastrarHospede() {
        System.out.print("Digite o nome do hóspede: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do hóspede: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o telefone do hóspede: ");
        String telefone = scanner.nextLine();
        criarHospede(nome, cpf, telefone);
        System.out.println("Hóspede cadastrado com sucesso!");
    }
}
