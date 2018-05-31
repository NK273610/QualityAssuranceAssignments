package Interface;

import Data.DeliveryAddress;

public interface PARTMANAGER {

    public enum PartResponse{
        SUCCESS,
        OUT_OF_STOCK,
        NO_LONGER_MANUFACTURED}


        public PartResponse SubmitPartForManufactureAndDelivery(int partNumber, int quantity, DeliveryAddress deliveryAddress);
}
