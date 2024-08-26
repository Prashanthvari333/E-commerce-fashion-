package com.prashu.Service;

import com.prashu.exceptions.ProductException;
import com.prashu.model.Product;
import com.prashu.requests.CreateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {


    public Product createProduct(CreateProductRequest req);

    public String deleteProduct(Long productId) throws ProductException;

    public Product updateProduct (Long productId,Product product) throws ProductException;

    public Product findProductById(Long id) throws  ProductException;

    public List<Product> findProductByCategory(String category);

    public Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes, Integer minPrice , Integer maxPrice
    , Integer minDiscount , String sort, String stock , Integer pageNumber, Integer pageSize);

    public  List<Product> findAllProducts();
}
