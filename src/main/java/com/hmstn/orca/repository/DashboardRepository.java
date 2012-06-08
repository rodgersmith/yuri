package com.hmstn.orca.repository;

import com.hmstn.orca.domain.DashboardInventory;
import com.hmstn.orca.domain.DashboardVendorProduct;
import com.hmstn.orca.domain.ItemType;
import com.hmstn.orca.domain.Vendor;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 5/31/12
 * Time: 10:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Scope(value="request")
public class DashboardRepository {
    private DashboardInventory inventory = new DashboardInventory();

    public DashboardRepository(){
        loadDashboard();
    }

    private void loadDashboard(){
        ItemType type = new ItemType();
        type.key = 10;
        type.description = "Gloves";

        Vendor vendor = new Vendor();
        vendor.id = 1;
        vendor.name = "Kimberly-Clark";

        DashboardVendorProduct product = new DashboardVendorProduct();
        product.id = 1;
        product.name = "Kimberly-Clark Small Exam Gloves";
        product.description = "Purple Nitrile Exam GlovesPowder-free, ambidextrous gloves with textured fingertips contain no natural rubber latex. Beaded cuff 9.5\" length. 100 gloves per box.SmallPurple Customers also search for: Powder-Free; Kimberly-Clark,Healthcare,Exam Gloves,Powder Free,Nitrile,Purple,Exam Gloves,Kimberly-Clark,Kimberly Clark";
        product.qty = 100;
        product.standardPrice = 9.00;
        product.targetPrice = 7.00;
        product.vendor = vendor;
        product.image = "../images/gloves.jpg";
        product.participantTargetNumber = 35;
        product.currentParticipantNumber = 15;
        product.itemType = type;
        product.offerCloseDate = DateTime.now().plusWeeks(3).toString("MM-dd-yyyy");
        product.isOnCurrentDashboard = true;
        product.shippingCost = 4.00;
        product.unitCost = 0.30;
        product.isOpen = true;
        product.qtyOrdered = 5;
        product.customerId = 1;
        product.daysRemainingOnOffer = Days.daysBetween(DateTime.now(), DateTime.now().plusWeeks(7)).getDays();
        product.shippingDetails = "Default";
        product.paymentDetails = "Default";

        inventory.products.add(product);

        product = new DashboardVendorProduct();
        product.id = 2;
        product.name = "SafeTouch Powder Free Exam Gloves";
        product.description = "The ideal solution for individuals sensitive to natural rubber latex and donning powder\n" +
                "Contains no allergy causing natural rubber proteins\n" +
                "Extraordinary strength and puncture resistance while maintaining tactile sensitivity\n" +
                "Dynarex 2513";
        product.qty = 100;
        product.standardPrice = 9.74;
        product.vendor = vendor;
        product.image = "../images/NitrateGlovesjpg.jpg";
        product.participantTargetNumber = 40;
        product.currentParticipantNumber = 10;
        product.itemType = type;
        product.offerCloseDate = DateTime.now().plusWeeks(6).toString("MM-dd-yyyy");
        product.isOnCurrentDashboard = true;
        product.shippingCost = 3.00;
        product.unitCost = 0.30;
        product.isOnCurrentDashboard = true;
        product.daysRemainingOnOffer = Days.daysBetween(DateTime.now(), DateTime.now().plusWeeks(3)).getDays();
        product.customerId = 1;
        product.shippingDetails = "Default";
        product.paymentDetails = "Default";

        inventory.products.add(product);

        product = new DashboardVendorProduct();
        product.id = 3;
        product.name = "Dynarex Black Nitrile Exam Gloves";
        product.description = "The ideal solution for individuals sensitive to natural rubber latex and donning powder\n" +
                "Contains no allergy causing natural rubber proteins\n" +
                "Extraordinary strength and puncture resistance while maintaining tactile sensitivity\n" +
                "Commonly used by law enforcement professionals\n" +
                "1 box containes 100 ambidextrous gloves\n";
        product.qty = 100;
        product.standardPrice = 9.40;
        product.targetPrice = 7.40;
        product.vendor = vendor;
        product.image = "../images/safeskin_gloves.jpg";
        product.participantTargetNumber = 60;
        product.currentParticipantNumber = 40;
        product.itemType = type;
        product.offerCloseDate = DateTime.now().plusWeeks(1).toString("MM-dd-yyyy");
        product.isOnCurrentDashboard = true;
        product.shippingCost = 4.00;
        product.unitCost = 0.30;
        product.daysRemainingOnOffer = Days.daysBetween(DateTime.now(),DateTime.now().plusWeeks(9)).getDays();
        product.customerId = 1;
        product.shippingDetails = "Default";
        product.paymentDetails = "Default";

        inventory.products.add(product);

        product = new DashboardVendorProduct();
        product.id = 4;
        product.name = "SAS Safety Powder Free Exam Gloves";
        product.description = "Powder-free exam grade nitrile\n" +
                "Super puncture and abrasion resistance\n" +
                "Latex-free\n" +
                "Textured grip\n" +
                "Beaded cuff and ambidextrous";
        product.qty = 100;
        product.standardPrice = 14.29;
        product.targetPrice = 11.00;
        product.vendor = vendor;
        product.image = "../images/gloves.jpg";
        product.participantTargetNumber = 55;
        product.currentParticipantNumber = 32;
        product.itemType = type;
        product.offerCloseDate = DateTime.now().plusMonths(2).toString("MM-dd-yyyy");
        product.isOnCurrentDashboard = true;
        product.shippingCost = 4.00;
        product.daysRemainingOnOffer = Days.daysBetween(DateTime.now(),DateTime.now().plusWeeks(1)).getDays();
        product.customerId = 1;
        product.shippingDetails = "Default";
        product.paymentDetails = "Default";

        inventory.products.add(product);

        product = new DashboardVendorProduct();
        product.id = 5;
        product.name = "Kimberly-Clark Purple Gloves Small 9-1/2 in";
        product.description = "Purple Nitrile Exam GlovesPowder-free, ambidextrous gloves with textured fingertips contain no natural rubber latex. Beaded cuff 9.5\" length. 100 gloves per box.SmallPurple Customers also search for: Powder-Free; Kimberly-Clark,Healthcare,Exam Gloves,Powder Free,Nitrile,Purple,Exam Gloves,Kimberly-Clark,Kimberly Clark";
        product.qty = 100;
        product.standardPrice = 9.00;
        product.targetPrice = 7.00;
        product.vendor = vendor;
        product.image = "../images/gloves.jpg";
        product.participantTargetNumber = 35;
        product.currentParticipantNumber = 35;
        product.itemType = type;
        product.offerCloseDate = DateTime.now().plusWeeks(2).toString("MM-dd-yyyy");
        product.isOnCurrentDashboard = true;
        product.shippingCost = 4.00;
        product.unitCost = 0.30;
        product.daysRemainingOnOffer = Days.daysBetween(DateTime.now(),DateTime.now().plusWeeks(3)).getDays();
        product.customerId = 1;
        product.shippingDetails = "Default";
        product.paymentDetails = "Default";

        inventory.products.add(product);

    }

    public DashboardInventory getInventoryForCustomer(int customerId) throws Exception{
        DashboardInventory customerInventory = new DashboardInventory();
        customerInventory.customerId = customerId;

        for(DashboardVendorProduct product: this.inventory.products){
            if (product.customerId.equals(customerId)){
                product.participantTargetDiff = product.participantTargetNumber - product.currentParticipantNumber;
                customerInventory.products.add(product);
            }
        }
        return  customerInventory;
    }

    public DashboardVendorProduct getInventoryById(Integer id) throws Exception{

        for(DashboardVendorProduct product: this.inventory.products){
            if (product.id.equals(id)){
                product.participantTargetDiff = product.participantTargetNumber - product.currentParticipantNumber;
                return product;
            }
        }
        return null;

    }
}
