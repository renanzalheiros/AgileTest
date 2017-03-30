package zalho.com.br.loginmvvmexampleapp.view.viewmodel;

import android.databinding.BaseObservable;

import zalho.com.br.loginmvvmexampleapp.model.EventoHumor;

/**
 * Created by andre on 30/03/2017.
 */

public class TimelineHolderViewModel extends BaseObservable {

    private EventoHumor eventoHumor;

    public TimelineHolderViewModel(EventoHumor evento){
        this.eventoHumor = evento;
    }

    public void setEvento(EventoHumor evento) {
        this.eventoHumor = evento;
    }
}
