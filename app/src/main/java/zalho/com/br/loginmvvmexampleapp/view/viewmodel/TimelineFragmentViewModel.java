package zalho.com.br.loginmvvmexampleapp.view.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import zalho.com.br.loginmvvmexampleapp.manager.TimelineManager;
import zalho.com.br.loginmvvmexampleapp.model.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.view.adapter.TimelineAdapter;

/**
 * Created by andre on 06/03/2017.
 */

public class TimelineFragmentViewModel extends BaseObservable{

    public ObservableArrayList<EventoHumor> listaHumor = new ObservableArrayList<>();

    private TimelineManager manager;

    @BindingAdapter("bind:itemsTimeline")
    public static void bindList(RecyclerView rv, ObservableArrayList<EventoHumor> list){
        LinearLayoutManager lytManager = new LinearLayoutManager(rv.getContext());
        rv.setLayoutManager(lytManager);
        rv.setAdapter(new TimelineAdapter(list));
    }

    //chamar no método onResume do TimelineFragment para atualizar a lista a cada onResume
    public void onResume(){
        if(manager == null){
            manager = new TimelineManager();
        } else {
            listaHumor.clear();
            listaHumor.addAll(manager.getEventosHumor());
        }

    }
}
