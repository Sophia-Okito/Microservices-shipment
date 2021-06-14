package com.quabbly.microservices.model;

import lombok.*;

import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {
    @NotNull
    @Size(max = 50, message = "Name too Long")
    @Pattern(regexp="(^[a-zA-Z]+\\s([a-zA-Z]+)?(\\s)?[a-zA-Z]+$)", message = "Must have first and last name") // first name, maybe middle name, and last name
    private String senderFullName;

    @NotNull
    @Pattern(regexp ="^\\S+@\\S+\\.\\S+$")
    private String senderEmail;

    @Pattern(regexp="^(0|(234)|(\\+234))([789])([01])\\d{8}", message = "Not a valid Nigeria number") //phone numbers beginning with and with country code
    private String senderPhone;

    @NotNull
    @Size(max = 50, message = "Name too Long")
    @Pattern(regexp="(^[a-zA-Z]+\\s+([a-zA-Z]+)?(\\s)?[a-zA-Z]+$)", message = "Must have first and last name") // first name, maybe middle name, and last name
    private String receiverFullName;

    @NotNull
    private String receiverAddress;

    @Pattern(regexp="^(0|(234)|(\\+234))([789])([01])\\d{8}", message = "Not a valid Nigeria number") //phone numbers beginning with and with country code
    private String receiverPhone;

    @NotNull
    private String receiverState;


    @Pattern(regexp = "DOCUMENT|PARCEL|CARGO" , flags = Pattern.Flag.CASE_INSENSITIVE, message = "Not a valid package type")
    private String packageType;

    private int packageWeight = 0;
    private int shipmentCharge;

    public Shipment(String senderFullName, String senderEmail, String senderPhone,
                    String receiverFullName, String receiverAddress, String receiverPhone,
                    String receiverState, String packageType, int packageWeight) {
        this.senderFullName = senderFullName;
        this.senderEmail = senderEmail;
        this.senderPhone = senderPhone;
        this.receiverFullName = receiverFullName;
        this.receiverAddress = receiverAddress;
        this.receiverPhone = receiverPhone;
        this.receiverState = receiverState;
        this.packageType = packageType;
        this.packageWeight = packageWeight;
    }
}
