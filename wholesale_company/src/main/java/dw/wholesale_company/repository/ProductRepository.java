package dw.wholesale_company.repository;

import dw.wholesale_company.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p1 from Product p1 where p1.productName like CONCAT('%', :name, '%')")
    public List<Product> getProductByName(@Param("name") String name);

    @Query("select p from Product p where p.unitPrice between :lowLimit and :highLimit")
    public List<Product> getProductByUnitPrice(@Param("lowLimit") int lowLimit, @Param("highLimit") int highLimit);
}
