package com.teste.paginacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PaginaSerivce {

    private PaginaRepository repository;

    public PaginaSerivce(PaginaRepository repository) {
        this.repository = repository;
    }

    public Page<Pagina> find(Pageable pageable) {
        long startTime = System.currentTimeMillis();
        Page<Pagina> pages = repository.getPages(null, pageable);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("em ms " + duration);

        return pages;
    }
}
