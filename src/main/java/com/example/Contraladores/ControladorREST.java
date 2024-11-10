package com.example.Contraladores;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorREST {

    // Mapea la ruta principal (/) a index.html
    @GetMapping("/")
    public String comienzo() {
        return "index";
    }


    @GetMapping("/inicio_sesion")
    public String showLoginPage() {
        return "inicio_sesion";
    }



    @GetMapping("/salto_angel")
public String saltoAngel() {
    return "salto_angel";  
}


@GetMapping("/tour_delamor")
public String TourDelAmor() {
    return "tour_delamor";  
}
@GetMapping("/La_herrera")
public String La_herrera() {
    return "La_herrera";  
}

@GetMapping("/reservar")
public String reservar() {
    return "reservar";
}
@GetMapping("/carrito")
public String carrito() {
    return "carrito";  
}
@GetMapping("/crear_cuenta")
public String CrearCuenta() {
    return "crear_cuenta";  
}
@GetMapping("/pura_sangre")
public String Pura_sangre() {
    return "pura_sangre"; 
}
@GetMapping("/login_prin")
public String login_prin() {
    return "login_prin"; 
}
    @GetMapping("/Crud_SaltoAngel")
    public String Crud_SaltoAngel() {
        return "Crud_SaltoAngel";
    }
    @GetMapping("/Crud_index")
    public String Crud_index() {
        return "Crud_index";
    }
    @GetMapping("/Crud_Caballos")
    public String Crud_Caballos() {
        return "Crud_Caballos";
    }


}

