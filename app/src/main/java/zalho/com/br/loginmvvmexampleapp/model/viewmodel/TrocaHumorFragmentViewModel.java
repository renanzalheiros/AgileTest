package zalho.com.br.loginmvvmexampleapp.model.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import zalho.com.br.loginmvvmexampleapp.manager.TrocaHumorManager;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.view.adapter.TrocaHumorAdapter;

/**
 * Created by andre on 03/04/2017.
 */

public class TrocaHumorFragmentViewModel extends BaseObservable {

    public final ObservableArrayList<EventoHumor> eventos = new ObservableArrayList<>();

    @Inject
    TrocaHumorManager manager;

    public TrocaHumorFragmentViewModel(){
    }

    @BindingAdapter("bind:itemsHumor")
    public static void bindList(RecyclerView rv, ObservableArrayList<EventoHumor> humorList){
        GridLayoutManager layoutManager = new GridLayoutManager(rv.getContext(), 2);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(new TrocaHumorAdapter(humorList));
    }

    public void onResume(){
//        if(manager == null){
//            manager = new TrocaHumorManager();
//        }

        eventos.clear();
        eventos.addAll(manager.getEventosHumorCadastrados());
    }
}
