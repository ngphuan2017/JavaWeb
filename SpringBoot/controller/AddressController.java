package r2s.SpringBoot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.SpringBoot.dto.request.CreadAddressDTO;


@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @GetMapping
    public ResponseEntity getAllAddress(){
        CreadAddressDTO address1 = new CreadAddressDTO(1, "VietNam", "HCM", "NguyenKiem");
        CreadAddressDTO address2 = new CreadAddressDTO(2, "China", "QuangChau", "QuangChau");
        CreadAddressDTO address3 = new CreadAddressDTO(3, "Japan", "Tokyo", "Số 21, khu 2 phố Beika");
        StringBuilder response = new StringBuilder("Get All Address: ");
        response.append(address1).append(address2).append(address3);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertAddress(@RequestBody CreadAddressDTO creadAddressDTO){
        int addressId = creadAddressDTO.getAddressId();
        String country = creadAddressDTO.getCountry();
        String city = creadAddressDTO.getCity();
        String street = creadAddressDTO.getStreet();
        StringBuilder stringBuilder = new StringBuilder();
        String response = stringBuilder.append(addressId).append(country).append(city).append(street).toString();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
