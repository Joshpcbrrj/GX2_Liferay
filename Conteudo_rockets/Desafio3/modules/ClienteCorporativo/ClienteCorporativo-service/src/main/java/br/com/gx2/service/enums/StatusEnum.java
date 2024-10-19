package br.com.gx2.service.enums;

public enum StatusEnum {
    ABERTO(1),   // Status aberto
    AGUARDANDO(2), // Status aguardando
    FECHADO(3);  // Status fechado

    private final int codigo; // Código associado ao status

    StatusEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo; // Retorna o código do status
    }

    // Método para obter a descrição do status
    public static String getDescricao(int codigo) {
        switch (codigo) {
            case 1: return "Aberto"; // Descrição para código 1
            case 2: return "Aguardando"; // Descrição para código 2
            case 3: return "Fechado"; // Descrição para código 3
            default: throw new IllegalArgumentException("Código inválido para Status."); // Lança exceção para códigos inválidos
        }
    }

    // Método para converter código em StatusEnum
    public static StatusEnum fromCodigo(int codigo) {
        for (StatusEnum status : StatusEnum.values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código inválido para Status: " + codigo);
    }
}
