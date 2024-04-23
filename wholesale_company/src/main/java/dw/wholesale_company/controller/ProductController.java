package dw.wholesale_company.controller;

import dw.wholesale_company.model.Product;
import dw.wholesale_company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductAll(){
        return new ResponseEntity<>(productService.getProductAll(), HttpStatus.OK);
    }

    @GetMapping("/products/Inventory50")
    public ResponseEntity<List<Product>> getProductInventory50(){
        return new ResponseEntity<>(productService.getProductInventory50(), HttpStatus.OK);
    }
}
