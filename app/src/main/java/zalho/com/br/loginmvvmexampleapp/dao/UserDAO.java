package zalho.com.br.loginmvvmexampleapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import zalho.com.br.loginmvvmexampleapp.model.entidades.Login;

/**
 * Created by andre on 18/05/2017.
 */

public class UserDAO extends SQLiteOpenHelper {

    public UserDAO(Context context) {
        super(context, "AgileTest", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE user(" +
                "id INTEGER PRIMARY KEY," +
                "login TEXT NOT NULL," +
                "senha TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insere(Login login){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("login", login.getLogin());
        contentValues.put("senha", login.getSenha());

        db.insert("user", null, contentValues);
    }

    public String buscaUsuario(){
        String sql = "select * from user";

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);
        String usuario = "";

        if(cursor.moveToNext()){
            usuario = String.valueOf(cursor.getInt(cursor.getColumnIndex("id")));
        }

        return usuario;
    }
}
