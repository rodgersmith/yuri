package com.hmstn.orca.repository;

import com.hmstn.orca.Utility.IMatcher;
import com.hmstn.orca.Utility.Utility;
import com.hmstn.orca.domain.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: totia
 * Date: 4/18/12
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Scope(value="request")
public class CatalogRepository {

    @Autowired
    MongoTemplate mongoTemplate;
    private Catalog catalog = new Catalog();


    public CatalogRepository(){

        loadCatalog();
    }



    private void loadCatalog(){

        ItemType type = new ItemType();
        type.key = 10;
        type.description = "Gloves";

        Vendor vendor = new Vendor();
        vendor.id = 1;
        vendor.name = "Kimberly-Clark";

        VendorProduct product = new VendorProduct();
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
        product.isOnCurrentDashboard = false;
        product.shippingCost = 4.00;
        product.unitCost = 0.30;

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 2;
        vendor.name = "Preferred Products Plus";

        product = new VendorProduct();
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

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 3;
        vendor.name = "Dynarex";

        product = new VendorProduct();
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
        product.isOnCurrentDashboard = false;
        product.shippingCost = 4.00;
        product.unitCost = 0.30;

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 4;
        vendor.name = "SAS Safety Corporation";

        product = new VendorProduct();
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
        product.isOnCurrentDashboard = false;
        product.shippingCost = 4.00;
        product.unitCost = 0.30;

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 1;
        vendor.name = "Kimberly-Clark";

        product = new VendorProduct();
        product.id = 5;
        product.name = "Kimberly-Clark Purple Gloves Small 9-1/2 in";
        product.description = "Purple Nitrile Exam GlovesPowder-free, ambidextrous gloves with textured fingertips contain no natural rubber latex. Beaded cuff 9.5\" length. 100 gloves per box.SmallPurple Customers also search for: Powder-Free; Kimberly-Clark,Healthcare,Exam Gloves,Powder Free,Nitrile,Purple,Exam Gloves,Kimberly-Clark,Kimberly Clark";
        product.qty = 100;
        product.standardPrice = 9.00;
        product.targetPrice = 7.00;
        product.vendor = vendor;
        product.image = "../images/gloves.jpg";
        product.participantTargetNumber = 35;
        product.currentParticipantNumber = 15;
        product.itemType = type;
        product.offerCloseDate = DateTime.now().plusWeeks(2).toString("MM-dd-yyyy");
        product.isOnCurrentDashboard = false;
        product.shippingCost = 4.00;
        product.unitCost = 0.30;

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 2;
        vendor.name = "Preferred Products Plus";

        product = new VendorProduct();
        product.id = 6;
        product.name = "SafeTouch Non Latex, Powder Free Gloves";
        product.description = "The ideal solution for individuals sensitive to natural rubber latex and donning powder\n" +
                "Contains no allergy causing natural rubber proteins\n" +
                "Extraordinary strength and puncture resistance while maintaining tactile sensitivity\n" +
                "Dynarex 2513";
        product.qty = 100;
        product.standardPrice = 9.74;
        product.targetPrice = 8.00;
        product.vendor = vendor;
        product.image = "../images/NitrateGlovesjpg.jpg";
        product.participantTargetNumber = 35;
        product.currentParticipantNumber = 5;
        product.itemType = type;
        product.offerCloseDate = DateTime.now().plusMonths(3).toString("MM-dd-yyyy");
        product.isOnCurrentDashboard = true;
        product.shippingCost = 4.00;
        product.unitCost = 0.30;

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 3;
        vendor.name = "Dynarex";

        product = new VendorProduct();
        product.id = 7;
        product.name = "Dynarex Exam Gloves";
        product.description = "The ideal solution for individuals sensitive to natural rubber latex and donning powder\n" +
                "Contains no allergy causing natural rubber proteins\n" +
                "Extraordinary strength and puncture resistance while maintaining tactile sensitivity\n" +
                "Commonly used by law enforcement professionals\n" +
                "1 box containes 100 ambidextrous gloves\n";
        product.qty = 100;
        product.standardPrice = 9.40;
        product.targetPrice = 7.60;
        product.vendor = vendor;
        product.image = "../images/safeskin_gloves.jpg";
        product.participantTargetNumber = 35;
        product.currentParticipantNumber = 3;
        product.itemType = type;
        product.offerCloseDate = DateTime.now().plusWeeks(3).toString("MM-dd-yyyy");
        product.isOnCurrentDashboard = true;
        product.shippingCost = 4.00;
        product.unitCost = 0.30;

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 4;
        vendor.name = "SAS Safety Corporation";

        product = new VendorProduct();
        product.id = 8;
        product.name = "Derma-Lite Grade Disposable Nitrile";
        product.description = "Powder-free exam grade nitrile\n" +
                "Super puncture and abrasion resistance\n" +
                "Latex-free\n" +
                "Textured grip\n" +
                "Beaded cuff and ambidextrous";
        product.qty = 100;
        product.standardPrice = 14.29;
        product.targetPrice = 11.20;
        product.vendor = vendor;
        product.image = "../images/gloves.jpg";
        product.participantTargetNumber = 40;
        product.currentParticipantNumber = 35;
        product.itemType = type;
        product.offerCloseDate = DateTime.now().plusWeeks(2).toString("MM-dd-yyyy");
        product.isOnCurrentDashboard = false;
        product.shippingCost = 4.00;
        product.unitCost = 0.30;

        catalog.products.add(product);


        vendor = new Vendor();
        vendor.id = 1;
        vendor.name = "Kimberly-Clark";

        product = new VendorProduct();
        product.id = 9;
        product.name = "KC Purple Nitrile Exam Gloves";
        product.description = "Purple Nitrile Exam GlovesPowder-free, ambidextrous gloves with textured fingertips contain no natural rubber latex. Beaded cuff 9.5\" length. 100 gloves per box.SmallPurple Customers also search for: Powder-Free; Kimberly-Clark,Healthcare,Exam Gloves,Powder Free,Nitrile,Purple,Exam Gloves,Kimberly-Clark,Kimberly Clark";
        product.qty = 100;
        product.standardPrice = 9.00;
        product.targetPrice = 7.00;
        product.vendor = vendor;
        product.image = "../images/gloves.jpg";
        product.participantTargetNumber = 40;
        product.currentParticipantNumber = 10;
        product.itemType = type;
        product.offerCloseDate = DateTime.now().plusWeeks(8).toString("MM-dd-yyyy");
        product.isOnCurrentDashboard = false;
        product.shippingCost = 4.00;
        product.unitCost = 0.30;

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 2;
        vendor.name = "Preferred Products Plus";

        product = new VendorProduct();
        product.id = 10;
        product.name = "Nitrile Exam Gloves, Non Latex";
        product.description = "The ideal solution for individuals sensitive to natural rubber latex and donning powder\n" +
                "Contains no allergy causing natural rubber proteins\n" +
                "Extraordinary strength and puncture resistance while maintaining tactile sensitivity\n" +
                "Dynarex 2513";
        product.qty = 100;
        product.standardPrice = 9.74;
        product.targetPrice = 7.00;
        product.vendor = vendor;
        product.image = "../images/NitrateGlovesjpg.jpg";
        product.participantTargetNumber = 45;
        product.currentParticipantNumber = 35;
        product.itemType = type;
        product.offerCloseDate = DateTime.now().plusWeeks(2).toString("MM-dd-yyyy");
        product.isOnCurrentDashboard = false;
        product.shippingCost = 4.00;
        product.unitCost = 0.30;

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 3;
        vendor.name = "Dynarex";


        catalog.products.add(product);
    }



