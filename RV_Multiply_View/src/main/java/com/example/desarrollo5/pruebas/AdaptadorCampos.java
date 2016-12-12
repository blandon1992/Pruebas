package com.example.desarrollo5.pruebas;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AdaptadorCampos extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<String> TipoCampo;

    public AdaptadorCampos(List<String> tipoCampo) {
        TipoCampo = tipoCampo;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view, parent, false);
                return new TextView(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_text, parent, false);
                return new EditText(view);
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.check_box, parent, false);
                return new CheckBox(view);
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.radio_button, parent, false);
                return new RadioButton(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return TipoCampo.size();
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(TipoCampo.get(position));
    }

    public static class TextView extends RecyclerView.ViewHolder{

        public TextView(View itemView) {
            super(itemView);
        }
    }

    public static class EditText extends RecyclerView.ViewHolder{

        public EditText(View itemView) {
            super(itemView);
        }
    }

    public static class CheckBox extends RecyclerView.ViewHolder{

        public CheckBox(View itemView) {
            super(itemView);
        }
    }

    public static class RadioButton extends RecyclerView.ViewHolder{

        public RadioButton(View itemView) {
            super(itemView);
        }
    }

}
