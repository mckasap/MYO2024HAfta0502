package com.example.myo2024hafta0502;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etFname;
    EditText etLname;
    EditText etEmail;
    SQLiteDatabase db;
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFname=(EditText)findViewById(R.id.etFname);
        etLname=(EditText)findViewById(R.id.etLname);
        etEmail=(EditText)findViewById(R.id.etEmail);
        lv= (ListView) findViewById(R.id.listView);

        db= SQLiteDatabase.openOrCreateDatabase(this.getDatabasePath("MyDB.db"),null);
        db.execSQL("Create Table  if not exists " +
                "Calisanlar(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "LastName varchar NOT NULL," +
                "FirstName char(50) NOT NULL," +
                "Email TEXT UNIQUE)");
        Listele();
    }
    public void Save(View v){
        try {
            db.execSQL("INSERT INTO Calisanlar (LastName, FirstName, Email) " +
                    "VALUES ('" + etLname.getText().toString() + "'," +
                    " '" + etFname.getText().toString() + "'," +
                    " ' " + etEmail.getText().toString() + "')");
            Toast.makeText( this,"KAYIT BAŞARILI",Toast.LENGTH_LONG).show();
            Listele();
           // db.close();
        }catch(Exception ex){

            Toast.makeText( this,ex.getMessage().toString(),Toast.LENGTH_LONG).show();
        }

    }


    public void Listele(){
        ArrayList<Calisanlar> calisanlarListesi= new ArrayList<>();
        Calisanlar cl;
        if(db.isOpen()){
            Cursor c= db.rawQuery("Select * from Calisanlar",null);

            if(c!=null){

                if(c.moveToFirst()){

                    do{

                        cl= new Calisanlar();
                        cl.setId(c.getInt(0));
                        cl.setfName(c.getString(2));
                        cl.setlName(c.getString(1));
                        cl.setEmail(c.getString(3));
                        calisanlarListesi.add(cl);

                    }while(c.moveToNext());


                }
        ArrayAdapter<Calisanlar> adap = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,calisanlarListesi);

        lv.setAdapter(adap);


            }

        }

    }
}