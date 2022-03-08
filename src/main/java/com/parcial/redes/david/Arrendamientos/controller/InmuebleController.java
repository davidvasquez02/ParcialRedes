package com.parcial.redes.david.Arrendamientos.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import com.parcial.redes.david.Arrendamientos.model.Inmueble;


@RestController
public class InmuebleController {

    @GetMapping(value = "api")
    void hola(){

    }


    ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();



}
