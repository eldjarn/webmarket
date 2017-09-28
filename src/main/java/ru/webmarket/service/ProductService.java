package ru.webmarket.service;

import ru.webmarket.entity.dto.CategoryDTO;
import ru.webmarket.entity.dto.ProductDTO;

import java.util.List;

/**
 * @author Сергей
 */
public interface ProductService {

    void addProduct(ProductDTO productDTO);

    ProductDTO getProduct(Long id);

    void editProduct(ProductDTO categoryDTO);

    void deleteProduct(Long id);

    List<ProductDTO> getAllProduct();

    List<CategoryDTO> getAllCategory(ProductDTO productDTO);

    ProductDTO findByName(String name);
}
