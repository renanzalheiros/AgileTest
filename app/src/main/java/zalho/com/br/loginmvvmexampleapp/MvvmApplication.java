package zalho.com.br.loginmvvmexampleapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import zalho.com.br.loginmvvmexampleapp.manager.LoginManager;
import zalho.com.br.loginmvvmexampleapp.manager.TimelineManager;
import zalho.com.br.loginmvvmexampleapp.manager.TrocaHumorManager;
import zalho.com.br.loginmvvmexampleapp.model.entidades.EventoHumor;
import zalho.com.br.loginmvvmexampleapp.service.LoginServiceImpl;

/**
 * Created by andre on 06/04/2017.
 */

public class MvvmApplication extends Application {

    private LoginManager loginManager;
    private TimelineManager timelineManager;
    private TrocaHumorManager trocaHumorManager;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public LoginManager getLoginManager(){
        if(this.loginManager == null){
            this.loginManager = new LoginManager(new LoginServiceImpl());
        }
        return loginManager;
    }

    public TimelineManager getTimelineManager() {
        if (this.timelineManager == null) {
            timelineManager = new TimelineManager();
        }
        return timelineManager;
    }

    public TrocaHumorManager getTrocaHumorManager() {
        if (trocaHumorManager == null) {
            trocaHumorManager = new TrocaHumorManager();
        }

        return trocaHumorManager;
    }
}
