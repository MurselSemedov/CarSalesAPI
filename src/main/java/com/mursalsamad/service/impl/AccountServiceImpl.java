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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;

    public List<AccountOutputDTO> getAllAccount() {
        return accountRepository.findAll()
                .stream()
                .map(accountEntity -> AccountOutputDTO.builder()
                 .cartNumber(accountEntity.getCartNumber())
                 .amount(accountEntity.getAmount())
                 .currencyType(accountEntity.getCurrencyType().name())
                 .createDate(accountEntity.getCreateDate()).build()).
                toList();
    }

    @Transactional
    public void saveAccount(AccountInputDTO inputDTO) throws Exception {
            AccountEntity accountEntity = new AccountEntity();
            BeanUtils.copyProperties(inputDTO, accountEntity);
            accountEntity.setCreateDate(LocalDate.now());
            accountEntity.setCurrencyType(CurrencyType.valueOf(inputDTO.getCurrencyType()));
            accountRepository.save(accountEntity);
            //throw new Exception("errors");
            /*Transaction is not working.
            Because thrown Exception is not Runtime Exception.
            Solution try catch{throw new Runtime Exception}*/
    }

    public AccountOutputDTO findById(long id) {
        Optional<AccountEntity> optional = accountRepository.findById(id);
        AccountOutputDTO outputDTO = new AccountOutputDTO();
        optional.ifPresent(accountEntity -> BeanUtils.copyProperties(accountEntity, outputDTO));
        return outputDTO;
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
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
