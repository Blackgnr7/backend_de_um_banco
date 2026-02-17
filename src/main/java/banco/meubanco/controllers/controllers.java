package banco.meubanco.controllers;

import banco.meubanco.dados.Usuario;
import banco.meubanco.dados.UsariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banco")
public class controllers {
    @Autowired
    private UsariosRepository usuariosRepository;

    @PostMapping("/criar")
    public Usuario criar(@RequestBody Usuario usuario){
        return usuariosRepository.save(usuario);
    }
    @GetMapping("/pegar_conta")
    public List<Usuario> buscar(@RequestParam String nome){
        return usuariosRepository.findByNome(nome);
    }
    @GetMapping("/todos")
    public List<Usuario> todos(){
        return usuariosRepository.findAll();
    }
}
