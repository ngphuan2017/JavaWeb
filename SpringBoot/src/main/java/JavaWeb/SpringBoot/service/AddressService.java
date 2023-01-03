package JavaWeb.SpringBoot.service;

import JavaWeb.SpringBoot.dto.request.CreatedAddressDTO;
import JavaWeb.SpringBoot.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddress();

    Address createdAddress(CreatedAddressDTO createdAddressDTO);
}
