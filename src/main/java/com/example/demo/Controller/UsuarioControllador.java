package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.Service.UsuarioServicio;
import com.example.demo.modelo.Usuario;

@RestController
@CrossOrigin( "http://localhost:4200")
@RequestMapping("/api/octans/usuario")
public class UsuarioControllador {

	@Autowired
	private UsuarioServicio usuarioServicio;
	@GetMapping("/users")
	public ResponseEntity<?> getUsers() {
		
		
	 List<Usuario>usuarios=this.usuarioServicio.findAll();
	 return usuarios!=null?new ResponseEntity<>(usuarios,HttpStatus.OK):new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
	 
	}
	
 
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO usuariodto) {
		
		Usuario usuario=new Usuario();
		usuario.setNombreUsuario("");
		int error=this.usuarioServicio.saveUsuario(usuariodto, usuario);
		
		
	ResponseEntity<?> respuesta=null;
	if(error==1) {
		respuesta=new ResponseEntity<>(usuario,HttpStatus.OK);
	}
	if (error==0) {
		respuesta=new ResponseEntity<>("ya existe este usuario",HttpStatus.BAD_REQUEST);
	}
		
		return respuesta;
	}
	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody UsuarioDTO usuariodto) {
		
		Usuario usuario=this.usuarioServicio.getUsuario(usuariodto.getIdUsuario());
		int error=this.usuarioServicio.saveUsuario(usuariodto, usuario);
		
		
	ResponseEntity<?> respuesta=null;
	if(error==1) {
		respuesta=new ResponseEntity<>(usuario,HttpStatus.OK);
	}
	if (error==0) {
		respuesta=new ResponseEntity<>("ya existe este usuario",HttpStatus.BAD_REQUEST);
	}
		
		return respuesta;
	}
	@DeleteMapping("/deleteUser")
	public ResponseEntity<?> deleteUser(@RequestBody UsuarioDTO usuariodto) {
		
 
		Usuario usuario=this.usuarioServicio.eliminarUsuario(usuariodto.getIdUsuario());
		if(usuario!=null) {
		 return new ResponseEntity<>("usuario eliminado",HttpStatus.OK);
		}
		 return new ResponseEntity<>("ha ocurrido un error",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<?>getUser(@RequestParam Integer idUsuario){
		Usuario usuario=this.usuarioServicio.getUsuario(idUsuario);
		
		return usuario!=null?new ResponseEntity<>(usuario,HttpStatus.OK):new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
	}
	
	
	
}
