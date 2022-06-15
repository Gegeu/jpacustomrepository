package com.teste.paginacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PaginaRepositoryImpl implements PaginaRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Pagina> getPages(List<String> valores, Pageable pageable) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM paginacao WHERE 1 = 1 ");
        sb.append("LIMIT :offset, :limit");
        Query query = entityManager.createNativeQuery(sb.toString());
        int offset = pageable.getPageNumber() * pageable.getPageSize();
        query.setParameter("offset", offset);
        query.setParameter("limit", pageable.getPageSize());
        List resultList = query.getResultList();
        Long total = getTotal();
        Page page = new PageImpl(resultList, pageable, total);

        return page;
    }

    @Override
    public Long getTotal() {
        Query query = entityManager.createNativeQuery("select total from total_item");
        Long singleResult = Long.valueOf(query.getSingleResult().toString());
        return singleResult;
    }
}
