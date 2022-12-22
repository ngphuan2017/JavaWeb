package r2s.SpringBoot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.SpringBoot.dto.request.CreatedOrderDTO;

import java.util.Date;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @GetMapping
    public ResponseEntity getAllOrder(){
        CreatedOrderDTO order1 = new CreatedOrderDTO(1, new Date(), new Date(), "None");
        CreatedOrderDTO order2 = new CreatedOrderDTO(2, new Date(), new Date(), "Null");
        CreatedOrderDTO order3 = new CreatedOrderDTO(3, new Date(), new Date(), "Data");
        StringBuilder response = new StringBuilder("Get All Order: ");
        response.append(order1).append(order2).append(order3);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertOrder(@RequestBody CreatedOrderDTO createdOrderDTO){
        int orderId = createdOrderDTO.getOrderId();
        Date createdDate = createdOrderDTO.getCreatedDate();
        Date modifiedDate = createdOrderDTO.getModifiedDate();
        String orderStatus = createdOrderDTO.getOrderStatus();
        StringBuilder stringBuilder = new StringBuilder();
        String response = stringBuilder.append(orderId).append(createdDate).append(modifiedDate).append(orderStatus).toString();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
