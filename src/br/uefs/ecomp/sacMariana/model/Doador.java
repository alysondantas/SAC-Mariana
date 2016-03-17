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

import java.util.Date;
//Import no util para poder usar o "Date"
/**
 * 
 * @author Alyson
 *Classe para os doadores
 */
public class Doador {
	//Tipo static para que não mude
	private static Integer serialId=0;//SerialID é quem vai definir o id de cada doador quando for criado
	private Integer id;//id do doador
	//id não foi usado em momento algum ja que o numero de cadastro tambem nunca se repete
	private Endereco endereco;//Endereço do tipo Endereço para não criar tanta String dentro de doador
	private String tipo;//tipo do doador fisica ou juridica
	private String numCadastro;// numero de cadastro cpf ou cnpj
	private String nome;//nome do doador
	private Date dt_nascimento;//data de nascimento
	/**
	 * Construtor da classe para incrementar o SeriaID e dar ao id
	 */
	public Doador(){
		serialId=serialId+1;//Incrementa o SerialID para que não se repita
		this.id=serialId;//id da doacao recebe o serialID da criação
	}
	//
	public Integer getId() {//para que em outro pacote possa acessar o id
		return id;//retorna o id
	}
	/**
	 * Metodo para cadastrar os endereços em um objeto
	 * @param rua
	 * @param numero
	 * @param bairro
	 * @param cep
	 * @param cidade
	 * @param uf
	 * @param pais
	 */
	public void Enderecovem(String rua,	int numero, String bairro, String cep, String cidade, String uf, String pais){//no ato de cadastro quando for pedido rua,numero,bairro etc, é criado um objeto so com esses atributos e enviado ao endereço do doador
		Endereco enderecovem = new Endereco(rua,numero,bairro,cep,cidade,uf,pais);//cria objeto
		this.endereco=enderecovem;//entrega o objeto ao endereço
		}
	//
	public Endereco getEndereco() {//para que em outro pacote possa acessar o endereço
		return endereco;//retorna o endereço
	}
	//
	public void setEndereco(Endereco endereco) {//para que em outro pacote possa alterar o endereço
		this.endereco = endereco;//endereço da classe recebe o endereço passado
	}
	//os get e set abaixo tem as mesma funções
	public String getTipo() {
		return tipo;
	}
	//
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	//
	public String getNumCadastro() {
		return numCadastro;
	}
	//
	public void setNumCadastro(String numCadastro) {
		this.numCadastro = numCadastro;
	}
	//
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	//
	public Date getDt_Nascimento() {
		return dt_nascimento;
	}
	//
	public void setDt_Nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	/**
	 * Metodo para apenas para mostrar o doador quando for chamada
	 */
	public void mostarDoador(){
		System.out.println("ID: "+id);//mostra id
		System.out.println("Nome: "+nome);//mostra nome
		System.out.println("Tipo: "+tipo);//mostra tipo
		System.out.println("Numero de Cadastro: "+numCadastro);//mostra numero de cadastro
		System.out.println("Data de Nascimento: "+dt_nascimento);//mostra data de nascimento
		System.out.println("Endereço:");
		System.out.println("Rua: "+endereco.getRua());//mostra rua do objeto endereço
		System.out.println("Numero: "+endereco.getNumero());//mostra numero do objeto endereço
		System.out.println("Bairro: "+endereco.getBairro());//mostra bairro do objeto endereço
		System.out.println("CEP: "+endereco.getCep());//mostra cep do objeto endereço
		System.out.println("Cidade: "+endereco.getCidade());
		System.out.println("UF: "+endereco.getUf());
		System.out.println("Pais: "+endereco.getPais());
		System.out.println("");
	}
}