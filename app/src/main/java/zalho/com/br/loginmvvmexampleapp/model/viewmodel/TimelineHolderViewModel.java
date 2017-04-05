package zalho.com.br.loginmvvmexampleapp.model.viewmodel;

import android.databinding.BaseObservable;

import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;

/**
 * Created by andre on 30/03/2017.
 */

public class TimelineHolderViewModel extends BaseObservable {

    public EventoHumor eventoHumor;

    public TimelineHolderViewModel(EventoHumor evento){
        this.eventoHumor = evento;
    }

    public void setEvento(EventoHumor evento) {
        this.eventoHumor = evento;
    }
}
