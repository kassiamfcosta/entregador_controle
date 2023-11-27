package com.controle.entregadores.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.controle.entregadores.dtos.EntregadorDto;
import com.controle.entregadores.models.EntregadorModel;
import com.controle.entregadores.repositories.EntregadorRepository;

import jakarta.validation.Valid;

@RestController
public class EntregadorController {
	@Autowired
	EntregadorRepository entregadorRepository;
	
	@GetMapping("/entregador")
	public ResponseEntity<List<EntregadorModel>> listar(){
		List<EntregadorModel> entregadorList = entregadorRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK) .body(entregadorList);	
	}
	 
	@PostMapping("/entregador")
    public ResponseEntity<EntregadorModel> salvar(@RequestBody @Valid EntregadorDto entregadorDto) {
		var entregadorModel	= new EntregadorModel();
		BeanUtils.copyProperties(entregadorDto, entregadorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(entregadorRepository.save(entregadorModel));
	}
	
	@GetMapping("/entregador/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable(value="id") Integer id){
	Optional<EntregadorModel> entregador = entregadorRepository.findById(id);
	if(entregador.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado.");
	}
	return ResponseEntity.status(HttpStatus.OK).body(entregador.get());
	}
	
	@PutMapping("/entregador/{id}")
	public ResponseEntity<Object>updateEntregador(@PathVariable(value="id") Integer id, @RequestBody @Valid EntregadorDto entregadorDto){
		
		Optional<EntregadorModel> entregador = entregadorRepository.findById(id);
		if(entregador.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado para edição.");
		}
		var entregadorModel = entregador.get();
		BeanUtils.copyProperties(entregadorDto, entregadorModel);
		return ResponseEntity.status(HttpStatus.OK).body(entregadorRepository.save(entregadorModel));
		
	}
	
	@DeleteMapping("/entregador/{id}")
	public ResponseEntity<Object> deleteProduct (@PathVariable(value="id")Integer id){
		Optional<EntregadorModel> entregador = entregadorRepository.findById(id);
		if(entregador.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado para edição.");
		}
		entregadorRepository.delete(entregador.get());
		return ResponseEntity.status(HttpStatus.OK).body("O entregador foi excluído com sucesso.");
	}
}
			
