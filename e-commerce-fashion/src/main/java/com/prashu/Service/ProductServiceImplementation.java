package com.prashu.Service;

import com.prashu.Repository.CategoryRepo;
import com.prashu.Repository.ProductRepo;
import com.prashu.exceptions.ProductException;
import com.prashu.model.Category;
import com.prashu.model.Product;
import com.prashu.requests.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation implements ProductService {


    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserService userService;

    //private UserService userService = new UserService();

    @Autowired
    private CategoryRepo categoryRepo;

    public ProductServiceImplementation(ProductRepo productRepo, UserService userService, CategoryRepo categoryRepo){
        this.productRepo = productRepo;
        this.userService = userService;
        this.categoryRepo = categoryRepo;

    }

    @Override
    public Product createProduct(CreateProductRequest req) {

        Category topLevel = categoryRepo.findByName(req.getTopLavelCategory());
        if (topLevel == null) {
            Category topLevelCategory = new Category();
            topLevelCategory.setName(req.getTopLavelCategory());
            topLevelCategory.setLevel(1);

            topLevel = categoryRepo.save(topLevelCategory);
        }

        Category secondLevel = categoryRepo.findByNameAndParent(req.getTopLavelCategory(), topLevel.getName());
        if (secondLevel == null) {
            Category secondLevelCategory = new Category();
            secondLevelCategory.setName(req.getSecondLavelCategory());
            secondLevelCategory.setParentCategory(topLevel);
            secondLevelCategory.setLevel(2);

            secondLevel = categoryRepo.save(secondLevelCategory);
        }

        Category thirdLevel = categoryRepo.findByNameAndParent(req.getThirdLavelCategory(), secondLevel.getName());
        if (thirdLevel == null) {
            Category thirdLevelCategory = new Category();
            thirdLevelCategory.setName(req.getThirdLavelCategory());
            thirdLevelCategory.setParentCategory(secondLevel);
            thirdLevelCategory.setLevel(3);

            thirdLevel = categoryRepo.save(thirdLevelCategory);
        }

        Product product = new Product();
        product.setTitle(req.getTitle());
        product.setColor(req.getColor());
        product.setDescription(req.getDescription());
        product.setDiscountedPrice(req.getDiscountedPrice());
        product.setDiscountPresent(req.getDiscountPercent());
        product.setImageUrl(req.getImageUrl());
        product.setBrand(req.getBrand());
        product.setPrice(req.getPrice());
        product.setSizes(req.getSize());
        product.setQuantity(req.getQuantity());
        product.setCategoryId(thirdLevel);
        product.setCreatedAt(LocalDateTime.now());

        return productRepo.save(product);
    }

    @Override
    public String deleteProduct(Long productId) throws ProductException {
        Product product = findProductById(productId);
        product.getSizes().clear();
        productRepo.delete(product);

        return "Product deleted Successfully";
    }

    @Override
    public Product updateProduct(Long productId, Product req) throws ProductException {
        Product product = findProductById(productId);
        if (req.getQuantity() != 0) {
            product.setQuantity(req.getQuantity());
        }
        return productRepo.save(product);
    }

    @Override
    public Product findProductById(Long id) {
        Optional<Product> opt = productRepo.findById(id);

        if (opt.isPresent()) {
            return opt.get();
        }
        try {
            throw new ProductException("No product found with id :" + id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findProductByCategory(String category) {
        return List.of();
    }

    @Override
    public Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes, Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        List<Product> products = productRepo.filterProducts(category, minPrice, maxPrice, minDiscount, sort);

        System.out.println("Products : " + products.size());
        if (!colors.isEmpty()) {
            products = products.stream().filter(
                    p -> colors.stream().anyMatch(c -> c.equalsIgnoreCase(p.getColor()))
            ).collect(Collectors.toList());

        }

        if (stock != null) {
            if (stock.equals("in_stock")) {
                products = products.stream().filter(p -> p.getQuantity() > 0).collect(Collectors.toList());
            } else if (stock.equals("out_of_stock")) {
                products = products.stream().filter(p -> p.getQuantity() < 1).collect(Collectors.toList());
            }
        }

        int startIndex = (int) pageable.getOffset();
        int endIndex = Math.min(startIndex + pageable.getPageSize(), products.size());

        List<Product> pageContent = products.subList(startIndex, endIndex);

        Page<Product> filteredProducts = new PageImpl<>(pageContent, pageable, products.size());

        return filteredProducts;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }
}

