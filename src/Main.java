import java.util.ArrayList;
import java.util.Scanner;

// Classe para o Produto
class Produto {
    private String nome;
    private double preco;

    // Construtor dos atributos
    public Produto (String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    //Getters
    public String getNome(){
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    //Método to String
    @Override
    public String toString(){
        return "Nome: " + nome + ", Preço: R$" + preco;
    }
}

//Classe para Gerenciar os Produtos
class GerenciadorDeProdutos {
    private ArrayList<Produto> produtos;

    //Método construtor do ArrayList
    public GerenciadorDeProdutos(){
        produtos = new ArrayList<>();
    }

    //Método para adicionar produtos
    public void adicionarProduto(String nome, double preco){
        produtos.add(new Produto(nome, preco));
        System.out.println("Produto adicionado com sucesso!");
    }

    //Método para exibir os Produtos
    public void exibirProdutos(){
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        }else {
            System.out.println("Produtos cadastrados: ");
            for (Produto produto : produtos){
                System.out.println(produto);
            }
        }
    }

    //Mpetodo para excluir produto(s)
    public void excluirProduto(String nome){
        boolean encontrado = false;
        for(int i = 0; i < produtos.size(); i++){
            if (produtos.get(i).getNome().equalsIgnoreCase(nome)){
                produtos.remove(i);
                encontrado = true;
                System.out.println("Produto excluido com sucesso!");
                break;
            }
        }
        if (!encontrado){
            System.out.println("Produto não encontrado.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        GerenciadorDeProdutos gereciador = new GerenciadorDeProdutos();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Exibir todos os produtos");
            System.out.println("3. Excluir produto pelo nome");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao){
                case 1:
                    System.out.println("Digite o nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o preço do produto");
                    double preco = Double.parseDouble(sc.nextLine());
                    gereciador.adicionarProduto(nome, preco);
                    break;
                case 2:
                    gereciador.exibirProdutos();
                    break;
                case 3:
                    System.out.println("Digite o nome do produto que deseja excluir: ");
                    String nomeParaExcluir = sc.nextLine();
                    gereciador.excluirProduto(nomeParaExcluir);
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);
    }
}