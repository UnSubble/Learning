package ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import ws.exception.OrderWSException;
import ws.model.Order;

@WebService
@SOAPBinding(style = Style.RPC)
public interface OrderWS {

	@WebMethod
	public Order getOrder(@WebParam(name = "id") String id) throws OrderWSException;

	@WebMethod
	public Order[] getOrders() throws OrderWSException;

}
