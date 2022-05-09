package service;

import java.util.List;

import model.Reserva;

public interface ReservasService {
	void altaReserva(Reserva reserva);
	List<Reserva> todasReservas();
}
