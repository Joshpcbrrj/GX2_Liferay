package br.com.gx2.service.validator;

import br.com.gx2.service.enums.StatusEnum;

public class StatusEnumValidator {

    // Método para validar o código de status
    public static void validate(int status) {
        if (status < 1 || status > 3) {
            throw new IllegalArgumentException("Status inválido. Valores permitidos: 1 (Aberto), 2 (Aguardando), 3 (Fechado).");
            // Lança exceção se o código não estiver no intervalo válido
        }
    }
}
