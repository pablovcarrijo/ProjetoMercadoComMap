package model.entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Estoque {

	private Map<Product, Integer> produtos;
	
	public Estoque() {
		this.produtos = new HashMap<>();
	}

	public Map<Product, Integer> getProdutos() {
		return produtos;
	}
	
	public void adicionarProdutos(Product prod, int quantidade) {
		produtos.put(prod, produtos.getOrDefault(prod, 0) + quantidade);
		System.out.println("Produto adicinado com sucesso!");
	}
	
	public void removeProduto(String nome) {
		int flag = 0;
		
		Iterator<Map.Entry<Product, Integer>> iterator = produtos.entrySet().iterator();
		
		while(iterator.hasNext()) {
			Map.Entry<Product, Integer> entry = iterator.next();
			Product prod = entry.getKey();
			
			if(prod.getName().equalsIgnoreCase(nome)) {
				iterator.remove();
				System.out.println("Produto removido com sucesso");
				flag = 1;
				break;
			}
		}
		
		if(flag == 0){
			System.out.println("Produto inexistente");
		}
	}
	
	public void atualizarQuantidade(String nome, int quantidade) {
		int flag = 0;
		for(Product prod : produtos.keySet()) {
			if(prod.getName().equals(nome)) {
				produtos.put(prod, quantidade);
				System.out.println("Quantidade atualizada no estoque");
			}
		}
		if(flag == 1) {
			System.out.println("Produto não encontrado");
		}
	}
	
	public void listarProdutos() {
		System.out.println("Produtos no sistema: ");
		for(Product prod : produtos.keySet()) {
			System.out.println(prod + " : " + produtos.get(prod));
		}
	}
	
}
