package zalho.com.br.loginmvvmexampleapp.model.entidades;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by andre on 29/03/2017.
 */

public class EventoHumor {

    private Humor humor;
    private Calendar data;

    public EventoHumor(Humor humor){
        this.humor = humor;
        data = Calendar.getInstance();
        data.setTime(new Date());
    }

    public String humorInfo(){
        return humor.getInfoHumor().getMensagem();
    }

    public String hourToString(){
        if(data.get(Calendar.MINUTE) < 10){
            return data.get(Calendar.HOUR_OF_DAY) + ":0" +  data.get(Calendar.MINUTE);
        }
        return data.get(Calendar.HOUR_OF_DAY) + ":" +  data.get(Calendar.MINUTE);
    }

    public int getHumorImagePath(){
        return humor.getHumorImagePath();
    }

    public void setNewDate(){
        this.data.setTime(new Date());
    }


}
