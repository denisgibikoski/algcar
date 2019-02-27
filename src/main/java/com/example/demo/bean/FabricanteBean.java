package com.example.demo.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.model.Fabricante;
import com.example.demo.repository.FabricanteRepository;




@Component
@Scope("view")
public class FabricanteBean extends AbstractBean<Fabricante,FabricanteRepository > {

	public  FabricanteBean() {
		super(Fabricante.class);
	}	

}
