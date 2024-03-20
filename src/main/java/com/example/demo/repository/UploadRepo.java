package com.example.demo.repository;

import com.example.demo.model.ProductJava;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepo extends JpaRepository<ProductJava,Integer> {
}
