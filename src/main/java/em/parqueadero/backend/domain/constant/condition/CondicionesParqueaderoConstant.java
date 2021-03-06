package em.parqueadero.backend.domain.constant.condition;

public final class CondicionesParqueaderoConstant {

	private CondicionesParqueaderoConstant() {
		throw new IllegalStateException("VehiculoConstant class");
	}
	
	public static final String MOTO = "Moto";
	public static final String CARRO = "Carro";
	public static final int LIMITE_CARROS_PARQUEADOS = 20;
	public static final int LIMITE_MOTOS_PARQUEADAS = 10;
	public static final int HORAS_MINIMA_PARA_GENERAR_COBRO_POR_DIA = 9;
	public static final int HORAS_AL_DIA = 24;
	public static final int CILINDRAJE_LIMITE_SIN_RECARGO = 500;
	public static final double COSTO_RECARGO_CILINDRAJE = 2000;
	public static final String LETRA_INICIAL = "A";
	public static final int MENOS_DE_UN_DIA = 0;
}
