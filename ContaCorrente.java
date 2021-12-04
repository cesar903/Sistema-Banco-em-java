//Os atributos são criados, e herdados por Cliente
public class ContaCorrente{
 int numero_doc_cc;
 int agencia_cc;
 int conta_cc;
 float valor;
 int tipo_cc;
 String data_ocorrencia_cc;
 float saldo;

 
 /*O metodo AtualizaSaldo() recebe 3 parametros, o valor a ser
  * depositado ou sacado, o saldo existente na conta e o tipo saque ou deposito
  * 
  */
 static public float AtualizaSaldo(float valor, float saldo, int oc) {

	 //Se o oc for 1 é deposito, então o deposito é adicionado ao saldo
	 if(oc == 1){
		 saldo += valor;
		 
	 //Se o oc for 2 é saque, então o saque é subtraido do saldo 
	 }else if(oc == 2) {
		 saldo -= valor;
		
	 }
	 
	 //O retorno é o saldo, agora atualizado
	 return saldo;
 }
 
 //Este metodo retorna apenas o comentario de que a ocorrencia foi registrada com sucesso
  static public String RegistraOcorrencia(){
	  
	return ("Ocorrencia Registrada com Sucesso !!!");

 }
}