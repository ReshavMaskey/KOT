package sqlhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import model.FoodItemModel;
import model.OrderModel;
import model.UserModel;

public class SqlHelper extends SQLiteOpenHelper {


    private static final String databaseName = "kot_db";
    private static final int dbVersion = 1;

    public SqlHelper(Context context) {
        super(context, databaseName, null, dbVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_USER_TABLE());//created user table
        db.execSQL(CREATE_FOOD_TABLE());//created food table
        db.execSQL(CREATE_ORDER_TABLE());//created order table

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    @org.jetbrains.annotations.Contract(pure = true)
    private String CREATE_USER_TABLE() {
        String CREATE_USER_TABLE = "CREATE TABLE " +
                UserModel.UTABLE_NAME +
                "(" +
                UserModel.UID + " Integer PRIMARY KEY AUTOINCREMENT," +
                UserModel.UNAME + "TEXT," +
                UserModel.UPASSWORD + "TEXT," +
                UserModel.UTYPE + "TEXT" +
                ")";
        return CREATE_USER_TABLE;
    }

    private String CREATE_FOOD_TABLE() {
        String CREATE_USER_TABLE = "CREATE TABLE " +
                FoodItemModel.FTABLE_NAME +
                "(" +
                FoodItemModel.FID + " Integer PRIMARY KEY AUTOINCREMENT," +
                FoodItemModel.FNAME + "TEXT," +
                FoodItemModel.FSUBNAME + "TEXT," +
                FoodItemModel.FPRICE + "INTEGER" +
                ")";
        return CREATE_USER_TABLE;
    }

    private String CREATE_ORDER_TABLE() {
        String CREATE_USER_TABLE = "CREATE TABLE " +
                OrderModel.OTABLE_NAME +
                "(" +
                OrderModel.OID + " Integer PRIMARY KEY AUTOINCREMENT," +
                OrderModel.ONAME + "TEXT," +
                OrderModel.OQUANTITY + "INTEGER," +
                OrderModel.OTOTAL + "INTEGER" +
                ")";
        return CREATE_USER_TABLE;
    }
}
