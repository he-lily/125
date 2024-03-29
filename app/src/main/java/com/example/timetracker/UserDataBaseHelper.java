package com.example.timetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.List;

//this class creates the Users db and provides CRUD functionality
public class UserDataBaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "UserInfo4.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Users";
    private static String COLUMN_ID = "_id";
    private static String COLUMN_EMAIL = "user_email";
    private static String COLUMN_NAME = "user_name";
    private static String COLUMN_JOB = "user_job";
    private static String COLUMN_AGE = "user_age";
    private static String COLUMN_OS = "system_os";
    private static String COLUMN_HABITS = "screen_time_habits";
    private static String COLUMN_RECOMMENDED = "has_been_recommended";
    private static String COLUMN_PREFERRED_CAT = "preferred_categories";
    private static String COLUMN_DISLIKED_APPS = "disliked_apps";

    public UserDataBaseHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String query =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_EMAIL  + " TEXT, " +
                        COLUMN_NAME   + " TEXT, " +
                        COLUMN_JOB    + " TEXT, " +
                        COLUMN_AGE    + " INTEGER, " +
                        COLUMN_OS     + " TEXT, " +
                        COLUMN_HABITS + " TEXT, " +
                      COLUMN_RECOMMENDED + " TEXT, " +
                        COLUMN_PREFERRED_CAT + " TEXT, " +
                        COLUMN_DISLIKED_APPS + " TEXT);";


        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void addUser(String user_email, String user_name, String user_job, int user_age, String app_usage, String has_been_recommended, String preferred_categories, String disliked_apps){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL,user_email);
        cv.put(COLUMN_NAME,user_name);
        cv.put(COLUMN_JOB,user_job);
        cv.put(COLUMN_AGE,user_age);
        cv.put(COLUMN_OS,System.getProperty("os.name"));
        cv.put(COLUMN_HABITS, app_usage);
        cv.put( COLUMN_RECOMMENDED,has_been_recommended);
        cv.put(COLUMN_PREFERRED_CAT,preferred_categories);
        cv.put(COLUMN_DISLIKED_APPS,disliked_apps);


        long result = db.insert(TABLE_NAME,null,cv);
        if(result == -1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }
    }





}