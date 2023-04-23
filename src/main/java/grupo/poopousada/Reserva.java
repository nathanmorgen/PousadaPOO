package grupo.poopousada;
/**
 *
 * @author Nathazin & Juju
 */
import java.util.Date;

public class Reserva {
    private Quarto quarto;
    private Hospede hospede;
    private Date dataInicio;
    private Date dataFim;

    public Reserva(Quarto quarto, Hospede hospede, Date dataInicio, Date dataFim) {
        this.quarto = quarto;
        this.hospede = hospede;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public double getPrecoTotal() {
        long duracaoEmDias = (dataFim.getTime() - dataInicio.getTime()) / (24 * 60 * 60 * 1000);
        return duracaoEmDias * quarto.getPrecoPorNoite();
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }
}
