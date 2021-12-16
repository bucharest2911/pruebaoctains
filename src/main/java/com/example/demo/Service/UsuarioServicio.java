package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.DTO.UsuarioDTO;
 
import com.example.demo.modelo.Rol;
import com.example.demo.modelo.Usuario;
import com.example.demo.repository.RolRepository;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServicio {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolRepository rolRepository;

	public int cargarDatos(UsuarioDTO usuariodto, Usuario usuario) {

		Usuario usuarioencontrado = this.buscarUsuarioPorNombre(usuario.getNombreUsuario());
		if (usuarioencontrado != null) {
			return 0;
		}

		Optional<Rol> optionalRol = this.rolRepository.findById(usuariodto.getIdRol());
		usuario.setNombreUsuario(usuariodto.getNombreUsuario());
		usuario.setRol(optionalRol.get());
		usuario.setActivo(usuariodto.getActivo());

		this.usuarioRepository.save(usuario);
		return 1;
	}

	public Usuario buscarUsuarioPorNombre(String nombre) {
		List<Usuario> usuarios = (List<Usuario>) this.usuarioRepository.findAll();
		Usuario usuarioencontrado = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getNombreUsuario().equalsIgnoreCase(nombre)) {
				usuarioencontrado = usuario;
				break;
			}
		}
		return usuarioencontrado;
	}

	public int saveUsuario(UsuarioDTO usuariodto, Usuario usuario) {
		return this.cargarDatos(usuariodto, usuario);
	}

	public void ActualizarUsuario(UsuarioDTO usuariodto) {
		Usuario usuario = this.getUsuario(usuariodto.getIdUsuario());
		this.cargarDatos(usuariodto, usuario);
	}

	public Usuario getUsuario(Integer idUsuario) {
		Usuario usuario = null;
		Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(idUsuario);

		if (usuarioOptional.isPresent()) {
			usuario = usuarioOptional.get();
		}

		return usuario;
	}

	public Usuario eliminarUsuario(Integer idUsuario) {
		Usuario usuario = this.getUsuario(idUsuario);

		if (usuario != null) {
			this.usuarioRepository.delete(usuario);
		}

		return usuario;
	}

	public List<Usuario> findAll() {
		return (List<Usuario>) this.usuarioRepository.findAll();
	}

}
