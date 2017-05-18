package zalho.com.br.loginmvvmexampleapp.model.viewmodel;

import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.functions.Action1;
import zalho.com.br.loginmvvmexampleapp.MainActivity;
import zalho.com.br.loginmvvmexampleapp.model.manager.TimelineManager;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.view.adapter.TimelineAdapter;
import zalho.com.br.loginmvvmexampleapp.view.fragments.TrocaHumorFragment;

/**
 * Created by andre on 06/03/2017.
 */

public class TimelineFragmentViewModel extends BaseObservable{

    public final ObservableArrayList<EventoHumor> listaHumor = new ObservableArrayList<>();
    public ObservableBoolean carregandoHumor = new ObservableBoolean(true);
    public ObservableBoolean listaVazia = new ObservableBoolean(false);

    @Inject
    TimelineManager manager;

    @BindingAdapter("bind:itemsTimeline")
    public static void bindList(RecyclerView rv, ObservableArrayList<EventoHumor> list){
        LinearLayoutManager lytManager = new LinearLayoutManager(rv.getContext());
        rv.setLayoutManager(lytManager);
        rv.setAdapter(new TimelineAdapter(list));
    }

    //chamar no método onResume do TimelineFragment para atualizar a lista a cada onResume
    public void onResume(){
        loadHumorList();
    }

    private void loadHumorList() {
        listaHumor.clear();

        manager.getEventosFromWeb().subscribe(new Action1<List<EventoHumor>>() {
            @Override
            public void call(List<EventoHumor> eventoHumors) {
                if(eventoHumors.size() == 0){
                    listaVazia.set(true);
                } else {
                    listaVazia.set(false);
                    Collections.reverse(eventoHumors);
                    listaHumor.addAll(eventoHumors);
                }
                carregandoHumor.set(false);
//                notifyChange();
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    private void loadHumorListRetrofit(){
        listaHumor.clear();

        manager.getHistoricoHumorRetrofit().subscribe(new Action1<List<EventoHumor>>() {
            @Override
            public void call(List<EventoHumor> eventoHumors) {
                if(eventoHumors.size() == 0){
                    listaVazia.set(true);
                } else {
                    listaVazia.set(false);
                    Collections.reverse(eventoHumors);
                    listaHumor.addAll(eventoHumors);
                }
                carregandoHumor.set(false);
//                notifyChange();
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    public void onClickTrocarHumor(View view){
        ((MainActivity) view.getContext()).navegarPara("timeline", TrocaHumorFragment.class);
    }
}
