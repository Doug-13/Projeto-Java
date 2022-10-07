
package projeto_a3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pessoas{
    private int id;
    private String nome;
    private int idade;
    private int sexo;
    private String email;
    private String fone;
   
    public Pessoas(String nome, int idade,int sexo, String email, String fone){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
        this.fone = fone;
       }
    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

       public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
   
    public int getSexo() {
        return sexo;
    }

  
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

  
    public String getEmail() {
        return email;
    }

   
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getFone() {
        return fone;
    }

   
    public void setFone(String fone) {
        this.fone = fone;
    }
    
/*public void cadastrar(){
    String sql = "INSERT INTO alunos (nome, email, fone, idade,sexo) "
            + "VALUES ('"+ this.getNome()+"', "
            + "'"+ this.getEmail()+"', "
            + "'"+ this.getFone()+"', "
            + ""+ this.getIdade()+", "
            + "'"+ this.getSexo()+"')";
    Conexao.executar( sql );
            
}*/
    public void dados(){
        System.out.println("Nome: " + getNome());
        System.out.println("E-mail: " + getEmail());
        System.out.println("Fone: " + getFone());
        System.out.println("Idade: " + getIdade());
        System.out.println("Sexo: " + getSexo());    
   }

}