/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import DTO.LigacaoDTO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Jamile
 */
public class LigacaoDAO { //classe inserida no pacote DAO - DIRETO AO OBJETO

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LigacaoDTO> lista = new ArrayList<>();

    public void CadastrarDAO(LigacaoDTO objLigacaoDTO) throws SQLException {

        String sql = "insert into tbl_extintores (Tipo, Número, Validade, Localização, id_Ordem ) values (?, ?, ?, ?, ? )";

        conn = new LigaDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, objLigacaoDTO.getTipo());
            pstm.setInt(2, objLigacaoDTO.getNumero());
            pstm.setString(3, objLigacaoDTO.getValidade());
            pstm.setString(4, objLigacaoDTO.getLocalizaçao());            
            pstm.setInt(5, objLigacaoDTO.getId_Ordem());
           

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!"); //Usado para mostrar a mensagem após o cadastro

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar" + erro);
        }
    }

    public void Alterar(LigacaoDTO objLigacaoDTO) throws SQLException {

        String sql = "update tbl_extintores set validade = ?, Localização = ? where id_ordem =? ";

        conn = new LigaDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, objLigacaoDTO.getValidade());
            pstm.setString(2, objLigacaoDTO.getLocalizaçao());
            pstm.setInt(3, objLigacaoDTO.getId_Ordem());

            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro Alterado com Sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro ao Alterar" + erro);
        }
    }

    public ArrayList<LigacaoDTO> ConsultarDAO() throws SQLException{

        String sql = "select * from tbl_extintores";
        conn = new LigaDAO().conectaBD();
        
        try {

            pstm = conn.prepareStatement(sql); //Prepara o estado da conexão com o banco de dados

            rs = pstm.executeQuery(); //codigo para executar a query

            while (rs.next()) {

                LigacaoDTO objLigacaoDTO = new LigacaoDTO();
                
                objLigacaoDTO.setTipo(rs.getString("Tipo"));
                objLigacaoDTO.setNumero(rs.getInt("Número"));
                objLigacaoDTO.setLocalizaçao(rs.getString("Localização"));
                objLigacaoDTO.setValidade(rs.getString("validade"));
                objLigacaoDTO.setId_Ordem(rs.getInt("id_Ordem"));

                lista.add(objLigacaoDTO);
                            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar" + erro);
        }
        return lista;
    }

    public void Excluir(LigacaoDTO objLigacaoDTO) throws SQLException {

        String sql = "delete from tbl_extintores where id_Ordem = ?"; //Comando do SQL para deletar o arquivo no banco
        
        conn = new LigaDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);

            
            pstm.setInt(1,objLigacaoDTO.getId_Ordem());
            

            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro Excluído!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Extintor não excluído" + erro);

        }
} 
}
