package com.mursalsamad.controller.impl;

import com.mursalsamad.controller.IAccountController;
import com.mursalsamad.model.request.AccountInputDTO;
import com.mursalsamad.model.response.AccountOutputDTO;
import com.mursalsamad.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/account")
@RequiredArgsConstructor
public class AccountController implements IAccountController {

    @Autowired
    private final IAccountService accountService;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountOutputDTO> getAllAccount() {
        return accountService.getAllAccount();
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody AccountInputDTO inputDTO) {
        accountService.saveAccount(inputDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountOutputDTO findById(@PathVariable long id) {
        return accountService.findById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccount(@PathVariable long id,@RequestBody AccountInputDTO inputDTO) {
        accountService.updateAccount(id,inputDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable long id) {
        accountService.deleteAccount(id);
    }
}
