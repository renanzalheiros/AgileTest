package zalho.com.br.loginmvvmexampleapp.component;

import javax.inject.Singleton;

import dagger.Component;
import zalho.com.br.loginmvvmexampleapp.model.viewmodel.TimelineFragmentViewModel;
import zalho.com.br.loginmvvmexampleapp.model.viewmodel.TrocaHumorHolderViewModel;
import zalho.com.br.loginmvvmexampleapp.module.TimelineModule;

/**
 * Created by andre on 26/04/2017.
 */
@Singleton
@Component(modules = TimelineModule.class)
public interface TimelineComponent {

    void inject(TimelineFragmentViewModel timelineFragmentViewModel);
    void inject(TrocaHumorHolderViewModel trocaHumorHolderViewModel);
}
