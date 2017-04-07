package zalho.com.br.loginmvvmexampleapp.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zalho.com.br.loginmvvmexampleapp.MvvmApplication;
import zalho.com.br.loginmvvmexampleapp.R;
import zalho.com.br.loginmvvmexampleapp.databinding.FragmentTrocaHumorBinding;
import zalho.com.br.loginmvvmexampleapp.model.viewmodel.TrocaHumorFragmentViewModel;

/**
 * Created by andre on 03/04/2017.
 */

public class TrocaHumorFragment extends Fragment {

    TrocaHumorFragmentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new TrocaHumorFragmentViewModel();

        FragmentTrocaHumorBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_troca_humor, container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        viewModel.onResume(((MvvmApplication) getActivity().getApplication()).getTrocaHumorManager());
        super.onResume();
    }
}
