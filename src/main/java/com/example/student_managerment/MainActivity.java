package com.example.student_managerment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

//import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Open DB

        String path = getFilesDir() + "/mydb";
        try {
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        createTable();
    }



        public void createTable() {
            db.beginTransaction();
            try {
                db.execSQL("create table student(mssv integer PRIMARY KEY, hoten text,email text,phone text,birth date)");
                db.execSQL("insert into student(mssv, hoten, email, phone,birth ) values('20194022, levanduc, duc@gmail.com, 125675443,null')");
                db.setTransactionSuccessful();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                db.endTransaction();
            }
        }

        @Override
        protected void onDestroy () {
            db.close();
            super.onDestroy();
        }
}
