package com.mursalsamad.controller;

import com.mursalsamad.model.request.AddressInputDTO;
import com.mursalsamad.model.response.AddressOutputDTO;

import java.util.List;

public interface IAddressController {

    public List<AddressOutputDTO> findAll();
    public void saveAddress(AddressInputDTO inputDTO);
}
