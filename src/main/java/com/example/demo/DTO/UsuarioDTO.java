package com.example.demo.DTO;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
private Integer idRol;
private String nombreUsuario;
private String activo;
private Integer idUsuario;
public Integer getIdRol() {
	return idRol;
}
public void setIdRol(Integer idRol) {
	this.idRol = idRol;
}
public String getNombreUsuario() {
	return nombreUsuario;
}
public void setNombreUsuario(String nombreUsuario) {
	this.nombreUsuario = nombreUsuario;
}
public String getActivo() {
	return activo;
}
public void setActivo(String activo) {
	this.activo = activo;
}
public Integer getIdUsuario() {
	return idUsuario;
}
public void setIdUsuario(Integer idUsuario) {
	this.idUsuario = idUsuario;
}

}
