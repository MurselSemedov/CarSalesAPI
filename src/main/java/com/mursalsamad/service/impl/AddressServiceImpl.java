package com.mursalsamad.service.impl;

import com.mursalsamad.dao.entity.AddressEntity;
import com.mursalsamad.dao.repository.AddressRepository;
import com.mursalsamad.enums.MessageType;
import com.mursalsamad.exception.BaseException;
import com.mursalsamad.exception.ErrorMessage;
import com.mursalsamad.model.request.AddressInputDTO;
import com.mursalsamad.model.response.AddressOutputDTO;
import com.mursalsamad.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private final AddressRepository addressRepository;

    public List<AddressOutputDTO> findAll() {
        List<AddressEntity> list = addressRepository.findAll();
        List<AddressOutputDTO> dtoList = new ArrayList<>();
        for(AddressEntity addressEntity : list){
            AddressOutputDTO addressDTO = new AddressOutputDTO();
            BeanUtils.copyProperties(addressEntity,addressDTO);
            dtoList.add(addressDTO);
        }
        return dtoList;
    }

    public void saveAddress(AddressInputDTO inputDTO){
        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(inputDTO, addressEntity);
        addressEntity.setCreateDate(LocalDate.now());
        addressRepository.save(addressEntity);
    }

    public AddressOutputDTO findById(long id){
        Optional<AddressEntity> optional = addressRepository.findById(id);
        if(optional.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_FOUND,"" + id));
        }
        AddressOutputDTO outputDTO = new AddressOutputDTO();
        BeanUtils.copyProperties(optional.get(),outputDTO);
        return outputDTO;
    }

    public void updateById(long id,AddressInputDTO inputDTO){
        Optional<AddressEntity> optional = addressRepository.findById(id);
        if(optional.isPresent()){
            AddressEntity addressEntity = optional.get();
            BeanUtils.copyProperties(inputDTO , addressEntity);
            addressRepository.save(addressEntity);
        }
    }
}
