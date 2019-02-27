package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Carro {

	private Long codigo;
	private String placa;
	private String cor;
	private BigDecimal valorDiaria;
	private ModeloCarro modelo;
	private List<Acessorio> acessorios;
	private List<Aluguel> alugueis;

	private LocalDate dataCriacao;
	private LocalDate dataModificacao;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_modelo")
	public ModeloCarro getModelo() {
		return modelo;
	}

	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}

	@Cascade(org.hibernate.annotations.CascadeType.REMOVE)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "carro_acessorio", joinColumns = @JoinColumn(name = "codigo_carro"), inverseJoinColumns = @JoinColumn(name = "codigo_acessorio"))
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	@OneToMany(mappedBy = "carro")
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}


	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	
	public LocalDate getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(LocalDate dataModificacao) {
		this.dataModificacao = dataModificacao;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
