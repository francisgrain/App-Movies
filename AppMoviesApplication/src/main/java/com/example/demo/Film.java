package com.example.demo;

public class Film {
	String titolo;
	String regista;
	String attori;
	String url;
	String anno;
	String trama;
	
	public String getAnno() {
		return anno;
	}
	public String getTrama() {
		return trama;
	}
	public void setTrama(String trama) {
		this.trama = trama;
	}
	public void setAnno(String string) {
		this.anno = string;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getRegista() {
		return regista;
	}
	public void setRegista(String regista) {
		this.regista = regista;
	}
	public String getAttori() {
		return attori;
	}
	public void setAttori(String attori) {
		this.attori = attori;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}