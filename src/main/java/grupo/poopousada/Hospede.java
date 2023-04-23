package grupo.poopousada;
/**
 *
 * @author Nathazin & Juju
 */
public class Hospede {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    
    

    public Hospede(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        //this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    /*public String getEmail() {
        return email;
    }*/

    public String getTelefone() {
        return telefone;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getEndereco(){
        return endereco;
    }
}