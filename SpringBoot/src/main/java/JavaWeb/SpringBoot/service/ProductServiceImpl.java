package JavaWeb.SpringBoot.service;

import JavaWeb.SpringBoot.dto.request.CreatedProductDTO;
import JavaWeb.SpringBoot.entity.Product;
import JavaWeb.SpringBoot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        Iterable<Product> productIterable = this.productRepository.findAll();
        return (List)productIterable;
    }
    @Override
    public Product createdProduct(CreatedProductDTO createdProductDTO) {
        Product product = new Product();
        product.setProductname(createdProductDTO.getProductname());
        product.setPrice(createdProductDTO.getPrice());
        product.setQuantity(createdProductDTO.getQuantity());
        product.setProductImg(createdProductDTO.getProductImg());
        product.setDiscontinued(createdProductDTO.getDiscontinued());
        product.setUnitSale(createdProductDTO.getUnitSale());
        this.productRepository.save(product);
        return product;
    }
}
