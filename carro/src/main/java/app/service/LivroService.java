package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Livro;

@Service
public class LivroService {
	private List<Livro> lista = new ArrayList<>();
	
	public String salvar(Livro livro) {
		lista.add(livro);
		return "Livro salvo com sucesso";
	}
	public String deletar(Livro livro) {
		lista.remove(livro);
		return "Livro deletado com sucesso";
	}
	public String atualizar(Livro livro) {
		var index = lista.indexOf(livro);
		this.lista.set(index, livro);
		return "Atualizado com sucesso";
	}
	public List<Livro> listAll(){
		return this.lista;
	}
}
