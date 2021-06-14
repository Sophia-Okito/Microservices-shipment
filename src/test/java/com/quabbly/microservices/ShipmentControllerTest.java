package com.quabbly.microservices;

import com.quabbly.microservices.model.Shipment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ShipmentControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void registerShipment() {
        HttpEntity <Shipment> validShipment = new HttpEntity<>(new Shipment("Sophia Okito", "sophia@gmail.com", "09032484389", "Okito Sophia", "Sangotedo", "+2349032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> invalidName = new HttpEntity<>(new Shipment("Sophia123", "sophia@gmail.com", "09032484389", "Okito Sophia", "Sangotedo", "+2349032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> withoutLastName = new HttpEntity<>(new Shipment("Sophia", "sophia@gmail.com", "09032484389", "Okito Sophia", "Sangotedo", "+2349032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> nullName = new HttpEntity<>(new Shipment("", "sophia@gmail.com", "09032484389", "Okito Sophia", "Sangotedo", "+2349032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> invalidEmail1 = new HttpEntity<>(new Shipment("Sophia", "sophiagmail.com", "09032484389", "Okito Sophia", "Sangotedo", "+2349032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> invalidEmail2 = new HttpEntity<>(new Shipment("Sophia", "sophia@gmailcom", "09032484389", "Okito Sophia", "Sangotedo", "+23409032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> nullEmail = new HttpEntity<>(new Shipment("Sophia", "", "09032484389", "Okito Sophia", "Sangotedo", "+2349032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> invalidPhone1 = new HttpEntity<>(new Shipment("Sophia", "sophia@gmailcom", "9032484389", "Okito Sophia", "Sangotedo", "+2349032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> invalidPhone2 = new HttpEntity<>(new Shipment("Sophia", "sophia@gmailcom", "06032484389", "Okito Sophia", "Sangotedo", "+2349032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> invalidPhone3 = new HttpEntity<>(new Shipment("Sophia", "sophia@gmailcom", "2339032484389", "Okito Sophia", "Sangotedo", "+2349032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> nullPhone = new HttpEntity<>(new Shipment("Sophia", "sophia@gmailcom", "2339032484389", "Okito Sophia", "Sangotedo", "+2349032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> nullAddress= new HttpEntity<>(new Shipment("Sophia", "sophia@gmailcom", "2339032484389", "Okito Sophia", "", "+2349032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> nullCity= new HttpEntity<>(new Shipment("Sophia", "sophia@gmailcom", "2339032484389", "Okito Sophia", "", "+2349032484389", "Lagos", "Cargo", 50));
        HttpEntity <Shipment> invalidPackageType= new HttpEntity<>(new Shipment("Sophia", "sophia@gmailcom", "2339032484389", "Okito Sophia", "", "+2349032484389", "Lagos", "Carg", 50));

        ResponseEntity<?> responseValidShipment = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", validShipment, String.class);
        ResponseEntity<?> responseInvalidName = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", invalidName, String.class);
        ResponseEntity<?> responseWithoutLastname = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment",withoutLastName , String.class);
        ResponseEntity<?> responseNullName = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", nullName, String.class);
        ResponseEntity<?> responseInvalidEmail1 = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", invalidEmail1, String.class);
        ResponseEntity<?> responseInvalidEmail2= this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", invalidEmail2, String.class);
        ResponseEntity<?> responseNullEmail = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", nullEmail, String.class);
        ResponseEntity<?> responseInvalidPhone1 = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", invalidPhone1, String.class);
        ResponseEntity<?> responseInvalidPhone2 = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", invalidPhone2, String.class);
        ResponseEntity<?> responseInvalidPhone3 = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", invalidPhone3, String.class);
        ResponseEntity<?> responseNullPhone = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", nullPhone, String.class);
        ResponseEntity<?> responseNullAddress = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", nullAddress, String.class);
        ResponseEntity<?> responseNullCity = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", nullCity, String.class);
        ResponseEntity<?> responseInvalidPackageType = this.restTemplate.postForEntity("http://localhost:" + port + "/registerShipment", invalidPackageType, String.class);

        assertThat(responseValidShipment.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(responseInvalidName.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(responseWithoutLastname.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(responseNullName.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(responseInvalidEmail1.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(responseInvalidEmail2.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(responseNullEmail.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(responseInvalidPhone1.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(responseInvalidPhone2.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(responseInvalidPhone3.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(responseNullPhone.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(responseNullAddress.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(responseNullCity.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(responseInvalidPackageType.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));

    }


}