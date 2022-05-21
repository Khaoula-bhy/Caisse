package com.example.caisse.Services;


import com.example.caisse.Exceptions.ResourcesNotfoundException;
import com.example.caisse.Models.ProductModel;
import com.example.caisse.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl  implements ProductServiceInterface {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }




    @Override
    public List<ProductModel> findAllProducts() {
        return productRepository.findAll();

    }

    @Override
    public ProductModel AddProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    @Override
    public ProductModel findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new ResourcesNotfoundException("Product doesn't exist with id:"+ id));

    }

    @Override
    public ProductModel updateProduct(Long id, ProductModel productDetails) {
        ProductModel product=findProductById(id);
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());

        return  productRepository.save(product);

    }

    @Override
    public Map<String, Boolean> deleteProduct(Long id) {
        ProductModel product=findProductById(id);
        productRepository.delete(product);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }


}
