package br.com.gx2.service.dto;

import br.com.gx2.service.enums.PrioridadeEnum;
import br.com.gx2.service.enums.StatusEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SolicitacaoServicoDto {

    @NotNull
    private Long solicitacaoId;

    @NotNull
    @Size(min = 1, max = 255)
    private String codigoUnimed;

    @NotNull
    @Size(min = 1, max = 500)
    private String descricao;

    @NotNull
    private LocalDate dataSolicitacao; // Alterado para LocalDate

    @NotNull
    private StatusEnum status; // Alterado para usar StatusEnum

    @NotNull
    private PrioridadeEnum prioridade; // Alterado para usar PrioridadeEnum

    @NotNull
    private Long clientePJId;

    // Getters e Setters

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public String getCodigoUnimed() {
        return codigoUnimed;
    }

    public void setCodigoUnimed(String codigoUnimed) {
        this.codigoUnimed = codigoUnimed;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    /**
     * Define a data de solicitação, garantindo que esteja no formato DD/MM/YYYY.
     *
     * @param dataSolicitacao a data a ser definida como string
     */
    public void setDataSolicitacao(String dataSolicitacao) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            this.dataSolicitacao = LocalDate.parse(dataSolicitacao, formatter); // Converte a String em LocalDate
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data deve estar no formato DD/MM/YYYY");
        }
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public PrioridadeEnum getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeEnum prioridade) {
        this.prioridade = prioridade;
    }

    public Long getClientePJId() {
        return clientePJId;
    }

    public void setClientePJId(Long clientePJId) {
        this.clientePJId = clientePJId;
    }

    /**
     * Obtém a descrição do status da solicitação.
     *
     * @return a descrição do status
     */
    public String getStatusDescricao() {
        return status.getDescricao(status.getCodigo());
    }

    /**
     * Obtém a descrição da prioridade da solicitação.
     *
     * @return a descrição da prioridade
     */
    public String getPrioridadeDescricao() {
        return prioridade.getDescricao(prioridade.getCodigo());
    }
}
