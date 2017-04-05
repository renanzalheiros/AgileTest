package zalho.com.br.loginmvvmexampleapp.model.entidades;

/**
 * Created by andre on 30/03/2017.
 */

public class Humor {

    private InformacaoHumor infoHumor;
    private int humorImagePath;

    public Humor(InformacaoHumor infoHumor, int humorImagePath){
        this.infoHumor = infoHumor;
        this.humorImagePath = humorImagePath;
    }

    public InformacaoHumor getInfoHumor() {
        return infoHumor;
    }

    public void setInfoHumor(InformacaoHumor infoHumor) {
        this.infoHumor = infoHumor;
    }

    public int getHumorImagePath() {
        return humorImagePath;
    }

    public void setHumorImagePath(int humorImagePath) {
        this.humorImagePath = humorImagePath;
    }
}
