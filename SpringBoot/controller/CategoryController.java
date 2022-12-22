package r2s.SpringBoot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.SpringBoot.dto.request.CreatedCategoryDTO;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @GetMapping
    public ResponseEntity getAllCategory(){
        CreatedCategoryDTO c1 = new CreatedCategoryDTO(1, "A");
        CreatedCategoryDTO c2 = new CreatedCategoryDTO(2, "B");
        CreatedCategoryDTO c3 = new CreatedCategoryDTO(3, "C");
        StringBuilder response = new StringBuilder("Get All Category: ");
        response.append(c1).append(c2).append(c3);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertCategory(@RequestBody CreatedCategoryDTO createdCategoryDTO){
        int categoryId = createdCategoryDTO.getCategoryId();
        String categoryName = createdCategoryDTO.getCategoryName();
        StringBuilder stringBuilder = new StringBuilder();
        String response = stringBuilder.append(categoryId).append(categoryName).toString();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
