package com.example.SerhalAndSerhal.Product;

import com.example.SerhalAndSerhal.Product.dto.ProductRequest;
import com.example.SerhalAndSerhal.Product.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    public ProductResponse createProduct(ProductRequest productRequest);

    public ProductResponse updateProductById(ProductRequest productRequest, Long id);

    public void deleteProduct(Long id);

    public ProductResponse getProductById(Long id);

    public ProductResponse getProductByName(String name);

    public List<ProductResponse> getAllProducts();

}
