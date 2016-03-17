package br.uefs.ecomp.sacMariana.controller;

/*******************************************************************************

Autor: Alyson Felipe Oliveira Dantas

Componente Curricular: MI - Algoritmos II

Concluido em: 12/12/2015

Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum

trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e

apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo

de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte

do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.

******************************************************************************************/

import br.uefs.ecomp.sacMariana.model.Lista;//import na lista
import br.uefs.ecomp.sacMariana.util.Iterador;//importo a interface do iterador
import br.uefs.ecomp.sacMariana.model.MeuIterador;//importo o Meu Iterador
import br.uefs.ecomp.sacMariana.model.Doacao;//importo a doa��o
import br.uefs.ecomp.sacMariana.model.Doador;//importo o doador
import br.uefs.ecomp.sacMariana.model.Produto;//improto o produto
import java.util.Date;//uso util.date para usar a variavel tipo date
/**
 * 
 * @author Alyson Dantas
 *Classe Controller para intermediar os metodos do model e view
 */
public class SACMarianaController {//abro a classe controller
/**
 * Construtor
 */
	public SACMarianaController(){//seria o construtor mas n�o houve necessidade

	}
	Lista doador = new Lista();//cria a lista de doadores
	Lista produto = new Lista();//cria a lista de produtos
	Lista doacao = new Lista();//cria a liasta de doa��es
	Lista listaauxiliar=null;//declaro a lista auxiliar para usar no futuro
	/**
	 * Metodo para cadastrar novo produto e recebe por parametro as informa��es
	 * @param nome
	 * @param tipo
	 * @param dt_criacao
	 * @return novoProduto
	 */
	public Produto cadastrarProduto(String nome, String tipo, Date dt_criacao) {
		Produto novoProduto=new Produto();//cria nova celula de produto
		novoProduto.setNome(nome);//atribui na celula o nome
		novoProduto.setTipo(tipo);//atribui na celula o tipo
		novoProduto.setDataCadastro(dt_criacao);//atribui na celula a data
		produto.inserirInicio(novoProduto);//insere no inicio da lista
		return novoProduto;//retorna o produto cadastrado
	}
	/**
	 * Metodo para editar produtos pelo id, recebe por parametro as informa��es do produto
	 * @param idProduto
	 * @param nome
	 * @param tipo
	 * @param dt_criacao
	 * @return Produto editado
	 */
	public Produto editarProduto(Integer idProduto, String nome, String tipo, Date dt_criacao) {
		Produto auxiliar=obterProduto(idProduto);//auxiliar tipo produto rebe o produto informado atravez do metodo obterproduto
		if(auxiliar!=null){//se for diferente de nulo as novas informa��es s�o passadas para o objeto
			auxiliar.setDataCadastro(dt_criacao);
			auxiliar.setNome(nome);
			auxiliar.setTipo(tipo);
			return auxiliar;//retona auxiliar que tem o produto editado
		}else{
			System.out.println("N�o foi encontrado produto respectivo.");
		}
		return null;//se n�o retorna null
	}
	/**
	 * Metodo para passar o iterador para listar
	 * @return iterador
	 */
	public Iterador listarProdutos() {
		return produto.iterador();//retorno do iterador recebendo o primeiro elemento da lista produto
	}
	/**
	 * Metodo para remover um produto e recebe por parametro o id do produto a ser alterado
	 * @param idProduto
	 * @return true ou false do produto removido
	 */
	public boolean removerProduto(Integer idProduto) {
		MeuIterador iterado=(MeuIterador)produto.iterador();//cria um iterador e da a ele o primeiro elemento da lista produto
		Produto objetoremover=null;//declara o objeto auxiliar para remo��o
		Doacao auxiliardoacao=null;//declara um objeto tipo doador para verificar se existe doa��o desse produto
		MeuIterador iteradordoacao=(MeuIterador)doacao.iterador();//cria um iterador e da ele o primeiro elemento da lista doa��o
		int index=0;//cria uma variavel para receber o index para remo��o
		if(!(produto.estaVazia())){//se existir lista produto
			while(iterado.temProximo()){//enquanto existir um proximo elemento da lista produto
				objetoremover=(Produto) iterado.obterProximo();//auxiliar para remo��o recebe o objeto atual e iterador de produto passa pro proximo
				if(objetoremover.getId_produto()==idProduto){//se o id do auxilar for igual ao id do produto informado
					while(iteradordoacao.temProximo()){//enquanto existir proximo elemento da lista de doa��o
						auxiliardoacao=(Doacao) iteradordoacao.obterProximo();//auxiliar de doa��o obtem o atual e iterador de doa��o passa pro proximo
						if(auxiliardoacao.getProduto().equals(objetoremover)){//se o produto referenciado em alguma doa��o for igual ao produto que deseja ser removido o processo � interrompido
							//uso de equals para comparar dois objetos
							System.out.println("Erro! Existe uma doacao desse produto, n�o foi possivel remover!");
							return false;
						}
					}
					return produto.remover(index)!=null;//se tudo estiver correto o index � passado para o metodo remover da lista
				}
				index++;//index incrementa mais um
			}
		}
		return false;
	}
	/**
	 * Metodo para obter produto pelo ID
	 * @param idProduto
	 * @return produto
	 */
	public Produto obterProduto(int idProduto){
		Produto auxiliar=null;//declara uma auxiliar do tipo produto
		MeuIterador iterador = (MeuIterador)produto.iterador();//cria um iterador e da a ele o primeiro elemento da lista produto
		if(!(produto.estaVazia())){//se a lista n�o estiver vazia
			while(iterador.temProximo()){//enquanto proximo elemtento na lista produto
				auxiliar = (Produto) iterador.obterProximo();//auxiliar recebe o objeto atual e o iterador recebe a proxima celula
				if(auxiliar.getId_produto()==idProduto){//se id do objeto de auxiliar for igual a id do objeto que � procurado
					return auxiliar;//retorna o objeto encontrado
				}
			}
		}
		return null;//se n�o retorna nulo
	}
	/**
	 * Metodo cadastrar doador, para cadastrar doador ele recebe por parametro as informa��es
	 * @param numCadastro
	 * @param nome
	 * @param dt_nascimento
	 * @param rua
	 * @param numero
	 * @param bairro
	 * @param cep
	 * @param cidade
	 * @param uf
	 * @param pais
	 * @param tipo
	 * @return novo doador
	 */
	public Doador cadastrarDoador(String numCadastro, String nome, Date dt_nascimento, String rua, int numero, String bairro, String cep, String cidade, String uf, String pais, String tipo) {
		Doador novoDoador=new Doador();//cria nova celula de doador
		Doador auxiliar;//cria auxiliar do tipo doador
		MeuIterador iterador = (MeuIterador)doador.iterador();//iterador recebe primeiro elemento da lista de doa��o
		novoDoador.setNumCadastro(numCadastro);//atribui na celula o numero de cadastro
		novoDoador.setNome(nome);//atribui na celula o nome
		novoDoador.setDt_Nascimento(dt_nascimento);//atribui na celula a data de nascimento
		novoDoador.Enderecovem(rua, numero, bairro, cep, cidade, uf, pais);//entrega ao construtor as informa��es de endere�o
		novoDoador.setTipo(tipo);//atribui na celula o tipo
		while(iterador.temProximo()){//enquanto tiver proximo elemento na lista
			auxiliar = (Doador) iterador.obterProximo();//auxiliar recebe o elemnto do iterador e iterador passa proximo
			if(numCadastro.contentEquals(auxiliar.getNumCadastro())){//se numero de cadastro do auxiliar for igual ao do novoDoador ent�o o processo � interrompido
				//contenEquals � para verifacar o conteudo do objeto
				System.out.println("Doador com o numero de cadastro ja cadastrado!");
				return null;
			}
		}
		doador.inserirInicio(novoDoador);//se n�o existir outro doador com esse numero de cadastro novo doador � inserido pelo inicio na lista doador
		return novoDoador;//retonar o doador cadastrado
	}
	/**
	 * Metodo para editar o doador pelo numero de cadastro para alterar doador, recebe por parametro as informa��es do doador
	 * @param numCadastro
	 * @param nome
	 * @param dt_nascimento
	 * @param rua
	 * @param numero
	 * @param bairro
	 * @param cep
	 * @param cidade
	 * @param uf
	 * @param pais
	 * @param tipo
	 * @return
	 */
	public Doador editarDoador(String numCadastro, String nome, Date dt_nascimento, String rua, int numero, String bairro, String cep, String cidade, String uf, String pais, String tipo) {
		Doador auxiliar=obterDoador(numCadastro);//auxiliar tipo doador rebe o doador informado atravez do metodo obterdoador
		if(auxiliar!=null){//se existir doador as novas informa��es s�o passadas ao objeto
			auxiliar.setNumCadastro(numCadastro);
			auxiliar.setNome(nome);
			auxiliar.setDt_Nascimento(dt_nascimento);
			auxiliar.Enderecovem(rua, numero, bairro, cep, cidade, uf, pais);
			auxiliar.setTipo(tipo);
			return auxiliar;//retona o objeto editado
		}
		System.out.println("N�o foi editar doador respectivo.");
		return null;//se n�o retorna null
	}
	/**
	 * Metodo para obter doador a partir do numero de cadastro
	 * @param numCadastro
	 * @return
	 */
	public Doador obterDoador(String numCadastro) {
		Doador auxiliar=null;//declara uma auxiliar do tipo doador
		MeuIterador iterador = (MeuIterador)doador.iterador();//cria um iterador e da a ele o primeiro elemento da lista doador
		if(!(doador.estaVazia())){//se a lista n�o estiver vazia
			while(iterador.temProximo()){//enquanto existir elemento na lista
				auxiliar = (Doador) iterador.obterProximo();//auxiliar recebe o objeto atual e o iterador recebe a proxima celula
				if(numCadastro.contentEquals(auxiliar.getNumCadastro())){//se numero de cadastro do objeto de auxiliar for igual a numero de cadastro do objeto que � procurado
					return auxiliar;//retonar objeto encontrado
				}
			}
		}
		return null;//se n�o retorna nulo
	}
	/**
	 * Metodo para remover doador pelo numero de cadastro
	 * @param numCadastro
	 * @return true ou false
	 */
	public boolean removerDoador(String numCadastro) {
		int index=0;//variavel para o index
		MeuIterador iterado=(MeuIterador)doador.iterador();//iterador recebe o primeiro elemento da lista doador
		Doacao auxiliardoacao=null;//varivel do tipo doa��o para auxiliar
		MeuIterador iteradordoacao=(MeuIterador)doacao.iterador();//iterador para a lista de doa��es
		Doador objetoremover=null;//variavel do tipo doador para recebe o objeto a ser removido
		if(!(doador.estaVazia())){//se existir lista de doadores
			while(iterado.temProximo()){//enquanto existir proximo elemento
				objetoremover=(Doador) iterado.obterProximo();//objeto a ser removido recebe o objeto atual e iterador passa pro proximo
				if((objetoremover.getNumCadastro()).equals(numCadastro)){//se numero de cadastro passado for igual ao numeor de cadastro do objeto
					while(iteradordoacao.temProximo()){//enquanto existir proximo elemento na lista de doa��e
						auxiliardoacao=(Doacao) iteradordoacao.obterProximo();//auxiliar do tipo doa��o recebe objeto atual e iterador passa pro proximo
						if(auxiliardoacao.getDoador().equals(objetoremover)){//se objeto doador for igual ao doador a ser removido o processo � interrompido
							System.out.println("Erro! Existe uma doacao desse doador, n�o foi possivel remover!");
							return false;
						}
					}
					doador.remover(index);//se n�o o index do objeto � passado ao metodo remover da lista
					return true;
				}
				index++;//index incrementa
			}
		}
		return false;//se houver erros retorna false
	}	
	/**
	 * metodo que retorna o iterador com o primeiro elemento da lista para ele ser listado na main
	 * @return iterador
	 */
	public Iterador listarDoadores() {
		return doador.iterador();//retorna o iterador com o primeiro elemento da lista doador
	}
	/**
	 * Metodo para cadastrar doa��o e recebe por parametro as informa��es
	 * @param doador
	 * @param produto
	 * @param quantidade
	 * @param dt_doacao
	 * @param tipo
	 * @return Nova doa��o
	 */
	public Doacao efetuarDoacao(Doador doador, Produto produto, Number quantidade, Date dt_doacao,boolean tipo){
		Doacao novaDoacao=new Doacao();//cria nova celula de doa��o
		novaDoacao.setDoador(doador);//atribui na celula a referencia do doador
		novaDoacao.setProduto(produto);//atribui na celula a referencia do produto
		novaDoacao.setQtd(quantidade);//atribui na celula a quantidade
		novaDoacao.setData(dt_doacao);//atribui na celula a data de doa��o
		novaDoacao.setMonetario(tipo);//atribui na celula o tpo de doa��o
		doacao.inserirInicio(novaDoacao);////insere no inicio da lsita doa��o
		return novaDoacao;//retorna a nova doa��o
	}
	/**
	 * Metodo para alterar doa��o, recebe por parametro as informa��es da doa��o
	 * @param idDoacao
	 * @param doador
	 * @param produto
	 * @param quantidade
	 * @param dt_doacao
	 * @param tipo
	 * @return doa��o alterada
	 */
	public Doacao alterarDoacao(Integer idDoacao, Doador doador, Produto produto, Number quantidade, Date dt_doacao, boolean tipo){
		Doacao auxiliar;//cria variavel auxiliar do tipo doa��o
		MeuIterador iterador=(MeuIterador) doacao.iterador();//iterador recebe o primeiro elemento da lista doa��o
		if(!(doacao.estaVazia())){//se existir lista
			while(iterador.temProximo()){//enquanto existir proximo elemento
				auxiliar=(Doacao) iterador.obterProximo();//auxiliar recebe o atual e iterdor passa pro proximo
				if(auxiliar.getId_doacao()==idDoacao){//se id do objeto atual for igual ao id passado
					auxiliar.setDoador(doador);//as novas informa��es s�o passadas para o objeto
					auxiliar.setProduto(produto);
					auxiliar.setQtd(quantidade);
					auxiliar.setData(dt_doacao);
					auxiliar.setMonetario(tipo);
					return auxiliar;//retorna o objeto editado
				}
			}
		}
		return null;//se n�o retorna nulo
	}
	/**
	 * Metodo para remover determinada doa��o pelo id
	 * @param idDoacao
	 * @return true ou false
	 */
	public boolean removerDoacao(int idDoacao){
		MeuIterador iterado=(MeuIterador)doacao.iterador();//iterador recebe o primeiro elemento da lista de doa��o
		Doacao objetoremover=null;//cria variavel do tipo doa��o para remover elemento
		int index=0;//variavel para receber index
		if(!(doacao.estaVazia())){//se a lista doacao n�o for vazio
			while(iterado.temProximo()){//se existir proximo elmento
				objetoremover=(Doacao) iterado.obterProximo();//objetoremover recebe elemento atual e iterador recebe o proximo
				if(objetoremover.getId_doacao()==idDoacao){//se o id do objeto atual for igual ao id passado
					return doacao.remover(index)!=null;//chama metodo remover da lista e passa index
					//se for diferente de null retorno � true
				}
				index++;//index � incrementado
			}
		}
		return false;//se n�o retorna false
	}
	/**
	 * Metodo que retorna o iterador com o primeiro elemento da lista doa��o para ele ser listado na main
	 * @param monetario
	 * @param doador
	 * @return iterador
	 */
	public Iterador listarDoacoesOrdenadas(boolean monetario, Doador doador){
		listaauxiliar=new Lista();//lista auxiliar � criada
		Doacao auxiliar;//cria variavel do tipo doa��o para auxiliar
		MeuIterador iterador=(MeuIterador) doacao.iterador();//cria iterador e ele recebe primeiro elemento da lista doa��o
		if(!(doacao.estaVazia())){//se a lista m�o estiver vazia
			if(monetario==true){//se for por monetario
				if(doador==null){//se doador vim nulo ent�o � pra listar todos
					while(iterador.temProximo()){//enquanto existir proximo elemento
						auxiliar=(Doacao)iterador.obterProximo();//auxiliar recebe elemento atual e iterador passa pro proximo
						if(auxiliar.isMonetario()==true){//se a atual for monetaria
							listaauxiliar.inserirInicio(auxiliar);//o elemento atual � inserido no inicio da lista auxiliar
						}
					}
					if(!listaauxiliar.estaVazia()){//se lista auxiliar n�o for vazia
						MeuIterador iterador2=(MeuIterador) ordenarLista();//iterador2 recebe a ordena��o da lista auxiliar 
						return iterador2;//retorna o iterador 2
					}
				}else{//se doador n�o vinher nulo
					while(iterador.temProximo()){//enquanto existir proximo elemento
						auxiliar=(Doacao)iterador.obterProximo();//auxiliar recebe objeto atual e iterador passa pro proximo
						if(auxiliar.isMonetario()==true){//se a atual for monetario
							if(doador.equals(auxiliar.getDoador())){//se doador for igual ao doador referenciado na auxiliar
								listaauxiliar.inserirInicio(auxiliar);//o elemento atual � inserido na lsita auxiliar
							}
						}
					}
					if(!listaauxiliar.estaVazia()){//se lista auxiliar n�o for vazia
						MeuIterador iterador2=(MeuIterador) ordenarLista();//iterador2 recebe a ordena��o da lista auxiliar
						return iterador2;//retirna o iterador 2
					}
				}
			}else{//se n�o for monetario
				if(doador==null){//se doador vim nulo ent�o � pra listar todos
					while(iterador.temProximo()){//se existir proximo elemento
						auxiliar=(Doacao)iterador.obterProximo();//auxiliar recebe atual e iterador passa pro proximo
						if(auxiliar.isMonetario()==false){//verifica se realmente n�o � monetario
							listaauxiliar.inserirInicio(auxiliar);//atual � inserida no inicio da lista auxiliar
						}
					}
					if(!listaauxiliar.estaVazia()){//se a lista auxiliar n�o for nula
						MeuIterador iterador2=(MeuIterador) ordenarLista();//iterador2 recebe a ordena��o da lista auxiliar
						return iterador2;//retorna o iterador 2
					}
				}else{//se n�o for nulo
					while(iterador.temProximo()){//se existir proximo elemento
						auxiliar=(Doacao)iterador.obterProximo();//auxiliar recebe atual e iterador passa pro proximo
						if(auxiliar.isMonetario()==false){//se monetario for false
							if(doador.equals(auxiliar.getDoador())){//se doador for igual referenciado dentro do atual
								listaauxiliar.inserirInicio(auxiliar);//atual � inserida no inicio da lista auxiliar
							}
						}
					}
					if(!listaauxiliar.estaVazia()){//se lsista auxiliar for diferente de nulo
						MeuIterador iterador2=(MeuIterador) ordenarLista();//iterador2 recebe a ordena��o da lista auxiliar
						return iterador2;//retorna o iterador 2
					}
				}
			}
		}
		return null;//se houver erro retorna nulo
	}
	/**
	 * Metodo para calcula percentual de doadores
	 */
	public void calcularPercentualDoadores(){
		double percentualTotalMonetario=0;//variavel para o percentual total monetario
		double percentualTotal=0;//variavel para o percentual total
		double percentual=0;//varivael para o percentual
		double quantidade=0;//variavel para a quantidade de doa��es por doador
		Doador auxiliardoador;//variavel auxiliar de doador
		Doacao auxiliardoacao;//variavel auxiliar de doa��o
		MeuIterador iteradordoacao = (MeuIterador) doacao.iterador();//iterador doa��o recebe primeiro elemento de doa��o
		MeuIterador iteradordoador = (MeuIterador) doador.iterador();//iterador doador recebe primeiro elemento de doador
		while(iteradordoacao.temProximo()){//enquanto houver proximo elemento na lista de doa��o
			auxiliardoacao=(Doacao) iteradordoacao.obterProximo();//auxiliar de doa��o recebe atual e iterador de doa��o recebe proximo
			if(auxiliardoacao.isMonetario()==true){//se atual for doa��o monetaria
				percentualTotalMonetario=percentualTotalMonetario+(double)auxiliardoacao.getQtd();//percentual total monetario recebe ele mais a quantidade da doa��o atual
			}else{//se n�o
				percentualTotal=percentualTotal+(double)auxiliardoacao.getQtd();//percentual total recebe ele mais a quantidade da doa��o atual
			}
		}
		iteradordoacao.reiniciar();//iterador de doa��o � reiniciado
		System.out.println("=====Total de doa��es n�o monetarias====");
		System.out.println("Total de doa��es n�o monetaria foi: "+percentualTotal);
		while(iteradordoador.temProximo()){//enquanto existir proximo doador
			auxiliardoador=(Doador) iteradordoador.obterProximo();//auxiliar de doador recebe atual e iterador passa pro proximo
			while(iteradordoacao.temProximo()){//enquanto existir proxima doa��o
				auxiliardoacao=(Doacao) iteradordoacao.obterProximo();//auxiliar doa��o recebe atual e iterador de doa��o passa pro proximo
				if(auxiliardoador.equals(auxiliardoacao.getDoador())){//se doador atual for igual ao referenciado na doa��o
					if(auxiliardoacao.isMonetario()==false){//se a doa��o n�o for monetaria
						quantidade=quantidade+(double)auxiliardoacao.getQtd();//quantidade recebe ela mesmo e a quantidade da doa��o
					}
				}
			}
			quantidade=quantidade*100;//quantidade � multiplicada por 100
			percentual=quantidade/percentualTotal;//percentual recebe quantidade dividida pelo percentual total
			System.out.println("Doador:"+auxiliardoador.getNome());//exibe nome do doador
			System.out.print("Percentual:"+percentual);//exibe percentual do doador
			System.out.println("%");
			System.out.println("");
			percentual=0;//reinicia as variaveis e o iterador de doa��o
			quantidade=0;
			iteradordoacao.reiniciar();
		}
		System.out.println("");
		System.out.println("=====Total de doa��es monetarias====");
		System.out.println("Total de doa��es monetaria foi: "+percentualTotalMonetario);
		iteradordoador.reiniciar();//iterador de doador � reiniciado
		while(iteradordoador.temProximo()){//enquanto existir proximo doador
			auxiliardoador=(Doador) iteradordoador.obterProximo();//auxiliar de doador recebe atual e iterador passa pro proximo
			while(iteradordoacao.temProximo()){//enquanto existir proxima doa��o
				auxiliardoacao=(Doacao) iteradordoacao.obterProximo();//auxiliar de do��o recebe o atual e iterador de doa��o passa pro proximo
				if(auxiliardoador.equals(auxiliardoacao.getDoador())){//se doador atual for igual ao doador referenciado na doa��o
					if(auxiliardoacao.isMonetario()==true){//se doa��o for monetaria
						quantidade=quantidade+(double)auxiliardoacao.getQtd();//quantidade recebe ela mais a quantidade de doa��o
					}
				}
			}
			quantidade=quantidade*100;//quantiade � multiplicada por 100
			percentual=quantidade/percentualTotalMonetario;//percentual recebe a quantidade dividida pelo percentual total monetario
			System.out.println("Doador:"+auxiliardoador.getNome());//exibe o doador
			System.out.print("Percentual:"+percentual);//exibe o percentual do doador
			System.out.println("%");
			System.out.println("");
			percentual=0;//reinicia as variavel e o iterador de doa��o
			quantidade=0;
			iteradordoacao.reiniciar();
		}
	}
	/**
	 * Metodo para ordenar uma lista
	 * @return iterador
	 */
	public Iterador ordenarLista(){
		int tamanho=0;//variavel para receber o tamanho da lista
		int indexauxiliar=0;//variavel auxiliar para receber o index
		int indexdepois=0;//variavel auxiliar para receber o index proximo ao indexauxiliar
		Doacao auxiliar;//varavel do tipo doa��o auxiliar
		MeuIterador iterador2=(MeuIterador) listaauxiliar.iterador();//iterador recebe o primeiro elemento da lista auxiliar
		Doacao depois=(Doacao)iterador2.obterProximo();//variavel do tipo doa��o que vai estar uma celula a frente da auxiliar
		tamanho=listaauxiliar.obterTamanho();//tamanho recebe o tamanho da lista pelo metodo obtertamanho
		while(iterador2.temProximo()){//enquanto houver um proximo elemento na lista
			indexdepois++;//index da proxima incrementa
			auxiliar=depois;//auxiliar recebe a proxima celula
			depois=(Doacao) iterador2.obterProximo();//depois passa pra proxima
			if( (double)auxiliar.getQtd()<(double)depois.getQtd() && tamanho>=indexdepois){//se quantidade da doa��o de auxiliar for menor que a quantidade da sucessora e depois n�o seja null
				listaauxiliar.bubbleSort(indexauxiliar, indexdepois);//o metodo bubble sort � chamado para trocar os objetos
				iterador2.reiniciar();//iterador volta ao inicio
				indexauxiliar=-1;//index auxiliar recebe -1
				indexdepois=0;//index da proxima de auxiliar recebe 0
				auxiliar=null;//auxiliar recebe null
				depois=(Doacao) iterador2.obterProximo();//depois recebe o primeiro elemento da lista
			}
			indexauxiliar++;//index auxiliar incrementa
		}
		iterador2.reiniciar();//iterador volta a primeira celula para ser retornado
		return iterador2;
	}

}