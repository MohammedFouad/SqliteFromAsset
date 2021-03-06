package com.mohamedfoad.sqlitefromasset.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mohamedfoad.sqlitefromasset.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EasyUApp on 12/26/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "sample.sqlite";
    public static final String DBLOCATION ="/data/data/com.mohamedfoad.sqlitefromasset/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context){
        super(context,DBNAME,null,1);
        this.mContext=context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void openDatabase(){
        String dbpath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()){
            return;
        }

        mDatabase = SQLiteDatabase.openDatabase(dbpath, null, SQLiteDatabase.OPEN_READWRITE);
    }
    public void closeDatabase(){

        if(mDatabase!=null){
            mDatabase.close();
        }

    }
    public List<Product> getListProduct(){
        Product product = null;
        List<Product> productList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM PRODUCT", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            product=new Product(cursor.getInt(0),cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3));
            productList.add(product);
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return productList;
    }
}
