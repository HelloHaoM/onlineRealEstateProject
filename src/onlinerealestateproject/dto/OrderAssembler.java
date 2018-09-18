package onlinerealestateproject.dto;

import onlinerealestateproject.datasource.OrderMapper;
import onlinerealestateproject.datasource.imp.OrderMapperImpl;
import onlinerealestateproject.domain.Order;

/**
 * @author haomai
 * An order assembler object
 */

public class OrderAssembler {
	
	public static OrderDTO writeDTO(Order order) {
		OrderDTO result = new OrderDTO(order.getUid(), 
				order.getOid(), order.getApid(),
				order.getInspStartTime(), order.getInspEndTime());
		return result;
	}
	
	public static void updateOrder(int oid, OrderDTO dto) {
		OrderMapper orderMapper = new OrderMapperImpl();
		Order order = orderMapper.find(oid);
		if(order == null)
			throw new RuntimeException("Order does not exit");
		order.setInspStartTime(dto.getInspStartTime());
		order.setInspEndTime(dto.getInspEndTime());
		
		orderMapper.updateOrderInspectionTime(oid, order.getInspStartTime());
	}
	
	public static void createOrder(OrderDTO dto) {
		Order order = new Order(dto.getOid(), 
				dto.getInspStartTime(), dto.getInspEndTime(),
				dto.getUid(), dto.getApid());
		OrderMapper orderMapper = new OrderMapperImpl();
		orderMapper.insert(order);
	}
	
	public static void deleteOrder(int oid) {
		OrderMapper orderMapper = new OrderMapperImpl();
		orderMapper.delete(oid);
	}

}
