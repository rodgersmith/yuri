package com.hmstn.orca.service;


import com.hmstn.orca.domain.Catalog;
import com.hmstn.orca.domain.ItemType;
import com.hmstn.orca.domain.VendorProduct;
import com.hmstn.orca.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Scope(value="request")
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    public Catalog getCatalogByType(String type) throws Exception{
        return catalogRepository.getCatalogByType(type);
    }

    public VendorProduct getCatalogItem(Integer id) throws Exception{
        return catalogRepository.getCatalogItem(id);
    }

    public List<ItemType> getCatalogItemTypes() throws Exception{
        return catalogRepository.getCatalogItemTypes();
    }



}
