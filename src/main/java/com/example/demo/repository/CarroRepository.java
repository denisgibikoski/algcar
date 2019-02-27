package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
