package com.pos.casa.crud_ws;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


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
        final EditText editTextId = findViewById(R.id.editText3);

        final Persons pessoa = new Persons(editTextFirstName.getText().toString(), editTextLastName.getText().toString());

        Button buttonIr = findViewById(R.id.bIr);

        final RadioButton listar = findViewById(R.id.radioButtonListar);
        final RadioButton cadastrar = findViewById(R.id.radioButtonCadastrar);
        final RadioButton alterar = findViewById(R.id.radioButtonAlterar);
        final RadioButton deletar = findViewById(R.id.radioButtonDeletar);


        final TextView textViewResposta = findViewById(R.id.tResposta);



        buttonIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //apenas pra inicializar a variavel (nao achei outra forma)
                Call<Persons> call = new RetrofitConfig().getModelService().getAllPersons();

                if (listar.isChecked()){

                    textViewResposta.setText("listar");
                    call = new RetrofitConfig().getModelService().getAllPersons();

                }
                if (cadastrar.isChecked()){

                    textViewResposta.setText("cadastrar");
                    call = new RetrofitConfig().getModelService().createPerson(pessoa);

                }
                else if (alterar.isChecked()){

                    textViewResposta.setText("alterar");
                    call = new RetrofitConfig().getModelService().updatePerson(
                            editTextId.getText().toString(), pessoa);

                }
                else if(deletar.isChecked()){

                    textViewResposta.setText("deletar");
                    call = new RetrofitConfig().getModelService().deletePerson(editTextId.getText().toString());

                }


                //Call<Persons> call = new RetrofitConfig().getModelService().getAllPersons();

                //Call<Persons> call = new RetrofitConfig().getModelService().getAllPersons(id.getText().toString());


                call.enqueue(new Callback<Persons>() {
                    @Override
                    public void onResponse(Call<Persons> call, Response<Persons> response) {
                        Persons persons = response.body();
                        textViewResposta.setText(persons.toString());
                    }

                    @Override
                    public void onFailure(Call<Persons> call, Throwable t) {
                        Log.e("ModelService   ", "Falha ao buscar" + t.getMessage());
                    }
                });


            }
        });
    }
}
