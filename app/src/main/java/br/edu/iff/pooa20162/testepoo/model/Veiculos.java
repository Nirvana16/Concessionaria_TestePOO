package br.edu.iff.pooa20162.testepoo.model;

import com.orm.SugarRecord;

/**
 * Created by boris on 17/03/17.
 */

public class Veiculos extends SugarRecord {

    private String placa;
    private String modelo;
    private String ano;
    private Proprietarios proprietario;


    public Veiculos(String placa, String modelo, String ano, Proprietarios proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.proprietario = proprietario;

    }

    public Veiculos(){

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Proprietarios getProprietario() {  return proprietario; }

    public void setProprietario(Proprietarios proprietario) { this.proprietario = proprietario; }
}

