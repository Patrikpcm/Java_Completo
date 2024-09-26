package OO.tratamento_excecoes.excecoes_personalizadas.solucao_boa.exceptions;

public class DomainException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Esse construtor permite que eu consiga instanciar minha classe
     * DomainException passando uma mensagem personalizada que será
     * transmitida para super classe.
     */
    public DomainException(String msg){
        super(msg);
    }
}
