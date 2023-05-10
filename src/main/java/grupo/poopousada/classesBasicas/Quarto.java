package grupo.poopousada.classesBasicas;

import java.util.*;

import grupo.poopousada.repositorio.GerenciadorArquivos;

public class Quarto extends GerenciadorArquivos {
    private static Scanner scanner = new Scanner(System.in);

    public Quarto(String nomeArquivo) {
        super(nomeArquivo);
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

    public void cadastrarQuarto() {
        List<String> dados = new ArrayList<String>();

        System.out.print("Digite o número do quarto: ");
        dados.add(scanner.nextLine());

        System.out.print("Digite a capacidade do quarto: ");
        dados.add(scanner.nextLine());

        System.out.print("Digite o valor da diária: ");
        dados.add(scanner.nextLine());

        salvarDados(dados);
        System.out.println("Quarto cadastrado com sucesso!");
    }


}   