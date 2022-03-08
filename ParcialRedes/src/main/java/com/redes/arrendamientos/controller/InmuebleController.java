

package com.redes.arrendamientos.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redes.arrendamientos.model.Inmueble;

@RestController
@RequestMapping("/arrendamientos/api")
@CrossOrigin("*")
public class InmuebleController {
	
    ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();
    
    @PostMapping("inmueble")
    public ResponseEntity<?> create(@RequestBody Inmueble inmueble){
    	
		Map<String,Object> response = new HashMap<>();
    	
    	try {
    		
    		if(Objects.isNull(this.findById(inmueble.getId()))){
        		inmuebles.add(inmueble);
        		
        		response.put("Inmueble", inmueble);
        		response.put("Codigo de Respuesta", HttpStatus.OK.toString());
        		response.put("Mensaje de Respuesta", "Has agregado el inmueble satisfactoriamente.");
        		
        		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);    			
    		}else {
    			response.put("Inmueble con el siguiente ID: ya existe", inmueble.getId());
        		response.put("Codigo de Respuesta", HttpStatus.ALREADY_REPORTED);
        		response.put("Mensaje de Respuesta", "El Id ya se encuentra asignado a otro inmueble");

        		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.ALREADY_REPORTED);    			

    		}
    		    		
    	}catch (Exception e) {
    		response.put("Mensaje de Error", e.getCause());
    		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    
    
    @GetMapping("inmueble")
    public ResponseEntity<?> findByIdd(@RequestBody int id){
    	Map<String,Object> response = new HashMap<>();

    	try {
    		Inmueble inmueble = this.findById(id);
    		if(!Objects.isNull(inmueble)){
    			
    			response.put("Inmueble", inmueble);
    			response.put("Codigo de Respuesta", HttpStatus.OK.toString());
        		response.put("Mensaje de Respuesta", "inmueble encontrado satisfactoriamente.");
        		
        		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);    			
    		}else {
    			response.put("Codigo de Respuesta", HttpStatus.NOT_FOUND.toString());
        		response.put("Mensaje de Respuesta", "No se encontró un inmueble con el id indicado");
        		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);    			

    		}

		} catch (Exception e) {
			response.put("Mensaje de Error", e.getCause());
    		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}    
    }
    
    @GetMapping("inmuebles")
    public ArrayList<Inmueble> findAll(){
    	return inmuebles;
    }
    
    @DeleteMapping("inmueble")
    public ResponseEntity<?> delete(@RequestBody int id){
    	
		Map<String,Object> response = new HashMap<>();

    	try {
    		Inmueble inmueble = this.findById(id);
    		if(!Objects.isNull(inmueble)){
    			int delete =  inmuebles.indexOf(inmueble);
    			inmuebles.remove(delete);
    			
    			response.put("Inmueble", inmueble);
    			response.put("Codigo de Respuesta", HttpStatus.OK.toString());
        		response.put("Mensaje de Respuesta", "Has eliminado el inmueble satisfactoriamente.");
        		
        		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);    			
    		}else {
    			response.put("Codigo de Respuesta", HttpStatus.NOT_FOUND.toString());
        		response.put("Mensaje de Respuesta", "No se encontró un inmueble con el id indicado");
        		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);    			

    		}

		} catch (Exception e) {
			response.put("Mensaje de Error", e.getCause());
    		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	    	
    }
    
    @PutMapping("inmueble")
    public ResponseEntity<?> update(@RequestBody Inmueble inmueble){
    	
    	Map<String,Object> response = new HashMap<>();

    	try {
    		Inmueble inmuebleActual = this.findById(inmueble.getId());
    		if(!Objects.isNull(inmuebleActual)){
    			
    			int toUpdate =  inmuebles.indexOf(inmuebleActual);
    			
    			inmuebles.get(toUpdate).setDireccion(inmueble.getDireccion());
    			inmuebles.get(toUpdate).setNombreEncargado(inmueble.getNombreEncargado());
    			inmuebles.get(toUpdate).setContactoEncargado(inmueble.getContactoEncargado());
    			inmuebles.get(toUpdate).setInmobiliaria(inmueble.getInmobiliaria());
    			inmuebles.get(toUpdate).setContactoInmobiliaria(inmueble.getContactoInmobiliaria());
    			inmuebles.get(toUpdate).setEstado(inmueble.isEstado());
    			
    			response.put("Inmueble", inmuebles.get(toUpdate));
    			response.put("Codigo de Respuesta", HttpStatus.OK.toString());
        		response.put("Mensaje de Respuesta", "Has editado el inmueble satisfactoriamente.");
        		
        		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);    			
    		}else {
    			response.put("Codigo de Respuesta", HttpStatus.NOT_FOUND.toString());
        		response.put("Mensaje de Respuesta", "No se encontró un inmueble con el id indicado");
        		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);    			

    		}

		} catch (Exception e) {
			response.put("Mensaje de Error", e.getCause());
    		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }

 
    
    private Inmueble findById(int id) {
    	
    	Inmueble inmueble = null;
    	
    	for(int i = 0; i<inmuebles.size();i++) {
    		if(inmuebles.get(i).getId() == id) {
    			inmueble = inmuebles.get(i);
        	}	
    	}
    	return inmueble;
    }

}
