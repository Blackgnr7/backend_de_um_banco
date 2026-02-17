package banco.meubanco.controllers;

import banco.meubanco.dados.Transações;
import banco.meubanco.dados.TransaçõesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transações")
public class transações {
    @Autowired
    private TransaçõesRepository transaçãorepository;

    @PostMapping("/enviar")
    public Transações enviar_dinheiro(@RequestBody Transações transação){
        return transaçãorepository.save(transação);
    }
    @GetMapping("/ver_todos")
    public List<Transações> receber_todos(){
        return transaçãorepository.findAll();
    }
}
