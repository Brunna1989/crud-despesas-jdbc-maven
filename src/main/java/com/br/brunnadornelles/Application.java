package com.br.brunnadornelles;

import com.br.brunnadornelles.dao.DespesaDAO;
import com.br.brunnadornelles.model.Categoria;
import com.br.brunnadornelles.model.Despesa;
import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {

        DespesaDAO dao = new DespesaDAO();

        Despesa despesa = new Despesa();
        despesa.setDescricao("Viagem de Uber até o Aeroporto");
        despesa.setCategoria(Categoria.TRANSPORTE);
        despesa.setValor(110);
        despesa.setData(LocalDate.of(2021, 4, 28));

        Despesa despesaInserida = dao.save(despesa);
        System.out.println("Foi inserida a despesa com id: " + despesaInserida.getId());

    }
}