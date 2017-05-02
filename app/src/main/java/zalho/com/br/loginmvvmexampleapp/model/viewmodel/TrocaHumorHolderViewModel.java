package zalho.com.br.loginmvvmexampleapp.model.viewmodel;

import android.databinding.BaseObservable;
import android.view.View;

import javax.inject.Inject;

import zalho.com.br.loginmvvmexampleapp.MainActivity;
import zalho.com.br.loginmvvmexampleapp.MvvmApplication;
import zalho.com.br.loginmvvmexampleapp.model.manager.TimelineManager;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Humor;

/**
 * Created by andre on 04/04/2017.
 */

public class TrocaHumorHolderViewModel extends BaseObservable {

    public EventoHumor evento;

    @Inject
    TimelineManager manager;

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
        MvvmApplication app = ((MvvmApplication) ((MainActivity) view.getContext()).getApplication());
        app.getTimelineComponent().inject(this);

        EventoHumor eventoHumor = new EventoHumor(new Humor(evento.getInformacaoHumor(), android.R.drawable.ic_menu_report_image));
        manager.addEventoHumor(eventoHumor);
        ((MainActivity) view.getContext()).getSupportFragmentManager().popBackStack();
    }
}
