package com.sumer.labs.orderservice.service;

import com.sumer.labs.commons.dto.AddressDto;
import com.sumer.labs.orderservice.domain.Address;

public class AddressService {

    public static AddressDto mapToDto(Address address){
        if (address != null){
            return new AddressDto(
                    address.getAddress1(),
                    address.getAddress2(),
                    address.getCity(),
                    address.getPostCode(),
                    address.getCountry()
            );
        }
        return null;
    }
}
