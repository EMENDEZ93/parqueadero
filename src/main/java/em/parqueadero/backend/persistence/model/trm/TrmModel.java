package em.parqueadero.backend.persistence.model.trm;

import java.io.Serializable;

public class TrmModel implements Serializable {
	
	private static final long serialVersionUID = 4795754599345805064L;
	
	private float value;

	public float getValue() { 
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
}
