package em.parqueadero.backend.persistence.builder.vehiculo;

import static org.junit.Assert.*;

import org.junit.Test;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.domain.constant.exception.VehiculoConstant;
import em.parqueadero.backend.domain.dto.vehiculo.VehiculoDto;
import em.parqueadero.backend.domain.vigilante.parqueadero.moto.MotoServiceImpl;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

public class VehiculoBuilderTest {

	@Test
	public void convertirVehiculoModelAEntityTest() {
	
		// arrange
		VehiculoDto vehiculoModel = new VehiculoTestDataBuilder().buildModel();
		VehiculoEntity vehiculoEntity = null;
		
		// act
		vehiculoEntity = VehiculoBuilder.convertirVehiculoModelAEntity(vehiculoModel);
	
		assertTrue(vehiculoEntity instanceof VehiculoEntity);
	
	}

	@Test
	public void convertirVehiculoModelAEntityNullTest() {
	
		// arrange
		VehiculoDto vehiculoModel = null;
		VehiculoEntity vehiculoEntity = null;
		
		// act
		vehiculoEntity = VehiculoBuilder.convertirVehiculoModelAEntity(vehiculoModel);
	
		assertTrue(vehiculoEntity == null);
	
	}	
	
	@Test
	public void convertirVehiculoEntityAModelTest() {
	
		// arrange
		VehiculoEntity vehiculoEntity= new VehiculoTestDataBuilder().buildEntity();
		VehiculoDto vehiculoModel = null;
		
		// act
		vehiculoModel = VehiculoBuilder.convertirVehiculoEntityAModel(vehiculoEntity);
	
		assertTrue(vehiculoModel instanceof VehiculoDto);
	
	}	

	@Test
	public void convertirVehiculoEntityAModelNullTest() {
	
		// arrange
		VehiculoEntity vehiculoEntity= null;
		VehiculoDto vehiculoModel = null;
		
		// act
		vehiculoModel = VehiculoBuilder.convertirVehiculoEntityAModel(vehiculoEntity);
	
		assertTrue(vehiculoModel == null);
	
	}
}
