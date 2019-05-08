package model;

public class UserModel {
    private int userID;
    private String username;
    private String userpassword;
    private String usertype;

    public static String tableName = "tblUser";

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
        return tableName;
    }
}
