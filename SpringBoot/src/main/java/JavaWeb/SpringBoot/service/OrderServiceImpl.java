package JavaWeb.SpringBoot.service;

import JavaWeb.SpringBoot.dto.request.CreatedOrderDTO;
import JavaWeb.SpringBoot.entity.Order;
import JavaWeb.SpringBoot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> getAllOrder() {
        Iterable<Order> orderIterable = this.orderRepository.findAll();
        return (List)orderIterable;
    }
    @Override
    public Order createdOrder(CreatedOrderDTO createdOrderDTO) {
        Order order = new Order();
        order.setTotalPrice(createdOrderDTO.getTotalPrice());
        order.setStatus(createdOrderDTO.getStatus());
        this.orderRepository.save(order);
        return order;
    }
}
