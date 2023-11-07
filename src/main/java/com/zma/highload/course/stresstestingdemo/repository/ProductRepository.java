package com.zma.highload.course.stresstestingdemo.repository;

import com.zma.highload.course.stresstestingdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {




}
