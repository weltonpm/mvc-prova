package prova;

import java.util.Scanner;

public class Executar {
	public static void main (String []args){
		ICadastroControl objControl = new CadastroControl();

		Scanner sc = new Scanner (System.in);
		String opc;
		do{
			ICadastroModel objCadastro = new CadastroModel();
			System.out.println("Digite o id: ");
			objCadastro.setId(sc.nextInt());
			System.out.println("Digite o nome: ");
			objCadastro.setNome(sc.next());
			objControl.salvar(objCadastro);
			System.out.println("Digite S para sair ou C para continuar: ");
			opc = sc.next();
		}while(!opc.equalsIgnoreCase("S"));

		System.out.println("Digite o id que deseja procurar: ");
		ICadastroModel objCadastrado = objControl.consultarID(sc.nextInt());
		if(objCadastrado.getId() != 0) {//Se o id do obj retornado for 0 significa que o id nao foi encontrado.
			System.out.println("ID: "+objCadastrado.getId()+" - Nome: "+objCadastrado.getNome());
		}
		else{ //ID nao encontrado
			System.out.println("ID nao encontrado!!!");
		}	

		System.out.println("Digite o nome que deseja procurar: ");
		objCadastrado = objControl.consultarNOME(sc.next());
		if(objCadastrado.getNome()!=null) {//Se o nome do obj retornado for null significa que o nome nao foi encontrado.
			System.out.println("ID: "+objCadastrado.getId()+" - Nome: "+objCadastrado.getNome());
		}
		else{ //nome nao encontrado
			System.out.println("Nome nao encontrado!!!");
		}		
	}
}