package model;

public class FoodItemModel {

    private int foodId;
    private String foodName;
    private String foodSubName;
    private int foodPrice;

    //Table information
    public static String FTABLE_NAME = "tblFood";
    public static final String FID = "fid";
    public static final String FNAME = "foodName";
    public static final String FSUBNAME = "foodSubName";
    public static final String FPRICE = "foodPrice";

    public FoodItemModel(int foodId, String foodName, String foodSubName, int foodPrice) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodSubName = foodSubName;
        this.foodPrice = foodPrice;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodSubName() {
        return foodSubName;
    }

    public void setFoodSubName(String foodSubName) {
        this.foodSubName = foodSubName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }
}
