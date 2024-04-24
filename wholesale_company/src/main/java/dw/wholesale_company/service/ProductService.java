package dw.wholesale_company.service;

import dw.wholesale_company.model.Product;
import dw.wholesale_company.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    //선생님코드. 제품의 재고가 50개 미만인 제품 정보 얻기
    public List<Product> getProductByInventoryUnder(int num) {
        List<Product> productList = productRepository.findAll();
        return productList.stream().filter(p->p.getInventory() < num)
                .collect(Collectors.toList());
    }

    //제품중에서 제품명에 '주스'가 들어간 제품에 대한 모든 벙보를 검색
    //제품명을 매개변수로 받아서 처리하는 것도 구현
    public List<Product> getProductByName(String name){
        List<Product> products = productRepository.findAll();
        //람다
        // return products.stream().filter(p->p.getProductName().contains(name)).collect(Collectors.toList());

        //JPQL
        return productRepository.getProductByName(name);
    }

    //제품단가가 5000원 이상 10000원 이하인 제품에는 무엇이 있는지 검색
    //lowlimit과 highlimit으로 매개변수 처리하는 것도 구현
    public List<Product> getProductByUnitPrice(int lowLimit, int highLimit){
        List<Product> products = productRepository.findAll();
        /*람다
        return products.stream().filter(p -> p.getUnitPrice() >= lowLimit).filter(p -> p.getUnitPrice() <= highLimit )
                .collect(Collectors.toList());*/

        //JPQL
        return productRepository.getProductByUnitPrice(lowLimit,highLimit);
    }

    //제품 제품번호가 1, 2, 4, 7, 11, 20인 제품의 모든 정보를 불러오기
    //포스트맨에서
    //본문에 [1, 2, 4, 7, 11, 20]
    public List<Product> getProductById(List<Long> idList){
        List<Product> products = productRepository.findAll();
        /*List<Product> newproducts = new ArrayList<>();
        for (int i =0; i < idList.size(); i++){
            for (int j =0; j< products.size();j++)
            if(idList.get(i) == products.get(j).getProductId()){
                newproducts.add(products.get(j));
            }
        }
        return newproducts;*/

        return products.stream().filter(product -> idList.contains(product.getProductId()))
                .collect(Collectors.toList());
    }

    //제품 재고금액이 높은 상위 10개제품
    public List<Product> getProductsByInventoryValueTop10(){
        List<Product> products = productRepository.findAll().stream()
                .sorted(Comparator.comparingInt((Product p) -> p.getUnitPrice() * p.getInventory()).reversed())
                .collect(Collectors.toList());
        List<Product> newProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            newProducts.add(products.get(i));
        }
        return newProducts;
    }

}
