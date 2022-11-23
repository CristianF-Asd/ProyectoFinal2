package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.proyectofinal1.Model.LoginInteractorImpl;
import com.example.proyectofinal1.Presenter.LoginPresenter;
import com.example.proyectofinal1.Presenter.LoginPresenterImpl;
import com.example.proyectofinal1.View.LoginView;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText usuario;
    private EditText password;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        progressBar = findViewById(R.id.progressBar);
        usuario = findViewById(R.id.edtusername);
        password = findViewById(R.id.edtpassword);

        findViewById(R.id.button).setOnClickListener(this);

        presenter = new LoginPresenterImpl(this,new LoginInteractorImpl());
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        presenter.validateCredentials(usuario.getText().toString(), password.getText().toString());

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility((View.GONE));

    }

    @Override
    public void setUsernameError() {

        usuario.setError("Error de usuario");


    }

    @Override
    public void setPasswordError() {
        password.setError("Error de password");

    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this,"Ingreso", Toast.LENGTH_SHORT).show();

    }
}