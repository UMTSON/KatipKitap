package com.example.katipkitap;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class kayitlar_1 extends AppCompatActivity {

    database vt;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitlar_1);
        list=findViewById(R.id.listview);
        vt=new database(this);
        String []sutunlar = {"ogr_numara","alinan_kitap","kitap_tarih"};
        SQLiteDatabase oku = vt.getWritableDatabase();
        Cursor isaretci = oku.query("uyeler",sutunlar,null,null,null,null,null);
        ArrayList<String> listee=new ArrayList<String>();
        while(isaretci.moveToNext())
        {
            listee.add(isaretci.getString(0)+" - "+isaretci.getString(1)+" - "+isaretci.getString(2));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,listee);
        list.setAdapter(adapter);
    }
}
