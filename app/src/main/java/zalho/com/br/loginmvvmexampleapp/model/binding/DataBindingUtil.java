package zalho.com.br.loginmvvmexampleapp.model.binding;

import android.databinding.BindingAdapter;
import android.view.View;

import zalho.com.br.loginmvvmexampleapp.model.viewmodel.TimelineFragmentViewModel;

/**
 * Created by andre on 02/05/2017.
 */

public class DataBindingUtil {

    @BindingAdapter("isGone")
    public static void setIsGone(View view, boolean viewModel){
        view.setVisibility(viewModel ? View.VISIBLE : View.GONE);
    }
}