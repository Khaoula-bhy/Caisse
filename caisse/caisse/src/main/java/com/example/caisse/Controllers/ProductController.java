package com.example.caisse.Controllers;



import com.example.caisse.Models.ProductModel;
import com.example.caisse.Services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin("*")

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    public ProductServiceInterface productService;

    @Autowired

    public ProductController(ProductServiceInterface productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        List<ProductModel> products= productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable Long id){
        ProductModel product =productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }
    @PostMapping("/products")
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel productModel){
        ProductModel product=productService.AddProduct(productModel);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @PutMapping("/products/{id}")

    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel productDetails){
        ProductModel C1=productService.updateProduct(id,productDetails);
        return   new ResponseEntity<>(C1,HttpStatus.OK);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable Long id){
        Map<String,Boolean> response=productService.deleteProduct(id);
        return  ResponseEntity.ok(response);
    }
}
