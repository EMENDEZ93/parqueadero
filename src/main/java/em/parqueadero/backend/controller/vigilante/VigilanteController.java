package em.parqueadero.backend.controller.vigilante;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.parqueadero.backend.domain.dto.factura.FacturaDto;
import em.parqueadero.backend.domain.dto.registrovehiculoparqueadero.VehiculosParqueadosDto;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vigilante.VigilanteService;
import em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso.ObtenerVehiculosParqueados;

@CrossOrigin
@RestController
public class VigilanteController {

	@Autowired
	private VigilanteService vigilante;

	@Autowired
	private ObtenerVehiculosParqueados vehiculosParqueados;

	@PostMapping("/registro/ingreso/vehiculo/parqueadero")
	public void ingresoVehiculoParqueadero(@Valid @RequestBody VehiculoDto vehiculo) throws PreconditionException {
		vigilante.ingresoVehiculoParqueadero(vehiculo);
	}	
	
	@GetMapping("/registro/salida/vehiculo/parqueadero/{idParqueaderoEntity}")
	public FacturaDto salidaVehiculoParqueadero(
			@PathVariable(value = "idParqueaderoEntity") int idParqueaderoEntity) throws PreconditionException {
		return vigilante.salidaVehiculoParqueadero(idParqueaderoEntity);
	}

	@GetMapping("/vehiculos/parqueados")
	public List<VehiculosParqueadosDto> getVehiculosParqueados() {
		return vehiculosParqueados.obtenerVehiculosParqueados();
	}

}
