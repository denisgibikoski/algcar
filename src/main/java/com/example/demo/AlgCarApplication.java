package com.example.demo;

import javax.faces.webapp.FacesServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.primefaces.util.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlgCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgCarApplication.class, args);
	}

	@Bean
	public ServletContextInitializer servletContextCustomizer() {
		return new ServletContextInitializer() {
			
			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", "true");
				servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "cliente");
				servletContext.setInitParameter(Constants.ContextParams.MOVE_SCRIPTS_TO_BOTTOM, "true");
				servletContext.setInitParameter(Constants.ContextParams.THEME, "#{sessionBean.theme}");
			}
		};
	}


	@Bean
	public FacesServlet facesServlet() {
		return new FacesServlet();
	}

	@Bean
	public ServletRegistrationBean<Servlet> facesServletRegistration() {
		ServletRegistrationBean<Servlet> registration = new ServletRegistrationBean<>(facesServlet(), "*.xhtml");
		registration.setName("FacesServlet");
		registration.setLoadOnStartup(1);
		return registration;
	}

}
