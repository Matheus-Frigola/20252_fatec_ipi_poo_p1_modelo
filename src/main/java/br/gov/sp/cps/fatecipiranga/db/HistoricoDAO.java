package br.gov.sp.cps.fatecipiranga.db;

import  br.gov.sp.cps.fatecipiranga.model.Historico;



public class HistoricoDAO {
    public void cadastrar(Historico a) throws Exception {
        var sql = "insert into historico_armas(nome_personagem, nome_arma, usos, mapa) VALUES(?,?,?,?)";
        try (
             var conexao = ConnectionFactory.getConnection();
                var ps = conexao.prepareStatement(sql);){

                    ps.setString(1, a.getNome_personagem());
                    ps.setString(2, a.getNome_arma());
                    ps.setInt(3, a.getUsos());
                    ps.setInt(4, a.getMapa());

                    ps.executeUpdate();
            }
        
    }
    
}