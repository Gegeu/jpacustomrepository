package com.teste.paginacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaginaRepositoryCustom {
    Page<Pagina> getPages(List<String> valores, Pageable pageable);
    Long getTotal();
}
