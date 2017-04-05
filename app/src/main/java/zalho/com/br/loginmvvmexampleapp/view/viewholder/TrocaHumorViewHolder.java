package zalho.com.br.loginmvvmexampleapp.view.viewholder;

import android.support.v7.widget.RecyclerView;

import zalho.com.br.loginmvvmexampleapp.databinding.AdapterTrocaHumorRowBinding;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.model.viewmodel.TimelineHolderViewModel;
import zalho.com.br.loginmvvmexampleapp.model.viewmodel.TrocaHumorHolderViewModel;

/**
 * Created by andre on 04/04/2017.
 */

public class TrocaHumorViewHolder extends RecyclerView.ViewHolder {

    AdapterTrocaHumorRowBinding binding;

    public TrocaHumorViewHolder(AdapterTrocaHumorRowBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public void bindData(EventoHumor evento) {
        if (binding.getViewModel() == null) {
            binding.setViewModel(new TrocaHumorHolderViewModel(evento));
        } else {
            binding.getViewModel().setEvento(evento);
        }
    }

}
