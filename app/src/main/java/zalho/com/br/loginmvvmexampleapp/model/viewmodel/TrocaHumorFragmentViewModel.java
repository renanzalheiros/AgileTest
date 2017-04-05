package zalho.com.br.loginmvvmexampleapp.model.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import zalho.com.br.loginmvvmexampleapp.manager.TrocaHumorManager;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.view.adapter.TrocaHumorAdapter;

/**
 * Created by andre on 03/04/2017.
 */

public class TrocaHumorFragmentViewModel extends BaseObservable {

    public final ObservableArrayList<EventoHumor> eventos = new ObservableArrayList<>();
    private TrocaHumorManager manager;

    public TrocaHumorFragmentViewModel(){
        manager = new TrocaHumorManager();
        eventos.clear();
        eventos.addAll(manager.getEventosHumorCadastrados());
    }

    @BindingAdapter("bind:itemsHumor")
    public static void bindList(RecyclerView rv, ObservableArrayList<EventoHumor> humorList){
        LinearLayoutManager layoutManager = new LinearLayoutManager(rv.getContext());
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(new TrocaHumorAdapter(humorList));
    }

    public void onResume(){
        if(manager == null){
            manager = new TrocaHumorManager();
        }

        eventos.clear();
        eventos.addAll(manager.getEventosHumorCadastrados());
    }
}
