package com.mursalsamad.controller;

import com.mursalsamad.model.request.AccountInputDTO;
import com.mursalsamad.model.response.AccountOutputDTO;

import java.util.List;

public interface IAccountController {

    public List<AccountOutputDTO> getAllAccount();

    public void saveAccount(AccountInputDTO inputDTO);

    public AccountOutputDTO findById(long id);

    public void updateAccount(long id , AccountInputDTO inputDTO);

    public void deleteAccount(long id);
}
