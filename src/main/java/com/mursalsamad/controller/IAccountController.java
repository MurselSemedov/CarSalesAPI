package com.mursalsamad.controller;

import com.mursalsamad.dto.input.AccountInputDTO;
import com.mursalsamad.dto.output.AccountOutputDTO;

import java.util.List;

public interface IAccountController {

    public List<AccountOutputDTO> getAllAccount();

    public void saveAccount(AccountInputDTO inputDTO);

    public AccountOutputDTO findById(long id);

    public void updateAccount(long id , AccountInputDTO inputDTO);

    public void deleteAccount(long id);
}
