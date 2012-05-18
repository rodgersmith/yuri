package com.hmstn.orca.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 4/22/12
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Document
public class Catalog {
    public List<VendorProduct> products;

    public Catalog(){
        products = new ArrayList<VendorProduct>();
    }
}
