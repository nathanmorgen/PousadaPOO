package grupo.poopousada;
/**
 *
 * @author Nathazin & Juju
 */
public class Hospede {
    private String nome;
    private String email;
    private String telefone;

    public Hospede(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}