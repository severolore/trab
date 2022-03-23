package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BoasVindas extends AppCompatActivity implements View.OnClickListener {


    private String login;
    private String welcome;
    private String senha;
    private TextView tvwelcome;
    private Button btenviar;



    protected void onSaveInstanceState(Bundle dados) {

        super.onSaveInstanceState(dados);
        dados.putString("Nome", login);
        dados.putString("Senha", senha);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cardápio");

        btenviar = (Button) findViewById(R.id.btenviar);

        tvwelcome = (TextView) findViewById(R.id.tvwelcome);




        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            login = extras.getString("Nome");
            senha = extras.getString("Senha");
            welcome = "Bem-vindx, "+login+"!";
            tvwelcome.setText(welcome);

        }

        btenviar.setOnClickListener(this);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //infar arquivo xml/incorporar arquivo xml
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_search){
            Toast.makeText(this, "Pesquisar!", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.action_refresh){
            Toast.makeText(this, "Refresh!", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.action_settings){
            Toast.makeText(this, "Settings!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }



    public void onClick(View view){
        if(view.getId()==R.id.btenviar){
            Toast.makeText(this, "O GARÇOM ESTÁ A CAMINHO!", Toast.LENGTH_SHORT).show();

        }


    }


}


