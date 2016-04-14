package prova;
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