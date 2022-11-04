package com.example.bt10sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bt10sqlite.Control.Database;
import com.example.bt10sqlite.Model.Lop;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Database db;
    List<Lop> categories = new ArrayList<Lop>();
    ArrayAdapter<Lop> lopArrayAdapter;
    boolean kt=true;
    ListView lvLop;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Database(this,"SINHVIEN.sqlite",null,1);
        db.QueryData("create table IF NOT EXISTS Lop(idLop VARCHAR(100),nameLop nVARCHAR(100))");
        db.QueryData("create table IF NOT EXISTS SinhVien(idSinhVien VARCHAR(100),nameSinhVien VARCHAR(100),idLop VARCHAR(100))");

        Cursor cursor = db.GetData("select * from Lop");
        if (cursor.getCount()==0){
            db.insertCa("20T2","Công Nghệ Số");
            db.insertCa("20T1","Công Nghệ Số");
            db.insertCa("20T3","Công Nghệ Số");
        }
        cursor = db.GetData("select * from SinhVien");
        if (cursor.getCount()==0){
            db.insertC("2050531200234","Vũ Lê Na","20T2");
            db.insertC("2050653672834","Nguyễn Văn A","20T2");
            db.insertC("2050531200394","Nguyễn Văn B","20T3");
            db.insertC("2050531200184","Nguyễn Văn C","20T1");
        }

        lvLop= (ListView) findViewById(R.id.listviewLop);

        getDataLop();
        lvLop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ListSinhVien.class);
                intent.putExtra("idLop", categories.get(i).getIdLop());
                System.out.println(categories.get(i).getIdLop());
                kt=true;
                startActivity(intent);
            }
        });

        lvLop.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                int j=i;
                AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(MainActivity.this);
                alertDiaLog.setTitle("Thông báo");
                alertDiaLog.setMessage("Bạn có muốn xóa "+categories.get(i).getIdLop()+" ?"    );
                alertDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.QueryData("delete from Lop where idLop ='"+categories.get(j).getIdLop()+"'");
                        getDataLop();
                        lopArrayAdapter.notifyDataSetChanged();
                    }
                });
                alertDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDiaLog.show();
                return true;
            }
        });
        Button button = (Button) findViewById(R.id.btn_themLop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialogLopcustom);
                dialog.show();
                TextView tv1 = (TextView) dialog.findViewById(R.id.isIDCa);
                TextView tv2 = (TextView) dialog.findViewById(R.id.isNameCa);
                Button btok = (Button) dialog.findViewById(R.id.btn_okCa);
                Button btcancel = (Button) dialog.findViewById(R.id.btn_cancelCa);
                btok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        db.insertCa(tv1.getText().toString().trim(),tv2.getText().toString().trim());
                        dialog.dismiss();
                        getDataLop();
                        lopArrayAdapter.notifyDataSetChanged();
                    }
                });
                btcancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
            }
        });
    }

    public void getDataLop() {
        categories = new ArrayList<Lop>();
        Cursor cursor = db.GetData("select * from Lop");
        System.out.println("ABC " + cursor.getCount());
        if (cursor.getCount()>0){
            System.out.println("abc");
            while (cursor.moveToNext()){
                @SuppressLint("Range") String idCa = cursor.getString(cursor.getColumnIndex("idLop"));
                @SuppressLint("Range") String nameCa = cursor.getString(cursor.getColumnIndex("nameLop"));
                categories.add(new Lop(idCa,nameCa));
            }
        }
        lopArrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,categories);
        lvLop.setAdapter(lopArrayAdapter);
        lopArrayAdapter.notifyDataSetChanged();
    }
}

