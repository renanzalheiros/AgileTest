package zalho.com.br.loginmvvmexampleapp.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zalho.com.br.loginmvvmexampleapp.manager.TrocaHumorManager;

/**
 * Created by andre on 26/04/2017.
 */

@Module
public class TrocaHumorModule {

    @Provides
    @Singleton
    TrocaHumorManager getTrocaHumorManager(){
        return new TrocaHumorManager();
    }
}
