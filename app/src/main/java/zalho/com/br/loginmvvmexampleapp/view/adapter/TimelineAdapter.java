package zalho.com.br.loginmvvmexampleapp.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zalho.com.br.loginmvvmexampleapp.R;
import zalho.com.br.loginmvvmexampleapp.databinding.AdapterTimelineRowBinding;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.view.viewholder.TimelineViewHolder;

/**
 * Created by andre on 29/03/2017.
 */

public class TimelineAdapter extends RecyclerView.Adapter<TimelineViewHolder> {

    private List<EventoHumor> humores = new ArrayList<>();

    public TimelineAdapter(List<EventoHumor> eventos){
        humores = eventos;
    }

    @Override
    public TimelineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterTimelineRowBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.adapter_timeline_row, parent, false);

        return new TimelineViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(TimelineViewHolder holder, int position) {
        holder.bindData(humores.get(position));
    }

    @Override
    public int getItemCount() {
        return humores.size();
    }
}
