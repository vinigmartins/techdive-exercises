package modulo1.semana10.banco.exceptions;

public class ContaInexistenteException extends RuntimeException {
    public ContaInexistenteException() {
        super("Conta inexistente");
    }

    public ContaInexistenteException(String message) {
        super(message);
    }
}
