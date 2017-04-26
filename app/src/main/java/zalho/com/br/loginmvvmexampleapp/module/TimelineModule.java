package zalho.com.br.loginmvvmexampleapp.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zalho.com.br.loginmvvmexampleapp.manager.TimelineManager;

/**
 * Created by andre on 26/04/2017.
 */

@Module
public class TimelineModule {

    @Provides
    @Singleton
    TimelineManager getTimelineManager(){
        return new TimelineManager();
    }

}
