package com.example.bt10sqlite.Control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //query
    public void QueryData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public void insertSinhVien(String idC,String nameC,String idCa){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO tblop VALUES(?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(0,idC);
        statement.bindString(1,nameC);
        statement.bindString(3,idCa);

        statement.executeInsert();
    }
    public long insertC(String idC,String nameC,String idCa) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("idSinhVien", idC);
        values.put("nameSinhVien", nameC);
        values.put("idLop", idCa);
        return db.insert("SinhVien", null, values);
    }
    public long insertCa(String idC,String nameC) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("idLop", idC);
        values.put("nameLop", nameC);
        return db.insert("Lop", null, values);
    }
    public void insertLop(String idCa,String nameCa){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO tblop VALUES(?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(0,idCa);
        statement.bindString(1,nameCa);
        statement.executeInsert();
    }
    public Boolean update_img(){
        return true;
    }
    public Cursor GetData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}


