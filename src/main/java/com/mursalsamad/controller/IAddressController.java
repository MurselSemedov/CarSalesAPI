package com.mursalsamad.controller;

import com.mursalsamad.dto.input.AddressInputDTO;
import com.mursalsamad.dto.output.AddressOutputDTO;

import java.util.List;

public interface IAddressController {

    public List<AddressOutputDTO> findAll();
    public void saveAddress(AddressInputDTO inputDTO);
}
