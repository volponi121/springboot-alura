package com.alura.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.forum.model.Topico;
//JpaRepository<Entidade, Tipo da PK>
public interface TopicoRepository extends JpaRepository<Topico, Long> {
	
	Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);
}
