package br.edu.iff.pooa20162.testepoo.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by boris on 20/03/17.
 */

public class Proprietarios extends SugarRecord implements Parcelable {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String dataNasc;

    public Proprietarios(String nome, String endereco, String telefone, String dataNasc) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
    }

    List<Veiculos> getVeiculos() {
        return Veiculos.find(Veiculos.class, "proprietario = ?", new String(getId().toString()));
    }

    public Proprietarios(){

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(endereco);
        dest.writeLong(id);

    }

    public Long getId() {
        return id;
    }

    private Proprietarios(Parcel from){

        id = from.readLong();
        endereco = from.readString();
        nome = from.readString();
    }

    public static final Parcelable.Creator<Proprietarios>
            CREATOR = new Parcelable.Creator<Proprietarios>() {

        public Proprietarios createFromParcel(Parcel in) {
            return new Proprietarios(in);
        }

        public Proprietarios[] newArray(int size) {
            return new Proprietarios[size];
        }
    };

    @Override
    public String toString()
    {
        return nome;
    }
}