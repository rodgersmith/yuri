package com.hmstn.orca.controller;


import com.hmstn.orca.domain.Catalog;
import com.hmstn.orca.domain.ItemType;
import com.hmstn.orca.domain.VendorProduct;
import com.hmstn.orca.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: totia
 * Date: 4/16/12
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value="/catalog", produces = "application/json", consumes = "*/*")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;



    @RequestMapping(value="/getcatalog/{type}", method = RequestMethod.GET)
    public @ResponseBody Catalog getCatalog(@PathVariable("type")String type) throws Exception {

        try{
        return catalogService.getCatalogByType(type);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value="/getcatalogItem/{id}", method = RequestMethod.GET)
    public @ResponseBody VendorProduct getCatalogItem(@PathVariable("id") Integer id) throws Exception {
        try{
            return catalogService.getCatalogItem(id);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value="/getcatalogitemtypes", method = RequestMethod.GET)
    public @ResponseBody List<ItemType> getCatalogItemTypes() throws Exception {
        try {
            return catalogService.getCatalogItemTypes();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
