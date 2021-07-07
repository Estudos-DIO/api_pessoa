package dio.API_Pessoa.controller;

import dio.API_Pessoa.dto.RespostaDTO;
import dio.API_Pessoa.entity.Pessoa;
import dio.API_Pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService servicoPessoa;

    @GetMapping
    public String getInicio()
    {
        return "API_Pessoa Test!";
    }

    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public RespostaDTO criarPessoa(@RequestBody Pessoa pessoa)
    {
        return servicoPessoa.criarPessoa( pessoa );
    }

}
