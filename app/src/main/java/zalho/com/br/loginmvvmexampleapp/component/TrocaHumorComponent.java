package zalho.com.br.loginmvvmexampleapp.component;

import javax.inject.Singleton;

import dagger.Component;
import zalho.com.br.loginmvvmexampleapp.model.viewmodel.TrocaHumorFragmentViewModel;
import zalho.com.br.loginmvvmexampleapp.module.TrocaHumorModule;

/**
 * Created by andre on 26/04/2017.
 */

@Singleton
@Component(modules = TrocaHumorModule.class)
public interface TrocaHumorComponent {

    void inject(TrocaHumorFragmentViewModel viewModel);
}
