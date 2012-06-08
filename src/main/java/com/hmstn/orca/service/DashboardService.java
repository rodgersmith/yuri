package com.hmstn.orca.service;

import com.hmstn.orca.domain.DashboardInventory;
import com.hmstn.orca.domain.DashboardVendorProduct;
import com.hmstn.orca.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 6/1/12
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    public DashboardInventory getInventoryByCustomer(int id) throws Exception{

        return dashboardRepository.getInventoryForCustomer(id);
    }

    public DashboardVendorProduct getInventoryById(int id)  throws Exception{
        return dashboardRepository.getInventoryById(id);
    }
}
