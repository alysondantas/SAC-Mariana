package br.uefs.ecomp.sacMariana.view;

/*******************************************************************************

Autor: Alyson Felipe Oliveira Dantas

Componente Curricular: MI - Algoritmos II

Concluido em: 12/12/2015

Declaro que este código foi elaborado por mim de forma individual e não contém nenhum

trecho de código de outro colega ou de outro autor, tais como provindos de livros e

apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código

de outra autoria que não a minha está destacado com uma citação para o autor e a fonte

do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.

******************************************************************************************/

import br.uefs.ecomp.sacMariana.util.Console;//importo conssole
import br.uefs.ecomp.sacMariana.controller.SACMarianaController;//importo o controle para usar os metodos dele
import br.uefs.ecomp.sacMariana.util.PegaData;//importo o PegaData
import java.io.IOException;
import java.util.Date;//Importo util.Date para usar variaveis do tipo Date
import br.uefs.ecomp.sacMariana.model.Produto;//importo produto
import br.uefs.ecomp.sacMariana.model.Doacao;//importo doacao
import br.uefs.ecomp.sacMariana.model.Doador;//importo doador
import br.uefs.ecomp.sacMariana.model.MeuIterador;//importo Meu Iterador
/**
 * @author Alyson Dantas
 *Classe menu para a main, menu principal e view
 */
