package JavaWeb.SpringBoot.controller;


import JavaWeb.SpringBoot.dto.request.CreatedProductDTO;
import JavaWeb.SpringBoot.dto.request.CreatedUserDTO;
import JavaWeb.SpringBoot.dto.request.UpdateProductDTO;
import JavaWeb.SpringBoot.dto.request.UpdateUserDTO;
import JavaWeb.SpringBoot.dto.response.PageResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @GetMapping(value = "/get-all")
    public ResponseEntity getAllProduct(@RequestParam(value = "page", required = false) Integer page,
                                        @RequestParam(value = "size", required = false) Integer size,
                                        @RequestParam(value = "sort", required = false) String sort){
        CreatedProductDTO p1 = new CreatedProductDTO(1, "A", 2.0, 3, 4);
        CreatedProductDTO p2 = new CreatedProductDTO(2, "B", 5.0, 6, 7);
        CreatedProductDTO p3 = new CreatedProductDTO(3, "C", 8.0, 9, 10);
        List<CreatedProductDTO> createdProductDTOList = new ArrayList<>();
        createdProductDTOList.add(p1);
        createdProductDTOList.add(p2);
        createdProductDTOList.add(p3);
        PageResponseDTO pageResponseDTO = new PageResponseDTO();
        pageResponseDTO.setPage(page);
        pageResponseDTO.setSize(size);
        pageResponseDTO.setSort(sort);
        StringBuilder response = new StringBuilder("Get All Product: ");
        response.append(createdProductDTOList).append(pageResponseDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping(value = "/{product-id}")
    public ResponseEntity getProductById(@PathVariable(value = "product-id")int productId){
        CreatedProductDTO p2 = new CreatedProductDTO(2, "B", 5.0, 6, 7);
        StringBuilder response = new StringBuilder("Get User By ID: "+productId);
        response.append(p2);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertProduct(@RequestBody CreatedProductDTO createdProductDTO){
        int productId = createdProductDTO.getProductId();
        String productName = createdProductDTO.getProductName();
        Double price = createdProductDTO.getPrice();
        int quantity = createdProductDTO.getQuantity();
        int categoryId = createdProductDTO.getCategoryId();
        StringBuilder response = new StringBuilder();
        response.append(productId).append(productName).append(price)
                .append(quantity).append(categoryId);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PutMapping(value = "/{product-id}")
    public ResponseEntity updateProduct(@PathVariable(value = "product-id")int productId,
                                        @RequestBody UpdateProductDTO updateProductDTO){
        String productName = updateProductDTO.getProductName();
        Double price = updateProductDTO.getPrice();
        int quantity = updateProductDTO.getQuantity();
        int categoryId = updateProductDTO.getCategoryId();
        StringBuilder response = new StringBuilder();
        response.append(productId).append(productName).append(price)
                .append(quantity).append(categoryId);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{product-id}")
    public ResponseEntity deleteProduct(@PathVariable(value = "product-id")int productId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
