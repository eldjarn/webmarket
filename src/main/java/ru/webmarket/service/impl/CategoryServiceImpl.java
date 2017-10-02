package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.entity.Category;
import ru.webmarket.entity.converter.CategoryConvecter;
import ru.webmarket.entity.dto.CategoryDTO;
import ru.webmarket.repository.CategoryRepository;
import ru.webmarket.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        Category category = CategoryConvecter.dtoToEntity(categoryDTO);
        if (category != null) categoryRepository.save(category);
    }

    @Override
    public CategoryDTO getCategory(Long id) {
        return CategoryConvecter.entityToDto(categoryRepository.findOne(id));
    }

    @Override
    public void editCategory(CategoryDTO toEditCategoryDTO) {
        categoryRepository.save(CategoryConvecter.dtoToEntity(toEditCategoryDTO));
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findOne(id);
        if (category != null) categoryRepository.delete(id);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return CategoryConvecter.entityToDto(categoryRepository.findAll());
    }

    @Override
    public CategoryDTO findByName(String name) {
        return CategoryConvecter.entityToDto(categoryRepository.findByName(name));
    }
}
