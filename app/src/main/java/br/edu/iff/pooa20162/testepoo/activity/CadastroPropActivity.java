package br.edu.iff.pooa20162.testepoo.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


import br.edu.iff.pooa20162.testepoo.R;
import br.edu.iff.pooa20162.testepoo.model.Proprietarios;


public class CadastroPropActivity extends Activity {

    EditText edtNome, edtEndereco, edtTel, edtData;
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
        setContentView(R.layout.activity_cadastro_prop);
        Intent intent = getIntent();
        id = (Long) intent.getSerializableExtra("id");

        String nomep = (String) intent.getSerializableExtra("edtNome");
        String enderecop = (String) intent.getSerializableExtra("edtEndereco");
        String telefonep = (String) intent.getSerializableExtra("edtTel");
        String dataNascp = (String) intent.getSerializableExtra("edtData");

        EditText nome = (EditText) findViewById(R.id.etNomeProprietario);
        nome.setText(nomep);

        EditText endereco = (EditText) findViewById(R.id.etEnderecoP);
        endereco.setText(enderecop);

        EditText telefone = (EditText) findViewById(R.id.etTelefoneP);
        telefone.setText(telefonep);

        EditText dataNasc = (EditText) findViewById(R.id.etDataNascP);
        dataNasc.setText(dataNascp);


        btsalvar = (Button) findViewById(R.id.btSalvarP);
        btalterar = (Button) findViewById(R.id.btAlterarP);


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

        edtNome = (EditText) findViewById(R.id.etNomeProprietario);
        edtEndereco = (EditText) findViewById(R.id.etEnderecoP);
        edtTel = (EditText) findViewById(R.id.etTelefoneP);
        edtData = (EditText) findViewById(R.id.etDataNascP);

        Proprietarios proprietarios = new Proprietarios(edtNome.getText().toString(), edtEndereco.getText().toString(),
                edtTel.getText().toString(), edtData.getText().toString());

        proprietarios.save();

        Toast.makeText(this, "Proprietário Cadastrado", Toast.LENGTH_LONG).show();
        //this.finish();

    }

    public void alterar() {

        edtNome = (EditText) findViewById(R.id.etNomeProprietario);
        edtEndereco = (EditText) findViewById(R.id.etEnderecoP);
        edtTel = (EditText) findViewById(R.id.etTelefoneP);
        edtData = (EditText) findViewById(R.id.etDataNascP);

        Proprietarios proprietarios = Proprietarios.findById(Proprietarios.class, id);

        proprietarios.setNome(edtNome.getText().toString());
        proprietarios.setEndereco(edtEndereco.getText().toString());
        proprietarios.setTelefone(edtTel.getText().toString());
        proprietarios.setDataNasc(edtData.getText().toString());

        proprietarios.save();

        Toast.makeText(this, "Proprietário Alterado com sucesso", Toast.LENGTH_LONG).show();
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