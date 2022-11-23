package com.example.proyectofinal1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DBHelper {

    private Context con;
    private SQLiteDatabase db;


    public DBHelper(Context con){
        this.con = con;
    }

    public DBHelper OpenDB(){
        DBConnector dbCon = new DBConnector(con);
        db = dbCon.getWritableDatabase();
        return  this;

    }
    public boolean RegistrarUser(User user){
        try{
            ContentValues cv = new ContentValues();
            cv.put("UserName", user.getUserName());
            cv.put("correo", user.getCorreo());
            cv.put("password", user.getPassword());

            db.insert("userInfo",null,cv);
            return true;
        }catch(Exception e){
            Toast.makeText(con, e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}
