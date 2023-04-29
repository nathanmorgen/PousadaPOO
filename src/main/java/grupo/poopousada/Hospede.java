package grupo.poopousada;

/**
 *
 * @author user
 */

import java.util.*;

public class Hospede extends GerenciadorArquivos {

    // Construtor da classe Hospede
    public Hospede(String nomeArquivo) {
        super(nomeArquivo);
    }

    // Método para criar um novo hóspede
    public void criarHospede(String nome, String cpf, String telefone) {
        // Carrega os dados já existentes do arquivo
        List<String> dados = carregarDados();
        // Cria uma nova linha para o hóspede
        String novaLinha = nome + ";" + cpf + ";" + telefone;
        // Adiciona a nova linha aos dados já existentes
        dados.add(novaLinha);
        // Salva os dados atualizados no arquivo
        salvarDados(dados);
    }
    
}
