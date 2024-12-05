package br.com.livrinhodavovo.api.Services;

import br.com.livrinhodavovo.api.models.Pessoa;
import br.com.livrinhodavovo.api.Repository.PessoaRepository;
import br.com.livrinhodavovo.api.models.Receitas;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ReceitasService receitasService; // Para associar receitas

    // Cadastrar uma nova pessoa
    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void associarReceita(Long pessoaId, Long receitaId) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
        Optional<Receitas> receita = receitasService.buscarReceitaPorID(receitaId);

        if (pessoa.isPresent() && receita.isPresent()) {
            pessoa.get().getReceitas().add(receita.get());  // Adiciona a receita à pessoa
            pessoaRepository.save(pessoa.get());  // Atualiza a pessoa com a nova receita
        }
    }

    public List<Pessoa> listarTodasPessoas() {
        return pessoaRepository.findAll();
    }

}
