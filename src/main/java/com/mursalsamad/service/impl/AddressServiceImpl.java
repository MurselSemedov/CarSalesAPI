package com.mursalsamad.service.impl;

import com.mursalsamad.dto.input.AddressInputDTO;
import com.mursalsamad.dto.output.AddressOutputDTO;
import com.mursalsamad.enums.MessageType;
import com.mursalsamad.exception.BaseException;
import com.mursalsamad.exception.ErrorMessage;
import com.mursalsamad.model.Address;
import com.mursalsamad.repository.AddressRepository;
import com.mursalsamad.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<AddressOutputDTO> findAll() {
        List<Address> list = addressRepository.findAll();
        List<AddressOutputDTO> dtoList = new ArrayList<>();
        for(Address address : list){
            AddressOutputDTO addressDTO = new AddressOutputDTO();
            BeanUtils.copyProperties(address,addressDTO);
            dtoList.add(addressDTO);
        }
        return dtoList;
    }

    public void saveAddress(AddressInputDTO inputDTO){
        Address address = new Address();
        BeanUtils.copyProperties(inputDTO,address);
        address.setCreateDate(new Date());
        addressRepository.save(address);
    }

    public AddressOutputDTO findById(long id){
        Optional<Address> optional = addressRepository.findById(id);
        if(optional.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_FOUND,"" + id));
        }
        AddressOutputDTO outputDTO = new AddressOutputDTO();
        BeanUtils.copyProperties(optional.get(),outputDTO);
        return outputDTO;
    }

    public void updateById(long id,AddressInputDTO inputDTO){
        Optional<Address> optional = addressRepository.findById(id);
        if(optional.isPresent()){
            Address address = optional.get();
            BeanUtils.copyProperties(inputDTO , address);
            addressRepository.save(address);
        }
    }
}
