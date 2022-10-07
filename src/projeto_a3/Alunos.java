package projeto_a3;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Alunos extends Pessoas{
    public int d_treinos;
    public float altura;
    public double peso;
        
   public Alunos(String nome, String email, String fone, int idade, int sexo, float altura, double peso, int d_treinos) {
        super(nome,idade,sexo,email,fone);
        this.d_treinos = d_treinos;
        this.peso = peso;
        this.altura = altura;
        
    }
 

    public int getD_treinos() {
        return d_treinos;
    }   
    public void setD_treinos(int d_treinos) {
        this.d_treinos = d_treinos;
    }
    public float getAltura() {
        return altura;
    }
     public void setAltura(float altura) {
        this.altura = altura;
    }
    public double getPeso() {
        return peso;
    }     
    public void setPeso(double peso) {
        this.peso = peso;
    }
      @Override
    public void dados(){
        super.dados();
        System.out.println("Altura: " + getAltura());
        System.out.println("Peso: " + getPeso());
        System.out.println("Dias de treinos: " + getD_treinos());
 }
     public void editar_alu(){
 String sql =  "UPDATE alunos SET  "
    + " Nome    = '" + this.getNome() +   "' ,  "
    + " Email   = '" + this.getEmail() +  "' ,  "
    + " Fone   = '" + this.getFone() +  "' ,  "  
    + " Idade   = " + this.getIdade() +  " ,  "  
    + " Sexo =  " + this.getSexo() +  " ,  "     
    + " Altura = " + this.getAltura() +  " ,  "
    + " Peso = " + this.getPeso() +" ,    "
    + " d_treinos = " + this.getD_treinos() +"     "
    + " WHERE idAlunos = " + this.getId();
 
 Conexao.executar( sql );
}
public void cadastrar_alun(){
    String sql = "INSERT INTO alunos (nome, email, fone, idade,sexo,altura, peso, d_treinos) "
            + "VALUES ('"+ this.getNome()+"', "
            + "'"+ this.getEmail()+"', "
            + "'"+ this.getFone()+"', "
            + ""+ this.getIdade()+", "
            + ""+ this.getSexo()+", "
            + ""+ this.getAltura()+", "
            + ""+ this.getPeso()+", "
            + ""+ this.getD_treinos()+")";
    Conexao.executar( sql );

    }

    public static ArrayList<Alunos> getAlunos(){
        ArrayList<Alunos> lista = new ArrayList<>();
        
        String sql = "SELECT idAlunos, nome, email, fone, idade, sexo, Altura, peso, d_treinos FROM alunos ORDER BY idAlunos ";
        
        ResultSet rs = Conexao.consultar( sql );
                
        if( rs != null){
            
            try{
                while ( rs.next() ) { 
                    
                    String nome = rs.getString( "nome" );
                    String email = rs.getString( "email" );
                    String fone = rs.getString("fone");
                    int idade=rs.getInt("idade");
                    int sexo=rs.getInt("sexo");
                    Float altura =rs.getFloat("altura");
                    float peso = rs.getFloat( "peso" );
                    int d_treinos= rs.getInt("d_treinos");
                     
                    
                    Alunos alun = new Alunos(nome, email, fone, idade,sexo, altura, peso, d_treinos);
                    alun.setId( rs.getInt( "idAlunos" ) );
                    lista.add( alun );
                }
            }catch(SQLException e){
                
            }
            
        }
     
        return lista;
    }
 public static void perfil_alu( int idAlunos ){
        
        String sql = "SELECT * FROM  alunos WHERE idalunos =" + idAlunos;
        
        ResultSet rs = Conexao.consultar( sql );
                
        if( rs != null){
            
            try{
                while ( rs.next() ) { 
                    
                    String nome = rs.getString( "nome" );
                    String email = rs.getString( "email" );
                    String fone = rs.getString("fone");
                    int idade=rs.getInt("idade");
                    int sexo=rs.getInt("sexo");
                    Float altura =rs.getFloat("altura");
                    float peso = rs.getFloat( "peso" );
                    int d_treinos= rs.getInt("d_treinos");
                 
                }
            }catch(SQLException e){
                
            }
        
        }
     
 }
public static void excluir_alu( int idAluno ){
        String sql = " DELETE FROM alunos WHERE idalunos = " + idAluno ;
        Conexao.executar( sql );
      
}
     
}

