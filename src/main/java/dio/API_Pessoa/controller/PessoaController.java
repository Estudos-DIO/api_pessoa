package dio.API_Pessoa.controller;

import dio.API_Pessoa.dto.PessoaDTO;
import dio.API_Pessoa.dto.RespostaDTO;
import dio.API_Pessoa.entity.Pessoa;
import dio.API_Pessoa.exception.ExcecaoPessoaNaoEncontrada;
import dio.API_Pessoa.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/pessoa")
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {
    //-----------------------------------------------------------------------------------
    @Autowired
    private PessoaService servicoPessoa;

    @GetMapping
    public String getInicio()
    {
        return "API_Pessoa Test!";
    }
    //-----------------------------------------------------------------------------------
    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public RespostaDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO)
    {
        return servicoPessoa.criarPessoa( pessoaDTO );
    }
    //-----------------------------------------------------------------------------------
    @GetMapping("/todas")
    public List<PessoaDTO> listarTodos() {

        List<PessoaDTO> lstPessoasDTO = servicoPessoa.listarTodasPessoas();

        return lstPessoasDTO;
    }
    //-----------------------------------------------------------------------------------
    @GetMapping("/{idPessoa}")
    public PessoaDTO pesquisarPorID( @PathVariable("idPessoa") Long idPessoa ) throws ExcecaoPessoaNaoEncontrada {
        return servicoPessoa.pesquisarPorID(idPessoa);
    }
    //-----------------------------------------------------------------------------------
}
