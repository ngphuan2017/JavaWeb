package JavaWeb.SpringBoot.service;

import JavaWeb.SpringBoot.dto.request.CreatedCategoryDTO;
import JavaWeb.SpringBoot.entity.Category;
import JavaWeb.SpringBoot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        Iterable<Category> categoryIterable = this.categoryRepository.findAll();
        return (List)categoryIterable;
    }
    @Override
    public Category createdCategory(CreatedCategoryDTO createdCategoryDTO) {
        Category category = new Category();
        category.setCategoryName(createdCategoryDTO.getCategoryName());
        category.setCategoryImg(createdCategoryDTO.getCategoryImg());
        this.categoryRepository.save(category);
        return category;
    }
}
