package zalho.com.br.loginmvvmexampleapp.model.entidades;

/**
 * Created by andre on 29/03/2017.
 */

public enum InformacaoHumor {

    BEM("Bem"),
    FELIZ("Feliz"),
    EMPOLGADO("Empolgado"),
    TRISTE("Triste"),
    DEPRIMIDO("Deprimido"),
    LUTO("Luto"),
    CANSADO("Cansado"),
    IRRITADO("Irritado");

    private String vmensagem;

    private InformacaoHumor(String vmensagem){
        this.vmensagem = vmensagem;
    }

    public String getMensagem(){
        return this.vmensagem;
    }

}
