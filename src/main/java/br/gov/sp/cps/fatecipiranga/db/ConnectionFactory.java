package br.gov.sp.cps.fatecipiranga.db;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
  private static String host = "rimj-fatec-8cf6.k.aivencloud.com";
  private static String port = "24728";
  private static String user = "avnadmin";
  private static String password = "";
  private static String database = "defaultdb";

  static Connection getConnection(){
    try{
     
      String url = String.format(
        "jdbc:postgresql://%s:%s/%s",
        host, port, database
      );
      Connection conexao = DriverManager.getConnection(url, user, password);
      return conexao;
    }
    catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }  

  public static void main(String[] args) {
    Connection conexao = getConnection();
    if(conexao != null){
      System.out.println("Conectou!");
    }
    else{
      System.out.println("Não conectou!");
    }  
  }
}
