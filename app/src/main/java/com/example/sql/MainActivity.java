package com.example.sql;

import  androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.sql.Product;
import com.example.sql.ProductDAO;
import com.example.sql.R;

public class MainActivity extends AppCompatActivity {
    EditText id, name, qt;
    TextView t1;
    ProductDAO DAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DAO = new ProductDAO(this);
        id = findViewById(R.id.e1);
        name = findViewById(R.id.e2);
        qt = findViewById(R.id.e3);
        t1 = findViewById(R.id.t1);


    }
    public void add(View view) {
        int idS = Integer.parseInt(id.getText().toString());
        String nameS = name.getText().toString();
        int qtS = Integer.parseInt(qt.getText().toString());
        Product p=new Product(idS, nameS, qtS);

        Toast.makeText(MainActivity.this,"inserted",Toast.LENGTH_SHORT).show();
        boolean d=  DAO.insertdata(p);
        if (d==true){
            Toast.makeText(MainActivity.this,"inserted",Toast.LENGTH_SHORT).show();
        }
        else
        {  Toast.makeText(MainActivity.this,"not inserted",Toast.LENGTH_SHORT).show();}
    }

    public void delete(View view) {
        int idS = Integer.parseInt(id.getText().toString());
        Boolean revue= DAO.deletedata(idS);
        if (revue=true)
        {
            Toast.makeText(MainActivity.this,"deleted",Toast.LENGTH_SHORT).show();
        }
        else{Toast.makeText(MainActivity.this,"not deleted",Toast.LENGTH_SHORT).show();}
    }

    public void show(View view) {
        Cursor c=DAO.showdata();

        String list="";
        if( c.getCount()==0 ){
            //empty
        } else{
            while (c.moveToNext()) {
                //get data
                list=("Id:" + c.getInt(0) + " " + "Name:" + c.getString(1) + " " + "Quantity:" + c.getString(2))+"\n"+list;
            }
            Toast.makeText(MainActivity.this,list,Toast.LENGTH_SHORT).show();

            t1.setText(list);}
    }
}
