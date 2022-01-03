package com.example.katipkitap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public database(@Nullable Context context) {
        super(context, "Katip_Kitap", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table uyeler (ogr_numara TEXT,ogr_ad TEXT,ogr_soyad TEXT,ogr_bolum TEXT,alinan_kitap TEXT,kitap_tarih TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists uyeler");
        this.onCreate(db);
    }
}
