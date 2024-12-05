package br.com.livrinhodavovo.api.Services;


import br.com.livrinhodavovo.api.Repository.ReceitasRepository;
import br.com.livrinhodavovo.api.models.Receitas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceitasService {

    @Autowired
    ReceitasRepository receitasRepository;

    public void cadastrarReceita(Receitas receitas) {
        receitasRepository.save(receitas);
    }

    public List<Receitas> listarTodasReceitas() {
        return receitasRepository.findAll();
    }

    public Optional<Receitas> buscarReceitaPorID(Long id) {
        return receitasRepository.findById(id);
    }

    public void deletarReceitaPorId(Long id) {
        receitasRepository.deleteById(id);
    }


    public Receitas atualizarReceitaPorId(Long id, Receitas receitas) {
        Optional<Receitas> receitaDoBancoDeDados = buscarReceitaPorID(id);

        if (receitaDoBancoDeDados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Receita Não Encontrada");
        }

        Receitas receitaEditada = receitaDoBancoDeDados.get();
        receitaEditada.setNomeReceita(receitas.getNomeReceita());
        receitaEditada.setReceita(receitas.getReceita());
        receitaEditada.setObsReceita(receitas.getObsReceita());
        receitaEditada.setCustoProducao(receitas.getCustoProducao());



        return receitasRepository.save(receitaEditada);
    }


    //////////////////////////////////////////// CONSULTAS /////////////////////////////////////////////////////////////

    public List<String> listarPessoasDoces() {
        // Buscar todas as receitas de categoria DOCE
        List<Receitas> receitasDoces = receitasRepository.findByCategoria("DOCE");

        // Extrair os nomes das pessoas das receitas
        return receitasDoces.stream()
                .map(receita -> receita.getPessoa().getNome())  // Aqui estamos pegando o nome da pessoa associada à receita
                .distinct()  // Garantir que a lista de nomes seja única
                .collect(Collectors.toList());
    }

    public List<String> listarPessoasChurras() {
        // Buscar todas as receitas de categoria DOCE
        List<Receitas> receitasChurras = receitasRepository.findByCategoria("CHURRAS");

        // Extrair os nomes das pessoas das receitas
        return receitasChurras.stream()
                .map(receita -> receita.getPessoa().getNome())  // Aqui estamos pegando o nome da pessoa associada à receita
                .distinct()  // Garantir que a lista de nomes seja única
                .collect(Collectors.toList());
    }

    public List<String> listarPessoasSalgados() {
        // Buscar todas as receitas de categoria DOCE
        List<Receitas> receitasSalgadas = receitasRepository.findByCategoria("SALGADO");

        // Extrair os nomes das pessoas das receitas
        return receitasSalgadas.stream()
                .map(receita -> receita.getPessoa().getNome())  // Aqui estamos pegando o nome da pessoa associada à receita
                .distinct()  // Garantir que a lista de nomes seja única
                .collect(Collectors.toList());
    }

    public List<Receitas> listarTop10ReceitasMaisCaras() {
        return receitasRepository.findTop10ReceitasMaisCaras();
    }


}
