package com.teste.paginacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaginaController {

    private PaginaSerivce serivce;

    public PaginaController(PaginaSerivce serivce) {
        this.serivce = serivce;
    }

    @GetMapping()
    public ResponseEntity<Page<Pagina>> find(Pageable pageable) {
        return ResponseEntity.ok().body(serivce.find(pageable));
    }
}
