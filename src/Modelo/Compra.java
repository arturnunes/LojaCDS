package Modelo;


public class Compra {

private int codigo ;
private String titulo_cd;
private String nome;
private String fpagamento;
private String tpagamento;
private String endereco;
private String envio;

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo_cd() {
        return titulo_cd;
    }

    public void setTitulo_cd(String titulo_cd) {
        this.titulo_cd = titulo_cd;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFpagamento() {
        return fpagamento;
    }

    public void setFpagamento(String fpagamento) {
        this.fpagamento = fpagamento;
    }

    public String getTpagamento() {
        return tpagamento;
    }

    public void setTpagamento(String tpagamento) {
        this.tpagamento = tpagamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
