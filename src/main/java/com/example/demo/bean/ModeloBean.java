package com.example.demo.bean;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.model.Categoria;
import com.example.demo.model.Fabricante;
import com.example.demo.model.ModeloCarro;
import com.example.demo.repository.FabricanteRepository;
import com.example.demo.repository.ModeloRepository;

@Component
@Scope("view")
public class ModeloBean extends AbstractBean<ModeloCarro, ModeloRepository> {

	private List<Fabricante> fabricantes;

	private List<Categoria> categorias;

	@Autowired
	private FabricanteRepository repository;

	public ModeloBean() {
		super(ModeloCarro.class);
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	@Override
	protected void carregarLookups() {
		fabricantes = repository.findAll();
		categorias = Arrays.asList(Categoria.values());
	}

}
