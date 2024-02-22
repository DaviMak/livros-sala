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
	
	public String removeById(Integer id) {
		
		Livro livro = this.findById(id);
		
		if(livro != null) {
			lista.remove(livro);
			return "Deletado com sucesso";
		}else
			return "não encontrou nada com esse id";
		
		/*
		if(id != null && id >= lista.size() + 1) {
			lista.remove(livro);
			return "Excluído com sucesso@";
		}else {
			return null;
		}*/
	}
	
	public Livro findById(long idLivro) {
		//banco de dados
		List<Livro> lista = this.listAll();
		
		if(lista != null) {
			for(int i = 0; i<lista.size(); i++) {
				if(lista.get(i).getId() == idLivro) {
					return lista.get(i);
				}
			}
			return null;
		}else {
			return null;
		}
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
