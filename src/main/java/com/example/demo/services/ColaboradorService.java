package com.example.demo.services;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Colaborador;
import com.example.demo.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {
    private static final String PASSWORD_REGEX = "^(?=.*[a-zA-Z]).{6,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_REGEX);
    
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Colaborador getColaborador(String idColaborador) {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(idColaborador);
        return colaborador.get();
    }

    public Colaborador salvar(Colaborador colaborador) throws RuntimeException{
        String senhaNormal = colaborador.getSenha();
        String senhaCriptografada = bCryptPasswordEncoder.encode(senhaNormal);
        colaborador.setSenha(senhaCriptografada);

        Colaborador usr = colaboradorRepository.getColaboradorPorLogin(colaborador.getLogin());
        if(usr != null) {
            throw new RuntimeException("Login já existe");
        }

        Matcher matcher = pattern.matcher(senhaNormal);
        if (!matcher.matches()){
            throw new RuntimeException("Senha não atende os requisitos");
        }

        return colaboradorRepository.save(colaborador);
    }

    public Colaborador atualizar(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public void remover(String idColaborador) {
        colaboradorRepository.deleteById(idColaborador);
    }

    public Colaborador getColaboradorPorLogin(String login) {
      return colaboradorRepository.getColaboradorPorLogin(login);
    }
}