    public Catalog getCatalogByType(String type) throws Exception {
//        Catalog results = mongoTemplate.find(Catalog.class);
//        return results;
        Catalog returnval = new Catalog();

        for( VendorProduct product : catalog.products )
        {
            if ((product.itemType.description.toLowerCase().equals(type.toLowerCase())))
            {
                product.participantTargetDiff = product.participantTargetNumber - product.currentParticipantNumber;
                returnval.products.add(product);
            }
        }
        return returnval;

    }




    public VendorProduct getCatalogItem (Integer id) throws Exception
    {
        for (VendorProduct product : catalog.products){
            if (product.id.equals(id)){
                product.participantTargetDiff = product.participantTargetNumber - product.currentParticipantNumber;
                return product;
            }
        }
        throw new Exception("item not found");
    }

    public List<ItemType> getCatalogItemTypes() throws Exception
    {
        List<ItemType> itemTypes = new ArrayList<ItemType>();
        ItemType type = new ItemType();
        type.key = 0;
        type.description = "Acrylics";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 1;
        type.description = "Alloys";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 2;
        type.description = "Anesthetic";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 3;
        type.description = "Books";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 4;
        type.description = "Bondingagents";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 5;
        type.description = "Cements";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 6;
        type.description = "Crowns";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 7;
        type.description = "Eyewear";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 8;
        type.description = "Desensitizers";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 9;
        type.description = "Diagnostics";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 10;
        type.description = "Gloves";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 11;
        type.description = "Hygiene";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 12;
        type.description = "Impression Trays";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 13;
        type.description = "Lab Products";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 14;
        type.description = "Mouth Guard";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 15;
        type.description = "Oral Rinses";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 16;
        type.description = "Pharmaceuticals";
        itemTypes.add(type);
        type = new ItemType();
        type.key = 17;
        type.description = "Surgical Products";
        itemTypes.add(type);

        return itemTypes;
    }


    public List<VendorProduct> searchCatalog (final String searchText) throws Exception {

        List<VendorProduct> products = catalog.products;
        List<VendorProduct> productList = Utility.searchIn(products, new IMatcher<VendorProduct>() {
            public boolean matches(VendorProduct vendorProduct) throws Exception {
                return vendorProduct.name.toLowerCase().contains(searchText.trim().toLowerCase());
            }
        });
        for(VendorProduct product: productList)
        {
            product.participantTargetDiff = product.participantTargetNumber - product.currentParticipantNumber;
        }


        return productList;
    }

}


