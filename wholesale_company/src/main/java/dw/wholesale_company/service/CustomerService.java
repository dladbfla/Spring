package dw.wholesale_company.service;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomerAll(){
        return customerRepository.findAll();
    }

    //4. 고객 전체의 평균마일리지보다 평균마일리지가 큰 고객 정보
    public List<Customer> getCustomerAboveAverage(){
        List<Customer> customers = customerRepository.findAll();
        List<Customer> newcustomers = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < customers.size(); i++){
            sum = sum + customers.get(i).getMileage();
        }
        int avg = sum/customers.size();
        for (int j = 0; j<customers.size(); j++){
            if (customers.get(j).getMileage() > avg){
                newcustomers.add(customers.get(j));
            }
        }
        return newcustomers;
    }

}
