package JavaWeb.SpringBoot.service;

import JavaWeb.SpringBoot.dto.request.CreatedOrderDTO;
import JavaWeb.SpringBoot.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder();

    Order createdOrder(CreatedOrderDTO createdOrderDTO);
}
