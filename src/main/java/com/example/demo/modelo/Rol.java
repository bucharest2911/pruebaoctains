package com.example.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Rol {
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)	
 @Column(name="id_rol")
private Integer rolId;
@Column(name="nombre_rol")	
private String nombreRol;
public Integer getRolId() {
	return rolId;
}
public void setRolId(Integer rolId) {
	this.rolId = rolId;
}
public String getNombreRol() {
	return nombreRol;
}
public void setNombreRol(String nombreRol) {
	this.nombreRol = nombreRol;
}



}
