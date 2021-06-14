package com.quabbly.microservices.service;

import com.quabbly.microservices.model.Shipment;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService{
    private int calculateShippingFee(String packageType, int packageWeight) {
        int shipmentCharge;
        packageType = packageType.toLowerCase();
        if (packageType.equals("cargo"))
            shipmentCharge = packageWeight <= 50 ? 22500 : packageWeight <= 200 ? 48000 : 100000;
         else if (packageType.equals("parcel"))
            shipmentCharge = 12000;
         else
            shipmentCharge = 5000;
        return shipmentCharge;
    }

    @Override
    public void register(Shipment shipment) {
        String packageType = shipment.getPackageType();
        int packageWeight = shipment.getPackageWeight();
        int shippingFee = calculateShippingFee(packageType, packageWeight);
        shipment.setShipmentCharge(shippingFee);
    }
}
