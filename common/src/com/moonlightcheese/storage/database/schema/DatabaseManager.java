package com.moonlightcheese.storage.database.schema;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.moonlightcheese.fruit.MainActivity;
import com.moonlightcheese.storage.database.schema.tables.CallTable;

/**
 * Created with IntelliJ IDEA.
 * User: jarrod
 * Date: 6/8/14
 * Time: 2:53 AM
 *
 * this is the meat of the database handling.
 */
public class DatabaseManager {
    //SINGLETON INSTANCE
    private static DatabaseManager m_Instance;

    //the SQLiteOpenHelper subclass built for this database
//    private static DatabaseHelper m_DatabaseHelper     = new DatabaseHelper();

    //the database object.  we only need one of these in the application, and it is contained in this singleton.
//    private final static SQLiteDatabase m_Database      = m_DatabaseHelper.getWritableDatabase();

    //database version let's Android know if it should update the database between versions.
    //in other words, if the database version increases, Android updates however you tell it to via a callback ().
    public static final int DATABASE_VERSION    = 1;

    //name of the database
    public static final String DATABASE_NAME    = "fruit_mobile_db";

    //the application Context
    private Context m_Context;

    //we need to call 'start' before doing anything with this singleton.  this boolean indicates whether start has been called yet or not.
    private static boolean m_isStarted = false;

    //
//    private static final CallTable  m_CallTable = new CallTable();


    private DatabaseManager() {
        //
    }

    //get the database manager instance
    public static DatabaseManager getInstance() {
        if(!m_isStarted)
            throw new IllegalStateException("you must call start before you can access the database manager.");
        if(m_Instance == null) {
            m_Instance = new DatabaseManager();
        }
        return m_Instance;
    }

    /**
     * this start method must be called before any other interaction with this singleton class.  this basically
     * sets the Context, so we can access the database.
     * @return
     */
    public static DatabaseManager start(Context context) {
        m_isStarted = true;
        getInstance().m_Context = context;
        return getInstance();
    }

    //the implementation of the database helper class provided by Android.
    public static class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            //the super expects: the application context, a database name, a CursorFactory (can be null), and the database version.
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase database) {
            //database.execSQL(database, );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
