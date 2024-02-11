package com.payment.repository;

import com.payment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> , JpaSpecificationExecutor<Customer> {

    Optional<Customer> findByIdentityNo(String identityNo);
}
