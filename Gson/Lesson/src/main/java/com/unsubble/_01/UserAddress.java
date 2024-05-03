package com.unsubble._01;

import lombok.Data;
import lombok.Value;

@Value
public class UserAddress {
    String street;
    String houseNumber;
    String city;
    String country;
}
