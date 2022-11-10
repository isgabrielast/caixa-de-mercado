package entities;
import entities.enums.TipoPagamento;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Caixa {
    private LocalDateTime dataCompra;
    private TipoPagamento tipoPagamento;

   List<Compra> compras = new ArrayList<>();

    public Caixa() {
    }

    public Caixa(LocalDateTime dataCompra, TipoPagamento tipoPagamento) {
        this.dataCompra = dataCompra;
        this.tipoPagamento = tipoPagamento;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }


    public List<Compra> getCompras() {
        return compras;
    }
    public void addCompra(Compra listCompra){
        this.compras.add(listCompra);
    }

    public void removerCompra(Compra listCompra){
        this.compras.remove(listCompra);
    }
    public Double total(Compra compra){
        double sum = 0;
        for (Compra comp : compras) {
            sum += comp.getProduto().getPreco() * comp.getQuantidadeItem();
        }
        return sum;
    }
}
