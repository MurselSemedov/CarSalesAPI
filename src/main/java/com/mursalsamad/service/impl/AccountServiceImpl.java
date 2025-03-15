package com.mursalsamad.service.impl;

import com.mursalsamad.dao.entity.AccountEntity;
import com.mursalsamad.dao.repository.AccountRepository;
import com.mursalsamad.enums.MessageType;
import com.mursalsamad.exception.BaseException;
import com.mursalsamad.exception.ErrorMessage;
import com.mursalsamad.model.enums.CurrencyType;
import com.mursalsamad.model.request.AccountInputDTO;
import com.mursalsamad.model.response.AccountOutputDTO;
import com.mursalsamad.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
    public List<AccountOutputDTO> getAllAccount() {
        List<AccountEntity> list = accountRepository.findAll();
        List<AccountOutputDTO> accountDTO = new ArrayList<>();
        for(AccountEntity accountEntity : list){
            AccountOutputDTO outputDTO = new AccountOutputDTO();
            BeanUtils.copyProperties(accountEntity,outputDTO);
            accountDTO.add(outputDTO);
        }
        return accountDTO;
    }

    public void saveAccount(AccountInputDTO inputDTO) {
            AccountEntity accountEntity = new AccountEntity();
            BeanUtils.copyProperties(inputDTO, accountEntity);
            accountEntity.setCreateDate(LocalDate.now());
            accountEntity.setCurrencyType(CurrencyType.valueOf(inputDTO.getCurrencyType()));
            accountRepository.save(accountEntity);
    }

    public AccountOutputDTO findById(long id) {
        Optional<AccountEntity> optional = accountRepository.findById(id);
        AccountOutputDTO outputDTO = new AccountOutputDTO();
        optional.ifPresent(accountEntity -> BeanUtils.copyProperties(accountEntity, outputDTO));
        return outputDTO;
    }

    public void updateAccount(long id, AccountInputDTO inputDTO) {
        Optional<AccountEntity> optional = accountRepository.findById(id);
        if(optional.isPresent()){
            AccountEntity accountEntity = optional.get();
            BeanUtils.copyProperties(inputDTO, accountEntity);
            accountRepository.save(accountEntity);
        }
    }

    public void deleteAccount(long id) {
        Optional<AccountEntity> optional = accountRepository.findById(id);
        if(optional.isPresent()){
            accountRepository.delete(optional.get());
        }else{
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_FOUND,"" + id));
        }

    }
}
