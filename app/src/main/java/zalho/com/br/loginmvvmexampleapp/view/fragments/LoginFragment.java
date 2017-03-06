package zalho.com.br.loginmvvmexampleapp.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zalho.com.br.loginmvvmexampleapp.R;
import zalho.com.br.loginmvvmexampleapp.databinding.FragmentLoginBinding;
import zalho.com.br.loginmvvmexampleapp.model.Login;
import zalho.com.br.loginmvvmexampleapp.view.viewmodel.LoginFragmentViewModel;

/**
 * Created by andre on 24/02/2017.
 */

public class LoginFragment extends Fragment {

    LoginFragmentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new LoginFragmentViewModel(new Login());

        FragmentLoginBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }
}
