package com.example.demo.bean;

import java.util.List;

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
		if (objeto == null) {
			FacesUtil.addMensagemErro("Selecione um registro");
		} else {
			operacao = Operacao.EDITAR;
			abrirDialog();
		}
	}
	
	public void cancelar() {
		objeto = null;
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
		objeto = modelClass.newInstance();
		operacao = Operacao.INSERIR;
		abrirDialog();
	}
	
	public void onRowSelect(SelectEvent event) {
		registroSelecionado = true;
	}
	
	public void remover() {
		if (objeto == null) {
			FacesUtil.addMensagemErro("Selecione um registro");
		} else {
			repository.delete(objeto);
			objeto = null;
			registroSelecionado = false;
			listar();
		}
	}
	
	public void salvar() {
		
		repository.save(objeto);
		FacesUtil.addMensagemInfo("Registro gravado com sucesso!");
		objeto = null;
		operacao = Operacao.LISTAR;
		fecharDialog();
		listar();
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
