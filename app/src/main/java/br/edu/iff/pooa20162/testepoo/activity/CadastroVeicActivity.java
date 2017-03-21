package br.edu.iff.pooa20162.testepoo.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import br.edu.iff.pooa20162.testepoo.R;
import br.edu.iff.pooa20162.testepoo.model.Proprietarios;
import br.edu.iff.pooa20162.testepoo.model.Veiculos;

public class CadastroVeicActivity extends Activity {

    EditText placa, modelo, ano;
    Spinner spProprietario;
    Button btsalvar, btalterar;
    Long id;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_veic);
        Intent intent = getIntent();
        id = (Long) intent.getSerializableExtra("id");

        String placav = (String) intent.getSerializableExtra("placa");
        String modelov = (String) intent.getSerializableExtra("modelo");
        String anov = (String) intent.getSerializableExtra("ano");


        EditText placa = (EditText) findViewById(R.id.etPlacaV);
        placa.setText(placav);

        EditText modelo = (EditText) findViewById(R.id.etModeloV);
        modelo.setText(modelov);

        EditText ano = (EditText) findViewById(R.id.etAnoV);
        ano.setText(anov);

        final ArrayList<Proprietarios> proprietario  = (ArrayList) Proprietarios.listAll(Proprietarios.class);

        ArrayAdapter<Proprietarios> adapter = new ArrayAdapter<Proprietarios>(this, android.R.layout.simple_spinner_item, proprietario);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spProprietario = (Spinner) findViewById(R.id.spProprietarioinVeiculo);
        spProprietario.setAdapter(adapter);




        btsalvar = (Button) findViewById(R.id.btSalvarV);
        btalterar = (Button) findViewById(R.id.btAlterarV);


        btsalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                alterar();
            }
        });

        if (id != 0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);
        } else {
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);

        }


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void salvar() {

        placa = (EditText) findViewById(R.id.etPlacaV);
        modelo = (EditText) findViewById(R.id.etModeloV);
        ano = (EditText) findViewById(R.id.etAnoV);
        Proprietarios proprietario  = ((Proprietarios) spProprietario.getSelectedItem());


        Veiculos veiculos = new Veiculos(placa.getText().toString(), modelo.getText().toString(),
                ano.getText().toString(), proprietario);

        veiculos.save();

        Toast.makeText(this, "Veículo Cadastrado", Toast.LENGTH_LONG).show();
        //this.finish();

    }

    public void alterar() {

        placa = (EditText) findViewById(R.id.etPlacaV);
        modelo = (EditText) findViewById(R.id.etModeloV);
        ano = (EditText) findViewById(R.id.etAnoV);
        Proprietarios proprietarios  = ((Proprietarios) spProprietario.getSelectedItem());

        Veiculos veiculos = Veiculos.findById(Veiculos.class, id);

        veiculos.setPlaca(placa.getText().toString());
        veiculos.setModelo(modelo.getText().toString());
        veiculos.setAno(ano.getText().toString());
        veiculos.setProprietario(proprietarios);

        veiculos.save();

        Toast.makeText(this, "Veículo Alterado", Toast.LENGTH_LONG).show();
        this.finish();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Cadastro Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
