package JavaWeb.SpringBoot.controller;


import JavaWeb.SpringBoot.dto.request.CreatedCategoryDTO;
import JavaWeb.SpringBoot.dto.request.CreatedUserDTO;
import JavaWeb.SpringBoot.dto.request.UpdateCategoryDTO;
import JavaWeb.SpringBoot.dto.request.UpdateUserDTO;
import JavaWeb.SpringBoot.dto.response.PageResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @GetMapping(value = "/get-all")
    public ResponseEntity getAllCategory(@RequestParam(value = "page", required = false) Integer page,
                                         @RequestParam(value = "size", required = false) Integer size,
                                         @RequestParam(value = "sort", required = false) String sort){
        CreatedCategoryDTO c1 = new CreatedCategoryDTO(1, "A");
        CreatedCategoryDTO c2 = new CreatedCategoryDTO(2, "B");
        CreatedCategoryDTO c3 = new CreatedCategoryDTO(3, "C");
        List<CreatedCategoryDTO> createdCategoryDTOS = new ArrayList<>();
        createdCategoryDTOS.add(c1);
        createdCategoryDTOS.add(c2);
        createdCategoryDTOS.add(c3);
        PageResponseDTO pageResponseDTO = new PageResponseDTO();
        pageResponseDTO.setPage(page);
        pageResponseDTO.setSize(size);
        pageResponseDTO.setSort(sort);
        StringBuilder response = new StringBuilder("Get All Category: ");
        response.append(createdCategoryDTOS).append(pageResponseDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping(value = "/{category-id}")
    public ResponseEntity getCategoryById(@PathVariable(value = "category-id")int categoryId){
        CreatedCategoryDTO c3 = new CreatedCategoryDTO(3, "C");
        StringBuilder response = new StringBuilder("Get User By ID: "+categoryId);
        response.append(c3);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertCategory(@RequestBody CreatedCategoryDTO createdCategoryDTO){
        int categoryId = createdCategoryDTO.getCategoryId();
        String categoryName = createdCategoryDTO.getCategoryName();
        StringBuilder response = new StringBuilder();
        response.append(categoryId).append(categoryName);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PutMapping(value = "/{category-id}")
    public ResponseEntity updateCategory(@PathVariable(value = "category-id")int categoryId,
                                         @RequestBody UpdateCategoryDTO updateCategoryDTO){
        String categoryName = updateCategoryDTO.getCategoryName();
        StringBuilder response = new StringBuilder();
        response.append(categoryId).append(categoryName);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{category-id}")
    public ResponseEntity deleteCategory(@PathVariable(value = "category-id")int categoryId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
