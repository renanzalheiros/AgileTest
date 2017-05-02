package zalho.com.br.loginmvvmexampleapp.service;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.kelvinapps.rxfirebase.RxFirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.model.entidades.Humor;
import zalho.com.br.loginmvvmexampleapp.model.entidades.InformacaoHumor;

/**
 * Created by andrepereira on 01/05/17.
 */

public class TimelineService {

    public Observable<List<EventoHumor>> getHistoricoEventosHumorWeb(String userId){
        return RxFirebaseDatabase.observeSingleValueEvent(FirebaseDatabase.getInstance(FirebaseApp.getInstance()).getReference("users")
                .child(userId).child("historicoHumor")).map(new Func1<DataSnapshot, List<EventoHumor>>() {
            @Override
            public List<EventoHumor> call(DataSnapshot dataSnapshot) {
                List<EventoHumor> eventos = new ArrayList<>();
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    EventoHumor evento = new EventoHumor(new Humor(InformacaoHumor.valueOf(data.child("humor").getValue(String.class)), 0));
                    evento.setData(data.child("data").getValue(long.class));
                    eventos.add(evento);
                }
                return eventos;
            }
        });
    }
}
