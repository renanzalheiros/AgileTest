package zalho.com.br.loginmvvmexampleapp.manager;

import java.util.ArrayList;
import java.util.List;

import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Humor;
import zalho.com.br.loginmvvmexampleapp.model.entidades.InformacaoHumor;

/**
 * Created by andre on 31/03/2017.
 */

public class TimelineManager {

    private List<EventoHumor> eventosHumor;

    public TimelineManager(){
        //criar historico de humores
        eventosHumor = new ArrayList<>();
        populaEventos();
    }

    public List<EventoHumor> getEventosHumor(){
        return eventosHumor;
    }

    public void addEventoHumor(EventoHumor eventoHumor){
        this.eventosHumor.add(eventoHumor);
    }

    private void populaEventos(){
        eventosHumor.add(new EventoHumor(new Humor(InformacaoHumor.BEM, android.R.drawable.ic_menu_report_image)));
        eventosHumor.add(new EventoHumor(new Humor(InformacaoHumor.CANSADO, android.R.drawable.alert_dark_frame)));
        eventosHumor.add(new EventoHumor(new Humor(InformacaoHumor.EMPOLGADO, android.R.drawable.arrow_up_float)));
        eventosHumor.add(new EventoHumor(new Humor(InformacaoHumor.IRRITADO, android.R.drawable.arrow_down_float)));
    }
}
