package com.ejemplo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ejemplo.bean.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	
	
}
