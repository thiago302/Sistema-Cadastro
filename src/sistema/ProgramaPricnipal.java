package sistema;

//Importação das bibliotecas necessárias
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Classe principal do programa
public class ProgramaPricnipal {

	public static void main(String[] args) {
		
		// Inicialização do scanner para entrada de dados do usuário
		Scanner leitor = new Scanner(System.in);
		
		 // Lista para armazenar os produtos cadastrados
		List<Produto> produtos = new ArrayList<>();
		
		// Declaração das variáveis de controle do menu
		int opcao;
		int opcaoAlteracao;
		
		// Loop principal do programa
		do {

			// Impressão do menu principal
			System.out.println("**********************");
			System.out.println(" MENU PRINCIPAL");
			System.out.println("*****************");
			System.out.println();
			System.out.println(" 1 - CADASTRAR PRODUTO");
			System.out.println("2- MOSTRAR TODOS OS PRODUTOS");
			System.out.println("3 - MOSTRAR PRODUTO DESEJADO");
			System.out.println("4 - ALTERAÇÃO NO PRODUTO");
			System.out.println("5 - EXCLUIR PRODUTO");
			System.out.println("6 - SAIR DO SISTEMA");
			System.out.print("Digite a opção desejada: ");

			// Leitura da opção escolhida pelo usuário
			opcao = leitor.nextInt();
			
			// Switch para tratar as opções do menu
			switch (opcao) {

			
			case 1:
				// Opção para cadastrar um novo produto
				System.out.println("**********************");
				System.out.println(" CADASTRANDO PRODUTO");
				System.out.println("*****************");
				System.out.println();
				
				// Leitura dos dados do novo produto
				System.out.println("Códido:");
				int codigo = leitor.nextInt();

				System.out.println("Produto: ");
				String nomeDoProduto = leitor.next();

				System.out.println("Preço: ");
				double preco = leitor.nextDouble();

				// Cria o objeto e insere as informações dentro dele
				Produto prod = new Produto(codigo, nomeDoProduto, preco);
				
				// adiciona o objeto dentro do vetor(simulando o banco de dados)
				produtos.add(prod);

				System.out.println("Produto cadastrado com sucesso!!!");
				break;

			case 2:
				// Opção para mostrar todos os produtos cadastrados
				System.out.println("**********************");
				System.out.println(" MOSTRANDO TODOS OS PRODUTOS");
				System.out.println("*****************");
				
				// Iteração sobre a lista de produtos e impressão na tela
				for (Produto produto : produtos) {

					System.out.println("código:" + produto.getCodigo());
					System.out.println("Produto:" + produto.getProduto());
					System.out.println("Preço:" + produto.getPreco());
					System.out.println("**************");

				}
				break;

			case 3:
				// Opção para mostrar um produto específico
				System.out.println("**********************");
				System.out.println(" MOSTRANDO PRODUTO DESEJADO");
				System.out.println("*****************");
				
				// Leitura do código do produto desejado
				System.out.print("Digite o código do produto desejado: ");
				int codigoDesejado = leitor.nextInt();
				
				// Busca do produto na lista e impressão dos seus dados
				boolean produtoEncontrado = false;
				for (Produto produto : produtos) {
					if (produto.getCodigo() == codigoDesejado) {
						System.out.println("Código: " + produto.getCodigo());
						System.out.println("Produto: " + produto.getProduto());
						System.out.println("Preço: " + produto.getPreco());
						produtoEncontrado = true;
						break; 
					}
				}
				
				// Mensagem de produto não encontrado
				if (!produtoEncontrado) {
					System.out.println("Produto não encontrado.");
				}
				break;

			case 4:
				// Opção para alterar os dados de um produto
				System.out.println("**********************");
				System.out.println(" ALTERANDO PRODUTO ");
				System.out.println("*****************");

				// Leitura do código do produto a ser alterado
				System.out.println("Digite o código do produto a ser alterado: ");
				int codigoAlterado = leitor.nextInt();
				
				// Busca do produto na lista e alteração dos seus dados
				boolean produtoEncontrado2 = false; 
				for (Produto produto : produtos) {
					if (produto.getCodigo() == codigoAlterado) {
						System.out.println("Código: " + produto.getCodigo());
						System.out.println("Produto: " + produto.getProduto());
						System.out.println("Preço: " + produto.getPreco());
						System.out.println();
						System.out.println("O que vai ser alterado?");
						System.out.println(" Se for código, digite 1");
						System.out.println(" Se for produto, digite 2");
						System.out.println(" Se for preço, digite 3");
						opcaoAlteracao = leitor.nextInt();

						// Switch para escolher o que será alterado
						switch (opcaoAlteracao) {
						case 1:
							System.out.println("Digite o novo código: ");
							int novoCodigo = leitor.nextInt();
							produto.setCodigo(novoCodigo);
							System.out.println("Alteração feita com sucesso!!!");

							break;

						case 2:
							System.out.println("Digite o novo produto: ");
							String novoProduto = leitor.next();
							produto.setProduto(novoProduto);
							System.out.println("Alteração feita com sucesso!!!");
							break;

						case 3:
							System.out.println("Digite o novo preco: ");
							double novoPreco = leitor.nextDouble();
							produto.setPreco(novoPreco);
							System.out.println("Alteração feita com sucesso!!!");
							break;
						default:
							System.out.println("Opção inválida");
							break;
						}
						produtoEncontrado2 = true;
						break;
					}
				}

				// Mensagem de produto não encontrado
				if (!produtoEncontrado2) {
					System.out.println("Produto não encontrado.");
				}

				break;
			case 5:
				// Opção para excluir um produto
				System.out.println("**********************");
				System.out.println(" EXCLUINDO PRODUTO ");
				System.out.println("*****************");
				
				// Leitura do código do produto a ser excluído
				System.out.print("Digite o código do produto a ser excluido: ");
				int codigoExcluir = leitor.nextInt();

				// Busca do produto na lista e exclusão do mesmo
				boolean produtoEncontrado3 = false;
				for (Produto produto : produtos) {
					if (produto.getCodigo() == codigoExcluir) {
						System.out.println("Código: " + produto.getCodigo());
						System.out.println("Produto: " + produto.getProduto());
						System.out.println("Preço: " + produto.getPreco());
						
						// Remoção do produto da lista
						produtos.remove(produto);
			            
			            System.out.println("Produto excluído com sucesso.");
			            
						produtoEncontrado3 = true;
						break; 
					}
				}

				// Mensagem de produto não encontrado
				if (!produtoEncontrado3) {
					System.out.println("Produto não encontrado.");
				}
				break;

			case 6:
				// Opção para sair do sistema
				System.out.println("**********************");
				System.out.println(" FINALIZANDO SISTEMA ");
				System.out.println("*****************");
				break;

			default:
				// Mensagem de opção inválida
				System.out.println("**********************");
				System.out.println(" OPÇÃO INVÁLIDA ");
				System.out.println("*****************");
				break;
			}
		} while (opcao != 6); // Loop continua até que o usuário escolha sair do sistema
		leitor.close();// Fechamento do scanner

	}

}
