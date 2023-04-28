package grupo.poopousada;

/**
 *
 * @author Nathazin & Juju
 */
import java.io.*;
//import java.util.ArrayList;
//import java.util.List;

//import java.io.*;
import java.util.*;

public class GerenciadorPousada {
    // Atributo que armazena a lista de hospedes
    private List<Hospede> hospedes;

    // Construtor que inicializa a lista de hospedes
    public GerenciadorPousada() {
        this.hospedes = new ArrayList<>();
    }

    // Método que adiciona um novo hospede na lista de hospedes
    public void adicionarHospede(Hospede hospede) {
        hospedes.add(hospede);
    }

    // Método que remove um hospede da lista de hospedes
    public void removerHospede(Hospede hospede) {
        hospedes.remove(hospede);
    }

    // Método que retorna a lista de hospedes
    public List<Hospede> getHospedes() {
        return hospedes;
    }

    // Método que salva os dados dos hospedes em um arquivo de texto
    public void salvarDados() {
        try {
            FileWriter writer = new FileWriter("dados.txt");
            // Itera sobre a lista de hospedes e grava os dados em formato CSV
            for (Hospede hospede : hospedes) {
                writer.write(hospede.getNome() + "," + hospede.getCpf() + "," + hospede.getEndereco() + "," + hospede.getTelefone() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método que carrega os dados dos hospedes a partir de um arquivo de texto
    public void carregarDados() {
        try {
            File file = new File("dados.txt");
            // Verifica se o arquivo existe
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                // Itera sobre as linhas do arquivo e cria um objeto Hospede para cada linha
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    String[] dados = linha.split(",");
                    Hospede hospede = new Hospede(dados[0], dados[1], dados[2], dados[3]);
                    hospedes.add(hospede);
                }
                scanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
