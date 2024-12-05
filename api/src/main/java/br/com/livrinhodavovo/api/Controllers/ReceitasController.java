package br.com.livrinhodavovo.api.Controllers;


import br.com.livrinhodavovo.api.Services.ReceitasService;
import br.com.livrinhodavovo.api.models.Receitas;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




@RestController
@RequestMapping("/receitas")
public class ReceitasController {



    @Autowired
    ReceitasService receitasService;

    // Cadastro De Receitas
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarReceita(@RequestBody Receitas receitas) {
        receitasService.cadastrarReceita(receitas);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Receitas> ListasTodasReceitas() {
        return receitasService.listarTodasReceitas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Receitas> buscarReceitaPorID(@PathVariable Long id) {
        return receitasService.buscarReceitaPorID(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarReceitaPorId(@PathVariable Long id) {
        receitasService.deletarReceitaPorId(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarReceitaPorId(@PathVariable Long id, @RequestBody Receitas receitas) {
        receitasService.atualizarReceitaPorId(id, receitas);
    }


    ///////////////////////////////////////////////// CONSULTAS /////////////////////////////////////////////////////////////////////////

    @GetMapping("/pessoas-doces")
    @ResponseStatus(HttpStatus.OK)
    public List<String> listarPessoasDoces() {
        return receitasService.listarPessoasDoces();
    }

    @GetMapping("/pessoas-churras")
    @ResponseStatus(HttpStatus.OK)
    public List<String> listarPessoasChurras() {
        return receitasService.listarPessoasChurras();
    }

    @GetMapping("/pessoas-salgados")
    @ResponseStatus(HttpStatus.OK)
    public List<String> listarPessoasSalgadas() {
        return receitasService.listarPessoasSalgados();
    }

    @GetMapping("/top10-receitas-mais-caras")
    @ResponseStatus(HttpStatus.OK)
    public List<Receitas> listarTop10ReceitasMaisCaras() {
        return receitasService.listarTop10ReceitasMaisCaras();
    }







}