package Controller;

import Data.DeliveryAddress;

import DataBase.DBclass;
import Interface.PARTMANAGER;

public class partmanager implements PARTMANAGER {

    ValidateData vd;
    validPart vp;
    public partmanager() {
    }

    public partmanager(ValidateData vd, validPart vp) {
        this.vd = vd;
        this.vp = vp;
    }

    @Override
    public PartResponse SubmitPartForManufactureAndDelivery(int partNumber, int quantity, DeliveryAddress deliveryAddress) {

        DBclass db=new DBclass();
        vd=new ValidateData();
        vp=new validPart(db);
//
        if(vp.check_valid_part(partNumber,quantity) && !vd.check_DealerAddress_for_null(deliveryAddress)) {
            return PartResponse.SUCCESS;
        }
        else if(db.getPartData().containsKey(partNumber))
        {
           if(quantity>db.getPartData().get(partNumber))
            return PartResponse.OUT_OF_STOCK;
        }

            return PartResponse.NO_LONGER_MANUFACTURED;

    }
}
