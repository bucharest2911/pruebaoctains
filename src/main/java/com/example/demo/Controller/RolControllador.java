package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.RolServicio;

@RestController
@CrossOrigin( "http://localhost:4200")
@RequestMapping("/api/octans/rol")
public class RolControllador {

	
	@Autowired
	private RolServicio rolServicio;
	
	
	@GetMapping("/getRols")
	public ResponseEntity<?>getAllRols() {
		return new ResponseEntity<>(this.rolServicio.findAll(),HttpStatus.OK);
	}
}
