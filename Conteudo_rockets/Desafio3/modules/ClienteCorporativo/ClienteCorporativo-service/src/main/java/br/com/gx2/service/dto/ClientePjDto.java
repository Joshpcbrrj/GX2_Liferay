package br.com.gx2.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DTO para transferência de dados do Cliente PJ.
 */
public class ClientePjDto {

    // Identificação do Cliente PJ
    @NotNull(message = "O ID do cliente PJ é obrigatório.")
    private Long clientePJId;

    // A razão social deve ser preenchida e ter um tamanho adequado
    @NotNull(message = "A razão social é obrigatória.")
    @Size(min = 1, max = 255, message = "A razão social deve ter entre 1 e 255 caracteres.")
    private String razaoSocial;

    // O CNPJ deve seguir o padrão com 14 caracteres (sem pontuação)
    @NotNull(message = "O CNPJ é obrigatório.")
    @Size(min = 14, max = 14, message = "O CNPJ deve ter 14 caracteres, sem pontuação.")
    private String cnpj;


    // Getters e Setters

    // ClientePJId - Identificação única
    public Long getClientePJId() {
        return clientePJId;
    }

    public void setClientePJId(Long clientePJId) {
        this.clientePJId = clientePJId;
    }

    // Razão Social - Nome legal do cliente PJ
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    // CNPJ - Cadastro Nacional da Pessoa Jurídica
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
