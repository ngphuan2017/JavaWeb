package JavaWeb.SpringBoot.service;

import JavaWeb.SpringBoot.dto.request.CreatedAddressDTO;
import JavaWeb.SpringBoot.entity.Address;
import JavaWeb.SpringBoot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> getAllAddress() {
        Iterable<Address> addressIterable = this.addressRepository.findAll();
        return (List)addressIterable;
    }
    @Override
    public Address createdAddress(CreatedAddressDTO createdAddressDTO) {
        Address address = new Address();
        address.setCountry(createdAddressDTO.getCountry());
        address.setCity(createdAddressDTO.getCity());
        address.setAddress(createdAddressDTO.getAddress());
        address.setDistrict(createdAddressDTO.getDistrict());
        address.setStreet(createdAddressDTO.getStreet());
        this.addressRepository.save(address);
        return address;
    }
}
