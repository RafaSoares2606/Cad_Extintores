/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LigacaoDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jamile
 */
public class UsuariosDAO {

    Connection conn;

    public ResultSet acessaUsuario(LigacaoDTO ObjLigacaoDTO) throws SQLException {

        conn = new LigaDAO().conectaBD();

        try {

            String sql = "select * from tbl_extintores where Tipo = ?, Número = ?, Validade = ?, Localizaçao = ?, id_ordem = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, ObjLigacaoDTO.getTipo());
            pstm.setInt(2, ObjLigacaoDTO.getNumero());
            pstm.setString(3, ObjLigacaoDTO.getValidade());
            pstm.setString(4, ObjLigacaoDTO.getLocalizaçao());
            pstm.setInt(5, ObjLigacaoDTO.getId_Ordem());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Usuário" + erro);
            return null;
        }

    }
}
