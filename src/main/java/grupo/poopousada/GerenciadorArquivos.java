package grupo.poopousada;
import java.io.*;
import java.util.*;

public class GerenciadorArquivos {
    // Atributo que armazena o nome do arquivo a ser usado para salvar os dados
    private String nomeArquivo;

    public GerenciadorArquivos(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    // Método que salva os dados em um arquivo de texto
    public void salvarDados(List<String> dados) {
        try {
            FileWriter writer = new FileWriter(nomeArquivo);
            // Itera sobre a lista de dados e grava cada elemento em uma linha do arquivo
            for (String dado : dados) {
                writer.write(dado + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método que carrega os dados a partir de um arquivo de texto
    
    public  List<String> carregarDados() {
        List<String> dados = new ArrayList<>();
        try {
            File file = new File(nomeArquivo);
            // Verifica se o arquivo existe
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                // Itera sobre as linhas do arquivo e adiciona cada uma à lista de dados
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    dados.add(linha);
                }
                scanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dados;
    }
}
