package entities;

public class Compra {
    private Integer quantidadeItem;
    private Produto produto;

    public Compra() {
    }
    public Compra(Produto produto, Integer quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
        this.produto = produto;
    }

    public Integer getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(Integer quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
