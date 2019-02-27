package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ModeloCarro;

public interface ModeloRepository extends JpaRepository<ModeloCarro, Long> {

}
