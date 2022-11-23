package com.example.proyectofinal1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class RegistrerFragment extends Fragment {

    EditText username, email, password, confirmPassword;

    private DBHelper dbHelper;

    Button button_reg;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrer,container,false);

        username = view.findViewById(R.id.input_username);
        email = view.findViewById(R.id.input_email);
        password = view.findViewById(R.id.input_password);
        confirmPassword = view.findViewById(R.id.input_confirmPassword);

        button_reg = view.findViewById(R.id.register_btn);

        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateUsername() | !validateEmail() | !validatePassword() | validateConfirmPassword())
                    return;
            }
        });

        return  view;
    }

    public Boolean validateUsername(){
        String value = username.getText().toString();
        String noWhiteSpaces = "(?=\\s+$)";

        if(value.isEmpty()){
            username.setError("Rellene el campo vacio");
            return false;
        }else if(value.length() >= 15){
            username.setError("Nombre de usuario muy largo");
            return false;
        }else if(!value.matches(noWhiteSpaces)) {
            username.setError("No estan permitidos los espacio en blanco");
            return false;
        }else{
            username.setError(null);
            return true;
        }
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
        String value = password.getText().toString();
        String passwordPattern = "^"+
                "(?=.*[a-zA-Z0-9])" +   //cualquier caracter
                "(?=\\s+$)" +           //sin espacios en blanco
                ".{4,}" +               //mas de 4 caracteres
                "$";

        if(value.isEmpty()){
            password.setError("Rellene el campo vacio");
            return false;
        }else if(!value.matches(passwordPattern)) {
            password.setError("contraseña invalido");
            password.requestFocus();
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }

    public Boolean validateConfirmPassword(){
        String pass = password.getText().toString();
        String confPass = confirmPassword.getEditableText().toString();

        if(confPass.isEmpty()) {
            confirmPassword.setError("Rellene el campo vacio");
            return false;
        }
        if(!pass.equals(confPass)){
            confirmPassword.setError("No coinciden las contraseñas");
            confirmPassword.requestFocus();
            return false;
        }else{
            confirmPassword.setError(null);
            return true;
        }
    }
}