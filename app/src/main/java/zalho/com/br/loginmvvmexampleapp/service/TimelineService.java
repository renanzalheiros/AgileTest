package zalho.com.br.loginmvvmexampleapp.service;

import java.util.List;

import rx.Observable;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;

/**
 * Created by andre on 11/05/2017.
 */

public interface TimelineService {

    void addHumorEventWeb(EventoHumor eventoHumor);
    Observable<List<EventoHumor>> getHistoricoEventosHumorWeb(String userId);
}
