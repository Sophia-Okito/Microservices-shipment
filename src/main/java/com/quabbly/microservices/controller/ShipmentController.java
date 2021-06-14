package com.quabbly.microservices.controller;

import com.quabbly.microservices.model.Shipment;
import com.quabbly.microservices.service.ShipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/registerShipment")
public class ShipmentController {
    final
    ShipmentServiceImpl shipmentService;


    public ShipmentController(ShipmentServiceImpl shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ResponseEntity<?> registerShipment(@Valid @RequestBody Shipment shipment) {
        shipmentService.register(shipment);
        String responsemessage = "Shipping fee = " + shipment.getShipmentCharge();
        return new ResponseEntity<>(responsemessage, HttpStatus.OK);

    }
}
