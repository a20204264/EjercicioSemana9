package com.idat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.DTO.AutoDTORequest;
import com.idat.DTO.AutoDTOResponse;
import com.idat.Service.AutoService;

@Controller
@RequestMapping("/auto/v1")
public class AutoController {

	@Autowired
	private AutoService service;
	
	//LISTAR TODO
			@RequestMapping("/listar")
			public @ResponseBody ResponseEntity<List<AutoDTOResponse>> listar(){
				
				return new ResponseEntity<List<AutoDTOResponse>>(service.listarAuto(),HttpStatus.OK);
			}
			
			
			//OBTENER POR ID:
			@GetMapping("/{id}")
			public @ResponseBody AutoDTOResponse ObtenerItemId(@PathVariable Integer id) {
				return service.obtenerAutoId(id);
			}
			
			//ELIMINAR:
			@RequestMapping(path="/eliminar/{id}",  method = RequestMethod.DELETE)
			public ResponseEntity<Void> eliminar(@PathVariable Integer id){
				AutoDTOResponse auto = service.obtenerAutoId(id);
				if(auto != null) {
					service.eliminarAuto(id);
					
					return new ResponseEntity<Void>(HttpStatus.OK);
				}
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			//GUARDAR:
			@RequestMapping(path = "/guardar", method = RequestMethod.POST)
			public ResponseEntity<Void> guardar(@RequestBody AutoDTORequest auto){
				service.guardarAuto(auto);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			
			//ACTUALIZAR:
			@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
			public ResponseEntity<Void> actualizar(@RequestBody AutoDTORequest auto){
				
				AutoDTOResponse autos= service.obtenerAutoId(auto.getIdauto());
				
				if(autos !=null) {
					service.actualizarAuto(auto);
					return new ResponseEntity<Void>(HttpStatus.OK);
				}
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			
			//LISTAR POR ID:
			
			@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
			public ResponseEntity<AutoDTOResponse> obtenerId(@PathVariable Integer id){
				
				AutoDTOResponse autos=service.obtenerAutoId(id);
				
				if(autos!= null) {
					return new ResponseEntity<AutoDTOResponse>(service.obtenerAutoId(id), HttpStatus.OK);
				}
				return new ResponseEntity<AutoDTOResponse>(HttpStatus.NOT_FOUND);
			}


	
	
	
	
}
