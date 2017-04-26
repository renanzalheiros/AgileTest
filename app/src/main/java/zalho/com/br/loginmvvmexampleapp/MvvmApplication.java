package zalho.com.br.loginmvvmexampleapp;

import android.app.Application;

import zalho.com.br.loginmvvmexampleapp.component.DaggerLoginComponent;
import zalho.com.br.loginmvvmexampleapp.component.DaggerTimelineComponent;
import zalho.com.br.loginmvvmexampleapp.component.DaggerTrocaHumorComponent;
import zalho.com.br.loginmvvmexampleapp.component.LoginComponent;
import zalho.com.br.loginmvvmexampleapp.component.TimelineComponent;
import zalho.com.br.loginmvvmexampleapp.component.TrocaHumorComponent;

/**
 * Created by andre on 06/04/2017.
 */

public class MvvmApplication extends Application {

//    private LoginManager loginManager;
//    private TimelineManager timelineManager;
//    private TrocaHumorManager trocaHumorManager;

    private TimelineComponent timelineComponent;
    private LoginComponent loginComponent;
    private TrocaHumorComponent trocaHumorComponent;

    @Override
    public void onCreate() {
        timelineComponent = DaggerTimelineComponent.builder().build();
        loginComponent = DaggerLoginComponent.builder().build();
        trocaHumorComponent = DaggerTrocaHumorComponent.builder().build();
        super.onCreate();
    }

    public TimelineComponent getTimelineComponent(){
        return timelineComponent;
    }

    public LoginComponent getLoginComponent(){
        return loginComponent;
    }

    public TrocaHumorComponent getTrocaHumorComponent(){
        return trocaHumorComponent;
    }

//    public LoginManager getLoginManager(){
//        if(this.loginManager == null){
//            this.loginManager = new LoginManager(new LoginServiceImpl());
//        }
//        return loginManager;
//    }
//
//    public TimelineManager getTimelineManager() {
//        if (this.timelineManager == null) {
//            timelineManager = new TimelineManager();
//        }
//        return timelineManager;
//    }
//
//    public TrocaHumorManager getTrocaHumorManager() {
//        if (trocaHumorManager == null) {
//            trocaHumorManager = new TrocaHumorManager();
//        }
//
//        return trocaHumorManager;
//    }
}
