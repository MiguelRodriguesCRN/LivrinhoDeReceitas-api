package br.com.livrinhodavovo.api.Controllers;

import br.com.livrinhodavovo.api.models.Pessoa;
import br.com.livrinhodavovo.api.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    // Endpoint para cadastrar uma pessoa
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.cadastrarPessoa(pessoa);
    }

    // Endpoint para associar uma receita a uma pessoa
    @PostMapping("/{pessoaId}/associar-receita/{receitaId}")
    @ResponseStatus(HttpStatus.OK)
    public void associarReceita(@PathVariable Long pessoaId, @PathVariable Long receitaId) {
        pessoaService.associarReceita(pessoaId, receitaId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> listarTodasPessoas() {
        return pessoaService.listarTodasPessoas();
    }
}
