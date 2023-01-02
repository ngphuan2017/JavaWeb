package JavaWeb.SpringBoot.controller;

import JavaWeb.SpringBoot.dto.request.CreatedOrderDTO;
import JavaWeb.SpringBoot.entity.Order;
import JavaWeb.SpringBoot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<?> getAllOrder(@RequestParam(value = "page", required = false) Integer page,
                                      @RequestParam(value = "size", required = false) Integer size,
                                      @RequestParam(value = "sort", required = false) String sort){
        List<Order> orderList = this.orderService.getAllOrder();
        return new ResponseEntity(orderList, HttpStatus.OK);
    }
//    @GetMapping(value = "/{order-id}")
//    public ResponseEntity getOrderById(@PathVariable(value = "order-id")int orderId){
//        CreatedOrderDTO order1 = new CreatedOrderDTO(1, new Date(), new Date(), "None");
//        StringBuilder response = new StringBuilder("Get User By ID: "+orderId);
//        response.append(order1);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity insertOrder(@RequestBody CreatedOrderDTO createdOrderDTO){
        Order order = this.orderService.createdOrder(createdOrderDTO);
        return new ResponseEntity(order, HttpStatus.OK);
    }
//    @PutMapping(value = "/{order-id}")
//    public ResponseEntity updateOrder(@PathVariable(value = "order-id")int orderId,
//                                      @RequestBody UpdateOrderDTO updateOrderDTO){
//        Date createdDate = updateOrderDTO.getCreatedDate();
//        Date modifiedDate = updateOrderDTO.getModifiedDate();
//        String orderStatus = updateOrderDTO.getOrderStatus();
//        StringBuilder response = new StringBuilder();
//        response.append(orderId).append(createdDate).append(modifiedDate).append(orderStatus);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//    @DeleteMapping(value = "/{order-id}")
//    public ResponseEntity deleteOrder(@PathVariable(value = "order-id")int orderId){
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
}
