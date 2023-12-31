package exception;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @HAG
 */
@Getter
@Setter
public class Mensaje {

    private String mensaje;

    //constructores
    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
