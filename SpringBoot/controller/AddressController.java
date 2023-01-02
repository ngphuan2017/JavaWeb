package JavaWeb.SpringBoot.controller;

import JavaWeb.SpringBoot.dto.request.CreatedAddressDTO;
import JavaWeb.SpringBoot.entity.Address;
import JavaWeb.SpringBoot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    //get all
    @GetMapping
    public ResponseEntity<?> getAllAddress(@RequestParam(value = "page", required = false)Integer page,
                                        @RequestParam(value = "size", required = false)Integer size,
                                        @RequestParam(value = "sort", required = false)String sort){
        List<Address> addressList = this.addressService.getAllAddress();
        return new ResponseEntity(addressList, HttpStatus.OK);
    }
    // get address by ID
//    @GetMapping(value = "/{address-id}")
//    public ResponseEntity getAddressById(@PathVariable(value = "address-id")int addressId){
//        CreatedAddressDTO address3 = new CreatedAddressDTO(3, "Japan", "Tokyo", "Số 21, khu 2 phố Beika");
//        StringBuilder response = new StringBuilder("Get Address By ID: "+addressId);
//        response.append(address3);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity insertAddress(@RequestBody CreatedAddressDTO createdAddressDTO){
        Address address = this.addressService.createdAddress(createdAddressDTO);
        return new ResponseEntity(address, HttpStatus.OK);
    }
//    @PutMapping(value = "/{address-id}")
//    public ResponseEntity updateAddress(@PathVariable(value = "address-id")int addressId,
//                                        @RequestBody UpdateAddressDTO updateAddressDTO){
//        String country = updateAddressDTO.getCountry();
//        String city =updateAddressDTO.getCity();
//        String street = updateAddressDTO.getStreet();
//        StringBuilder response = new StringBuilder();
//        response.append(addressId).append(country).append(city).append(street);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//    @DeleteMapping(value = "/{address-id}")
//    public ResponseEntity deleteAddress(@PathVariable(value = "address-id")int addressId){
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
}
