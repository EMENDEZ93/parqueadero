package em.parqueadero.backend.domain.vehiculo.factory.carro;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.model.vehiculo.VehiculoModel;

@RunWith(SpringRunner.class)
public class CarroServiceTest {

	@MockBean
	private CarroServiceImpl carroService;

	private CarroServiceImpl carroServiceImpl;

	@Before
	public void setUp() {
		carroServiceImpl = new CarroServiceImpl();
	}

	@Test
	public void lugarDisponibleParqueoCarroTest() throws PreconditionException {

		// arrange
		when(carroService.lugarDisponibleParqueo()).thenReturn(true);

		// act
		boolean lugarDisponibleCarro = carroService.lugarDisponibleParqueo();

		// assert
		assertTrue(lugarDisponibleCarro);

	}

	@Test
	public void lugarNoDisponibleParqueoCarroTest() throws PreconditionException {

		// arrange
		when(carroService.lugarDisponibleParqueo())
				.thenThrow(new PreconditionException(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_CARRO));

		try {

			// act
			carroService.lugarDisponibleParqueo();

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.NO_HAY_LUGAR_DISPONIBLE_CARRO, e.getMessage());

		}

	}

	@Test
	public void validarDatosVehiculoTipoCarro() throws PreconditionException {

		// arrange
		VehiculoModel carro = new VehiculoTestDataBuilder().build();

		// act
		boolean datosValidos = carroServiceImpl.isValid(carro);

		// assert
		assertTrue(datosValidos);

	}

	@Test
	public void placaNoValidaCarro() throws PreconditionException {

		// arrange
		VehiculoModel carro = new VehiculoTestDataBuilder().setPlaca("").build();

		try {

			// act
			carroServiceImpl.isValid(carro);

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.PLACA_NO_VALIDA, e.getMessage());

		}
	}

	@Test
	public void tipoVehiculoNoValidoVacioCarro() throws PreconditionException {

		// arrange
		VehiculoModel carro = new VehiculoTestDataBuilder().setTipoVehiculo("").build();

		try {

			// act
			carroServiceImpl.isValid(carro);

		} catch (PreconditionException e) {

			// assert
			assertEquals(ConstantExcep.TIPO_VEHICULO_NO_VALIDO, e.getMessage());

		}
	}
	
}