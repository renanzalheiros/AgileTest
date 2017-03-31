package zalho.com.br.loginmvvmexampleapp.manager;

import java.util.ArrayList;
import java.util.List;

import zalho.com.br.loginmvvmexampleapp.model.EventoHumor;

/**
 * Created by andre on 31/03/2017.
 */

public class TimelineManager {

    private List<EventoHumor> eventosHumor;

    public TimelineManager(){
        //criar historico de humores
        eventosHumor = new ArrayList<>();
        eventosHumor = populaEventos();
    }

    public List<EventoHumor> getEventosHumor(){
        return eventosHumor;
    }

    public void addEventoHumor(EventoHumor eventoHumor){
        this.eventosHumor.add(eventoHumor);
    }

    private List<EventoHumor> populaEventos(){

        return null;
    }
}
