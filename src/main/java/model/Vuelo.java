package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vuelo {
	private int idVuelo;
	private String company;
	private String fecha;
	private double precio;
	private int plazas;
}
