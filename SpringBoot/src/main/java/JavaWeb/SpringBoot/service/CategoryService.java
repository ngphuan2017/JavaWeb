package JavaWeb.SpringBoot.service;

import JavaWeb.SpringBoot.dto.request.CreatedCategoryDTO;
import JavaWeb.SpringBoot.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    Category createdCategory(CreatedCategoryDTO createdCategoryDTO);
}
