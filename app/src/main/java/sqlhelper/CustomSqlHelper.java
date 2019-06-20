package sqlhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import model.CreateToast;
import model.FoodItemModel;
import model.OrderModel;
import model.UserModel;

public class CustomSqlHelper extends SQLiteOpenHelper {


    private static final String databaseName = "kot_db";
    private static final int dbVersion = 1;
    public static boolean ADMIN_FLAG = false;


    public CustomSqlHelper(Context context) {
        super(context, databaseName, null, dbVersion);
    }

    public long insertUser(UserModel um, SQLiteDatabase db) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(UserModel.UNAME, um.getUsername());
            contentValues.put(UserModel.UPASSWORD, um.getUserpassword());
            contentValues.put(UserModel.UTYPE, um.getUsertypes());
            return db.insert(UserModel.UTABLE_NAME, null, contentValues);

        } catch (Exception e) {
            CreateToast.create_Toast(null, "Something error in insert");
            return 0;
        }

    }

    public boolean checkLoginUser(String uname, String upass, String utype, SQLiteDatabase db) {
        Cursor cursor = db.rawQuery("select * from tblUser where uname =? and upassword=? and utype=?", new String[]{uname, upass, utype});
        if (cursor.getCount() > 0) {
            if (cursor.moveToNext()) {

                if(cursor.getString(2).equals("admin")){
                    ADMIN_FLAG = true;
                }else {
                    ADMIN_FLAG = false;
                }
                return true;
//                words.add(new Word(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));

            }
        }
        return false;
    }


    /////////////////////////////////////
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_USER_TABLE());//created user table
            db.execSQL(CREATE_FOOD_TABLE());//created food table
            db.execSQL(CREATE_ORDER_TABLE());//created order table

            System.out.println("all table created");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    ////Table method setting
    @org.jetbrains.annotations.Contract(pure = true)
    private String CREATE_USER_TABLE() {
        String CREATE_USER_TABLE = "CREATE TABLE " +
                UserModel.UTABLE_NAME +
                "(" +
                UserModel.UID + " Integer PRIMARY KEY AUTOINCREMENT," +
                UserModel.UNAME + " TEXT," +
                UserModel.UPASSWORD + " TEXT," +
                UserModel.UTYPE + " TEXT" +
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
    //////////////////////////

//    public boolean checkUserLOGIN(String uname, String upass, String utype, SQLiteDatabase db) {
//        Cursor cursor = db.rawQuery("select * from tblUser where uname = '" + uname + "'" +
//                "and upassword = '" + upass + "' and utype='" + utype + "'", null);
//        if (cursor.getCount() > 0) {
//            if (cursor.moveToNext()) {
//                return true;
////                words.add(new Word(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
//
//            }
//        }
//        return false;
//    }

}
