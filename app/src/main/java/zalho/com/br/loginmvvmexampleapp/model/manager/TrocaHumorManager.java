package zalho.com.br.loginmvvmexampleapp.model.manager;

import java.util.ArrayList;
import java.util.List;

import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Humor;
import zalho.com.br.loginmvvmexampleapp.model.entidades.InformacaoHumor;

/**
 * Created by andre on 04/04/2017.
 */

public class TrocaHumorManager {

    private List<EventoHumor> humoresCadastrados;

    public TrocaHumorManager(){
        humoresCadastrados = new ArrayList<>();
        populaEventos();
    }

    public List<EventoHumor> getEventosHumorCadastrados(){
        return humoresCadastrados;
    }

    private void populaEventos() {

        humoresCadastrados.add(new EventoHumor(new Humor(InformacaoHumor.Bem, android.R.drawable.ic_menu_report_image)));
        humoresCadastrados.add(new EventoHumor(new Humor(InformacaoHumor.Empogado, android.R.drawable.arrow_up_float)));
        humoresCadastrados.add(new EventoHumor(new Humor(InformacaoHumor.Feliz, android.R.drawable.arrow_down_float)));
        humoresCadastrados.add(new EventoHumor(new Humor(InformacaoHumor.Cansado, android.R.drawable.alert_dark_frame)));
        humoresCadastrados.add(new EventoHumor(new Humor(InformacaoHumor.Triste, android.R.drawable.alert_dark_frame)));
        humoresCadastrados.add(new EventoHumor(new Humor(InformacaoHumor.Deprimido, android.R.drawable.alert_dark_frame)));
        humoresCadastrados.add(new EventoHumor(new Humor(InformacaoHumor.Luto, android.R.drawable.alert_dark_frame)));
        humoresCadastrados.add(new EventoHumor(new Humor(InformacaoHumor.Irritado, android.R.drawable.alert_dark_frame)));
    }

}
