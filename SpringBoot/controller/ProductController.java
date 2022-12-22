package r2s.SpringBoot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.SpringBoot.dto.request.CreatedProductDTO;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @GetMapping
    public ResponseEntity getAllProduct(){
        CreatedProductDTO p1 = new CreatedProductDTO(1, "A", 2.0, 3, 4);
        CreatedProductDTO p2 = new CreatedProductDTO(2, "B", 5.0, 6, 7);
        CreatedProductDTO p3 = new CreatedProductDTO(3, "C", 8.0, 9, 10);
        StringBuilder response = new StringBuilder("Get All Product: ");
        response.append(p1).append(p2).append(p3);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertProduct(@RequestBody CreatedProductDTO createdProductDTO){
        int productId = createdProductDTO.getProductId();
        String productName = createdProductDTO.getProductName();
        Double price = createdProductDTO.getPrice();
        int quantity = createdProductDTO.getQuantity();
        int categoryId = createdProductDTO.getCategoryId();
        StringBuilder stringBuilder = new StringBuilder();
        String response = stringBuilder.append(productId).append(productName).append(price)
                .append(quantity).append(categoryId).toString();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
