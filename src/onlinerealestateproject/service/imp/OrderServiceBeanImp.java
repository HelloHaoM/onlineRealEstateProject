package onlinerealestateproject.service.imp;

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

}
