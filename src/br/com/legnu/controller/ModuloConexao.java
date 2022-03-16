/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.legnu.controller;

import java.sql.*;

/**
 *
 * @author Ad3ln0r
 */
public class ModuloConexao {
    //metodo responsavel pela conexao do banco de dados
    public static Connection conector(){
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/legnuerp";
        String user = "root";
        String password = "Peruca@13";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //A Linha abaixo serve para esclarecer o erro.
            //System.out.println(e);
            return null;
        }
    }
}
