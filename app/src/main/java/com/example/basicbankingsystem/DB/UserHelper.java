package com.example.basicbankingsystem.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingsystem.DB.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;


    private static final String DATABASE_NAME = "User.db";


    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(90901,'Ankana Sarkar', 'ankana@gmail.com','12345890','7789432190', 16000)");
        db.execSQL("insert into " + TABLE_NAME + " values(45678,'Tridiv Patel', 'tridivp@gmail.com','12809876','6254376543', 6000)");
        db.execSQL("insert into " + TABLE_NAME + " values(78770,'Anshika Sharma', 'anshikas@gmail.com','23423567','9876768798', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(36558,'Shrestha Rath', 'shresthar@gmail.com','67568909','8905655789', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(90978,'Shubhangi Kumari', 'shubhangik@gmail.com','56453212','9976875644', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(67689,'Amisha Sahay', 'amishas@gmail.com','6789034','8988767894', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(36432,'Samar Pattanaik', 'samarp@gmail.com','16578907','9756589459', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(78530,'Ruchir Jain', 'ruchirj@gmail.com','98977682','9985456539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(45221,'Soubhik Basu', 'soubhikb@gmail.com','65820021','9098767238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(23907,'Sumit Parida', 'sumitp@gmail.com','54500989','7878976091', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(78546,'Ayush Sharma', 'ayush@gmail.com','26560096','7501914037', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(30987,'Nitish Kumar', 'nitish@gmail.com','12031234','9657668888', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(19087,'Nayan Chandra', 'nayanc@gmail.com','55669098','9098097890', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(45678,'Gaurav Paul', 'gauravp@gmail.com','22361234','7879004532', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(32324,'Yash Malik', 'yashm@gmail.com','98907687','8787654321', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}