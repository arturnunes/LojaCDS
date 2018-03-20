package Modelo;

public class Carrinho {

private String nome;
private int codigo_cd;
private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public int getCodigo_cd() {
        return codigo_cd;
    }

    public void setCodigo_cd(int codigo_cd) {
        this.codigo_cd = codigo_cd;
    }
}
