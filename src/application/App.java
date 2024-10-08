package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Estoque;
import model.entities.Product;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		Estoque estoque = new Estoque();
		
		int num = 1;
		while(num != 0) {
			System.out.println("1 - Adicionar produto");
			System.out.println("2 - Remover produto");
			System.out.println("3 - Atualizar produto");
			System.out.println("4 - Listar todos os produtos");
			System.out.println("0 - Sair");
			num = sc.nextInt();
			sc.nextLine();
			if(num == 0) {
				System.out.println("Programa encerrado! ");
				System.exit(0);
			}
			switch(num) {
				case 1:
					System.out.print("Digite o nome do produto: ");
					String name = sc.nextLine();
					System.out.print("Digite a quantidade inicial: ");
					Integer quantity = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite o valor do produto: ");
					Double price = sc.nextDouble();
					estoque.adicionarProdutos(new Product(name, price), quantity);
					break;
				case 2:
					System.out.print("Digite o produto a ser removido: ");
					String productRemove = sc.nextLine();
					estoque.removeProduto(productRemove);
					break;
					
				case 3:
					System.out.println("Digite o produto a ser atualizado: ");
					String productAtt = sc.nextLine();
					System.out.print("Digite a nova quantidade: ");
					Integer newQuantity = sc.nextInt();
					sc.nextLine();
					estoque.atualizarQuantidade(productAtt, newQuantity);
					break;
					
				case 4:
					estoque.listarProdutos();
					break;
				default:
					System.out.println("Opção invalida!");
					break;
			}
			
		}

	}

}
