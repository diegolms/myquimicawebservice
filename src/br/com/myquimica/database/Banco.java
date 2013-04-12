package br.com.myquimica.database;

import java.util.ArrayList;

import br.com.myquimica.model.Mistura;

public class Banco {
	private static Banco instance;
	private ArrayList<Mistura> listaMisturas;
	private int idMistura;

	private Banco() {
		idMistura = 1;
		listaMisturas = new ArrayList<Mistura>();
		Mistura mistura = new Mistura();
		mistura.setNome("Água");
		mistura.setFormula("HHO");
		inserir(mistura);
	}

	public static Banco getBancoInstance(){
		if(instance==null)
			instance = new Banco();
		return instance;
	}

	public ArrayList<Mistura> getListaMisturas(){
		return listaMisturas;
	}

	public String inserir(Mistura mistura){
		mistura.setId(idMistura++);
		listaMisturas.add(mistura);
		return "Mistura inserida no banco com sucesso!";
	}

	public Mistura buscar(int id){
		Mistura mistura = null;
		for (int i = 0; i < listaMisturas.size(); i++) {
			if (listaMisturas.get(i).getId() == id){
				mistura = new Mistura();
				mistura = listaMisturas.get(i);
				break;
			}
		}
		return mistura;
	}

	private int getPosition(int id) {
		int pos = -1;
		for (int i = 0; i < listaMisturas.size(); i++) {
			if (listaMisturas.get(i).getId() == id){
				pos = i;
			}
		}
		return pos;
	}

	public String delete(int id){
		Mistura mistura = buscar(id);
		int pos = getPosition(id);
		if(mistura == null || pos < 0){
			return "Mistura não encontrada!";
		} else {
			listaMisturas.remove(pos);
			return "Mistura removida com sucesso!";
		}

	}
}

