package prova;

public interface ICadastroModel {
	int getId();
	void setId(int id);
	String getNome();
	void setNome(String nome);
}

public class CadastroModel implements ICadastroModel{
	private int id;
	private String nome;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
}

public interface ICadastroControl {
	void salvar(ICadastroModel objCadastro);
	ICadastroModel consultarId(int id);
	ICadastroModel consultarNome(String nome);
	ICadastroModel consultarID(int id);
	ICadastroModel consultarNOME(String nome);
}

import java.util.List;
import java.util.ArrayList;
public class CadastroControl implements ICadastroControl {
	List<ICadastroModel> listControl;

	public CadastroControl(){
		listControl = new ArrayList<ICadastroModel>();
	}

	public void salvar(ICadastroModel objCadastro){
		listControl.add(objCadastro);
	}

	public ICadastroModel consultarId(int id){
		ICadastroModel objRetorno = new CadastroModel();
		for(ICadastroModel objCadastro : listControl){
			if(objCadastro.getId() == id){
				objRetorno = objCadastro;
				return objRetorno;
			}
		}
		return objRetorno;
	}
	public ICadastroModel consultarID(int id){
		ICadastroModel objAux = new CadastroModel();
		for(int i=0; i<listControl.size();i++){
			if(listControl.get(i).getId() == id){
				objAux = listControl.get(i);
				return objAux;
			}
		}
		return objAux;
	}
	public ICadastroModel consultarNome(String nome){
		ICadastroModel objRetorno = new CadastroModel();
		for(ICadastroModel objCadastro : listControl){
			if(objCadastro.getNome().equals(nome)){
				objRetorno = objCadastro;
				return objRetorno;
			}	
		}
		return objRetorno;
	}
	public ICadastroModel consultarNOME(String nome){
		ICadastroModel objAux = new CadastroModel();
		for(int i=0; i<listControl.size();i++){
			if(listControl.get(i).getNome().equals(nome)){
				objAux = listControl.get(i);
				return objAux;
			}
		}
		return objAux;
	}
}

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
