package JavaWeb.SpringBoot.controller;


import JavaWeb.SpringBoot.dto.request.CreatedProductDTO;
import JavaWeb.SpringBoot.entity.Product;
import JavaWeb.SpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<?> getAllProduct(@RequestParam(value = "page", required = false) Integer page,
                                        @RequestParam(value = "size", required = false) Integer size,
                                        @RequestParam(value = "sort", required = false) String sort){
        List<Product> productList = this.productService.getAllProduct();
        return new ResponseEntity(productList, HttpStatus.OK);
    }
//    @GetMapping(value = "/{product-id}")
//    public ResponseEntity getProductById(@PathVariable(value = "product-id")int productId){
//        CreatedProductDTO p2 = new CreatedProductDTO(2, "B", 5.0, 6, 7);
//        StringBuilder response = new StringBuilder("Get User By ID: "+productId);
//        response.append(p2);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity insertProduct(@RequestBody CreatedProductDTO createdProductDTO){
        Product product = this.productService.createdProduct(createdProductDTO);
        return new ResponseEntity(product, HttpStatus.OK);
    }
//    @PutMapping(value = "/{product-id}")
//    public ResponseEntity updateProduct(@PathVariable(value = "product-id")int productId,
//                                        @RequestBody UpdateProductDTO updateProductDTO){
//        String productName = updateProductDTO.getProductName();
//        Double price = updateProductDTO.getPrice();
//        int quantity = updateProductDTO.getQuantity();
//        int categoryId = updateProductDTO.getCategoryId();
//        StringBuilder response = new StringBuilder();
//        response.append(productId).append(productName).append(price)
//                .append(quantity).append(categoryId);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//    @DeleteMapping(value = "/{product-id}")
//    public ResponseEntity deleteProduct(@PathVariable(value = "product-id")int productId){
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
}
