# Microservices-shipment

#### Create a new Shipment 

      curl -X POST "http://localhost:8080/registerShipment" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"packageType\": \"parcel\", \"packageWeight\": 0, \"receiverAddress\": \"string\", \"receiverFullName\": \"string String\", \"receiverPhone\": \"09032484389\", \"receiverState\": \"string\", \"senderEmail\": \"string@gmail.com\", \"senderFullName\": \"string String\", \"senderPhone\": \"09032484389\", \"shipmentCharge\": 0}"
