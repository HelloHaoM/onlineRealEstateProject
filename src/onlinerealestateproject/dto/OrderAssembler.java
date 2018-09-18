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
	
	public static void updateOrder(String oid, OrderDTO dto) {
		OrderMapper orderMapper = new OrderMapperImpl();
		Order order = orderMapper.find(Integer.parseInt(oid));
		if(order == null)
			throw new RuntimeException("Order does not exit");
		order.setInspStartTime(dto.getInspStartTime());
		order.setInspEndTime(dto.getInspEndTime());
	}

}
