package JavaWeb.SpringBoot.controller;

import JavaWeb.SpringBoot.dto.request.CreadAddressDTO;
import JavaWeb.SpringBoot.dto.request.UpdateAddressDTO;
import JavaWeb.SpringBoot.dto.response.PageResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/address")
public class AddressController {
    //get all
    @GetMapping(value = "/get-all")
    public ResponseEntity getAllAddress(@RequestParam(value = "page", required = false)Integer page,
                                        @RequestParam(value = "size", required = false)Integer size,
                                        @RequestParam(value = "sort", required = false)String sort){
        CreadAddressDTO address1 = new CreadAddressDTO(1, "VietNam", "HCM", "NguyenKiem");
        CreadAddressDTO address2 = new CreadAddressDTO(2, "China", "QuangChau", "QuangChau");
        CreadAddressDTO address3 = new CreadAddressDTO(3, "Japan", "Tokyo", "Số 21, khu 2 phố Beika");
        StringBuilder response = new StringBuilder("Get All Address: ");
        List<CreadAddressDTO> creadAddressDTOList = new ArrayList<>();
        creadAddressDTOList.add(address1);
        creadAddressDTOList.add(address2);
        creadAddressDTOList.add(address3);
        PageResponseDTO pageResponseDTO = new PageResponseDTO();
        pageResponseDTO.setPage(page);
        pageResponseDTO.setSize(size);
        pageResponseDTO.setSort(sort);
        response.append(creadAddressDTOList).append(pageResponseDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    // get address by ID
    @GetMapping(value = "/{address-id}")
    public ResponseEntity getAddressById(@PathVariable(value = "address-id")int addressId){
        CreadAddressDTO address3 = new CreadAddressDTO(3, "Japan", "Tokyo", "Số 21, khu 2 phố Beika");
        StringBuilder response = new StringBuilder("Get Address By ID: "+addressId);
        response.append(address3);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertAddress(@RequestBody CreadAddressDTO creadAddressDTO){
        int addressId = creadAddressDTO.getAddressId();
        String country = creadAddressDTO.getCountry();
        String city = creadAddressDTO.getCity();
        String street = creadAddressDTO.getStreet();
        StringBuilder response = new StringBuilder();
        response.append(addressId).append(country).append(city).append(street);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PutMapping(value = "/{address-id}")
    public ResponseEntity updateAddress(@PathVariable(value = "address-id")int addressId,
                                        @RequestBody UpdateAddressDTO updateAddressDTO){
        String country = updateAddressDTO.getCountry();
        String city =updateAddressDTO.getCity();
        String street = updateAddressDTO.getStreet();
        StringBuilder response = new StringBuilder();
        response.append(addressId).append(country).append(city).append(street);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{address-id}")
    public ResponseEntity deleteAddress(@PathVariable(value = "address-id")int addressId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
