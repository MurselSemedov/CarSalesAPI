package com.mursalsamad.service;

import com.mursalsamad.model.request.AddressInputDTO;
import com.mursalsamad.model.response.AddressOutputDTO;

import java.util.List;

public interface IAddressService {

    public List<AddressOutputDTO> findAll();
    public void saveAddress(AddressInputDTO inputDTO);

}
