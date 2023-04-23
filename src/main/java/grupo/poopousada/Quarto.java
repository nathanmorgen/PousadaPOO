package grupo.poopousada;
/**
 *
 * @author Nathazin & Juju
 */
public class Quarto {
    private int numero;
    private String tipoCama;
    private double precoPorNoite;

    public Quarto(int numero, String tipoCama, double precoPorNoite) {
        this.numero = numero;
        this.tipoCama = tipoCama;
        this.precoPorNoite = precoPorNoite;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }
}
