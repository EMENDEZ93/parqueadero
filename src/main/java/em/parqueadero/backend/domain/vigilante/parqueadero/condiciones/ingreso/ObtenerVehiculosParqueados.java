package em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso;

import java.util.List;

import em.parqueadero.backend.domain.dto.registrovehiculoparqueadero.VehiculosParqueadosDto;

public interface ObtenerVehiculosParqueados {

	public List<VehiculosParqueadosDto> obtenerVehiculosParqueados();
	
}
