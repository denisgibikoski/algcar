package com.example.demo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.ModeloCarro;
import com.example.demo.repository.ModeloRepository;
import com.example.demo.util.FacesUtil;
import com.example.demo.util.MessageUtil;

@Component
public class ModeloConverter implements Converter {

	@Autowired
	private ModeloRepository repository;
	@Autowired
	private MessageUtil messageUtil;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		try {
			return repository.findById(Long.parseLong(value)).orElse(null);
		} catch (Exception ex) {
			throw new ConverterException(FacesUtil.criarMensagemErro(messageUtil.getMessage("categoria.invalida")));
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof ModeloCarro) {
			ModeloCarro modeloCarro = (ModeloCarro) value;
			return String.valueOf(modeloCarro.getCodigo());
		} else {
			return null;
		}
	}

}
