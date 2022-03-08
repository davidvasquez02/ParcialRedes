package com.redes.arrendamientos.model;


public class Inmueble {
	
    private int id;
    private String direccion;
    private String nombreEncargado;
    private String contactoEncargado;
    private String inmobiliaria;
    private String contactoInmobiliaria;
    private boolean estado;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombreEncargado() {
		return nombreEncargado;
	}
	public void setNombreEncargado(String nombreEncargado) {
		this.nombreEncargado = nombreEncargado;
	}
	public String getContactoEncargado() {
		return contactoEncargado;
	}
	public void setContactoEncargado(String contactoEncargado) {
		this.contactoEncargado = contactoEncargado;
	}
	public String getInmobiliaria() {
		return inmobiliaria;
	}
	public void setInmobiliaria(String inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}
	public String getContactoInmobiliaria() {
		return contactoInmobiliaria;
	}
	public void setContactoInmobiliaria(String contactoInmobiliaria) {
		this.contactoInmobiliaria = contactoInmobiliaria;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
    
    



}
