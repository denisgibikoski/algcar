package com.example.demo.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.model.Acessorio;
import com.example.demo.repository.AcessorioRepository;




@Component
@Scope("view")
public class AcessorioBean extends AbstractBean<Acessorio,AcessorioRepository > {

	public  AcessorioBean() {
		super(Acessorio.class);
	}	

}
