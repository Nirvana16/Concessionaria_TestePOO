package br.edu.iff.pooa20162.testepoo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.edu.iff.pooa20162.testepoo.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamaTelaCadastrosP(View v){

        Intent intentp = new Intent(MainActivity.this, ListaPropActivity.class);
        startActivity(intentp);
    }

    public void chamaTelaCadastrosV(View v){
        Intent intentv = new Intent(MainActivity.this, ListaVeicActivity.class);
        startActivity(intentv);
    }

    private Context getContext(){
        return this;

    }
}
