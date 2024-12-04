package ws.inmemory;

import java.util.List;

import ws.model.Order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MemoryData {

	public static List<Order> orders = new ArrayList<>();

	static {
		Calendar calendar = Calendar.getInstance();

		calendar.set(2017, 11, 21, 20, 30, 40);
		Date date1 = calendar.getTime();

		calendar.set(2017, 11, 20, 21, 35, 45);
		Date date2 = calendar.getTime();

		calendar.set(2017, 11, 15, 23, 20, 50);
		Date date3 = calendar.getTime();

		Order order1 = new Order("Order-100", date1, 150.25);
		Order order2 = new Order("Order-200", date2, 250);
		Order order3 = new Order("Order-300", date3, 180.55);

		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
	}

	public static Order getOrder(String id) {
		return orders.stream().filter(p -> id.equals(p.getOrderId())).findFirst().get();
	}

	public static Order[] getOrdersArrays() {
		return orders.toArray(new Order[orders.size()]);
	}

}
