/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compras.controller;

import com.mycompany.compras.model.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProdutoController {
    private ArrayList<Produto> listaDeProdutos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        listaDeProdutos.add(produto);
    }
    
    public void atualizaTabela(JTable tabela){
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        
        for (Produto p: listaDeProdutos){
            Object [] linha = {
                p.getNome(),
                p.getQuantidade(),
                p.getPreco(),
                p.getCodigo()
            };
            modelo.addRow(linha);
         }
    }

    public void editarProduto(int index, Produto produto) {
        if (index >= 0 && index < listaDeProdutos.size()) {
            listaDeProdutos.set(index, produto);
        }
    }

    public void excluirProduto(int index) {
        if (index >= 0 && index < listaDeProdutos.size()) {
            listaDeProdutos.remove(index);
        }else{
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado para exclusão", "Erro ao excluir produto", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public Produto getProduto(int index) {
        if (index >= 0 && index < listaDeProdutos.size()) {
            return listaDeProdutos.get(index);
        }
        return null;
    }
}
