package com.hmstn.orca.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 5/28/12
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class DashboardInventory {
    public Integer customerId;
    public List<DashboardVendorProduct> products;


    public DashboardInventory(){
        products = new ArrayList<DashboardVendorProduct>();

    }
}
