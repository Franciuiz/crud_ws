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

    final EditText editTextFirstName = findViewById(R.id.editText1);
    final EditText editTextLastName = findViewById(R.id.editText2);

    Button buttonListar = findViewById(R.id.bListar);
    //Button buttonCadastrar = findViewById(R.id.bCadastrar);
    //Button buttonAlterar = findViewById(R.id.bAlterar);
    //Button buttonDeletar = findViewById(R.id.bDeletar);

    final TextView textViewResposta = findViewById(R.id.tResposta);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //@GET Implementação do botao
        buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<Pessoa> call = new RetrofitConfig().getModelService().getAllPersons(
                        editTextFirstName.getText().toString(),
                        editTextLastName.getText().toString());


                call.enqueue(new Callback<Pessoa>() {
                    @Override
                    public void onResponse(Call<Pessoa> call, Response<Pessoa> response) {
                        Pessoa pessoa = response.body();
                        textViewResposta.setText(pessoa.toString());
                    }

                    @Override
                    public void onFailure(Call<Pessoa> call, Throwable t) {
                        Log.e("ModelService   ", "Falha ao buscar" + t.getMessage());
                    }
                });

            }
        });
    }
}
