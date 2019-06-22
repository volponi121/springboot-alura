package com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.alura.forum.model.Topico;
import com.alura.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {

	@NotNull
	@NotEmpty
	private String titulo;
	@NotNull
	@NotEmpty
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id);
		topico.setTitulo(titulo);
		topico.setMensagem(mensagem);
		return topico;
	}

}
