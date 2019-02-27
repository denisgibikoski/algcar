package com.example.demo.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.model.Acessorio;
import com.example.demo.model.Carro;
import com.example.demo.model.ModeloCarro;
import com.example.demo.repository.AcessorioRepository;
import com.example.demo.repository.CarroRepository;
import com.example.demo.repository.ModeloRepository;

@Component
@Scope("view")
public class CarroBean extends AbstractBean<Carro, CarroRepository> {

	private List<Acessorio> acessorios;
	private List<ModeloCarro> modelos;
	
	
	@Autowired
	private AcessorioRepository acessorioRepository;
	@Autowired
	private ModeloRepository modeloRepository;

	public CarroBean() {
		super(Carro.class);
	}
	
	@Override
	protected void carregarLookups() {
		acessorios = acessorioRepository.findAll();
		modelos = modeloRepository.findAll();
		
		
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public List<ModeloCarro> getModelos() {
		return modelos;
	}

	public void setModelos(List<ModeloCarro> modelos) {
		this.modelos = modelos;
	}

	

}
