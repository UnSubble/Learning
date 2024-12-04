package ws.model;

import java.util.Date;

public class Order {

	private String orderId;
	private Date orderDate;
	private double amount;

	public Order() {
		super();
	}

	public Order(String orderId, Date orderDate, double amount) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.amount = amount;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", amount=" + amount + "]";
	}

	
}
