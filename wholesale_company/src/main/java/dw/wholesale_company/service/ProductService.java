package dw.wholesale_company.service;

import dw.wholesale_company.model.Product;
import dw.wholesale_company.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductAll(){
        return productRepository.findAll();
    }

    //2. 제품의 재고가 50개 미만인 제품 정보 얻기
    public List<Product> getProductInventory50(){
        List<Product> products = productRepository.findAll();
        List<Product> newProducts = new ArrayList<>();
        for (int i = 0; i< products.size(); i++){
            if (products.get(i).getInventory() < 50){
                newProducts.add(products.get(i));
            }
        }
        return newProducts;
    }
}
