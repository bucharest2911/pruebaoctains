package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Rol;
import com.example.demo.repository.RolRepository;

@Service
public class RolServicio {
    @Autowired
	private RolRepository rolRepository;
    
    public List<Rol> findAll() {
    return (List<Rol>) this.rolRepository.findAll();
    }
	
}
