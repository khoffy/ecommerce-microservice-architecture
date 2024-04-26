package koffitipoh.me.clientui.beans;


public class ShippingBean {
    private long id;
    private String orderId;
    private String status;

    public ShippingBean() {}

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
