package com.mursalsamad.service.impl;

import com.mursalsamad.dto.input.AccountInputDTO;
import com.mursalsamad.dto.output.AccountOutputDTO;
import com.mursalsamad.enums.CurrencyType;
import com.mursalsamad.enums.MessageType;
import com.mursalsamad.exception.BaseException;
import com.mursalsamad.exception.ErrorMessage;
import com.mursalsamad.model.Account;
import com.mursalsamad.repository.AccountRepository;
import com.mursalsamad.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
    public List<AccountOutputDTO> getAllAccount() {
        List<Account> list = accountRepository.findAll();
        List<AccountOutputDTO> accountDTO = new ArrayList<>();
        for(Account account : list){
            AccountOutputDTO outputDTO = new AccountOutputDTO();
            BeanUtils.copyProperties(account,outputDTO);
            accountDTO.add(outputDTO);
        }
        return accountDTO;
    }

    public void saveAccount(AccountInputDTO inputDTO) {
            Account account = new Account();
            BeanUtils.copyProperties(inputDTO,account);
            account.setCreateDate(new Date());
            account.setCurrencyType(CurrencyType.valueOf(inputDTO.getCurrencyType()));
            accountRepository.save(account);
    }

    public AccountOutputDTO findById(long id) {
        Optional<Account> optional = accountRepository.findById(id);
        AccountOutputDTO outputDTO = new AccountOutputDTO();
        optional.ifPresent(account -> BeanUtils.copyProperties(account, outputDTO));
        return outputDTO;
    }

    public void updateAccount(long id, AccountInputDTO inputDTO) {
        Optional<Account> optional = accountRepository.findById(id);
        if(optional.isPresent()){
            Account account = optional.get();
            BeanUtils.copyProperties(inputDTO,account);
            accountRepository.save(account);
        }
    }

    public void deleteAccount(long id) {
        Optional<Account> optional = accountRepository.findById(id);
        if(optional.isPresent()){
            accountRepository.delete(optional.get());
        }else{
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_FOUND,"" + id));
        }

    }
}
