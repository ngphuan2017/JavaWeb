package JavaWeb.SpringBoot.service;

import JavaWeb.SpringBoot.dto.request.CreatedProductDTO;
import JavaWeb.SpringBoot.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    Product createdProduct(CreatedProductDTO createdProductDTO);
}
