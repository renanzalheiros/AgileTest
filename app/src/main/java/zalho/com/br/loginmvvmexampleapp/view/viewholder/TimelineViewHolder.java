package zalho.com.br.loginmvvmexampleapp.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import zalho.com.br.loginmvvmexampleapp.databinding.AdapterTimelineRowBinding;
import zalho.com.br.loginmvvmexampleapp.model.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.view.viewmodel.TimelineHolderViewModel;

/**
 * Created by andre on 29/03/2017.
 */

public class TimelineViewHolder extends RecyclerView.ViewHolder {

    AdapterTimelineRowBinding binding;

    public TimelineViewHolder(AdapterTimelineRowBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public void bindData(EventoHumor evento) {

        if (binding.getViewModel() == null) {
            binding.setViewModel(new TimelineHolderViewModel(evento));
        } else {
            binding.getViewModel().setEvento(evento);
        }
    }
}
