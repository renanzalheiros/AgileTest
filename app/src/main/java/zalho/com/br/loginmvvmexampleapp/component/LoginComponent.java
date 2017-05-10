package zalho.com.br.loginmvvmexampleapp.component;

import javax.inject.Singleton;

import dagger.Component;
import zalho.com.br.loginmvvmexampleapp.model.manager.LoginManager;
import zalho.com.br.loginmvvmexampleapp.model.viewmodel.LoginFragmentViewModel;
import zalho.com.br.loginmvvmexampleapp.module.LoginModule;

/**
 * Created by andre on 26/04/2017.
 */
@Singleton
@Component(modules ={LoginModule.class})
public interface LoginComponent {

    void inject(LoginFragmentViewModel viewModel);
    void inject(LoginManager manager);
}
