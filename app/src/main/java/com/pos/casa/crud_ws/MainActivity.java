package com.pos.casa.crud_ws;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

        Button buttonIr = findViewById(R.id.bIr);

        final RadioButton listarTudo = findViewById(R.id.radioButtonListarTudo);
        final RadioButton listar = findViewById(R.id.radioButtonListar);
        final RadioButton cadastrar = findViewById(R.id.radioButtonCadastrar);
        final RadioButton alterar = findViewById(R.id.radioButtonAlterar);
        final RadioButton deletar = findViewById(R.id.radioButtonDeletar);


        final TextView textViewResposta = findViewById(R.id.tResposta);


        final Persons persons = new Persons();


        buttonIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //excuta 4 dos 5 serviços passando classe Persons
                if(!(listarTudo.isChecked())) {

                    //apenas pra inicializar a variavel (nao achei outra forma)
                    Call<Persons> call = new RetrofitConfig().getModelService().createPerson(persons);

                    //@Get Psaando id
                    if (listar.isChecked()) {

                        call = new RetrofitConfig().getModelService().getPersons((long) Integer.parseInt(editTextId.getText().toString()));

                    //@Post
                    } else if (cadastrar.isChecked()) {


                        persons.setFirstName(editTextFirstName.getText().toString());
                        persons.setLastName(editTextLastName.getText().toString());

                        call = new RetrofitConfig().getModelService().createPerson(persons);
                        Toast.makeText(getBaseContext(), editTextFirstName.getText().toString() + "Cadastrado com sucesso", Toast.LENGTH_LONG).show();

                    //@Put
                    } else if (alterar.isChecked()) {

                        persons.setFirstName(editTextFirstName.getText().toString());
                        persons.setLastName(editTextLastName.getText().toString());

                        call = new RetrofitConfig().getModelService().updatePerson((long) Integer.parseInt(editTextId.getText().toString()), persons);
                        Toast.makeText(getBaseContext(), "Item " + editTextId.getText().toString() + "Alterado com sucesso", Toast.LENGTH_LONG).show();

                    //@Delete
                    } else if (deletar.isChecked()) {

                        call = new RetrofitConfig().getModelService().deletePerson((long) Integer.parseInt(editTextId.getText().toString()));
                        Toast.makeText(getBaseContext(), "Item " + editTextId.getText().toString() + "Deletado com sucesso", Toast.LENGTH_LONG).show();

                    }


                    call.enqueue(new Callback<Persons>() {
                        @Override
                        public void onResponse(Call<Persons> call, Response<Persons> response) {
                            if(response.body() != null) {
                                Persons p = response.body();
                                textViewResposta.setText(p.toString());
                            } else {
                                textViewResposta.setText("Elemento não encontrado");
                            }
                        }

                        @Override
                        public void onFailure(Call<Persons> call, Throwable t) {
                            Log.e("ModelService   ", "Falha ao buscar" + t.getMessage());
                        }
                    });

                    //executa serviço @getall passando um List de Persons
                } else {

                    Call<List<Persons>> call = new RetrofitConfig().getModelService().getAllPersons();
                    call = new RetrofitConfig().getModelService().getAllPersons();

                    call.enqueue(new Callback<List<Persons>>() {
                        @Override
                        public void onResponse(Call<List<Persons>> call, Response<List<Persons>> response) {
                            List<Persons> p = response.body();
                            textViewResposta.setText(p.toString());
                        }

                        @Override
                        public void onFailure(Call<List<Persons>> call, Throwable t) {
                            Log.e("ModelService   ", "Falha ao buscar" + t.getMessage());
                        }
                    });

                }


            }
        });
    }
}
