package Controller;

import Data.DeliveryAddress;

import DataBase.DBclass;
import Interface.PARTMANAGER;

public class partmanager implements PARTMANAGER {


    @Override
    public PartResponse SubmitPartForManufactureAndDelivery(int partNumber, int quantity, DeliveryAddress deliveryAddress) {

        DBclass db=new DBclass();
        ValidateData vd=new ValidateData();
        validPart vp=new validPart(db);
        if(vp.check_valid_part(partNumber,quantity)  && vd.check_DealerAddress_for_null(deliveryAddress) ) {
            return PartResponse.SUCCESS;
        }
        else if(quantity<=0)
        {
            return PartResponse.OUT_OF_STOCK;
        }
        else
        {
            return PartResponse.NO_LONGER_MANUFACTURED;
        }
    }
}
