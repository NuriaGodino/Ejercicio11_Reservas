package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;
import model.Vuelo;

@Service
public class ReservasServiceImpl implements ReservasService{

	ReservasDao reservasDao;
	RestTemplate template;
	String urlBase = "http://localhost:8080";
	
	
	public ReservasServiceImpl(@Autowired ReservasDao reservasDao, @Autowired RestTemplate template) {
		super();
		this.reservasDao = reservasDao;
		this.template = template;
	}
	
//	@Override
//	public void altaReserva(int idReserva, String nombre, String dni, int hotel, int vuelo) {
//		Reserva reserva = new Reserva(idReserva, nombre, dni, hotel, vuelo);
//		template.postForLocation(urlBase, reserva);
//		reservasDao.save(reserva);
//	}

	@Override
	public List<Reserva> todasReservas() {
		return reservasDao.findAll();
	}

	@Override
	public void altaReserva(Reserva reserva) {
		Vuelo[] vuelos = template.getForObject(urlBase, Vuelo[].class);
		reservasDao.save(reserva);
		List<Vuelo> vuelo = Arrays.stream(vuelos).filter(x -> x.getIdVuelo() == reserva.getVuelo()).collect(Collectors.toList());
		template.put(urlBase+"/Vuelo/{idVuelo}/{plazas}", vuelo.get(0).getIdVuelo(), vuelo.get(0).getPlazas()-1);
		
	}
	
}
