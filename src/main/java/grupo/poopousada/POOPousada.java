package grupo.poopousada;

import java.util.Date;
/**
 *
 * @author Nathazin & Juju
 */
public class POOPousada {

    public static void main(String[] args) {
        Quarto quarto1 = new Quarto(101, "Casal", 200.0);
        Hospede hospede1 = new Hospede("João", "joao@email.com", "9999-9999");
        Date dataInicio = new Date(2023, 4, 1); // 1 de maio de 2023
        Date dataFim = new Date(2023, 4, 7); // 7 de maio de 2023
        Reserva reserva1 = new Reserva(quarto1, hospede1, dataInicio, dataFim);

        System.out.println("Quarto: " + quarto1.getNumero() + ", " + quarto1.getTipoCama() + ", Preço por noite: R$" + quarto1.getPrecoPorNoite());
        System.out.println("Hóspede: " + hospede1.getNome() + ", " + hospede1.getEmail() + ", " + hospede1.getTelefone());
        System.out.println("Reserva: Quarto " + reserva1.getQuarto().getNumero() + ", Hóspede " + reserva1.getHospede().getNome() + ", Preço Total: R$" + reserva1.getPrecoTotal());
    }
}
