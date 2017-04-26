package zalho.com.br.loginmvvmexampleapp.model.entidades;

import java.util.Calendar;

/**
 * Created by andre on 29/03/2017.
 */

public class EventoHumor {

    private Humor humor;
    private long data;

    public EventoHumor(Humor humor){
        this.humor = humor;
        data = Calendar.getInstance().getTimeInMillis();
    }

    public InformacaoHumor getInformacaoHumor(){
        return humor.getInfoHumor();
    }

    public String humorInfo(){
        return humor.getInfoHumor().getMensagem();
    }

    public String hourToString(){

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(data);
        if(calendar.get(Calendar.MINUTE) < 10){
            return calendar.get(Calendar.HOUR_OF_DAY) + ":0" +  calendar.get(Calendar.MINUTE);
        }
        return calendar.get(Calendar.HOUR_OF_DAY) + ":" +  calendar.get(Calendar.MINUTE);
    }

    public int getHumorImagePath(){
        return humor.getHumorImagePath();
    }

//    public void setNewDate(){
//        this.data.setTime(new Date());
//    }


}
