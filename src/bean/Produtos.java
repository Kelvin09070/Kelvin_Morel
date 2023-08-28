/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Marcos
 */
public class Produtos {
    private int idProdutos;
    private String nome;
    private double valorUnitario;
    private int grupo;

    public Produtos() {
        
    }
    /**
     * @return the idProdutos
     */
    public int getIdProdutos() {
        return idProdutos;
    }

    /**
     * @param idProdutos the idProdutos to set
     */
    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the grupo
     */
    public int getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
    
}
