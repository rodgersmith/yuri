package com.hmstn.orca.domain;

import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 4/22/12
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Document
public class VendorProduct {
    public Integer id;
    public String name;
    public String description;
    public ItemType itemType;
    public Integer qty;
    public double standardPrice;
    public double targetPrice;
    public Vendor vendor;
    public String image;
    public Integer participantTargetNumber;
    public Integer currentParticipantNumber;
    public Integer participantTargetDiff;
    public Boolean isOnCurrentDashboard;
    public double shippingCost;
    public double unitCost;
    public String offerCloseDate;
    public int daysRemainingOnOffer;

    public VendorProduct() {
        vendor = new Vendor();

    }



}
