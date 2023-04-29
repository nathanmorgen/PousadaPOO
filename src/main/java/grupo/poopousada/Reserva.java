package grupo.poopousada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva extends GerenciadorArquivos {

    // Construtor da classe Reserva
    public Reserva(String nomeArquivo) {
        super(nomeArquivo);
    }

    // Método para criar uma nova reserva
    public void criarReserva(String nomeHospede, int numQuarto, LocalDate dataInicio, LocalDate dataFim) {
        // Carrega os dados já existentes do arquivo
        List<String> dados = carregarDados();
        // Cria uma nova linha para a reserva
        String novaLinha = nomeHospede + ";" + numQuarto + ";" + dataInicio + ";" + dataFim;
        // Adiciona a nova linha aos dados já existentes
        dados.add(novaLinha);
        // Salva os dados atualizados no arquivo
        salvarDados(dados);
    }

    // Método para obter todas as reservas de um determinado hóspede
    
    public List<String> obterReservasPorHospede(String nomeHospede) {
        List<String> reservasHospede = new ArrayList<>();
        List<String> dados = carregarDados();
        // Itera sobre as linhas do arquivo e adiciona à lista as reservas do hóspede especificado
        for (String linha : dados) {
            String[] campos = linha.split(";");
            if (campos[0].equals(nomeHospede)) {
                reservasHospede.add(linha);
            }
        }
        return reservasHospede;
    }


    // Método para obter todas as reservas de um determinado quarto
    public List<String> obterReservasPorQuarto(int numQuarto) {
        List<String> reservasQuarto = new ArrayList<>();
        List<String> dados = carregarDados();
        // Itera sobre as linhas do arquivo e adiciona à lista as reservas do quarto especificado
        for (String linha : dados) {
            String[] campos = linha.split(";");
            if (Integer.parseInt(campos[1]) == numQuarto) {
                reservasQuarto.add(linha);
            }
        }
        return reservasQuarto;
    }
}
