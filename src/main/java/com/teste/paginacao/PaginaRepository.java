package com.teste.paginacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaginaRepository extends JpaRepository<Pagina, Long>, PaginaRepositoryCustom {
}
