package com.example.taskmaster;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList; import java.util.List;
public class DataBaseHelper extends SQLiteOpenHelper  {
    //client table
    public static final String CLIENT_TABLE = "CLIENT_Table";
    public static final String COLUMN_CLIENT_NAME = "CLIENT_NAME";
    public static final String COLUMN_CLIENT_ID = "CLIENT_ID";
    public static final String COLUMN_CLIENT_EMAIL = "STUDENT_EMAIL";
    public static final String COLUMN_CLIENT_PASSWORD = "CLIENT_PASSWORD";

    //service table
    public static final String SERVICE_TABLE = "SERVICE_Table";
    public static final String COLUMN_CATEGORY_NAME = "CATEGORY_NAME";
    public static final String COLUMN_SERVICE_ID = "SERVICE_ID";
    public static final String COLUMN_SUBCATEGORY_NAME = "SUBCATEGORY_NAME";
    public static final String COLUMN_PRICE = "PRICE";
    public static final String COLUMN_DESCRIPTION = "DESCRIPTION";

    //order table
    public static final String ORDER_TABLE = "ORDER_Table";
    public static final String COLUMN_ORDER_ID = "ORDER_ID";
    //service id and client id as foreign key
    public static final String COLUMN_LOCATION = "LOCATION";
    public static final String COLUMN_RATE = "RATE";
    public static final String COLUMN_TIME = "TIME";
    public static final String COLUMN_WORKER_NAME = "WORKER_NAME";
    public static final String COLUMN_ORDER_STATUS = "ORDER_STATUS";
    public static final String COLUMN_WORKER_PHONE = "WORKER_PHONE";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "student.db", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "Create TABLE " + CLIENT_TABLE + " (" + COLUMN_CLIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CLIENT_NAME + " TEXT, " + COLUMN_CLIENT_EMAIL + " TEXT, " + COLUMN_CLIENT_PASSWORD + " TEXT )";
        sqLiteDatabase.execSQL(createTableStatement);
        String createTable2Statement = "Create TABLE " + SERVICE_TABLE + " (" + COLUMN_SERVICE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CATEGORY_NAME + " TEXT, " + COLUMN_SUBCATEGORY_NAME + " TEXT, "+ COLUMN_PRICE + " INTEGER, " + COLUMN_DESCRIPTION + " TEXT )";
        sqLiteDatabase.execSQL(createTable2Statement);
        String createTable3Statement = "Create TABLE " + ORDER_TABLE + " (" + COLUMN_ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_SERVICE_ID +"INTEGER, FOREIGN KEY ('SERVICE_ID') REFERENCES "+ SERVICE_TABLE +"('SERVICE_ID'), " + COLUMN_CLIENT_ID +"INTEGER, FOREIGN KEY ('CLIENT_ID') REFERENCES "+ CLIENT_TABLE +"('CLIENT_ID'), "+ COLUMN_LOCATION + " TEXT, " + COLUMN_RATE + " INTEGER, " + COLUMN_TIME + " TEXT, "+ COLUMN_WORKER_NAME + " TEXT, "+ COLUMN_WORKER_PHONE + " TEXT, "+ COLUMN_ORDER_STATUS + " TEXT )";
        sqLiteDatabase.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public boolean addClient(clientmod clientmod){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CLIENT_NAME, clientmod.getcName());
        cv.put(COLUMN_CLIENT_EMAIL, clientmod.getEmail());
        cv.put(COLUMN_CLIENT_PASSWORD, clientmod.getPassword());
        long insert = db.insert(CLIENT_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        else {
            return true;
        } }

    public Boolean checkUsername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from " + CLIENT_TABLE + " where " + COLUMN_CLIENT_NAME + " = ?", new
                String[]{username});
        if (cursor.getCount() > 0) return true;
        return false;
    }
    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from " + CLIENT_TABLE + " where " + COLUMN_CLIENT_NAME + " = ? and " + COLUMN_CLIENT_PASSWORD +
                " = ?", new String[] {username,password});
        if(cursor.getCount()>0) return true;
        return false;
    }

    public boolean addService(servicemod servicemod){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CATEGORY_NAME,servicemod.getCategoryName() );
        cv.put(COLUMN_SUBCATEGORY_NAME, servicemod.getSubcategory());
        cv.put(COLUMN_PRICE, servicemod.getPrice());
        cv.put(COLUMN_DESCRIPTION,servicemod.getDescription() );
        long insert = db.insert(CLIENT_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        else {
            return true;
        } }
    public boolean addOrder(ordermod ordermod){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_SERVICE_ID,ordermod.getServiceID() );
        cv.put(COLUMN_CLIENT_ID,ordermod.getClientID() );
        cv.put(COLUMN_LOCATION,ordermod.getLocation() );
        cv.put(COLUMN_RATE, ordermod.getRate());
        cv.put(COLUMN_TIME, ordermod.getTime());
        cv.put(COLUMN_WORKER_NAME, ordermod.getWorkerName());
        cv.put(COLUMN_WORKER_PHONE, ordermod.getWorkerPhone());
        cv.put(COLUMN_ORDER_STATUS, ordermod.getOrderStatus());
        long insert = db.insert(CLIENT_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        else {
            return true;
        } }

    public boolean DeleteClient(clientmod clientmod){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString= "Delete From " + CLIENT_TABLE + " WHERE " +
                COLUMN_CLIENT_ID + " = " + clientmod.getClientID() ;
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            return true;
        } else{
            return false;
        }
    }

    public boolean DeleteService(servicemod servicemod){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString= "Delete From " + SERVICE_TABLE + " WHERE " +
                COLUMN_SERVICE_ID + " = " + servicemod.getServiceID() ;
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            return true;
        } else{
            return false;
        }
    }

    public boolean DeleteOrder(ordermod ordermod){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString= "Delete From " + ORDER_TABLE + " WHERE " +
                COLUMN_ORDER_ID+ " = " + ordermod.getOrderID() ;
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            return true;
        } else{
            return false;
        }
    }



}
