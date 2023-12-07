package com.example.demo.security;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Colaborador;
import com.example.demo.services.ColaboradorService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ColaboradorService colaboradorService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Colaborador colaborador = colaboradorService.getColaboradorPorLogin(login);
        if (colaborador == null) {
            throw new UsernameNotFoundException(login);
        }
        return new User(colaborador.getLogin(), colaborador.getSenha(), emptyList());
    }
  
}