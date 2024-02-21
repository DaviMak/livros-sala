package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.entity.Livro;
import app.service.LivroService;

@RestController
@RequestMapping("api/livro")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody Livro livro){
		try {
			String msg = this.livroService.salvar(livro);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("erro", HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/deletar")
	public ResponseEntity<String> deletar(@RequestBody Livro livro){
		try {
			String msg = this.livroService.deletar(livro);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/atualizar")
	public ResponseEntity<String> atualizar(@RequestBody Livro livro){
		try {
			String msg = this.livroService.atualizar(livro);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/listAll")
	private ResponseEntity<String> listAll(){
		try {
			List<Livro> lista = this.livroService.listAll();
			ObjectMapper objectMapper = new ObjectMapper();
	        String json = objectMapper.writeValueAsString(lista);

			return new ResponseEntity<String>(json, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
