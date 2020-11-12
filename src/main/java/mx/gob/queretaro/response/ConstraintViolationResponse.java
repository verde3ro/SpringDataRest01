package mx.gob.queretaro.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConstraintViolationResponse implements Serializable {

	private static final long serialVersionUID = -4789680610119491655L;
	private String campo;
	private String mensaje;
	private Object valor;

}
