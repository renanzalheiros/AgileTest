package zalho.com.br.loginmvvmexampleapp.model;

/**
 * Created by andre on 30/03/2017.
 */

public class Humor {

    private InformacaoHumor infoHumor;
    private String humorImagePath;

    public Humor(InformacaoHumor infoHumor, String humorImagePath){
        this.infoHumor = infoHumor;
        this.humorImagePath = humorImagePath;
    }

    public InformacaoHumor getInfoHumor() {
        return infoHumor;
    }

    public void setInfoHumor(InformacaoHumor infoHumor) {
        this.infoHumor = infoHumor;
    }

    public String getHumorImagePath() {
        return humorImagePath;
    }

    public void setHumorImagePath(String humorImagePath) {
        this.humorImagePath = humorImagePath;
    }
}
