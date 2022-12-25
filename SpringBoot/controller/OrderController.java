package JavaWeb.SpringBoot.controller;

import JavaWeb.SpringBoot.dto.request.CreatedOrderDTO;
import JavaWeb.SpringBoot.dto.request.CreatedUserDTO;
import JavaWeb.SpringBoot.dto.request.UpdateOrderDTO;
import JavaWeb.SpringBoot.dto.request.UpdateUserDTO;
import JavaWeb.SpringBoot.dto.response.PageResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @GetMapping(value = "/get-all")
    public ResponseEntity getAllOrder(@RequestParam(value = "page", required = false) Integer page,
                                      @RequestParam(value = "size", required = false) Integer size,
                                      @RequestParam(value = "sort", required = false) String sort){
        CreatedOrderDTO order1 = new CreatedOrderDTO(1, new Date(), new Date(), "None");
        CreatedOrderDTO order2 = new CreatedOrderDTO(2, new Date(), new Date(), "Null");
        CreatedOrderDTO order3 = new CreatedOrderDTO(3, new Date(), new Date(), "Data");
        List<CreatedOrderDTO> createdOrderDTOList = new ArrayList<>();
        createdOrderDTOList.add(order1);
        createdOrderDTOList.add(order2);
        createdOrderDTOList.add(order3);
        PageResponseDTO pageResponseDTO = new PageResponseDTO();
        pageResponseDTO.setPage(page);
        pageResponseDTO.setSize(size);
        pageResponseDTO.setSort(sort);
        StringBuilder response = new StringBuilder("Get All Order: ");
        response.append(createdOrderDTOList).append(pageResponseDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping(value = "/{order-id}")
    public ResponseEntity getOrderById(@PathVariable(value = "order-id")int orderId){
        CreatedOrderDTO order1 = new CreatedOrderDTO(1, new Date(), new Date(), "None");
        StringBuilder response = new StringBuilder("Get User By ID: "+orderId);
        response.append(order1);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertOrder(@RequestBody CreatedOrderDTO createdOrderDTO){
        int orderId = createdOrderDTO.getOrderId();
        Date createdDate = createdOrderDTO.getCreatedDate();
        Date modifiedDate = createdOrderDTO.getModifiedDate();
        String orderStatus = createdOrderDTO.getOrderStatus();
        StringBuilder response = new StringBuilder();
        response.append(orderId).append(createdDate).append(modifiedDate).append(orderStatus);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PutMapping(value = "/{order-id}")
    public ResponseEntity updateOrder(@PathVariable(value = "order-id")int orderId,
                                      @RequestBody UpdateOrderDTO updateOrderDTO){
        Date createdDate = updateOrderDTO.getCreatedDate();
        Date modifiedDate = updateOrderDTO.getModifiedDate();
        String orderStatus = updateOrderDTO.getOrderStatus();
        StringBuilder response = new StringBuilder();
        response.append(orderId).append(createdDate).append(modifiedDate).append(orderStatus);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{order-id}")
    public ResponseEntity deleteOrder(@PathVariable(value = "order-id")int orderId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
