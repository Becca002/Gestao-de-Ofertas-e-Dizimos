/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Oferta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import model.Conexao;

/**
 *
 * @author becca
 */
public class OfertaModel {
    public ArrayList liste() throws ClassNotFoundException, SQLException, ParseException {
        
        ArrayList<Oferta> ofertas = new ArrayList<>();
        
        Conexao c = new Conexao();
        c.conecte();
        
        Statement st = c.conexao.createStatement();
        
        String sql = "select o.oferta_id, o.valor, o.pago, o.categoria, o.usuario_id, o.membro_id, m.nome as membro from oferta o inner join membro m on m.membro_id = o.membro_id order by o.data_hora desc";
        
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()) {
            Oferta oferta = new Oferta(
                rs.getInt(1),
                rs.getDouble(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getInt(5),
                rs.getInt(6),
                rs.getString(7)
        );
            ofertas.add(oferta);
        }
        
        return ofertas;
    }
    
    // MÉTODO DE REGISTRO 
    public String grave(Oferta oferta) throws ClassNotFoundException, SQLException {
        String msg = "";
        Conexao c = new Conexao();
        c.conecte(); 
        
        String sql = "call p_salve_oferta(?, ?, ?, ?, ?, ?)";
        
        PreparedStatement st = c.conexao.prepareStatement(sql);
        
        st.setInt(1, oferta.getOfertaId());
        st.setDouble(2, oferta.getValor());
        st.setInt(3, oferta.getPago());
        st.setString(4, oferta.getCategoria());
        st.setInt(5, oferta.getUsuarioId());
        st.setInt(6, oferta.getMembroId());
        
        st.executeUpdate();
        ResultSet rs = st.getResultSet();
        rs.next();
        
        msg = rs.getString(2);
        st.close();
        
        return msg;
    }
    
    // MÉTODO DE REMOÇÃO/EXCLUSÃO
    public String remova(int ofertaId) throws ClassNotFoundException, SQLException {
        String msg = "";
        
        Conexao c = new Conexao();
        c.conecte();
        
        String sql = "call p_delete_oferta(?)";
        
        PreparedStatement st = c.conexao.prepareStatement(sql);
        st.setInt(1, ofertaId);
        ResultSet rs = st.executeQuery();
        
        rs.next();
        msg = rs.getString(2);
        st.close();
        
        return msg;
    }
    
    // MÉTODO DE PESQUISA
    public ArrayList pesquise(int membroId) throws ClassNotFoundException, SQLException, ParseException {
        
        ArrayList<controller.Oferta> ofertas = new ArrayList<>();
        
        Conexao c = new Conexao();
        c.conecte();
        
        String sql = "select o.oferta_id, o.valor, o.pago, o.categoria, o.usuario_id, o.membro_id, m.nome as membro from oferta o inner join membro m on m.membro_id = o.membro_id where o.membro_id = ? order by o.data_hora desc";
        
        PreparedStatement st = c.conexao.prepareStatement(sql);
        
        st.setInt(1, membroId);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
            Oferta oferta = new Oferta(
            rs.getInt(1),
            rs.getDouble(2),
            rs.getInt(3),
            rs.getString(4),
            rs.getInt(5),
            rs.getInt(6),
            rs.getString(7)
        );
            ofertas.add(oferta);
        }
        
        return ofertas;
    }
}
