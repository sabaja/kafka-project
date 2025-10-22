package it.js.commons.dto;

import java.util.List;

public class NewOrder {

    private String customer;
    private List<Integer> orderIds;

    public NewOrder() {
    }

    public NewOrder(String customer, List<Integer> orderIds) {
        this.customer = customer;
        this.orderIds = orderIds;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Integer> orderIds) {
        this.orderIds = orderIds;
    }

    @Override
    public String toString() {
        return "{" +
                "\"customer:\"" + customer + "\" " +
                ", \"orderIds\": " + orderIds +
                "}";
    }
}
