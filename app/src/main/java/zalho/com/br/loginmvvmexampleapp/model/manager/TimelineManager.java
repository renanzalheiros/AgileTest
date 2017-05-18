package zalho.com.br.loginmvvmexampleapp.model.manager;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Action1;
import zalho.com.br.loginmvvmexampleapp.dao.UserDAO;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.service.TimelineService;
import zalho.com.br.loginmvvmexampleapp.service.TimelineServiceImpl;
import zalho.com.br.loginmvvmexampleapp.service.TimelineServiceRetrofit;

/**
 * Created by andre on 31/03/2017.
 */

public class TimelineManager {

    private TimelineService timelineService;

    @Inject
    TimelineServiceRetrofit serviceRetrofit;

    public TimelineManager()
    {
        timelineService = new TimelineServiceImpl();
    }

    public Observable<List<EventoHumor>> getEventosFromWeb() {
        return timelineService.getHistoricoEventosHumorWeb(FirebaseAuth.getInstance(FirebaseApp.getInstance()).getCurrentUser().getUid());
    }

    public void addEventoHumor(EventoHumor eventoHumor) {
        timelineService.addHumorEventWeb(eventoHumor);
    }

    public Observable<List<EventoHumor>> getHistoricoHumorRetrofit(){

        String userId = "";

        return serviceRetrofit.getHistoricoHumor(userId);
    }
}
