package br.com.gx2.service.enums;

public enum PrioridadeEnum {
    BAIXA(1),  // Prioridade baixa
    MEDIA(2),  // Prioridade média
    ALTA(3);   // Prioridade alta

    private final int codigo; // Código associado à prioridade

    PrioridadeEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo; // Retorna o código da prioridade
    }

    // Método para obter a descrição da prioridade
    public static String getDescricao(int codigo) {
        switch (codigo) {
            case 1: return "Baixa"; // Descrição para código 1
            case 2: return "Média"; // Descrição para código 2
            case 3: return "Alta"; // Descrição para código 3
            default: throw new IllegalArgumentException("Código inválido para Prioridade."); // Lança exceção para códigos inválidos
        }
    }

    // Método para converter código em PrioridadeEnum
    public static PrioridadeEnum fromCodigo(int codigo) {
        for (PrioridadeEnum prioridade : PrioridadeEnum.values()) {
            if (prioridade.getCodigo() == codigo) {
                return prioridade;
            }
        }
        throw new IllegalArgumentException("Código inválido para Prioridade: " + codigo);
    }
}
