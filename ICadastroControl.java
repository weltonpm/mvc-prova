package prova;

public interface ICadastroControl {
	void salvar(ICadastroModel objCadastro);
	ICadastroModel consultarId(int id);
	ICadastroModel consultarNome(String nome);
	ICadastroModel consultarID(int id);
	ICadastroModel consultarNOME(String nome);
}