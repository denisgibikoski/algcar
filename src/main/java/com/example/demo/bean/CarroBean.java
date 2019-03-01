package com.example.demo.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.model.Acessorio;
import com.example.demo.model.Carro;
import com.example.demo.model.ModeloCarro;
import com.example.demo.repository.AcessorioRepository;
import com.example.demo.repository.CarroRepository;
import com.example.demo.repository.ModeloRepository;
import com.example.demo.util.FacesUtil;

@Component
@Scope("view")
public class CarroBean  {
	
	private Carro carro;
	private List<Acessorio> acessorioSelecionados; 
	private List<Acessorio> acessorios;
	private List<ModeloCarro> modelos;
	private List<Carro> carros;
	
	
	
	@Autowired
	private AcessorioRepository acessorioRepository;
	@Autowired
	private ModeloRepository modeloRepository;
	@Autowired
	private CarroRepository carroRepository;

	private Operacao operacao;
	private boolean registroSelecionado;

	
	@PostConstruct
	public void inicializar() {
		listar();
	}
	
	public boolean isRegistroSelecionado() {
		return registroSelecionado;
	}

	public void setRegistroSelecionado(boolean registroSelecionado) {
		this.registroSelecionado = registroSelecionado;
	}

	private void abrirDialog() {
		carregarLookups();
		FacesUtil.abrirDialog("dlgForm");
	}
	
	
	public void alterar() {
		if (carro == null) {
			FacesUtil.addMensagemErro("Selecione um registro");
		} else {
			operacao = Operacao.EDITAR;
			abrirDialog();
		}
	}
	
	public void cancelar() {
		carro = null;
		operacao = Operacao.LISTAR;
		fecharDialog();
	}
	

	private void fecharDialog() {
		registroSelecionado = false;
		FacesUtil.fecharDialog("dlgForm");
	}
	
	public String getTituloDialog() {
		return Operacao.EDITAR == operacao ?
				"Alterar Registro" : "Novo Registro";
	}
	

	
	public void novo() throws InstantiationException, IllegalAccessException {
		carro = new Carro();
		carro.setAcessorios(new ArrayList<>());
		operacao = Operacao.INSERIR;
		abrirDialog();
	}
	
	public void onRowSelect(SelectEvent event) {
		registroSelecionado = true;
	}
	
	public void remover() {
		if (carro == null) {
			FacesUtil.addMensagemErro("Selecione um registro");
		} else {
			carroRepository.delete(carro);
			carro = null;
			registroSelecionado = false;
			listar();
		}
	}
	
	@Transactional
	public void salvar() {
			
		carro.setDataCriacao(LocalDate.now());
			
		carroRepository.save(carro);
		FacesUtil.addMensagemInfo("Registro gravado com sucesso!");
		carro= null;
		operacao = Operacao.LISTAR;
		fecharDialog();
		listar();
	}
	
		
	protected void listar() {
		modelos = modeloRepository.findAll();
		acessorioSelecionados = acessorioRepository.findAll();
	}
	
	
	public void carregarLookups() {
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

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public List<Acessorio> getAcessorioSelecionados() {
		return acessorioSelecionados;
	}

	public void setAcessorioSelecionados(List<Acessorio> acessorioSelecionados) {
		this.acessorioSelecionados = acessorioSelecionados;
	}
	
	
}
