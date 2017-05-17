package com.example.hp.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//package com.androidtutorialshub.loginregister.model;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "Users";
    SQLiteDatabase db;

    // User Table Columns names

    private static final String COLUMN_USER_NAME = "username";
    private static final String COLUMN_USER_EMAIL = "useremail";
    private static final String COLUMN_USER_PASSWORD = "userpassword";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_CONTACT_NO = "contactno";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_BLODD_GROUP = "bloodgroup";
    private static final String COLUMN_ALLERGIC_TO = "allergicto";
    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_AGE + "TEXT,"
            + COLUMN_GENDER + "TEXT," + COLUMN_CONTACT_NO + "TEXT," + COLUMN_HEIGHT + "TEXT,"
            + COLUMN_WEIGHT + "TEXT," + COLUMN_BLODD_GROUP + "TEXT," + COLUMN_ALLERGIC_TO + "TEXT" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);           //this.on...

    }

    /**
     * This method is to create user record
     */
    public void insertContact(Contact c) {
        db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        Log.e("track","inside insertcontact");
        values.put(COLUMN_USER_NAME, c.getName());
        values.put(COLUMN_USER_EMAIL, c.getEmail());
        values.put(COLUMN_USER_PASSWORD, c.getPassword());
        values.put(COLUMN_AGE, c.getAge());
        values.put(COLUMN_GENDER, c.getGender());
        values.put(COLUMN_CONTACT_NO, c.getContact_no());
        values.put(COLUMN_HEIGHT, c.getHeight());
        values.put(COLUMN_WEIGHT, c.getWeight());
        values.put(COLUMN_BLODD_GROUP, c.getBlood_group());
        values.put(COLUMN_ALLERGIC_TO, c.getAllergic_to());
        // Inserting Row
        db.insert(TABLE_USER, null, values);
            Log.e("track","after inserting data");
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    //Ye jab login per jo pass daalenge uski checking ke liye
    public String searchPass(String uname)

    {
        Log.e("track","inside method");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_USER,null);
        Log.e("track","after querry");
        String a, b;
        b = "Not Found";

        if (cursor.moveToFirst()) {

            do {
                Log.e("track","here");
                a = cursor.getString(0);//user_name
                Log.e("track","after user name");
                if (a.equalsIgnoreCase(uname)) {
                    b = cursor.getString(2);//password
                    Log.e("track","after password");
                    break;
                }

            } while (cursor.moveToNext());
        }
        return b;
    }
}