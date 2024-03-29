package com.br.brunnadornelles.dao;

import com.br.brunnadornelles.infra.ConnectionFactory;
import com.br.brunnadornelles.model.Categoria;
import com.br.brunnadornelles.model.Despesa;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DespesaDAO implements IDespesaDAO  {
    @Override
    public Despesa save(Despesa despesa) {

        try (Connection connection = ConnectionFactory.getConnection()) {
           String sql = "INSERT INTO Despesas (descricao, valor, data, categoria) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, despesa.getDescricao());
            preparedStatement.setDouble(2, despesa.getValor());
            preparedStatement.setDate(3, java.sql.Date.valueOf(despesa.getData()));
            preparedStatement.setString(4, despesa.getCategoria().toString());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            Long generatedId = resultSet.getLong("id");
            despesa.setId(generatedId);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return despesa;
    }

    @Override
    public Despesa update(Despesa despesa) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Despesa> findAll() {
        String sql = "SELECT id, descricao, data, valor, categoria FROM Despesas";

        List<Despesa> despesas = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()){
          Long id = rs.getLong("id");
          String descricao = rs.getString("descricao");
          LocalDate data = rs.getDate("data").toLocalDate();
          double valor = rs.getDouble("valor");
          Categoria cat = Categoria.valueOf(rs.getString("categoria"));

          Despesa despesa = new Despesa();
          despesas.add(despesa);

        }

        } catch (SQLException ex) {
           throw new RuntimeException(ex);
        }


        return despesas;
    }

    @Override
    public Optional<Despesa> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Despesa> findByCategoria(Categoria categoria) {
        return null;
    }
}
