package com.example.caisse.Services;


import com.example.caisse.Models.ProductModel;

import java.util.List;
import java.util.Map;

public interface ProductServiceInterface {
    public List<ProductModel> findAllProducts();
    public ProductModel AddProduct( ProductModel productModel);
    public ProductModel findProductById( Long id);
    public ProductModel updateProduct(Long id,  ProductModel productDetails);
    public Map<String,Boolean> deleteProduct(Long id);
}
