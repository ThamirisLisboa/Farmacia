package org.generation.farmacia.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.farmacia.model.Postagens;
import org.generation.farmacia.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagem")
@CrossOrigin (origins = "*")
public class PostagemController {

	@Autowired
 private PostagemRepository repository;
	
public ResponseEntity<List<Postagens>> getAll() {
	return ResponseEntity.ok(repository.findAll());
}
@GetMapping("/{id}")
public ResponseEntity<Postagens> getById(@PathVariable Long id) {
	return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
		.orElse(ResponseEntity.notFound().build())	;
}
 @GetMapping("/titulo/{titulo}")
  public ResponseEntity<List<Postagens>> getByTitulo(@PathVariable String Titulo) {
	  return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(Titulo));
  }
 public ResponseEntity<Postagens> post (@Valid @RequestBody Postagens postagem) {
	 return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
 }
 @DeleteMapping("/{id}")
 public void delete (@PathVariable Long id) {
	 repository.deleteById(id);
 }
}
