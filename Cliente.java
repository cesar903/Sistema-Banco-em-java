
/*É criado uma classe Cliente, que recebe a herança de ContaCorrente,
 * ou seja, todos os atributos e metodos que a ContaCorrente tem  a classe Cliente tambem ira ter.
  
*/

public class Cliente extends ContaCorrente{
	
 int agencia;
 int conta;
 String cpf;
 String nome;
 String endereco;
 String nascimento;
 String telefone;
 String senha;
 float saldo;

 /*
  * O metodo abaixo, é chamado quado o cliente ja digitou toos os dados e
  *  o pragrama esta prestes a terminar seu ciclo.
  *  OS dados são recebidos atraves dos parametro, e logo depois é expostos atraves do 		
  *  System.out.println(" ");

  */
 
 static void MostrarCliente(
		 int agencia, 
		 int conta, 
		 String cpf, 
		 String nome, 
		 String endereco,
		 String telefone,
		 String senha,
		 float saldo,
		 int numero_doc_cc,
		 int agencia_cc,
		 int conta_cc,
		 int tipo_cc,
		 String data_ocorrencia_cc,
		 String ocorrencia,
		 String nascimento,
		 float saldoAntigo,
		 String regOcorrencia,
		 float valor
		 
		 ) {
	 	
	 
		
		System.out.println("---Dados do Cliente---");
		System.out.println("Agencia: " + agencia);
		System.out.println("Conta: " + conta );
		System.out.println("CPF: " + cpf);
		System.out.println("Nome: " + nome);
		System.out.println("Nascimento: " + nascimento);
		System.out.println("Endereço: " + endereco);
		System.out.println("Telefone: " + telefone);
		System.out.println("Saldo: " + saldoAntigo);
		System.out.println("Senha: " + senha);
		
		System.out.println("---Conta Corrente---");
		System.out.println("Número do documento: " + numero_doc_cc);
		System.out.println("Agência: " + agencia_cc);
		System.out.println("Conta: " + conta_cc);
		System.out.println("Valor: " + valor);
		System.out.println("Tipo: " + ocorrencia);
		System.out.println("Data Ocorrência: " + data_ocorrencia_cc);
		System.out.println("Saldo Anterior: " + saldoAntigo);
		System.out.println("Saldo Atualizado: " + saldo);
		System.out.println("Mensagem: " + regOcorrencia);

 }
 
}


	 