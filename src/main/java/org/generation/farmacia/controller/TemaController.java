package org.generation.farmacia.controller;
import java.util.List;

import javax.validation.Valid;

import org.generation.farmacia.model.Tema;
import org.generation.farmacia.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;


@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*")
public class TemaController {
     
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
  public ResponseEntity<Tema> getById (@PathVariable Long id){
	  return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
			      .orElse(ResponseEntity.notFound().build());
	    
	      }
	@PostMapping
	public ResponseEntity<Tema> post(@Valid @RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
    @PutMapping
	public ResponseEntity<Tema> put(@Valid @RequestBody Tema tema) {
		   return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
 }
    @DeleteMapping
    public void delete(@PathVariable Long id ) {
    	repository.deleteById(id);
}
    }