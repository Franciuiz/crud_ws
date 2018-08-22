package com.pos.casa.crud_ws;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText editTextFirstName = findViewById(R.id.editText1);
        final EditText editTextLastName = findViewById(R.id.editText2);

        Button buttonListar = findViewById(R.id.bListar);
        //Button buttonCadastrar = findViewById(R.id.bCadastrar);
        //Button buttonAlterar = findViewById(R.id.bAlterar);
        //Button buttonDeletar = findViewById(R.id.bDeletar);

        final TextView textViewResposta = findViewById(R.id.tResposta);


        //@GET ALL Implementação do botao
        buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Call<Model> call = new RetrofitConfig().getModelService().getAllPersons();

                //Call<Model> call = new RetrofitConfig().getModelService().getAllPersons(id.getText().toString());


                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Model model = response.body();
                        textViewResposta.setText(model.toString());
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e("ModelService   ", "Falha ao buscar" + t.getMessage());
                    }
                });


            }
        });
    }
}
