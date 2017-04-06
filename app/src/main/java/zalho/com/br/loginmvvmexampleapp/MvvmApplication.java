package zalho.com.br.loginmvvmexampleapp;

import android.app.Application;

import zalho.com.br.loginmvvmexampleapp.manager.TimelineManager;
import zalho.com.br.loginmvvmexampleapp.manager.TrocaHumorManager;

/**
 * Created by andre on 06/04/2017.
 */

public class MvvmApplication extends Application {

    private TimelineManager timelineManager;
    private TrocaHumorManager trocaHumorManager;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public TimelineManager getTimelineManager(){
        if(timelineManager == null){
            return new TimelineManager();
        } else {
            return timelineManager;
        }
    }

    public TrocaHumorManager getTrocaHumorManager(){
        if(trocaHumorManager == null){
            return new TrocaHumorManager();
        } else {
            return trocaHumorManager;
        }
    }
}
