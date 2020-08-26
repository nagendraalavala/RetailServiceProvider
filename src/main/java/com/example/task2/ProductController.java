package com.example.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ProductController
{

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public ProductEntity addProduct(@RequestBody ProductEntity productEntity)
    {
        return service.postProduct(productEntity);
    }

    @GetMapping()
    public ResponseEntity<List<ProductEntity>> getAllProducts()
    {
        return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id)
    {
        return service.getProductById(id);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductEntity> updateproduct(@PathVariable Long id, @RequestBody ProductEntity productEntity)
    {
        return new ResponseEntity(service.updateProduct(id,productEntity),HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id)
    {
        service.deleteProduct(id);
    }
}
