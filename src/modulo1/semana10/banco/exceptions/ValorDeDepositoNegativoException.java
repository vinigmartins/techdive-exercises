package modulo1.semana10.banco.exceptions;

public class ValorDeDepositoNegativoException extends RuntimeException {
    public ValorDeDepositoNegativoException() {
        super("Valor do depósito deve ser maior que ZERO");
    }
}
