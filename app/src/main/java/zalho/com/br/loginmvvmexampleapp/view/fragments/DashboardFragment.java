package zalho.com.br.loginmvvmexampleapp.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zalho.com.br.loginmvvmexampleapp.R;
import zalho.com.br.loginmvvmexampleapp.databinding.FragmentDashboardBinding;
import zalho.com.br.loginmvvmexampleapp.view.viewmodel.DashboardFragmentViewModel;

/**
 * Created by andre on 06/03/2017.
 */

public class DashboardFragment extends Fragment{

    DashboardFragmentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new DashboardFragmentViewModel();

        FragmentDashboardBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }
}
