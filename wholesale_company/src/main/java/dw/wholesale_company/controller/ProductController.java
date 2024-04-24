package dw.wholesale_company.controller;

import dw.wholesale_company.model.Product;
import dw.wholesale_company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    //선생님코드
    @GetMapping("/products/inventory/under/{num}")
    public ResponseEntity<List<Product>> getProductByInventoryUnder(@PathVariable int num) {
        return new ResponseEntity<>(productService.getProductByInventoryUnder(num),
                HttpStatus.OK);
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String name){
        return new ResponseEntity<>(productService.getProductByName(name), HttpStatus.OK);
    }

    @GetMapping("/products/unitPrice/{lowLimit}/{highLimit}")
    public ResponseEntity<List<Product>> getProductByUnitPrice(@PathVariable int lowLimit,
                                                               @PathVariable int highLimit){
        return new ResponseEntity<>(productService.getProductByUnitPrice(lowLimit,highLimit), HttpStatus.OK);
    }

    @GetMapping("/products/idList")
    public ResponseEntity<List<Product>> getProductById(@RequestBody List<Long> idList){
        return new ResponseEntity<>(productService.getProductById(idList), HttpStatus.OK);
    }

    @GetMapping("/products/InventoryValueTop10")
    public ResponseEntity<List<Product>> getProductsByInventoryValueTop10(){
        return new ResponseEntity<>(productService.getProductsByInventoryValueTop10(), HttpStatus.OK);
    }
}
