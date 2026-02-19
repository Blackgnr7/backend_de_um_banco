package banco.meubanco.controllers;

import banco.meubanco.dados.Usuario;
import banco.meubanco.dados.UsariosRepository;
import banco.meubanco.services.Jwtserviços;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/banco")
public class controllers {
    @Autowired
    private Jwtserviços jwtserviços;
    @Autowired
    private UsariosRepository usuariosRepository;
    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody Usuario usuario){
        Usuario usuarios = usuariosRepository.save(usuario);
        return ResponseEntity.ok("usuario criado");
    }
    @GetMapping("/pegar_conta")
    public List<Usuario> buscar(Authentication authentication){
        Integer userId = Integer.parseInt(authentication.getName());
        return usuariosRepository.findById(userId);
    }
    @PostMapping("/login")
    public Map<String, String> logar(@RequestBody Usuario request){
        String accessToken = jwtserviços.gerarAccessToken(request.getId());
        String refreshToken = jwtserviços.gerarRefreshToken(request.getId());
        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);
        return tokens;
    }
    @GetMapping("/todos")
    public List<Usuario> todos(){
        return usuariosRepository.findAll();
    }
    @GetMapping("/refresh")
    public Map<String, String> refresh(@RequestBody Map<String, String> request) {
        Claims id = jwtserviços.validarToken(request.get("refreshToken"));
        String novoAccessToken = jwtserviços.gerarAccessToken(Long.parseLong(id.getSubject()));
        return Map.of("accessToken", novoAccessToken);
    }
}
