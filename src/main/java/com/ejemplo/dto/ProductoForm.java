package com.ejemplo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductoForm {

	private long id;
	
	@NotNull
	@Size(min=1, max=30)
	private String nombre;
	@NotNull
	@Size(min=1, max=45)
	private String descripcion;	
	
	@NotNull(message="No puede estar vacio")
	@Min(value=1,message="No puede ser cero")
	private Double precio;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "ProductoForm [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	
}
