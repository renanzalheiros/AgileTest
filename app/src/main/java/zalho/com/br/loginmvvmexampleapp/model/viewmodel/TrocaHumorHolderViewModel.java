package zalho.com.br.loginmvvmexampleapp.model.viewmodel;

import android.app.Application;
import android.databinding.BaseObservable;
import android.view.View;

import zalho.com.br.loginmvvmexampleapp.MainActivity;
import zalho.com.br.loginmvvmexampleapp.MvvmApplication;
import zalho.com.br.loginmvvmexampleapp.manager.TimelineManager;
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

    public EventoHumor getEvento() {
        return evento;
    }

    public void onSelectHumor(View view){
        TimelineManager timelineManager = ((MvvmApplication) ((MainActivity) view.getContext()).getApplication()).getTimelineManager();
        this.evento.setNewDate();
        timelineManager.addEventoHumor(evento);
        ((MainActivity) view.getContext()).getSupportFragmentManager().popBackStack();
    }
}
