package onlinerealestateproject.service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import onlinerealestateproject.dto.OrderDTO;

/**
 * @author haomai
 * A remote order service interface 
 */

public interface OrderServiceBean {
	public OrderDTO getOrder(int oid) throws RemoteException;
	public byte[] gerOrderByte(int oid) throws RemoteException;
	public ArrayList<byte[]> getOrderByteList(int uid) throws RemoteException;
	public void createOrder(OrderDTO dto) throws RemoteException;
	public void createOrderByByte(byte[] orderByte) throws RemoteException;
	public void updateOrder(int oid, OrderDTO dto) throws RemoteException;
	public void updateOrder(int oid, byte[] orderByte) throws RemoteException;
	public void deleteOrder(int oid) throws RemoteException;
}
