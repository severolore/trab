package com.example.trabalho;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etsenha;
    private EditText etlogin;
    private Button btenviar;
    private String senha;
    private String login;

   ;


    protected void onSaveInstanceState(Bundle dados) {

        super.onSaveInstanceState(dados);
        dados.putString("Nome", login);
        dados.putString("Senha", senha);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btenviar = (Button) findViewById(R.id.btenviar);
        etlogin = (EditText) findViewById(R.id.etlogin);
        etsenha = (EditText) findViewById(R.id.etsenha);
        btenviar.setOnClickListener(this);
        getSupportActionBar().setTitle("Cardápio");


        if(savedInstanceState!= null){
            login = savedInstanceState.getString("Nome");
            senha = savedInstanceState.getString("Senha");
            etlogin.setText(login);
            etsenha.setText(senha);
        }





    }

    public void onClick(View view){
        if(view.getId()==R.id.btenviar){

            senha = etsenha.getText().toString().trim();
            login = etlogin.getText().toString().trim();


            if(senha.equals("12345") && login.equals("Lorenzo"))
            {

                Intent  intent2 = new Intent(MainActivity.this, BoasVindas.class);
                intent2.putExtra("Nome",login);
                startActivity(intent2);


            }
            else{
                Toast.makeText(this, "LOGIN/EMAIL INCORRETOS", Toast.LENGTH_SHORT).show();
            }
        }


    }
}