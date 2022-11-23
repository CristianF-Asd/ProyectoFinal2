package com.example.proyectofinal1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.proyectofinal1.View.CallFragment;


public class LoginFragment extends Fragment {
    
    Button btnLogin,btnRegistro;
    EditText email, etPassword;
    CallFragment callFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        email = view.findViewById(R.id.et_username);
        etPassword = view.findViewById(R.id.etpassword);

        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnRegistro = (Button) view.findViewById(R.id.btnRegistro);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateEmail() | !validatePassword())
                    return;
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callFragment!=null){
                    callFragment.changeFragment();
                }
            }
        });


        return  view;
    }
    public void setCallFragment (CallFragment callFragment){
        this.callFragment = callFragment;
    }

    public Boolean validateEmail(){
        String value = email.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(value.isEmpty()){
            email.setError("Rellene el campo vacio");
            return false;
        }else if(!value.matches(emailPattern)) {
            email.setError("Correo electronico invalido");
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String value = etPassword.getText().toString();
        String passwordPattern = "^"+
                "(?=.*[a-zA-Z0-9])" +   //cualquier caracter
                "(?=\\s+$)" +           //sin espacios en blanco
                ".{4,}" +               //mas de 4 caracteres
                "$";

        if(value.isEmpty()){
            etPassword.setError("Rellene el campo vacio");
            return false;
        }else if(!value.matches(passwordPattern)) {
            etPassword.setError("contraseña invalido");
            etPassword.requestFocus();
            return false;
        }else{
            etPassword.setError(null);
            return true;
        }
    }

}