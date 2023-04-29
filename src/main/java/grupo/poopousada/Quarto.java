package grupo.poopousada;

import java.util.List;

public class Quarto extends GerenciadorArquivos {

    private int numero;
    private int capacidade;
    private double valorDiaria;

    public Quarto(String nomeArquivo, int numero, int capacidade, double valorDiaria) {
        super(nomeArquivo);
        this.numero = numero;
        this.capacidade = capacidade;
        this.valorDiaria = valorDiaria;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    // Método para criar um novo quarto
    public void criarQuarto() {
        // Carrega os dados já existentes do arquivo
        List<String> dados = carregarDados();
        // Cria uma nova linha para o quarto
        String novaLinha = this.numero + ";" + this.capacidade + ";" + this.valorDiaria;
        // Adiciona a nova linha aos dados já existentes
        dados.add(novaLinha);
        // Salva os dados atualizados no arquivo
        salvarDados(dados);
    }

    // Método para buscar um quarto pelo número
    public String buscarQuarto(int numero) {
        // Carrega os dados já existentes do arquivo
        List<String> dados = carregarDados();
        // Itera sobre as linhas do arquivo e busca pelo número do quarto
        for (String linha : dados) {
            String[] partes = linha.split(";");
            if (partes[0].equals(String.valueOf(numero))) {
                return linha;
            }
        }
        // Se o número do quarto não for encontrado, retorna null
        return null;
    }

    // Método para atualizar as informações de um quarto
    public void atualizarQuarto(int numero, int capacidade, double valorDiaria) {
        // Carrega os dados já existentes do arquivo
        List<String> dados = carregarDados();
        // Itera sobre as linhas do arquivo e busca pelo número do quarto
        for (int i = 0; i < dados.size(); i++) {
            String linha = dados.get(i);
            String[] partes = linha.split(";");
            if (partes[0].equals(String.valueOf(numero))) {
                // Cria uma nova linha com as informações atualizadas do quarto
                String novaLinha = numero + ";" + capacidade + ";" + valorDiaria;
                // Substitui a linha antiga pela nova linha nos dados
                dados.set(i, novaLinha);
                // Salva os dados atualizados no arquivo
                salvarDados(dados);
                return;
            }
        }
    }


    // Método para excluir um quarto pelo número
    public void excluirQuarto(int numero) {
        // Carrega os dados já existentes do arquivo
        List<String> dados = carregarDados();
        // Itera sobre as linhas do arquivo e busca pelo número do quarto
        for (int i = 0; i < dados.size(); i++) {
            String linha = dados.get(i);
            String[] partes = linha.split(";");
            if (partes[0].equals(String.valueOf(numero))) {
                // Remove a linha do quarto dos dados
                dados.remove(i);
                // Salva os dados atualizados no arquivo
                salvarDados(dados);
                return;
            }
        }
    }

    // Método para listar todos os quartos
    public void listarQuartos() {
        // Carrega os dados já existentes do arquivo
        List<String> dados = carregarDados();
        // Imprime os dados na tela
        for (String linha : dados) {
            System.out.println(linha);
        }
    }

}   
