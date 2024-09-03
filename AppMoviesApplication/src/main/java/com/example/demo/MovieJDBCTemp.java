package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters.ZoneIdToStringConverter;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class MovieJDBCTemp {
	 private JdbcTemplate jdbcTemplateObject;
	
	 @Autowired
	public MovieJDBCTemp(JdbcTemplate jdbcTemplateObject){
		
		 this.jdbcTemplateObject = jdbcTemplateObject;
	}
	 

	    public int insertMovie(String titolo , String regista, String attori,String url, String anno, String trama) {
	        String query = "INSERT INTO movies (titolo, regista, attori, url, anno, trama) VALUES (?, ?, ?, ?, ?, ?)";
	        return jdbcTemplateObject.update(query, titolo, regista, attori,  url, anno, trama);
	    }
	    
	    public int deleteMovie(String titolo) {
	    	String query = "DELETE FROM movies WHERE titolo = ?";
	    	return jdbcTemplateObject.update(query, titolo);
	    }
	    
	    
	    public ArrayList<Film> ritornaFilms(){
	    	ResultSet rs1 = null;
	    	
	    	
	            String query = "SELECT * FROM movies";
	            return jdbcTemplateObject.query(query, new ResultSetExtractor<ArrayList<Film>>() {
	                @Override
	                public ArrayList<Film> extractData(ResultSet rs) throws SQLException {
	                	ArrayList <Film> listaFilm = new ArrayList<>();
	                    while (rs.next()) {
	                    	Film o1 = new Film();
	                        
	                        o1.setTitolo(rs.getString("titolo"));
	                        o1.setRegista(rs.getString("regista"));
	                        o1.setAttori(rs.getString("attori"));
	                        o1.setUrl(rs.getString("url"));
	                        o1.setAnno(rs.getString("anno"));
	                        o1.setTrama(rs.getString("trama"));
	                      
	                        
	                        listaFilm.add(o1);
	                    }
	                    return listaFilm;
	                }
	            });
	        }

}