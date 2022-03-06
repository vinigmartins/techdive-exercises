package modulo1.semana10.banco.exceptions;

public class TransferenciaMesmaContaException extends RuntimeException {
    public TransferenciaMesmaContaException() {
        super("Não pode ser feita transferencia para mesma conta");
    }
}
