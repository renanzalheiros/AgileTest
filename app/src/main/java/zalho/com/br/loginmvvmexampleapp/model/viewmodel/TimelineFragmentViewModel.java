package zalho.com.br.loginmvvmexampleapp.model.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Collections;
import java.util.List;

import zalho.com.br.loginmvvmexampleapp.MainActivity;
import zalho.com.br.loginmvvmexampleapp.MvvmApplication;
import zalho.com.br.loginmvvmexampleapp.R;
import zalho.com.br.loginmvvmexampleapp.manager.TimelineManager;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.view.adapter.TimelineAdapter;
import zalho.com.br.loginmvvmexampleapp.view.fragments.TrocaHumorFragment;

/**
 * Created by andre on 06/03/2017.
 */

public class TimelineFragmentViewModel extends BaseObservable{

    public final ObservableArrayList<EventoHumor> listaHumor = new ObservableArrayList<>();

    @BindingAdapter("bind:itemsTimeline")
    public static void bindList(RecyclerView rv, ObservableArrayList<EventoHumor> list){
        LinearLayoutManager lytManager = new LinearLayoutManager(rv.getContext());
        rv.setLayoutManager(lytManager);
        rv.setAdapter(new TimelineAdapter(list));
    }

    //chamar no método onResume do TimelineFragment para atualizar a lista a cada onResume
    public void onResume(TimelineManager manager){
        listaHumor.clear();
        List<EventoHumor> eventosHumor = manager.getEventosHumor();
        Collections.reverse(eventosHumor);
        listaHumor.addAll(eventosHumor);
    }

    public void onClickTrocarHumor(View view){
        ((MainActivity) view.getContext()).navegarPara("timeline", TrocaHumorFragment.class);
    }
}
