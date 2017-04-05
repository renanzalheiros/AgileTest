package zalho.com.br.loginmvvmexampleapp.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zalho.com.br.loginmvvmexampleapp.R;
import zalho.com.br.loginmvvmexampleapp.databinding.AdapterTrocaHumorRowBinding;
import zalho.com.br.loginmvvmexampleapp.manager.TrocaHumorManager;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.view.viewholder.TrocaHumorViewHolder;

/**
 * Created by andre on 04/04/2017.
 */

public class TrocaHumorAdapter extends RecyclerView.Adapter<TrocaHumorViewHolder> {

    private List<EventoHumor> eventos;

    public TrocaHumorAdapter(List<EventoHumor> humorList){
        eventos = humorList;
    }

    @Override
    public TrocaHumorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterTrocaHumorRowBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_troca_humor_row, parent, false);

        return new TrocaHumorViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(TrocaHumorViewHolder holder, int position) {
        holder.bindData(eventos.get(position));
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }
}
