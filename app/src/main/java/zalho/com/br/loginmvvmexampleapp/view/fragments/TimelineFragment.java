package zalho.com.br.loginmvvmexampleapp.view.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zalho.com.br.loginmvvmexampleapp.MvvmApplication;
import zalho.com.br.loginmvvmexampleapp.R;
import zalho.com.br.loginmvvmexampleapp.databinding.FragmentTimelineBinding;
import zalho.com.br.loginmvvmexampleapp.model.viewmodel.TimelineFragmentViewModel;

/**
 * Created by andre on 06/03/2017.
 */

public class TimelineFragment extends Fragment{

    TimelineFragmentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new TimelineFragmentViewModel();
        ((MvvmApplication) getActivity().getApplication()).getTimelineComponent().inject(viewModel);

        FragmentTimelineBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_timeline, container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        //        TimelineManager timelineManager = ((MvvmApplication) getActivity().getApplication()).getTimelineManager();
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        viewModel.onResume();
        super.onResume();
    }
}
