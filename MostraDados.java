//Importa as bibliotecas qe seram usadas no programa

//Biblioteca para entrada de dados do teclado
import java.util.Scanner;

//Biblioteca para formatação de datas
import java.text.SimpleDateFormat;

//Biblioteca para uso de calendario do sistema
import java.util.Calendar;


public class MostraDados {

	//Nome da classe principal que possui o main()
	public static void main(String[] args) {
		
		//Toda entrada de dados pelo teclado recebe o nome de entrada neste caso
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Preencha os dados abaixo, para abrir sua Conta Corrente:");
		
		//Cria um novoCliente (Objeto), que herdados os atributos ja criado em Cliente
		Cliente novoCliente = new Cliente();
		
		//Alguns dados são pré definidos, como agencia, o numero da conta, entre outros
		novoCliente.agencia =100;
		novoCliente.conta = 34567;
		novoCliente.numero_doc_cc = 23456789;
		novoCliente.agencia_cc = 100;
		novoCliente.conta_cc = 34567;
		novoCliente.data_ocorrencia_cc = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());//recebe a data do sistema e formata
		novoCliente.tipo_cc = 1;
		String ocorrencia = "";
		
		//Faz a entrada de dados
		
		System.out.println("Digite seu Nome Completo:");
		//O .next() indica a entrada de texto, o nextInt() indica um numero interio, e eaasim por diante
		String nome = entrada.next();
		novoCliente.nome = nome;
		
		System.out.println("Digite seu CPF formatado.. ex: 123.456.789-10");
		String cpf = entrada.next();
		novoCliente.cpf = cpf;
		
		
		System.out.println("Digite seu Nascimento formatado.. ex: 08/02/2002:");
		String nascimento = entrada.next();
		novoCliente.nascimento = nascimento;
		
		System.out.println("Digite seu Endereço:");
		String end = entrada.next();
		novoCliente.endereco = end;
		
		System.out.println("Digite seu Numero de telefone formatado.. ex:(11)98219-2778");
		String numero = entrada.next();
		novoCliente.telefone = numero;
		
		novoCliente.saldo = (float) 0;
		
		System.out.println("Cadastre sua nova senha:");
		String senha = entrada.next();
		novoCliente.senha = senha;
		
		/*O valor começa recebendo zero e muda de acordo com o deposito ou o saque feito,
		 * por exemplo se o deposito for de 50, o valor recebe 50,
		 * se for retirado no sa 30, o valor = 30
		 */
		float valor = 0;
		
		
		
		System.out.println("Digite sua senha para continuar: ");
		String confSenha = entrada.next();
		int saudacao = 0;
		
		//continua recebe "s" para entrar no loop do while
		String continua = "s";
		
		//enquando a resposta de continuar for "S", o while contianua a rodar
		while(continua.equals("s") || continua.equals("S")) {
			
			//Se a senha cadastrada for igual a senha digitada
			if(confSenha.equals(novoCliente.senha)) {
				
					float saldoAntigo = novoCliente.saldo;
					
					
					/*A saudação é feita somente uma vez, então quando o usuario continua o looping pra não
					 * mostra os dados rasos novamente  a saudação recebe 1 na primeira vez que é executada.
					 */
					if(saudacao == 0) {
						
					System.out.println("---Dados do Cliente---");
					System.out.println("Agencia: " + novoCliente.agencia);
					System.out.println("Conta: " + novoCliente.conta );
					System.out.println("CPF: " + novoCliente.cpf);
					System.out.println("Nome: " + novoCliente.nome);
					
					saudacao = 1;
					}
				
					System.out.println("Qual deseja ser sua operação? Digite [1](Deposito) ou [2](Saque)? ");
					int operacao = entrada.nextInt();
					
					//O switch ve a operação escolhida e realiza o case diacordo
					switch (operacao) {
					
					case 1:
						
						System.out.println("Operação escolhida foi deposito, Qual o valor a ser depositado?");
						int deposito = entrada.nextInt();
						
						//Ocorrencia recebe deposito;
						ocorrencia = "1 (Deposito)";
					
						novoCliente.valor = deposito;
						valor = deposito;
						
						/*O metodo AtualizaSaldo() é chamado e recebe por parametro o valor, do deposito feito,
						 * o saldo do cliente, e a operação escolhida 1-deposito ou 2-saque
						 */
						novoCliente.saldo = novoCliente.AtualizaSaldo(novoCliente.valor, novoCliente.saldo, 1);
						
						//Faz a quebra do switch pois um case ja foi executado
						break;
					
					case 2:
						System.out.println("Operação escolhida foi saque, Qual o valor a ser sacado?");
						int saque = entrada.nextInt();
						
						//Ocorrencia receb saque
						ocorrencia = "2 (Saque)";
						novoCliente.valor = saque;
						
						//se o saque for maior do que o saldo existente, o banco não executa, e mostra a mensagem
						if (saque > novoCliente.saldo) {
							System.out.println("Saldo de valor indisponivel");
							
						}else {
							//Se o saque for menor do que existente
							valor = saque;
							
							/*O metodo AtualizaSaldo() é chamado e recebe por parametro o valor, do deposito feito,
							 * o saldo do cliente, e a operação escolhida 1-deposito ou 2-saque
							 */
							novoCliente.saldo = novoCliente.AtualizaSaldo(saque, novoCliente.saldo, 2);
						}
						break;
						
						/*Caso alguma das opções não estiver dentro das disponiveis,
						 * executa o bloco do default
						 */
						default:
							
							System.out.println("Operação não encontrada, realize novamente...");
						
					};
					
					/*O sistema faz a pergunta se o usuario deseja continuar, se a resposta for sim,
					 * volta no looping do while, se a resposta for n, executa o codigo abaixo
					 */
					System.out.println("Deseja continuar? S/N");
					continua = entrada.next();
					
					if(continua.equals("n") || continua.equals("N")) {
						
						/*O registro de ocorrencia chama o metodo que retorna um comentario,
						 * que é salvo em uma variavel
						 */
						String regOcorrencia = novoCliente.RegistraOcorrencia();
						
						/*
						 * O metodo mostra cliente é chamado, e recebe todas as informações do objeto novoCliente via parametro
						 */
						novoCliente.MostrarCliente(
								novoCliente.agencia,
								novoCliente.conta,
								novoCliente.cpf,
								novoCliente.nome,
								novoCliente.endereco,
								novoCliente.telefone,
								novoCliente.senha,
								novoCliente.saldo,
								novoCliente.numero_doc_cc,
								novoCliente.agencia_cc,
								novoCliente.conta_cc,
								novoCliente.tipo_cc,
								novoCliente.data_ocorrencia_cc,
								ocorrencia,
								novoCliente.nascimento,
								saldoAntigo,
								regOcorrencia,
								valor
								
								);
					}
				
			//Se a senha não for igual a senha cadastrada o looping cai no else
			}else {
				System.out.println("Senha não localizada, Deseja continuar? [S/N]");
				continua = entrada.next();
			}
			
		}

	}

}