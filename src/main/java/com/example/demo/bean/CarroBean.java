package com.example.demo.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.model.Carro;
import com.example.demo.repository.CarroRepository;




@Component
@Scope("view")
public class CarroBean extends AbstractBean<Carro,CarroRepository > {

	public CarroBean() {
		super(Carro.class);
	}
	

}
