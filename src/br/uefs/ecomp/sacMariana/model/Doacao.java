package br.uefs.ecomp.sacMariana.model;

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

import java.util.Date;//Import no util para poder usar o "Date"
/**
 * 
 * @author Alyson
 * Classe para as doações
 */
public class Doacao {
	//Tipo static para que não mude
	private static Integer serialId=0;//SerialID é quem vai definir o id de cada doacao quando for criada 
	private Integer id;//id da doacao
	private Date data;//data da doacao
	private Doador doador;//Objeto do tipo doador para receber a referencia do doador
	private Produto produto;//Objeto do tipo produto para receber a referencia do produto
	private Number qtd;//quantidade da doação
	private boolean monetario;//Tipo bolean para saber se é monetario ou não true=sim false=não
	/**
	 * Construtor da classe para incrementar o SeriaID e dar o serial da doação
	 */
	public Doacao(){
		serialId=serialId+1;//Incrementa o SerialID para que não se repita
		this.id=serialId;//id da doacao recebe o serialID da criação
	}
	/**
	 * Metodo para apenas para mostrar a doação quando for chamada
	 */
	public void mostarDoacao(){
		System.out.println("ID: "+id);//mostra id
		System.out.println("Data: "+data);//mostra data
		System.out.println("Quantidade: "+qtd);//mostra quantidade
		System.out.println("");//da uma quebra de linha
	}
	//
	public Integer getId_doacao() {//para que em outro pacote possa acessar o id
		return id;//retorna o id
	}
	//
	public Date getData() {//para que em outro pacote possa acessar a data
		return data;//retorna a data
	}
	public void setData(Date data) {//Para que a data possa ser alterada por outro pacote
		this.data = data;//data da classe recebe o que foi passado
	}
	//os get e set abaixo tem as mesma funções
	public Doador getDoador() {
		return doador;
	}
	public void setDoador(Doador doador) {
		this.doador = doador;
	}
	//
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	//
	public Number getQtd() {
		return qtd;
	}
	//
	public void setQtd(Number qtd) {
		this.qtd = qtd;
	}
	//
	public boolean isMonetario() {
		return monetario;
	}
	//
	public void setMonetario(boolean monetario) {
		this.monetario = monetario;
	}
	
}