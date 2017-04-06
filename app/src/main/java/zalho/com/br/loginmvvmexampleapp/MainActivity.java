package zalho.com.br.loginmvvmexampleapp;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.FirebaseApp;

import zalho.com.br.loginmvvmexampleapp.view.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseApp.initializeApp(getApplicationContext());

        navegarPara(LoginFragment.class);
    }

    public void navegarPara(Class<?> destino){
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout_app, (Fragment) destino.newInstance())
                    .commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void navegarPara(String origem, Class<?> destino){
        try {
            getSupportFragmentManager().getFragments().get(0);
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_app, (Fragment) destino.newInstance()).addToBackStack(origem)
                    .commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }





}
