package com.link.generator.system.link.generator.system.repository;


import com.link.generator.system.link.generator.system.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
