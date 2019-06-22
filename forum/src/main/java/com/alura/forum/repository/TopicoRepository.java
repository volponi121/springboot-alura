package com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.forum.model.Topico;
//JpaRepository<Entidade, Tipo da PK>
public interface TopicoRepository extends JpaRepository<Topico, Long> {
	
	List<Topico> findByCursoNome(String nomeCurso);
}
