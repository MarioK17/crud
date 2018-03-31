package com.ejemplo.controller;

import java.util.List;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.hibernate.validator.internal.engine.messageinterpolation.el.RootResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ejemplo.bean.Producto;
import com.ejemplo.dto.ProductoForm;
import com.ejemplo.repositorio.ProductoRepository;

@Controller
public class RootController {

	private ProductoRepository productoRepository;
	private Logger logger = LoggerFactory.getLogger(RootController.class);
	DataSource datasource;
	
	@Autowired
	public RootController(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;	
	}
	
	@RequestMapping("/")
	public String index(Model model) {

		List<Producto> productos = productoRepository.findAll();
		
		model.addAttribute("productos", productos);
		
		return "index";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String insertar(Model model) {

		model.addAttribute("productoForm", new ProductoForm());
		
		return "nuevo";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public String insertar(@ModelAttribute("productoForm") @Valid ProductoForm productoForm, BindingResult result) {

		if(result.hasErrors()) {
			return "nuevo";
		}
		
		Producto producto = new Producto();
		producto.setNombre(productoForm.getNombre());
		producto.setDescripcion(productoForm.getDescripcion());
		producto.setPrecio(productoForm.getPrecio());		
		
		productoRepository.save(producto);		
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/{id}/editar", method=RequestMethod.GET)
	public String editar(Model model, @PathVariable long id) {
		
		Producto producto = productoRepository.findOne(id);
		
		ProductoForm productoForm = new ProductoForm();		
		
		productoForm.setId(producto.getId());
		productoForm.setNombre(producto.getNombre());
		productoForm.setDescripcion(producto.getDescripcion());
		productoForm.setPrecio(producto.getPrecio());
		
		model.addAttribute("productoForm", productoForm);		
		
		return "editar";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editar(@ModelAttribute("productoForm") @Valid ProductoForm productoForm,BindingResult result) {
		
		if(result.hasErrors()) {
			return "editar";
		}
		
		Producto producto = productoRepository.findOne(productoForm.getId());		
		
		producto.setNombre(productoForm.getNombre());
		producto.setDescripcion(productoForm.getDescripcion());
		producto.setPrecio(productoForm.getPrecio());
	
		productoRepository.save(producto);
		
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/{id}/eliminar", method=RequestMethod.GET)
	public String eliminar(@PathVariable long id) {
		
		Producto producto = productoRepository.findOne(id);
		
		if(producto!=null) {
		
			productoRepository.delete(id);	
		}
		return "redirect:/";
	}

}
