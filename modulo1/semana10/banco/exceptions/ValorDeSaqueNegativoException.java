package modulo1.semana10.banco.exceptions;

public class ValorDeSaqueNegativoException extends RuntimeException {
    public ValorDeSaqueNegativoException() {
        super("Valor de saque deve ser maior que ZERO");
    }
}
