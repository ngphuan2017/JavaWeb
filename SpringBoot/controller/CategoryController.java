package JavaWeb.SpringBoot.controller;


import JavaWeb.SpringBoot.dto.request.CreatedCategoryDTO;
import JavaWeb.SpringBoot.entity.Category;
import JavaWeb.SpringBoot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<?> getAllCategory(@RequestParam(value = "page", required = false) Integer page,
                                         @RequestParam(value = "size", required = false) Integer size,
                                         @RequestParam(value = "sort", required = false) String sort){
        List<Category> categoryList = this.categoryService.getAllCategory();
        return new ResponseEntity(categoryList, HttpStatus.OK);
    }
//    @GetMapping(value = "/{category-id}")
//    public ResponseEntity getCategoryById(@PathVariable(value = "category-id")int categoryId){
//        CreatedCategoryDTO c3 = new CreatedCategoryDTO(3, "C");
//        StringBuilder response = new StringBuilder("Get User By ID: "+categoryId);
//        response.append(c3);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity insertCategory(@RequestBody CreatedCategoryDTO createdCategoryDTO){
        Category category = this.categoryService.createdCategory(createdCategoryDTO);
        return new ResponseEntity(category, HttpStatus.OK);
    }
//    @PutMapping(value = "/{category-id}")
//    public ResponseEntity updateCategory(@PathVariable(value = "category-id")int categoryId,
//                                         @RequestBody UpdateCategoryDTO updateCategoryDTO){
//        String categoryName = updateCategoryDTO.getCategoryName();
//        StringBuilder response = new StringBuilder();
//        response.append(categoryId).append(categoryName);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//    @DeleteMapping(value = "/{category-id}")
//    public ResponseEntity deleteCategory(@PathVariable(value = "category-id")int categoryId){
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
}
