package com.example.UD26EJ3.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UD26EJ3.dto.Equipo;
import com.example.UD26EJ3.service.EquipoServiceImpl;


@RestController
@RequestMapping("/api")
public class  EquipoController{
	
	@Autowired
	EquipoServiceImpl equipoServiceImpl;
	
	
	
	@GetMapping("/equipos")
	public List<Equipo> listarEquipos(){
		return equipoServiceImpl.listarEquipos();
	}
	
	
	@PostMapping("/equipos")
	public Equipo salvarEquipo(@RequestBody Equipo equipo) {
		
		return equipoServiceImpl.guardarEquipo(equipo);
	}
	
	
	@GetMapping("/equipo/{numerserie}")
	public Equipo equipoXID(@PathVariable(name="numerserie") String numerserie) {
		
		Equipo Equipo_xid= new Equipo();
		
		Equipo_xid=equipoServiceImpl.equipoXID(numerserie);
		
		System.out.println("Equipo XID: "+Equipo_xid);
		
		return Equipo_xid;
	}
	
	@PutMapping("/equipos/{numerserie}")
	public Equipo actualizarEquipo(@PathVariable(name="numerserie") String numerserie,@RequestBody Equipo equipo) {
		
		Equipo Equipo_seleccionado= new Equipo();
		Equipo Equipo_actualizado= new Equipo();
		
		Equipo_seleccionado= equipoServiceImpl.equipoXID(numerserie);
		
		Equipo_seleccionado.setNombre(equipo.getNombre());
		Equipo_seleccionado.setFacultad(equipo.getFacultad());
		
		Equipo_actualizado = equipoServiceImpl.actualizarEquipo(Equipo_seleccionado);
		
		System.out.println("El Curso actualizado es: "+ Equipo_actualizado);
		
		return Equipo_actualizado;
	}
	
	@DeleteMapping("/equipos/{numerserie}")
	public void eleiminarEquipo(@PathVariable(name="numerserie")String numerserie) {
		equipoServiceImpl.eliminarEquipo(numerserie);
	}

}



