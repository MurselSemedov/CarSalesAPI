package com.mursalsamad.service;

import com.mursalsamad.model.request.AccountInputDTO;
import com.mursalsamad.model.response.AccountOutputDTO;

import java.util.List;

public interface IAccountService {

    public List<AccountOutputDTO> getAllAccount();

    public void saveAccount(AccountInputDTO inputDTO) throws Exception;

    public AccountOutputDTO findById(long id);

    public void updateAccount(long id , AccountInputDTO inputDTO);

    public void deleteAccount(long id);
}
