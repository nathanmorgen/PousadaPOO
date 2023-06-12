package grupo.poopousada.Fachada;


import grupo.poopousada.classesBasicas.Hospede;
import grupo.poopousada.classesBasicas.Quarto;
import grupo.poopousada.classesBasicas.Reserva;

public class Fachada {
    private Hospede hospede;
    private Quarto quarto;
    private Reserva reserva;

    public Fachada(Hospede hospede, Quarto quarto, Reserva reserva) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.reserva = reserva;
    }
    
    // Métodos públicos para acessar e modificar os componentes

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    
}
