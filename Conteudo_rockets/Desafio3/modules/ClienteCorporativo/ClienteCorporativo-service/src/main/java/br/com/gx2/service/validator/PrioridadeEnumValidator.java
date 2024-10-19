package br.com.gx2.service.validator;

import br.com.gx2.service.enums.PrioridadeEnum;

public class PrioridadeEnumValidator {

    // Método para validar o código de prioridade
    public static void validate(int prioridade) {
        if (prioridade < 1 || prioridade > 3) {
            throw new IllegalArgumentException("Prioridade inválida. Valores permitidos: 1 (Baixa), 2 (Média), 3 (Alta).");
            // Lança exceção se o código não estiver no intervalo válido
        }
    }
}
