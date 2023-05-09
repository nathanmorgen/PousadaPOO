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
   
    public void cadastrarHospede() {
        List<String> dados = new ArrayList<String>();

        System.out.print("Digite o nome do hóspede: ");
        dados.add(scanner.nextLine());
    

        System.out.print("Digite o CPF do hóspede: ");
        dados.add(scanner.nextLine());

        System.out.print("Digite o telefone do hóspede: ");
        dados.add(scanner.nextLine());

        setDados(dados);
        System.out.println("Hóspede cadastrado com sucesso!");
    }
}
