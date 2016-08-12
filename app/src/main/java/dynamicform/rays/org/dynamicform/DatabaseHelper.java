package dynamicform.rays.org.dynamicform;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by rmodi on 8/8/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    // The Android's default system path of your application database.
//    private static String DB_PATH = "";

    private static final String DB_PATH_SUFFIX = "/databases/";

    private static String DB_NAME = "IHVTest.db";

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    /**
     * Constructor Takes and keeps a reference of the passed context in order to
     * access to the application assets and resources.
     *
     * @param context
     */
    @SuppressLint("SdCardPath")
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
//        DB_PATH = "/data/data/" + myContext.getPackageName() + "/databases/";
//        Log.e("log_tag", "DB_PATH :" + DB_PATH);
    }

    /**
     * Creates a empty database on the system and rewrites it with your own
     * database.
     */
    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
            Log.i("log_tag", "Db is already ecxist");
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each
     * time you open the application.
     *
     * @return true if it exists, false if it doesn't
     */
//    private boolean checkDataBase() {
//        SQLiteDatabase checkDB = null;
//        try {
////            String myPath = DB_PATH + DB_NAME;
//            String myPath = getDatabasePath();
//            checkDB = SQLiteDatabase.openDatabase(myPath, null,
//                    SQLiteDatabase.OPEN_READWRITE);
//        } catch (SQLiteException e) {
//            // database does't exist yet.
//        }
//
//        if (checkDB != null) {
//            checkDB.close();
//        }
//        return checkDB != null ? true : false;
//    }
    private boolean checkDataBase() {
        File databasePath = myContext.getDatabasePath(DB_NAME);
        return databasePath.exists();
    }

    /**
     * Copies your database from your local assets-folder to the just created
     * empty database in the system folder, from where it can be accessed and
     * handled. This is done by transfering bytestream.
     */
    private void copyDataBase() throws IOException {

        // Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
//        String outFileName = DB_PATH + DB_NAME;

        String outFileName = getDatabasePath();

        Log.e("DBPATH", "DB Path is : " + outFileName);

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {
        // Open the database
//        String myPath = DB_PATH + DB_NAME;
        String myPath = getDatabasePath();
        myDataBase = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    private String getDatabasePath() {
        return myContext.getApplicationInfo().dataDir + DB_PATH_SUFFIX
                + DB_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i("onUpgrade", "Old Version : " + oldVersion + " & New Version : "
                + newVersion);
    }

    // Add your public helper methods to access and get content from the
    // database.
    // You could return cursors by doing "return myDataBase.query(....)" so it'd
    // be easy
    // to you to create adapters for your views.


    public long insertQuestion(String Question) {
        ContentValues initialValues = new ContentValues();
        initialValues.put("Q_Type", Question);
        return myDataBase.insert("Test", null, initialValues);
    }

    public String getQuestions() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM Test";
        Log.e("log_tag", selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        String strQuestion;
        if (c.getCount() == 0) {
            return "";
        }
        if (c != null)
            c.moveToFirst();
        do {
            strQuestion = c.getString(c.getColumnIndex("Q_Type")).trim();
        } while (c.moveToNext());
        return strQuestion;
    }
}

