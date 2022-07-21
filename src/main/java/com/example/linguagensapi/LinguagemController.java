package com.example.linguagensapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {
    /* private List<Linguagem> linguagens = List.of(
        new Linguagem("Java","image.png", 1),
        new Linguagem("PHP","image2.png",2)
    );
    @GetMapping("/linguagem-preferida")
    public String processarLinguagemPreferida(){
        return "Oi, Java";
    } */
    @Autowired
    private LinguagemRepository repositorio;
    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens(){
        List<Linguagem> linguagens = repositorio.findAll();// Conexão com MongoDB 
        return linguagens;
    }
    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem (Linguagem lingugagem){
        Linguagem salvar = repositorio.save(lingugagem);
        return salvar;
    }
}