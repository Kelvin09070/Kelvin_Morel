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
public class Clientes {

    private int idClientes;
    private String nome;
    private String endereco;
    private String cep;

    /**
     * @return the idClientes
     */
    public int getIdClientes() {
        return idClientes;
    }

    /**
     * @param idClientes the idClientes to set
     */
    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
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
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return getNome();
    }

    public boolean equals(Object object) {
        if (object instanceof Clientes) {
            Clientes clientes = (Clientes) object;
            if (this.getIdClientes() == clientes.getIdClientes()) {
                return true;
            }
        }
        return false;
    }

}
