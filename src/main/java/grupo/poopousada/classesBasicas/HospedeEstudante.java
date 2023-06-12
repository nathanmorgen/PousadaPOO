package grupo.poopousada.classesBasicas;

import java.util.List;

import grupo.poopousada.repositorio.GerenciadorArquivos;

public class HospedeEstudante extends Hospede {
    public HospedeEstudante(){
        super();
    }

    @Override
    public String valorCobrado(String numeroQuarto){
        GerenciadorArquivos dadosQuartos = new GerenciadorArquivos("dados/quartos.txt");
        List<String> quartos = dadosQuartos.carregarDados();

         for (String quarto : quartos) {
            String[] campos = quarto.split(";");
            if (campos[0].equals(numeroQuarto)) {
                float valor = Float.parseFloat(campos[2]);
                valor  = valor / 2; 
                String valorString = Float.toString(valor);
                return valorString;
                
            }
        }
        return null;
    }

}
