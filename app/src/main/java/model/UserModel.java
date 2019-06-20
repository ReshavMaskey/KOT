package model;

import android.content.Context;
import android.widget.ArrayAdapter;

public class UserModel {
    private int userID;
    private String username;
    private String userpassword;
    private String usertype;


    //Table information
    public static String UTABLE_NAME = "tblUser";
    public static final String UID = "uid";
    public static final String UNAME = "uname";
    public static final String UPASSWORD = "upassword";
    public static final String UTYPE = "utype";
    ///////////////////////

    public static final String[] USER_TYPE_DATA = {"--Select User Type--","admin", "staff"};



    public static ArrayAdapter SET_USERTYPE_ARRAYADAPTER(Context context){
        ArrayAdapter adapter= new ArrayAdapter<>(context,android.R.layout.simple_list_item_1,UserModel.USER_TYPE_DATA);
        return adapter;

    }

    public UserModel() {
    }

    public UserModel(int userID, String username, String userpassword, String usertype) {
        this.userID = userID;
        this.username = username;
        this.userpassword = userpassword;
        this.usertype = usertype;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public String getUsertypes() {
        return usertype;
    }

    public static String getTableNames() {
        return UTABLE_NAME;
    }


}
