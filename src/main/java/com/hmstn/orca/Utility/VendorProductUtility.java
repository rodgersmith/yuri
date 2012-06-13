package com.hmstn.orca.Utility;

import com.hmstn.orca.Enum.DashboardItemStatus;
import com.hmstn.orca.domain.VendorProduct;

/**
 * Created by IntelliJ IDEA.
 * User: rodsmith
 * Date: 6/10/12
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class VendorProductUtility {
    public static int calculateTargetDiff( VendorProduct product ){
        return product.participantTargetNumber - product.currentParticipantNumber;
    }

    public static DashboardItemStatus getItemStatus( VendorProduct product) {
        if (product.participantTargetDiff == 0){
            return DashboardItemStatus.Success;
        }
        if (product.daysRemainingOnOffer == 0){
            return DashboardItemStatus.Elapsed;
        }
        return DashboardItemStatus.Open;
    }
}
