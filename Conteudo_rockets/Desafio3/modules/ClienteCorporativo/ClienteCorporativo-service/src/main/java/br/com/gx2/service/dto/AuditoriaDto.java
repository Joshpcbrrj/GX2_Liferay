package br.com.gx2.service.dto;

import java.util.Date;

/**
 * Data Transfer Object (DTO) para Auditoria.
 */
public class AuditoriaDto {

    private long auditoriaId;
    private String usuario; // Mantenha o campo 'usuario' como parte do DTO
    private String acao;
    private Date dataAcao;

    public AuditoriaDto(long auditoriaId, String usuario, String acao, Date dataAcao) {
        this.auditoriaId = auditoriaId;
        this.usuario = usuario;
        this.acao = acao;
        this.dataAcao = dataAcao;
    }

    // Getters e Setters
    public long getAuditoriaId() { return auditoriaId; }
    public void setAuditoriaId(long auditoriaId) { this.auditoriaId = auditoriaId; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getAcao() { return acao; }
    public void setAcao(String acao) { this.acao = acao; }
    public Date getDataAcao() { return dataAcao; }
    public void setDataAcao(Date dataAcao) { this.dataAcao = dataAcao; }

    @Override
    public String toString() {
        return "AuditoriaDto{" +
                "auditoriaId=" + auditoriaId +
                ", usuario='" + usuario + '\'' +
                ", acao='" + acao + '\'' +
                ", dataAcao=" + dataAcao +
                '}';
    }


}
