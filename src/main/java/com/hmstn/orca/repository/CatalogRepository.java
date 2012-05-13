package com.hmstn.orca.repository;

import com.hmstn.orca.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


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

    private Catalog catalog = new Catalog();

    public CatalogRepository(){
        loadRepo();
    }

    private void loadRepo(){

        Vendor vendor = new Vendor();
        vendor.id = 1;
        vendor.name = "Kimberly-Clark";

        VendorProduct product = new VendorProduct();
        product.id = 1;
        product.name = "Kimberly-Clark Purple Nitrile Exam Gloves Small 9-1/2 in";
        product.description = "Purple Nitrile Exam GlovesPowder-free, ambidextrous gloves with textured fingertips contain no natural rubber latex. Beaded cuff 9.5\" length. 100 gloves per box.SmallPurple Customers also search for: Powder-Free; Kimberly-Clark,Healthcare,Exam Gloves,Powder Free,Nitrile,Purple,Exam Gloves,Kimberly-Clark,Kimberly Clark";
        product.qty = 100;
        product.standardPrice = 9.00;
        product.targetPrice = 7.00;
        product.vendor = vendor;
        product.image = "../images/gloves.jpg";
        product.participantTargetNumber = 35;
        product.currentParticipantNumber = 15;

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 2;
        vendor.name = "Preferred Products Plus";

        product = new VendorProduct();
        product.id = 2;
        product.name = "SafeTouch Nitrile Exam Gloves, Non Latex, Powder Free";
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

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 3;
        vendor.name = "Dynarex";

        product = new VendorProduct();
        product.id = 3;
        product.name = "Dynarex Black Nitrile Exam Gloves, Box/100";
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

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 4;
        vendor.name = "SAS Safety Corporation";

        product = new VendorProduct();
        product.id = 4;
        product.name = "SAS Safety 6609-20 Derma-Lite Powder Free Exam Grade Disposable Nitrile 5 Mil Gloves, Extra Large, 100 Gloves by Weight";
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

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 1;
        vendor.name = "Kimberly-Clark";

        product = new VendorProduct();
        product.id = 5;
        product.name = "Kimberly-Clark Purple Nitrile Exam Gloves Small 9-1/2 in";
        product.description = "Purple Nitrile Exam GlovesPowder-free, ambidextrous gloves with textured fingertips contain no natural rubber latex. Beaded cuff 9.5\" length. 100 gloves per box.SmallPurple Customers also search for: Powder-Free; Kimberly-Clark,Healthcare,Exam Gloves,Powder Free,Nitrile,Purple,Exam Gloves,Kimberly-Clark,Kimberly Clark";
        product.qty = 100;
        product.standardPrice = 9.00;
        product.targetPrice = 7.00;
        product.vendor = vendor;
        product.image = "../images/gloves.jpg";
        product.participantTargetNumber = 35;
        product.currentParticipantNumber = 15;

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 2;
        vendor.name = "Preferred Products Plus";

        product = new VendorProduct();
        product.id = 6;
        product.name = "SafeTouch Nitrile Exam Gloves, Non Latex, Powder Free";
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

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 3;
        vendor.name = "Dynarex";

        product = new VendorProduct();
        product.id = 7;
        product.name = "Dynarex Black Nitrile Exam Gloves, Box/100";
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

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 4;
        vendor.name = "SAS Safety Corporation";

        product = new VendorProduct();
        product.id = 8;
        product.name = "SAS Safety 6609-20 Derma-Lite Powder Free Exam Grade Disposable Nitrile 5 Mil Gloves, Extra Large, 100 Gloves by Weight";
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

        catalog.products.add(product);


        vendor = new Vendor();
        vendor.id = 1;
        vendor.name = "Kimberly-Clark";

        product = new VendorProduct();
        product.id = 9;
        product.name = "Kimberly-Clark Purple Nitrile Exam Gloves Small 9-1/2 in";
        product.description = "Purple Nitrile Exam GlovesPowder-free, ambidextrous gloves with textured fingertips contain no natural rubber latex. Beaded cuff 9.5\" length. 100 gloves per box.SmallPurple Customers also search for: Powder-Free; Kimberly-Clark,Healthcare,Exam Gloves,Powder Free,Nitrile,Purple,Exam Gloves,Kimberly-Clark,Kimberly Clark";
        product.qty = 100;
        product.standardPrice = 9.00;
        product.targetPrice = 7.00;
        product.vendor = vendor;
        product.image = "../images/gloves.jpg";
        product.participantTargetNumber = 40;
        product.currentParticipantNumber = 10;

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 2;
        vendor.name = "Preferred Products Plus";

        product = new VendorProduct();
        product.id = 10;
        product.name = "SafeTouch Nitrile Exam Gloves, Non Latex, Powder Free";
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

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 3;
        vendor.name = "Dynarex";

        product = new VendorProduct();
        product.id = 11;
        product.name = "Dynarex Black Nitrile Exam Gloves, Box/100";
        product.description = "The ideal solution for individuals sensitive to natural rubber latex and donning powder\n" +
                "Contains no allergy causing natural rubber proteins\n" +
                "Extraordinary strength and puncture resistance while maintaining tactile sensitivity\n" +
                "Commonly used by law enforcement professionals\n" +
                "1 box containes 100 ambidextrous gloves\n";
        product.qty = 100;
        product.standardPrice = 9.40;
        product.targetPrice = 7.65;
        product.vendor = vendor;
        product.image = "../images/safeskin_gloves.jpg";
        product.participantTargetNumber = 25;
        product.currentParticipantNumber = 23;

        catalog.products.add(product);

        vendor = new Vendor();
        vendor.id = 4;
        vendor.name = "SAS Safety Corporation";

        product = new VendorProduct();
        product.id = 12;
        product.name = "SAS Safety 6609-20 Derma-Lite Powder Free Exam Grade Disposable Nitrile 5 Mil Gloves, Extra Large, 100 Gloves by Weight";
        product.description = "Powder-free exam grade nitrile\n" +
                "Super puncture and abrasion resistance\n" +
                "Latex-free\n" +
                "Textured grip\n" +
                "Beaded cuff and ambidextrous";
        product.qty = 100;
        product.standardPrice = 14.29;
        product.targetPrice = 12.00;
        product.vendor = vendor;
        product.image = "../images/gloves.jpg";
        product.participantTargetNumber = 35;
        product.currentParticipantNumber = 15;

        catalog.products.add(product);
    }


    @Autowired
    MongoTemplate mongoTemplate;

    public Catalog getCatalog() throws Exception {
//        Catalog results = mongoTemplate.find(Catalog.class);
//        return results;
        return catalog;

    }


    public VendorProduct getCatalogItem (Integer id) throws Exception
    {
        for (VendorProduct product : catalog.products){
            if (product.id.equals(id)){
                return product;
            }
        }
        throw new Exception("item not found");
    }


}
