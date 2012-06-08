package com.hmstn.orca.controller;

import com.hmstn.orca.domain.DashboardInventory;
import com.hmstn.orca.domain.DashboardVendorProduct;
import com.hmstn.orca.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/dashboard", produces = "application/json", consumes = "*/*")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;


    @RequestMapping(value="/getInventoryByCustomer/{id}", method = RequestMethod.GET)
     public @ResponseBody
     DashboardInventory getInventoryByCustomer(@PathVariable("id")Integer id) throws Exception {


        try{
            return dashboardService.getInventoryByCustomer(id);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value="/getInventoryById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    DashboardVendorProduct getInventoryById(@PathVariable("id")Integer id) throws Exception {

        try{
            return dashboardService.getInventoryById(id);
        } catch (Exception ex) {
            throw ex;
        }
    }

}
