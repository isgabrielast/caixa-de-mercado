package application;
import entities.Caixa;
import entities.Compra;
import entities.Produto;
import entities.enums.TipoPagamento;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.print("Qual será o tipo de Pagamento? ");
        String tipoPagamento = input.nextLine();

        System.out.println();

        Caixa caixa = new Caixa(LocalDateTime.now(), TipoPagamento.valueOf(tipoPagamento));

        System.out.print("Quantos produtos você irá comprar? ");
        int numeroProdutos = input.nextInt();
        input.nextLine();

        System.out.println();

        //Instanciei o objeto aqui para poder mostrar o valor da compra no final do código.
        Compra compra = null;

        for (int i = 0; i < numeroProdutos; i++) {
            System.out.print("Digite o nome do produto: ");
            String nomeProduto = input.nextLine();

            System.out.print("Digite o preço do produto: ");
            double precoProduto = input.nextDouble();
            input.nextLine();

            System.out.println();

            compra = new Compra(new Produto(nomeProduto, precoProduto), numeroProdutos);
            caixa.addCompra(compra);
        }

        System.out.println();

        System.out.printf("Data da compra: %s%nTipo de pagamento: %s%n",
                caixa.getDataCompra().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
                caixa.getTipoPagamento());

        System.out.print("Produtos comprados: ");
        for (Compra comp : caixa.getCompras()) {
            System.out.print(comp.getProduto().getNome() + " ");
        }

        System.out.println();

        System.out.print("Valor total da compra: ");
        System.out.printf("R$%.2f",caixa.total(compra));

        input.close();
    }
}