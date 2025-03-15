package com.mursalsamad.controller.impl;

import com.mursalsamad.controller.IAddressController;
import com.mursalsamad.model.request.AddressInputDTO;
import com.mursalsamad.model.response.AddressOutputDTO;
import com.mursalsamad.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/address")
public class AddressController implements IAddressController {

    @Autowired
    IAddressService addressService;

    @GetMapping("/list")
    public List<AddressOutputDTO> findAll() {
        return addressService.findAll();
    }

    @PostMapping("/save")
    public void saveAddress(@RequestBody AddressInputDTO inputDTO) {
        addressService.saveAddress(inputDTO);
    }
}
