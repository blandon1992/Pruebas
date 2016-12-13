package com.example.desarrollo5.pruebas;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> tipoFormularios;
    private AdaptadorCampos adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipoFormularios = new ArrayList<String>();
        for(int j = 0;j<4;j++){
            tipoFormularios.add(Integer.toString(j));
        }
        for(int j = 0;j<3;j++){
            tipoFormularios.add(Integer.toString(j));
        }

        adapter = new AdaptadorCampos(tipoFormularios,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rvCampos);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);

    }

    public class AdaptadorCampos extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        private List<String> TipoCampo;
        private AdaptadorCampos adapter;
        private Context context;
        private int selected_position;

        public AdaptadorCampos(List<String> tipoCampo,Context context) {
            TipoCampo = tipoCampo;
            this.context=context;
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
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            if(selected_position == position){
                // Se resalta el elemento
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context,R.color.amarillo));
            }else{
                holder.itemView.setBackgroundColor(Color.TRANSPARENT);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notifyItemChanged(selected_position);
                    selected_position = position;
                    notifyItemChanged(selected_position);
                    Toast.makeText(context, Integer.toString(position), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return TipoCampo.size();
        }

        @Override
        public int getItemViewType(int position) {
            return Integer.parseInt(TipoCampo.get(position));
        }

        public class TextView extends RecyclerView.ViewHolder{

            public TextView(View itemView) {
                super(itemView);
            }
        }

        public class EditText extends RecyclerView.ViewHolder{

            public EditText(View itemView) {
                super(itemView);
            }
        }

        public class CheckBox extends RecyclerView.ViewHolder{

            public CheckBox(View itemView) {
                super(itemView);
            }
        }

        public class RadioButton extends RecyclerView.ViewHolder{

            public RadioButton(View itemView) {
                super(itemView);
            }
        }

    }

}
