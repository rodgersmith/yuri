package com.hmstn.orca.Enum;

/**
 * Created by IntelliJ IDEA.
 * User: rodsmith
 * Date: 6/10/12
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DashboardItemStatus {

        Open(0),
        Elapsed(1),
        Success(2);

        private final int index;

        DashboardItemStatus(int index){
            this.index = index;
        }

        public int index(){
            return index;
        }


}
