package grupo.poopousada;

import java.util.Date;
/**
 *
 * @author Nathazin & Juju
 */
public class POOPousada {

    
    public static void main(String[] args) {
        
        GerenciadorPousada gerenciadorPousada = new GerenciadorPousada();

        // Adiciona alguns hospedes à lista
        /*gerenciadorPousada.adicionarHospede(new Hospede("João", "111.111.111-11", "Rua A, 123", "1111-1111"));
        gerenciadorPousada.adicionarHospede(new Hospede("Maria", "222.222.222-22", "Rua B, 456", "2222-2222"));
        gerenciadorPousada.adicionarHospede(new Hospede("Pedro", "333.333.333-33", "Rua C, 789", "3333-3333"));

        // Salva os dados dos hospedes em um arquivo de texto
        gerenciadorPousada.salvarDados();*/

        // Limpa a lista de hospedes
        //gerenciadorPousada.getHospedes().clear();

        // Carrega os dados dos hospedes a partir do arquivo de texto
        gerenciadorPousada.carregarDados();

        // Exibe os dados dos hospedes carregados
        for (Hospede hospede : gerenciadorPousada.getHospedes()) {
            System.out.println(hospede.getNome() + " - " + hospede.getCpf() + " - " + hospede.getEndereco() + " - " + hospede.getTelefone());
        }
        
    }
}   