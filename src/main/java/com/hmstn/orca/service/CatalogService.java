package com.hmstn.orca.service;


import com.hmstn.orca.domain.Catalog;
import com.hmstn.orca.domain.VendorProduct;
import com.hmstn.orca.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope(value="request")
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    public Catalog getCatalog() throws Exception{
        return catalogRepository.getCatalog();
    }

    public VendorProduct getCatalogItem(Integer id) throws Exception{
        return catalogRepository.getCatalogItem(id);
    }


}
