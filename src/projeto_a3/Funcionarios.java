
package projeto_a3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Funcionarios extends Pessoas{
    private float salario;
    private String especializacao;

    public Funcionarios (String nome, String email, String fone, int idade, int sexo, String especializacao, float salario){
        super(nome,idade,sexo,email,fone);
        this.especializacao=especializacao;
        this.salario = salario;
}

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    @Override
    public void dados(){
        super.dados();
        System.out.println("Salário: " + getSalario());
        System.out.println("Especialização: " + getEspecializacao());
            
   }
    
    public void cadastrar_func(){
    String sql = "INSERT INTO funcionarios (nome, email, fone, idade,sexo,especializacao,salario) "
            + "VALUES ('"+ this.getNome()+"', "
                    + "'"+ this.getEmail()+"', "
                    + "'"+ this.getFone()+"', "
                    + ""+ this.getIdade()+", "
                    + ""+ this.getSexo()+","
                    + "'"+ this.getEspecializacao()+"',"
                    + ""+ this.getSalario()+")";
    
    //System.out.println(sql);
    Conexao.executar( sql );

    }
    public static ArrayList<Funcionarios> getFuncionarios(){
        ArrayList<Funcionarios> lista = new ArrayList<>();
        
        String sql = "SELECT idFuncionarios, nome, email, fone, idade, sexo, especializacao, salario FROM funcionarios ORDER BY idFuncionarios ";
        
        ResultSet rs = Conexao.consultar( sql );
        
        if( rs != null){
            
            try{
                while ( rs.next() ) {                
                    String nome = rs.getString( "nome" );
                    String fone = rs.getString("fone");
                    String email = rs.getString( "email" );
                    int idade=rs.getInt("idade");
                    int sexo=rs.getInt("sexo");
                    String especializacao=rs.getString("especializacao");
                    float salario = rs.getFloat( "salario" );
                   
                    Funcionarios func = new Funcionarios(nome,email,fone,idade,sexo,especializacao,salario);
                    func.setId( rs.getInt( "idFuncionarios" ) );
                    lista.add( func );
                }
            }catch(SQLException e){
                
            }
            
        }
     
        return lista;
    }
 
  
public static void excluir_func( int idfuncionario ){
        String sql = " DELETE FROM funcionarios WHERE idfuncionarios = " + idfuncionario ;
        Conexao.executar( sql );
  
}
                                
 public void editar_func(){
 String sql =  "UPDATE funcionarios SET  "
    + " Nome    = '" + this.getNome() +   "' ,  "
    + " Email   = '" + this.getEmail() +  "' ,  "
    + " Fone   = '" + this.getFone() +  "' ,  "  
    + " Idade   = " + this.getIdade() +  " ,  "  
    + " Sexo =  " + this.getSexo() +  " ,  "     
    + " Salario = " + this.getSalario() +  " ,  "
    + " Especializacao =  '" + this.getEspecializacao() +  "'   "     
    + " WHERE idFuncionarios = " + this.getId();
 Conexao.executar( sql );
}     
}