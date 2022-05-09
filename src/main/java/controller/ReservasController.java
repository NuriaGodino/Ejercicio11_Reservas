package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Reserva;
import service.ReservasService;

@RestController
public class ReservasController {
	@Autowired
	ReservasService service;
	
//	@PostMapping(value = "Reserva", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void altaReserva(@RequestBody int idReserva, @RequestBody String nombre, @RequestBody String dni, @RequestBody int hotel, @RequestBody int vuelo) {
//		service.altaReserva(idReserva, nombre, dni, hotel, vuelo);
//	}
	
	@GetMapping(value = "Reserva", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> todasReservas(){
		return service.todasReservas();
	}
	
	@PostMapping(value = "Reserva", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaReserva(@RequestBody Reserva reserva) {
		service.altaReserva(reserva);
	}
}
