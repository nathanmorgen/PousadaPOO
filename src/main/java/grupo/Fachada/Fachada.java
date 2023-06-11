package grupo.Fachada;


import grupo.poopousada.classesBasicas.Hospede;
import grupo.poopousada.classesBasicas.Quarto;
import grupo.poopousada.classesBasicas.Reserva;

public class Fachada {
    public Hospede hospede;
    public Quarto quarto;
    public Reserva reserva;

    public Fachada(){
        hospede = new Hospede("dados/hospedes.txt");
        quarto = new Quarto("dados/quartos.txt");
        reserva = new Reserva("dados/reservas.txt");
    }
    
}
