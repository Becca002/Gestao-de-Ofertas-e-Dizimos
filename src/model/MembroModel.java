package model;

import controller.Membro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MembroModel {

    public ArrayList liste() throws ClassNotFoundException, SQLException, ParseException {

        ArrayList<controller.Membro> membros = new ArrayList<>();

        Conexao c = new Conexao();
        c.conecte();

        Statement st = c.conexao.createStatement();

        String sql = "select membro_id, nome, data_cadastro, telefone, usuario_id from membro order by nome";

        ResultSet rs = st.executeQuery(sql);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        while (rs.next()) {
            Membro membro = new Membro(
                rs.getInt(1),
                rs.getString(2),
                format.parse(rs.getString(3)),
                rs.getString(4),
                rs.getInt(5)
            );
            membros.add(membro);
        }

        return membros;
    }

    // registra um membro no banco de dados
    public String grave(Membro membro) throws ClassNotFoundException, SQLException {
        // declara uma variável para armazenar a mensagem
        String msg = "";
        Conexao c = new Conexao();
        c.conecte();

        String sql = "call p_salve_membro(?, ?, ?, ?, ?)";

        PreparedStatement st = c.conexao.prepareStatement(sql);

        st.setInt(1, membro.getMembroId());
        st.setString(2, membro.getNome());
        st.setString(3, membro.getTelefone());
        st.setDate(4, new java.sql.Date(membro.getDataNascimento().getTime()));
        st.setInt(5, membro.getUsuarioId());

        st.executeUpdate();
        ResultSet rs = st.getResultSet();
        rs.next();
        
        msg = rs.getString(2);
        st.close();

        return msg;
    }

    // método responsável por executar a procedure de remoção de membro
    public String remova(int membroId) throws ClassNotFoundException, SQLException {
        // mensagem que será retornada
        String msg = "";

        // cria uma conexão com o banco de dados
        Conexao c = new Conexao();
        c.conecte();

        // chamada da procedure de remoção
        String sql = "call p_delete_membro(?)";

        // objeto para manipulação e execução da procedure
        PreparedStatement st = c.conexao.prepareStatement(sql);
        st.setInt(1, membroId);
        ResultSet rs = st.executeQuery();

        // recupera o retorno da procedure
        rs.next();
        msg = rs.getString(2);
        st.close();

        // retorna a mensagem
        return msg;
    }

    public ArrayList pesquise(String termo) throws ClassNotFoundException, SQLException, ParseException {

        ArrayList<controller.Membro> membros = new ArrayList<>();

        Conexao c = new Conexao();
        c.conecte();

        String sql = "select membro_id, nome, data_cadastro, telefone, usuario_id from membro where nome like ? order by nome";

        PreparedStatement st = c.conexao.prepareStatement(sql);

        st.setString(1, "%" + termo + "%");

        ResultSet rs = st.executeQuery();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        while (rs.next()) {
            Membro membro = new Membro(
                rs.getInt(1),
                rs.getString(2),
                format.parse(rs.getString(3)),
                rs.getString(4),
                rs.getInt(5)
            );
            membros.add(membro);
        }

        return membros;
    }

}