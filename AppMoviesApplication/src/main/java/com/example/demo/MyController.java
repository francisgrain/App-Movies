
package com.example.demo;




import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MyController {

	private MovieJDBCTemp movieJDBCTemp;

	@Autowired
	public MyController(MovieJDBCTemp movieJDBCTemp) {

		this.movieJDBCTemp = movieJDBCTemp;
	}


	@Autowired
	private OmdbService omdbService;

	@GetMapping("/")
	public String getMovieForm(Model model) {
		ArrayList <Film> lista = new ArrayList<>();
		lista = movieJDBCTemp.ritornaFilms();
		model.addAttribute("lista", lista);

		return "getMovieForm";
	}
	

	@PostMapping("/getMovie")
	public String getMovie(@RequestParam("title") String title, Model model) {
		String movieDetails = omdbService.getMovieDetails(title);

		// Parse JSON string
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(movieDetails);
            if (jsonNode.get("Response").asText().equals("False")) {
                model.addAttribute("errorMessage", "Film non trovato.");
                
                ArrayList<Film> lista = movieJDBCTemp.ritornaFilms();
        	    model.addAttribute("lista", lista);
        	    
                return "getMovieForm"; // Redirect to the form page with an error message
            }

            model.addAttribute("title", jsonNode.get("Title").asText());
            model.addAttribute("director", jsonNode.get("Director").asText());
            model.addAttribute("actors", jsonNode.get("Actors").asText());
            model.addAttribute("poster", jsonNode.get("Poster").asText());
            model.addAttribute("year", jsonNode.get("Year").asText());
            model.addAttribute("plot", jsonNode.get("Plot").asText());
            model.addAttribute("awards", jsonNode.get("Awards").asText());
            model.addAttribute("released", jsonNode.get("Released").asText());
            model.addAttribute("rated", jsonNode.get("Rated").asText());
            model.addAttribute("ratings", jsonNode.get("Ratings").asText());
            model.addAttribute("runtime", jsonNode.get("Runtime").asText());
            model.addAttribute("genre", jsonNode.get("Genre").asText());

        } catch (IOException e) {
            e.printStackTrace();
        }

        
	    
        return "movieDetails";
    }

	
	@PostMapping("/add")
	public String addMovie(@RequestParam("title") String s, Model model) {
		String movieDetails = omdbService.getMovieDetails(s);
		// Parse JSON string
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			JsonNode jsonNode = objectMapper.readTree(movieDetails);
			String titolo =  jsonNode.get("Title").asText();
			String regista =  jsonNode.get("Director").asText();
			String attori = jsonNode.get("Actors").asText();
			String url =  jsonNode.get("Poster").asText();
			String anno =  jsonNode.get("Year").asText();
			String trama =  jsonNode.get("Plot").asText();
			movieJDBCTemp.insertMovie(titolo, regista, attori, url, anno, trama);


		} catch (IOException e) {
			e.printStackTrace();
		}




		ArrayList<Film> lista = movieJDBCTemp.ritornaFilms();
	    model.addAttribute("lista", lista);

	    return "redirect:/";

	}
	
	@PostMapping("/del")
	public String delMovie(@RequestParam("title") String s, Model model) {
	    // Cancella il film dal database
	    movieJDBCTemp.deleteMovie(s);

	    // Recupera la lista aggiornata dei film preferiti
	    ArrayList<Film> lista = movieJDBCTemp.ritornaFilms();
	    model.addAttribute("lista", lista);

	    // Ritorna alla pagina che visualizza la lista aggiornata
	    return "redirect:/";
	}

}

