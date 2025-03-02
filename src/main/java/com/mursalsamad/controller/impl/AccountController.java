package com.mursalsamad.controller.impl;

import com.mursalsamad.controller.IAccountController;
import com.mursalsamad.dto.input.AccountInputDTO;
import com.mursalsamad.dto.output.AccountOutputDTO;
import com.mursalsamad.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/account")
public class AccountController implements IAccountController {

    @Autowired
    IAccountService accountService;
    @GetMapping("/list")
    public List<AccountOutputDTO> getAllAccount() {
        return accountService.getAllAccount();
    }


    @PostMapping("/save")
    public void saveAccount(@RequestBody AccountInputDTO inputDTO) {
        accountService.saveAccount(inputDTO);
    }

    @GetMapping("/{id}")
    public AccountOutputDTO findById(@PathVariable long id) {
        return accountService.findById(id);
    }

    @PutMapping("/update/{id}")
    public void updateAccount(@PathVariable long id,@RequestBody AccountInputDTO inputDTO) {
        accountService.updateAccount(id,inputDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable long id) {
        accountService.deleteAccount(id);
    }
}
