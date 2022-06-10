package com.example.symbian_sas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.symbian_sas.model.Cliente;
import com.example.symbian_sas.remote.APIUtil;
import com.example.symbian_sas.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroCliente extends AppCompatActivity {

    /*
     * Atributo de interface gráfica
     */

    EditText txtNome;
    EditText txtSobrenome;
    EditText txtEmail;
    EditText txtCelular;
    Button btnCadastrar;

    /*
     * Atributo de representação das rotas
     */

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        /*
         * Recebendo os objetos de interface
         */

        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtEmail = findViewById(R.id.txtEmail);
        txtCelular = findViewById(R.id.txtCelular);
        btnCadastrar = findViewById(R.id.btnCadastrarUsuario);

        /*
         * Tratamento do envento de click no botão inserir
         */

        btnCadastrar.setOnClickListener(view -> {

            /*
             *  Cria um objeto da model de usuário
             */

            Cliente cliente = new Cliente();

            /*
             *  Carrega os dados do formulário no objeto de model usuário
             */

            cliente.setNome(txtNome.getText().toString());
            cliente.setSobrenome(txtSobrenome.getText().toString());
            cliente.setEmail(txtEmail.getText().toString());
            cliente.setCelular(txtCelular.getText().toString());

            /*
             *  Passar os dados para a APIREST
             */

            routerInterface = APIUtil.getClienteInterface();
            addCliente(cliente);

        });

        /*
         *  Fim do método onCreate
         */
    }

    /**
     * Implementação do método de Call addUsuario
     */

    public void addCliente(Cliente cliente) {

        Call<Cliente> call = routerInterface.addCliente(cliente);

        call.enqueue(new Callback<Cliente>() {

            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                Toast.makeText(CadastroCliente.this, "Cliente cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Log.d("Erro-API", t.getMessage());
            }
        });
    }

}