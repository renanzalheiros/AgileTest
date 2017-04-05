package zalho.com.br.loginmvvmexampleapp.model.viewmodel;

import android.databinding.BaseObservable;

import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;

/**
 * Created by andre on 04/04/2017.
 */

public class TrocaHumorHolderViewModel extends BaseObservable {

    public EventoHumor evento;

    public TrocaHumorHolderViewModel(EventoHumor eventoHumor){
        evento = eventoHumor;
    }

    public void setEvento(EventoHumor evento) {
        this.evento = evento;
    }
}
