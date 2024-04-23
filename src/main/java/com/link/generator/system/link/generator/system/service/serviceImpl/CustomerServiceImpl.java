package com.link.generator.system.link.generator.system.service.serviceImpl;


import com.link.generator.system.link.generator.system.exception.CustomerNotFoundException;
import com.link.generator.system.link.generator.system.model.Customer;
import com.link.generator.system.link.generator.system.repository.CustomerRepository;
import com.link.generator.system.link.generator.system.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public Customer saveCustomerDetails(Customer aCustomer) {

        return customerRepository.save(aCustomer);
    }
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("No customer found with Id: " + id));
        
}

}
