package com.example.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProductDAO {
    //Attributes
    public static final String CREATE_TABLE = "create table product ( id INTEG ER PRIMARY KEY, name TEXT, quantity INTEGER);" ;
    public static final String DROP_TABLE="DROP TABLE IF EXISTS product ";
    public DataBaseHandler dbHandler;
    //Constructor
    public ProductDAO(Context context) {
        dbHandler = new DataBaseHandler(context,"", null,1);
    }
    //Insert data
    public boolean insertdata (Product p)  {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id" , p.getId());
        values.put("name", p.getName());
        values.put("quantity", p.getQte());
        // Insertion Ligne (Row)
        db.insert("product", null, values);
        //db.close(); // fermer la connection BDx
        return true;
    }
    //Delete data
    public Boolean deletedata(Integer first) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete("product","id='"+first+"'",null);
        return true;
    }
    //Show data
    public Cursor showdata() {
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String req="SELECT * FROM product";
        Cursor c=db.rawQuery(req,null);
        return c;
    }
}