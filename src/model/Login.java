package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    // Método para autenticar usuário
    public int autentique(String login, String senha) throws SQLException, ClassNotFoundException {

        // conecta com o banco de dados
        Conexao c = new Conexao();
        c.conecte();

        // Consulta SQL para verificar o login e senha
        String sql = "select * from usuario where login = ? and senha = ?";
        
        // Prepara a consulta
        PreparedStatement stmt = c.conexao.prepareStatement(sql);
        stmt.setString(1, login);
        stmt.setString(2, senha);
        
        // Executa a consulta e obtém o resultado
        ResultSet rs = stmt.executeQuery();

        int usuarioId = rs.next() ? rs.getInt(1) : -1;

        // Retorna true se encontrar um usuário, ou false se não encontrar
        return usuarioId;
    }
}
