package zalho.com.br.loginmvvmexampleapp.model.manager;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kelvinapps.rxfirebase.DataSnapshotMapper;
import com.kelvinapps.rxfirebase.RxFirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Humor;
import zalho.com.br.loginmvvmexampleapp.model.entidades.InformacaoHumor;
import zalho.com.br.loginmvvmexampleapp.service.TimelineService;

/**
 * Created by andre on 31/03/2017.
 */

public class TimelineManager {

    private TimelineService timelineService;

    public TimelineManager(){
        timelineService = new TimelineService();
    }

    public Observable<List<EventoHumor>> getEventosFromWeb() {
        return timelineService.getHistoricoEventosHumorWeb(FirebaseAuth.getInstance(FirebaseApp.getInstance()).getCurrentUser().getUid());
    }

    public void addEventoHumor(EventoHumor eventoHumor){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("historicoHumor")
                .child(String.valueOf(eventoHumor.getData()*-1));
        ref.child("humor").setValue(eventoHumor.getHumor().getInfoHumor().getMensagem().toUpperCase());
        ref.child("data").setValue(eventoHumor.getData());
    }
}
