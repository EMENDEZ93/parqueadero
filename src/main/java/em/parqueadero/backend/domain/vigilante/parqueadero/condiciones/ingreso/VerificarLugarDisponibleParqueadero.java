package em.parqueadero.backend.domain.vigilante.parqueadero.condiciones.ingreso;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;

public interface VerificarLugarDisponibleParqueadero {

	public boolean verificarLugarDisponibleParqueo() throws PreconditionException;
	
}