public class Menu {
/**
 * Metodo static main para o menu principal
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {
		SACMarianaController controle = new SACMarianaController();//instancio um controller para usar os metodos
		int opcao = 1;//variavel para as opções do menu
		Doador doador;//variavel do doador
		Produto produto;//variavel do produto
		Doacao doacao;//variavel da doação
		int idProduto;//id do produto
		Number qtd;//quantidade da doação
		String numCadastro;//numero de cadastro do doador
		boolean tipoMonetario=false;//tipo monetario thrue=sim ou false=não da doação
		Date data;//variavel para as datas
		int escolha=0;//variavel para as escolhas semelhante a opção
		MeuIterador iterador;//varivel do iterador

		while(opcao!=0){//while que deixa o menu sempre rodando ate o usuario escolher sair opção 0
			System.out.println("============MENU-SAC-Mariana============");
			System.out.print("Você deseja:\n	1-Cadatrar Produto.\n	2-Alterar Produto:\n	3-Remover Produto.\n	4-Listar Produtos.\n	5-Cadastrar Doador.\n	6-Alterar Doador.\n	7-Remover Doador.\n	8-Listar Doadores.\n	9-Inserir doação.\n	10-Alterar doação.\n	11-Remover doação\n	12-Listar doações\n	13-Listar doações de um doador.\n	14-Listar Doadores e respectivo percentual de doação\n	0-Para sair\n");
			opcao = Console.readShort();//faz leitura da opção
			switch(opcao)//switch verifica a opção e joga nos casos(UserStorys)
			{
			case 0://opção de sair
				System.out.println("Finalizado!");
				break;
			case 1://opção de cadastrar produto
				System.out.println("Digite as informações do produto a ser cadastrado na seguinte ordem: nome,tipo (alimento, vestuário, limpeza, monetaria ou outro),data de cadastro.");
				//usuario digitara sequencialmente as informações e vai passar para o metodo do controle
				//leitura é pelos metodos do Console
				//if serve de verificação se diferente de null ou true é pq realizou com sucesso a ação se não mensagem de erro é exibida
				if(controle.cadastrarProduto(Console.readString(), Console.readString(), (Date)PegaData.pegaData())!=null){
					System.out.println("Cadastrado!");
				}else{
					System.out.println("Não foi cadastrado!");
				}
				break;
			case 2://opção de alterar produto
				System.out.println("Insira o id do produto que deseja alterar em seguida o nome,tipo (alimento, vestuário, limpeza, monetaria ou outro) e data de cadastro.");
				//usuario digitara sequencialmente as informações e vai passar para o metodo do controle
				//leitura é pelos metodos do Console
				//if serve de verificação se diferente de null ou true é pq realizou com sucesso a ação se não mensagem de erro é exibida
				if(controle.editarProduto(Console.readInt(), Console.readString(), Console.readString(), (Date)PegaData.pegaData())!=null){
					System.out.println("Alterado com sucesso!");
				}else{
					System.out.println("Erro na alteração!");
				}
				break;
			case 3://opção 3 é remoção de produto
				System.out.println("Diga qual o produto a remover pelo ID:");
				//usuario digitara sequencialmente as informações e vai passar para o metodo do controle
				//leitura é pelos metodos do Console
				//if serve de verificação se diferente de null ou true é pq realizou com sucesso a ação se não mensagem de erro é exibida
				if(controle.removerProduto(Console.readInt())==true){
					System.out.println("Removido com sucesso!");
				}else{
					System.out.println("Não foi possivel remover!");
				}
				break;
			case 4://opção de listar produtos
				produto=null;//utilizo variavel previamente cadastrada dando null a ela
				iterador=null;//utilizo variavel previamente cadastrada dando null a ela
				iterador = (MeuIterador) controle.listarProdutos();//iterador recebe a primeira celula pelo metodo do controle
				while(iterador.temProximo()){//enquanto existir um proximo
					produto=(Produto) iterador.obterProximo();//produto recebe o objeto e iterador passa ao prixmo
					produto.mostarProduto();//metodo de mostrar produto é chamado
				}
				break;
			case 5://opção de cadastrardoador
				System.out.println("Digite as informações do doador a ser cadastrado na seguinte ordem: numero de cadastro(cpf ou cnpj),nome,data de nascimento, endereço (rua,numero,bairro,cep,cidade,uf,pais) e tipo(física ou jurídica).");
				//usuario digitara sequencialmente as informações e vai passar para o metodo do controle
				//leitura é pelos metodos do Console
				//if serve de verificação se diferente de null ou true é pq realizou com sucesso a ação se não mensagem de erro é exibida
				if(controle.cadastrarDoador(Console.readString(), Console.readString(), (Date)PegaData.pegaData(), Console.readString(), Console.readShort(), Console.readString(), Console.readString(), Console.readString(), Console.readString(), Console.readString(),Console.readString())!=null){
					System.out.println("Cadastrado!");
				}else{
					System.out.println("Não foi cadastrado!");
				}
				break;
			case 6://opção de alterar doador
				System.out.println("Insira o numero de cadastro(cpf ou cnpj) do doador que deseja alterar em seguida na seguinte ordem: nome,data de nascimento, endereço (rua,numero,bairro,cep,cidade,uf,pais) e tipo(física ou jurídica.");
				//usuario digitara sequencialmente as informações e vai passar para o metodo do controle
				//leitura é pelos metodos do Console
				//if serve de verificação se diferente de null ou true é pq realizou com sucesso a ação se não mensagem de erro é exibida
				if(controle.editarDoador(Console.readString(), Console.readString(), (Date)PegaData.pegaData(), Console.readString(), Console.readInt(), Console.readString(), Console.readString(), Console.readString(), Console.readString(), Console.readString(), Console.readString())!=null){
					System.out.println("Alterado com sucesso!");
				}else{
					System.out.println("Erro na alteração!");
				}
				break;
			case 7://opção de remover doador por numero de cadastro
				System.out.println("Diga qual o produto a remover pelo Numero de cadastro(cpf ou cnpj):");
				//usuario digitara sequencialmente as informações e vai passar para o metodo do controle
				//leitura é pelos metodos do Console
				//if serve de verificação se diferente de null ou true é pq realizou com sucesso a ação se não mensagem de erro é exibida
				if(controle.removerDoador(Console.readString())==true){
					System.out.println("Removido com sucesso!");
				}else{
					System.out.println("Não foi possivel remover!");
				}
				break;
			case 8://opção de listar doadores
				iterador=null;//utilizo variavel previamente criada
				doador=null;//utilizo variavel previamente criada
				iterador = (MeuIterador) controle.listarDoadores();//iterador recebe a primeira cela pelo metodo listar 
				while(iterador.temProximo()){//enquanto existir um proximo
					doador=(Doador) iterador.obterProximo();//doador recebe celula atual e iterador passa pro proximo 
					doador.mostarDoador();//chama metodo de mostrar doadores
				}
				break;
			case 9://opção de inserir doação
				produto=null;//uso de variavel previamente criada
				doador=null;//uso de variavel previamente criada
				qtd=0;//uso de variavel previamente criada
				idProduto=0;//uso variavel previamente criada
				numCadastro=null;//uso de variavel previamente criada
				data=null;//uso de variavel previamente criada
				tipoMonetario=false;//uso de variavel previamente criada
				escolha=0;//uso de variavel previamente criada
				System.out.println("Diga o Numero de cadastro(cpf ou cnpj) do doador que realiza a doação:");
				//leio numero de cadastro atravez do metodo do console
				numCadastro=Console.readString();
				System.out.println("Diga o ID do produto doado:");
				//leio ido do produto atravez do metodo do console
				idProduto=Console.readInt();
				doador=controle.obterDoador(numCadastro);//doador recebe o doador informado
				produto=controle.obterProduto(idProduto);//produto recebe o produto informado
				//todos dois atravez do metodod do controle de obter
				if(doador==null || produto==null){//se um dos dois for nulo(não for encontrado o processo é interrompido
					System.out.println("Erro! Doador ou produto não encontrado!");
					break;
				}
				System.out.println("Diga a quantidade da doação e a data:");
				qtd=Console.readDouble();//qtd recebe a qtd da doação
				data=(Date)PegaData.pegaData();//data recebe a data de doação
				System.out.println("A doacao é monetaria? 0-sim 1-não");
				escolha=Console.readInt();//variavel para verificar se a doação é monetaria ou não
				if(escolha==0){//se 0(sim) TipoMonetario recebe true
					tipoMonetario=true;
				}else{//se não recebe false
					tipoMonetario=false;
				}
				//if serve de verificação se diferente de null ou true é pq realizou com sucesso a ação se não mensagem de erro é exibida
				if(controle.efetuarDoacao(doador, produto, qtd, data, tipoMonetario)!=null){
					System.out.println("Doaçao inserida com sucesso!");
				}else{
					System.out.println("Não foi possivel inserir doação!");
				}
				break;
			case 10://opção para alterar doação
				int idDoacao;//crio uma variavel para o id da doação
				produto=null;//uso variavel previamente criada
				doador=null;//uso de variavel previamente criada
				qtd=0;//uso de variavel previamente criada
				idProduto=0;//uso de variavel previamente criada
				numCadastro=null;//uso de variavel previamente criada
				tipoMonetario=false;//uso de variavel previamente criada
				data=null;//uso de variavel previamente criada
				escolha=0;//uso de variavel previamente criada
				System.out.println("Diga o ID da doação a ser alterada:");
				idDoacao=Console.readInt();//leitura do id da doação atravez do console
				System.out.println("Diga o Numero de cadastro(cpf ou cnpj) do doador que realiza a doação:");
				numCadastro=Console.readString();//leitura do numero de cadastro atravez do console
				System.out.println("Diga o ID do produto doado:");
				idProduto=Console.readInt();//leitura do id do produto atravez do console
				doador=controle.obterDoador(numCadastro);//doador recebe o doador informado pelo metodo do controle obterdoador que é passado pelo numero de cadastro
				produto=controle.obterProduto(idProduto);//produto recebe o produto informado pelo metodo do controle obterdoador que é passado pelo id do produto
				if(doador==null || produto==null){//se doador ou produto for null o processo é interrompido
					System.out.println("Erro! Doador ou produto não encontrado!");
					break;
				}
				System.out.println("Diga a quantidade da doação e a data:");
				qtd=Console.readDouble();//qtd recebe quantidade da doação atravezdo do metodo do console
				data=(Date)PegaData.pegaData();//data recebe a data travez do metodo PegaData
				System.out.println("A doacao é monetaria? 0-sim 1-não");
				escolha=Console.readInt();//escolha é recebida atravez do metodo de console
				if(escolha==0){//se 0 tipoMonetario recebe true
					tipoMonetario=true;
				}else{//se não recebe false
					tipoMonetario=false;
				}
				//if serve de verificação se diferente de null ou true é pq realizou com sucesso a ação se não mensagem de erro é exibida
				if(controle.alterarDoacao(idDoacao, doador, produto, qtd, data, tipoMonetario)!=null){
					System.out.println("Doaçao alterada com sucesso!");
				}else{
					System.out.println("Não foi possivel alterar doação!");
				}
				break;
			case 11://opção de remover doação
				System.out.println("Diga qual o doação a remover pelo ID:");
				//usuario digitara sequencialmente as informações e vai passar para o metodo do controle
				//leitura é pelos metodos do Console
				//if serve de verificação se diferente de null ou true é pq realizou com sucesso a ação se não mensagem de erro é exibida
				if(controle.removerDoacao(Console.readInt())==true){
					System.out.println("Removido com sucesso!");
				}else{
					System.out.println("Não foi possivel remover!");
				}
				break;
			case 12://opção de listar doações
				escolha=0;//varivel para escolha de se por monetaria ou nao
				tipoMonetario=false;//variavel boolean para saber se é do tipo monetario
				doador=null;//uso de variavel previamente criada
				doacao=null;//uso de variavel previamente criada
				iterador=null;//uso de variavel previamente criada
				System.out.print("Tipo de listagem é por ordem monetaria? 0-sim 1-não:");
				escolha=Console.readInt();//escolha recebe a opção do usuario pelo metodo do console
				if(escolha==0){//se for 0 TipoMonetario recebe true
					tipoMonetario=true;
				}else{//se não tipo monetario recebe false
					tipoMonetario=false;
				}
				iterador = (MeuIterador) controle.listarDoacoesOrdenadas(tipoMonetario, doador);//iterador recebe uma lista ja ordenada por meio do controle que recebeu o tipoMonetario e objeto doador
				if(iterador!=null){//se existir lista
					while(iterador.temProximo()){//enquanto existir proximo
						doacao=(Doacao) iterador.obterProximo();//doação recebe celula atual e iterador passa pro proximo
						doacao.mostarDoacao();//metodo de mostrar doação é chamado
					}
				}
				break;
			case 13://opção de mostrar doação de um doador
				escolha=0;//escolha se monetario ou não
				tipoMonetario=false;//uso de variavel previamente cadastrada
				doador=null;//uso de variavel previamente cadastrada
				doacao=null;//uso de variavel previamente cadastrada
				numCadastro=null;//uso de variavel previamente cadastrada
				iterador=null;//uso de variavel previamente cadastrada
				System.out.println("Diga o Numero de cadastro do doador que realiza a doação:");
				numCadastro=Console.readString();//ler o numero de cadastro atravez do Console
				doador=controle.obterDoador(numCadastro);//doador recebe o doador informado pelo metodo do controle obterdoador que é passado pelo numero de cadastro
				if(doador==null){//sedoador for nulo não foi encontrado doador e o processo é interrompido
					System.out.println("Erro! Doador não foi encontrador.");
					break;
				}
				System.out.print("Tipo de listagem é por ordem monetaria? 0-sim 1-não:");
				escolha=Console.readInt();//escolha recebe a opção do usuario pelo metodo do Console
				if(escolha==0){//se 0 é monetario e TipoMonetario recebe true
					tipoMonetario=true;
				}else{//senão tipo monetario recebe false
					tipoMonetario=false;
				}
				iterador = (MeuIterador) controle.listarDoacoesOrdenadas(tipoMonetario, doador);//iterador recebe a lista ordenada que é passada pelo controle pelo parametros TipoMonetario e objeto Doador
				if(iterador!=null){//se iterador não for nulo
					while(iterador.temProximo()){//enquanto existir proximo
						doacao=(Doacao) iterador.obterProximo();//doação recebe o objeto atual e iterador passa pro proximo
						doacao.mostarDoacao();//metodo de exibir doação é chamado
					}
				}
				break;
			case 14:
				controle.calcularPercentualDoadores();//chama metodo de calcular e lsitar percentual de doadores
				break;
			default:
				System.out.println("Erro opção invalida!!");//se o susario digitar qualquer outra opção exibe um erro
				break;
			}
		}
	}

}
