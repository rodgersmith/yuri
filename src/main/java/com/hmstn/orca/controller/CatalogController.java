package com.hmstn.orca.controller;


import com.hmstn.orca.domain.Catalog;
import com.hmstn.orca.domain.VendorProduct;
import com.hmstn.orca.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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



    @RequestMapping(value="/getcatalog", method = RequestMethod.GET)
    public @ResponseBody Catalog getCatalog() throws Exception {



        try{
        return catalogService.getCatalog();
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


}
