package com.example.proyectofinal1.Model;

public interface LoginInteractor {

    interface OnLoginFinishedListener{
        void onUsernameError();
        void onPasswordError();
        void onSuccess();
    }

    void login (String username, String password, OnLoginFinishedListener listener);

}
