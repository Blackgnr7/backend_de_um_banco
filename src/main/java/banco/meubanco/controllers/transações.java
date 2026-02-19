package banco.meubanco.controllers;

import banco.meubanco.dados.Transações;
import banco.meubanco.dados.TransaçõesRepository;
import banco.meubanco.dados.Usuario;
import banco.meubanco.services.Jwtserviços;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transações")
public class transações {
    @Autowired
    private Jwtserviços jwtserviçõs;
    @Autowired
    private TransaçõesRepository transaçãorepository;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviar(@RequestBody Transações transacao,@RequestHeader("Authorization") String header) {
        String token = header.replace("Bearer ", "");
        transaçãorepository.save(transacao);
        jwtserviçõs.validarToken(token);
        return ResponseEntity.ok("dinheiro enviado.");
    }
    @GetMapping("/ver_todos")
    public List<Transações> receber_todos(){
        return transaçãorepository.findAll();
    }
}
