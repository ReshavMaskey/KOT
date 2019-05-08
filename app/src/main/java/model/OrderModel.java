package model;

public class OrderModel {

    private int orderId;
    private String orderName;
    private int quantity;
    private int total;

    //Table information
    public static String OTABLE_NAME = "tblOrder";
    public static final String OID = "oid";
    public static final String ONAME = "orderName";
    public static final String OQUANTITY = "quantity";
    public static final String OTOTAL = "total";

    public OrderModel(int orderId, String orderName, int quantity, int total) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.quantity = quantity;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
