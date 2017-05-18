package zalho.com.br.loginmvvmexampleapp.model.entidades;

/**
 * Created by andre on 29/03/2017.
 */

public enum InformacaoHumor {

    Bem("Bem"),
    Feliz("Feliz"),
    Empogado("Empolgado"),
    Triste("Triste"),
    Deprimido("Deprimido"),
    Luto("Luto"),
    Cansado("Cansado"),
    Irritado("Irritado");

    private String vmensagem;

    InformacaoHumor(String vmensagem){
        this.vmensagem = vmensagem;
    }

    public String getMensagem(){
        return this.vmensagem;
    }

}
