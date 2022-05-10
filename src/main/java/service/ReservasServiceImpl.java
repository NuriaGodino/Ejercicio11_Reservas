package service;


import java.util.List;

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

	@Override
	public List<Reserva> todasReservas() {
		return reservasDao.findAll();
	}

	@Override
	public void altaReserva(Reserva reserva, int plazas) {
		//Vuelo[] vuelos = template.getForObject(urlBase, Vuelo[].class);
		reservasDao.save(reserva);
		//List<Vuelo> vuelo = Arrays.stream(vuelos).filter(x -> x.getIdVuelo() == reserva.getVuelo()).collect(Collectors.toList());
		template.put(urlBase+"/Vuelo/{idVuelo}/{plazas}",Vuelo[].class ,reserva.getVuelo(), plazas);
		
	}
	
}
