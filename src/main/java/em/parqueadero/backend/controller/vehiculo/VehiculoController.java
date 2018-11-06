package em.parqueadero.backend.controller.vehiculo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.vehiculo.VehiculoService;
import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

@RestController
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;
	
	@PostMapping("/ingreso/vehiculo/parqueadero")
	public ParqueaderoEntity ingresoVehiculoParqueadero(@Valid @RequestBody VehiculoModel vehiculo) throws PreconditionException {
		return vehiculoService.ingresoVehiculoParqueadero(vehiculo);
	}

	@GetMapping("/salida/vehiculo/parqueadero/{idParqueaderoEntity}")
	public ParqueaderoEntity salidaVehiculoParqueadero(@PathVariable(value="idParqueaderoEntity") int idParqueaderoEntity) throws PreconditionException {
		return vehiculoService.salidaVehiculoParqueadero(idParqueaderoEntity);
	}	
}