package com.example.learningfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button bEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.et);
        bEnviar = (Button) findViewById(R.id.buttonSend);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("item");

        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue(editText.getText().toString());
                editText.setText("");
            }
        });

/*        Firebase.setAndroidContext(this);   //Se indica el contexto que puede utilizar firebase
        firebase = new Firebase(URL).child(CHILD);  //Se le da un valor a la variable firebase indicandole la url y el hijo o valor al que va acceder

        //Para leer solo un valor cuando se presente un cambio
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null){
                    Toast.makeText(MainActivity.this, dataSnapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebase.setValue(editText.getText().toString());
                editText.setText("");
            }
        });*/
    }
}
