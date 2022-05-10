package service;

import java.util.List;

import model.Reserva;

public interface ReservasService {
	void altaReserva(Reserva reserva, int plazas);
	List<Reserva> todasReservas();
}
