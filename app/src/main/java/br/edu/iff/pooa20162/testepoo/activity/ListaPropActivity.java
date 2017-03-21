package br.edu.iff.pooa20162.testepoo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.testepoo.R;
import br.edu.iff.pooa20162.testepoo.adapter.ProprietarioAdapter;
import br.edu.iff.pooa20162.testepoo.model.Proprietarios;

public class ListaPropActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_prop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaPropActivity.this,CadastroPropActivity.class);
                intent.putExtra("id",Long.valueOf(0));
                intent.putExtra("edtNome","");
                intent.putExtra("edtEndereco","");
                intent.putExtra("edtTel","");
                intent.putExtra("edtData","");

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_prop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onResume() {
        super.onResume();
        final ArrayList<Proprietarios> proprietarios  = (ArrayList) Proprietarios.listAll(Proprietarios.class);


        ListView lista = (ListView) findViewById(R.id.lvProprietarios);
        ArrayAdapter adapter = new ProprietarioAdapter(this,proprietarios);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaPropActivity.this,CadastroPropActivity.class);

                intent.putExtra("id",proprietarios.get(i).getId());
                intent.putExtra("edtNome",proprietarios.get(i).getNome());
                intent.putExtra("edtEndereco",proprietarios.get(i).getEndereco());
                intent.putExtra("edtTel",proprietarios.get(i).getTelefone());
                intent.putExtra("edtData",proprietarios.get(i).getDataNasc());

                startActivity(intent);

            }
        });


    }


}
