/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO; //Pacote criado para abrigar os getters e setters da aplicação

public class LigacaoDTO {
    
    private Integer numero;
    private String validade;    
    private String Localização;
    private String tipo;
    private Integer id_Ordem;

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the validade
     */
    public String getValidade() {
        return validade;
    }

    /**
     * @param validade the validade to set
     */
    public void setValidade(String validade) {
        this.validade = validade;
    }

    /**
     * @return the localizaçao
     */
    public String getLocalizaçao() {
        return Localização;
    }

    /**
     * @param localizaçao the localizaçao to set
     */
    public void setLocalizaçao(String localizaçao) {
        this.Localização = localizaçao;
    }

    /**
     * @return the ordem
     */
        /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    /**
     * @return the id_Ordem
     */
    public Integer getId_Ordem() {
        return id_Ordem;
    }

    /**
     * @param id_Ordem the id_Ordem to set
     */
    public void setId_Ordem(Integer id_Ordem) {
        this.id_Ordem = id_Ordem;
    }
    
}
