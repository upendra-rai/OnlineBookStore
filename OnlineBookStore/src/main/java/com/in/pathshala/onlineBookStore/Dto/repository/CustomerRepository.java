package com.in.pathshala.onlineBookStore.Dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.pathshala.onlineBookStore.Dto.model.Book;
import com.in.pathshala.onlineBookStore.Dto.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
