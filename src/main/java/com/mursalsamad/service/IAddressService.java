package com.mursalsamad.service;

import com.mursalsamad.dto.input.AddressInputDTO;
import com.mursalsamad.dto.output.AddressOutputDTO;

import java.util.List;

public interface IAddressService {

    public List<AddressOutputDTO> findAll();
    public void saveAddress(AddressInputDTO inputDTO);

}
