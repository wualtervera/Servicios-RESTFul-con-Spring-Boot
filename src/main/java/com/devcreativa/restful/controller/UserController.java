package com.devcreativa.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devcreativa.restful.models.User;
import com.devcreativa.restful.services.UserService;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/users")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("")
	public ResponseEntity<?> getAll(){
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Intentelo más tarde.\"}");
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id){
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ \"error\" : \"Error, usuario no encontrado.\"}");
		}
	}
	
	@PostMapping("")	
	public ResponseEntity<?> save(@RequestBody User entity){
		try {			
			return ResponseEntity.status(HttpStatus.OK).body(userService.save(entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\" : \"Error al guardar datos.\"}");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User entity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.update(id, entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error al actualizar daros.\"}");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userService.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\" : \"Error al eliminar el usuario.\"}");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
