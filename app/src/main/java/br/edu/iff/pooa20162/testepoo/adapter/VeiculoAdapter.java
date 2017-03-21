package br.edu.iff.pooa20162.testepoo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.testepoo.R;
import br.edu.iff.pooa20162.testepoo.model.Veiculos;

/**
 * Created by boris on 21/03/17.
 */

public class VeiculoAdapter extends ArrayAdapter<Veiculos>{

    private Context context = null;
    private ArrayList<Veiculos> veiculos = null;


    public VeiculoAdapter(Context context, ArrayList<Veiculos> veiculos) {
        super(context, R.layout.linhaveiculo,veiculos);
        this.context = context;
        this.veiculos = veiculos;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhaveiculo, parent, false);

        TextView placa = (TextView) rowView.findViewById(R.id.tvllvPlaca);
        TextView modelo = (TextView) rowView.findViewById(R.id.tvllvModelo);
        TextView ano = (TextView) rowView.findViewById(R.id.tvllvAno);
        TextView proprietario = (TextView) rowView.findViewById(R.id.tvllvProprietario);

        placa.setText(veiculos.get(position).getPlaca());
        modelo.setText(veiculos.get(position).getModelo());
        ano.setText(veiculos.get(position).getAno());
        proprietario.setText(veiculos.get(position).getProprietario().getNome());
        return rowView;
    }

}
