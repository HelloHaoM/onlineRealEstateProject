package onlinerealestateproject.service.imp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;

import onlinerealestateproject.datasource.OrderMapper;
import onlinerealestateproject.datasource.imp.OrderMapperImpl;
import onlinerealestateproject.dto.OrderAssembler;
import onlinerealestateproject.dto.OrderDTO;
import onlinerealestateproject.service.OrderServiceBean;

public class OrderServiceBeanImp implements OrderServiceBean{

	@Override
	public OrderDTO getOrder(int oid) throws RemoteException {
		// TODO Auto-generated method stub
		OrderMapper orderMapper = new OrderMapperImpl();
		return new OrderAssembler().writeDTO(orderMapper.find(oid));
	}

	@Override
	public void createOrder(OrderDTO dto) throws RemoteException {
		// TODO Auto-generated method stub
		new OrderAssembler().createOrder(dto);
		
	}

	@Override
	public void updateOrder(int oid, OrderDTO dto) throws RemoteException {
		// TODO Auto-generated method stub
		new OrderAssembler().updateOrder(oid, dto);
		
		
	}

	@Override
	public void deleteOrder(int oid) throws RemoteException {
		// TODO Auto-generated method stub
		new OrderAssembler().deleteOrder(oid);
		
	}

	@Override
	public byte[] gerOrderByte(int oid) throws RemoteException {
		// TODO Auto-generated method stub
		OrderMapper orderMapper = new OrderMapperImpl();
		return OrderDTO.object2Byte(new OrderAssembler().writeDTO(orderMapper.find(oid)));
	}

	@Override
	public void createOrderByByte(byte[] orderByte) throws RemoteException {
		// TODO Auto-generated method stub
		new OrderAssembler().createOrder(OrderDTO.byte2Object(orderByte));
		
	}

	@Override
	public void updateOrder(int oid, byte[] orderByte) throws RemoteException {
		// TODO Auto-generated method stub
		new OrderAssembler().updateOrder(oid, OrderDTO.byte2Object(orderByte));
	}

}
