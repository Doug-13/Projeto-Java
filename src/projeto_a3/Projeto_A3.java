package projeto_a3;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.ArrayList;

public class Projeto_A3 {

    public static void main(String[] args) {
        
              
        Scanner ler = new Scanner(System.in);
        ArrayList<Funcionarios> listaFuncionarios= new ArrayList();
        ArrayList<Alunos> listaAlunos= new ArrayList();
        Alunos aluno;
        Funcionarios funcionario;
        int menu, menu_aluno,menu_func,d_treinos, idFuncionario,idAlunos,teste;
        int idade,sexo,sexo_n;
        String nome,email,fone,especializacao, artigo;
        float salario,altura,imc,peso_min,peso_max,peso_ideal;
        double peso;
        
        do{
        System.out.println("1 - Aluno");
        System.out.println("2 - Funcionário");
        System.out.println("3 - Agenda");
        System.out.println("4 - Sair");
        System.out.print("\nDigite sua opção: ");
        menu=ler.nextInt();
        //LIMPAR TELA
        switch(menu){
               case 1:
                    System.out.println("\n   ALUNOS   \n ");
                    System.out.println("1 - Cadastrar Aluno");
                    System.out.println("2 - Listar Alunos");
                    System.out.println("3 - Excluir Aluno");
                    System.out.println("4 - Editar Aluno");
                    System.out.println("5 - Perfil Aluno");
                    System.out.println("6 - Voltar");
                    System.out.print("\nDigite sua opção: ");
                    menu_aluno=ler.nextInt();
                    ler.nextLine();
                    switch (menu_aluno){
                        case 1:
                            System.out.print("\nDigite o nome Completo: ");
                            nome = ler.nextLine();
                            
                            System.out.print("Email: ");
                            email = ler.nextLine();
                                                        
                            System.out.print("Fone: ");
                            fone = ler.nextLine();
                            
                            System.out.print("Idade: ");
                            idade = ler.nextInt();
                            ler.nextLine();
                            
                            do{
                            System.out.print("Sexo: 1- Masculino \n      2- Feminino\n => ");
                            sexo = ler.nextInt();
                            ler.nextLine();
                                if(sexo==1){
                                    System.out.println("Sexo: Masculino");
                                }else if (sexo==2){
                                   System.out.println("Sexo: Feminino");    
                                }else{
                                   System.out.print("Valor inválido, digite novamente\n");        
                                }
                                
                            }while (sexo<1 || sexo>2);
                            
                            System.out.print("Altura: ");
                            altura = ler.nextFloat();
                            ler.nextLine();
                            
                            System.out.print("Peso: ");
                            peso = ler.nextInt();
                            ler.nextLine();
                            do{
                            System.out.print("Quantidade de treinos semanais? \n    1 - 2X (Terça e Quinta)\n    2 - 3X (Segunda, Quarta e Sexta) ");
                            System.out.print("\n    3 - 4X (Segunda,Terça,Quinta e Sexta)\n    4 - 5X (Todos os dias)\n\n    =>");
                            
                            d_treinos = ler.nextInt();
                            ler.nextLine();
                            if(d_treinos==1){
                                   System.out.println("Reservado: Treinos Todas as Terças e Quintas");
                                }else if (d_treinos==2){
                                   System.out.println("Reservado: Treinos Todas as Segundas, Quartas e Sextas");    
                                }else if(d_treinos==3){
                                   System.out.println("Reservado: Treinos Todas as Segundas,Terças,Quintas e Sextas");       
                                }else if(d_treinos==4){
                                   System.out.println(" Treinos diários "); 
                                }else{
                                   System.out.print("Valor inválido, digite novamente\n");        
                                }
                                }while (d_treinos<1 || d_treinos>4); 
                                System.out.println("\nAguarde enquanto salvamos seus dados!");
                                
                                aluno = new Alunos (nome,email,fone,idade,sexo,altura,peso,d_treinos);
                                aluno.cadastrar_alun();
                                
                                System.out.println("\nCadastro realizado com sucesso!");
                                System.out.println("\n#################################");
                                break;
                        case 2:
                                    System.out.println("\nLista de Alunos: \n");
                                    listaAlunos = Alunos.getAlunos();
                                    for(Alunos f:listaAlunos){
                                        System.out.println("\n");
                                    f.dados();
                                    }
                                    System.out.println("\n#################################");
                                 break;  
                                 
                        case 3:
                                    listaAlunos = Alunos.getAlunos();
                                    for(Alunos p: listaAlunos ){
                                      System.out.println( p.getId() + " - " + p.getNome() );
                                    }
                                    System.out.print("\nDigite o id do Aluno que será excluído: ");
                                    idAlunos = ler.nextInt();
                                    Alunos.excluir_alu( idAlunos );
                                    System.out.println("\nCadastro excluido com sucesso!");
                                    System.out.println("\n#################################");                                   
                            break;
                            
                        case 4:   
                                    listaAlunos = Alunos.getAlunos();
                                        for(Alunos p: listaAlunos ){
                                        System.out.println( p.getId() + " - " + p.getNome() );
                                            }
                                    System.out.print("\nDigite o ID do aluno que será editado: ");
                                    idAlunos = ler.nextInt();
                                    ler.nextLine();
                                    
                                    System.out.print("\nDigite novamente os dados para atualização do cadastro: \n");
                                    System.out.print("\nDigite o nome Completo: ");
                                    nome = ler.nextLine();
                                  
                                    System.out.print("Email: ");
                                    email = ler.nextLine();

                                    System.out.print("Fone: ");
                                    fone = ler.nextLine();

                                    System.out.print("Idade: ");
                                    idade = ler.nextInt();
                                    ler.nextLine();

                                    do{
                                    System.out.print("Sexo: 1- Masculino \n      2- Feminino\n => ");

                                    sexo = ler.nextInt();
                                    ler.nextLine();
                                        if(sexo==1){
                                           System.out.println("Sexo: Masculino");
                                        }else if (sexo==2){
                                           System.out.println("Sexo: Feminino");    
                                        }else{
                                           System.out.print("Valor inválido, digite novamente\n");        
                                        }
                                    }while (sexo<1 || sexo>2);

                                    System.out.print("Altura: ");
                                    altura = ler.nextFloat();
                                    ler.nextLine();

                                    System.out.print("Peso: ");
                                    peso = ler.nextInt();
                                    ler.nextLine();
                                    do{
                                    System.out.print("Quantidade de treinos semanais? \n    1 - 2X (Terça e Quinta)\n    2 - 3X (Segunda, Quarta e Sexta) ");
                                    System.out.print("\n    3 - 4X (Segunda,Terça,Quinta e Sexta)\n    4 - 5X (Todos os dias)\n\n    =>");

                                    d_treinos = ler.nextInt();
                                    ler.nextLine();
                                    if(d_treinos==1){
                                           System.out.println("Reservado: Treinos Todas as Terças e Quintas");
                                        }else if (d_treinos==2){
                                           System.out.println("Reservado: Treinos Todas as Segundas, Quartas e Sextas");    
                                        }else if(d_treinos==3){
                                           System.out.println("Reservado: Treinos Todas as Segundas,Terças,Quintas e Sextas");       
                                        }else if(d_treinos==4){
                                           System.out.println(" Treinos diários "); 
                                        }else{
                                           System.out.print("Valor inválido, digite novamente\n");        
                                        }
                                        }while (d_treinos<1 || d_treinos>4); 
                                        System.out.println("\nAguarde enquanto salvamos seus dados!");

                                        aluno = new Alunos (nome,email,fone,idade,sexo,altura,peso,d_treinos);
                                        aluno.setId( idAlunos );
                                        aluno.editar_alu();
                                        
                                        System.out.println("\nCadastro atualizado com sucesso!");
                                        System.out.println("\n#################################");
                            break;
                         case 5:
                                    listaAlunos = Alunos.getAlunos();
                                    for(Alunos p: listaAlunos ){
                                    System.out.println( p.getId() + " - " + p.getNome() );
                                    }
                                    
                                    System.out.print("\nDigite o ID para ver o perfil completo do Aluno: ");
                                    idAlunos = ler.nextInt();
                                    ler.nextLine();
                                    Alunos.perfil_alu(idAlunos);
                                                                        
                                    listaAlunos = Alunos.getAlunos();
                                                                       
                                    for(Alunos p: listaAlunos ){
                                    teste =  p.getId();
                                    if (idAlunos==teste){
                                            System.out.println( "\n -----------   ID: " + p.getId() + "\n|           |  Nome: " + p.getNome() );
                                            sexo_n = p.getSexo();
                                              if(sexo_n==1){
                                                 System.out.println( "|    Foto   |  Idade: "+p.getIdade()+ "        Sexo: Masculino" );
                                              }else if (sexo_n==2){
                                                   System.out.println( "|    Foto   |  Idade: "+p.getIdade()+ "        Sexo: Feminino" );    
                                                }
                                            System.out.println( "|    3X4    |  E-mail: "+p.getEmail()+ "       Fone: " + p.getFone() );
                                            System.out.println( "|           |  Altura: "+p.getAltura() + "     Peso: " + p.getPeso() );
                                            d_treinos = p.getD_treinos();                                  
                                                if(d_treinos==1){
                                                   System.out.println("|___________|  Dias de Treinos: Terças e Quirtas\n");
                                                }else if (d_treinos==2){
                                                   System.out.println("|___________|  Dias de Treinos: Segundas, Quartas e Sextas\n");    
                                                }else if(d_treinos==3){
                                                   System.out.println("|___________|  Dias de Treinos: Segundas,Terças,Quintas e Sextas\n");       
                                                }else if(d_treinos==4){
                                                   System.out.println("|___________|  Treinos diários\n ");
                                      }        
                                                                        
                                    if(p.getSexo()==1){
                                        artigo="o";
                                    }else
                                        artigo="a";
                                              
                                        imc = (float) (p.getPeso()/((p.getAltura()*p.getAltura())));
                                        peso_min = (float) (18.5 * (p.getAltura()*p.getAltura()));
                                        peso_max = (float) (24.9 * (p.getAltura()*p.getAltura()));
                                        peso_ideal = (peso_min + peso_max)/2;
                                      
                                      System.out.printf("IMC:%.2f %n",imc);{
                                      if(imc<18.5){
                                        System.out.print("De acordo com o IMC, "+artigo +" alun"+artigo+" está classificad"+artigo+" como MAGREZA Grau 0.");
                                        System.out.printf("\nDe acordo com o peso e altura informados pel"+artigo+" alun"+artigo+" seu peso ideal é entre %.2f Kg e %.2f Kg.",peso_min, peso_max);
                                        System.out.printf("\nPara que "+ artigo +"alun"+artigo+" atinja o peso ideal precisará ganhar %.2f Kg.",(peso_ideal - p.getPeso()));
                                      }else if(imc<24.9){
                                        System.out.print("De acordo com o IMC, "+ artigo +" alun"+artigo+" está classificad"+artigo+" como NORMAL.");
                                        System.out.printf("\nDe acordo com o peso e altura informados pel"+artigo+" alun"+artigo+" seu peso ideal é entre %.2f kg e %.2f Kg.",peso_min, peso_max);
                                        System.out.printf("\nAtualmente "+ artigo +"alun"+artigo+", encontra-se dentro desta faixa.\n");
                                      }else if(imc<29.9){
                                        System.out.print("De acordo com o IMC, "+ artigo +" alun"+artigo+" está classificad"+artigo+" como SOBREPESO Grau I.");
                                        System.out.printf("\nDe acordo com o peso e altura informados pel"+artigo+" alun"+artigo+" seu peso ideal é entre %.2f Kg e %.2f Kg).",peso_min, peso_max);
                                        System.out.printf("\nPara que "+ artigo +" alun"+artigo+" atinja a faixa de peso ideal precisará perder %.2f Kg ",( p.getPeso() - peso_max));
                                      }else if(imc<39.9){  
                                        System.out.print("De acordo com o IMC, "+ artigo +" alun"+artigo+" está classificad"+artigo+" como SOBREPESO Grau II.");
                                        System.out.printf("\nDe acordo com o peso e altura informados pel"+artigo+" alun"+artigo+" seu peso ideal é entre %.2f Kg e %.2f kg.",peso_min,peso_max);
                                        System.out.printf("\nPara que "+ artigo +" alun"+artigo+" atinja a faixa de peso ideal precisará perder %.2f Kg",( p.getPeso() - peso_max));
                                      }else if(imc>39.91){  
                                        System.out.println("De acordo com o IMC, "+ artigo +" alun"+artigo+" está classificad"+artigo+" como OBESIDADE GRAVE.");
                                        System.out.printf("\nDe acordo com o peso e altura informados pel"+artigo+" alun"+artigo+" seu peso ideal é entre %.2f 2kg e %.2f Kg.",peso_min," e ",peso_max);
                                        System.out.printf("\nPara que "+ artigo +" alun"+artigo+" atinja a faixa de peso ideal precisará perder %.2f Kg",( p.getPeso() - peso_max));
                                      }                                             
                                    }    
                                      
                                      System.out.println("\n\n#################################\n");
                                    }
                                    }
                                    
                            break;
        }
                    break;
                                    
                    case 2:
                            System.out.println("\n   FUNCIONÁRIOS   \n ");
                            System.out.println("1 - Cadastrar ");
                            System.out.println("2 - Listar ");
                            System.out.println("3 - Excluir ");
                            System.out.println("4 - Editar ");
                            System.out.println("5 - Sair");
                            System.out.print("\nDigite sua opção: ");
                            menu_func=ler.nextInt();
                             ler.nextLine();
                            switch (menu_func){
                                case 1:
                                    System.out.print("\nDigite o nome Completo: ");
                                    nome = ler.nextLine();

                                    System.out.print("Email: ");
                                    email = ler.nextLine();

                                    System.out.print("Fone: ");
                                    fone = ler.nextLine();

                                    System.out.print("Idade: ");
                                    idade = ler.nextInt();
                                     ler.nextLine();
                                    do{
                                    System.out.print("Sexo: 1- Masculino \n      2- Feminino\n => ");
                                    sexo = ler.nextInt();
                                     ler.nextLine();
                                        if(sexo==1){
                                           System.out.println("Sexo: Masculino");
                                        }else if (sexo==2){
                                           System.out.println("Sexo: Feminino");    
                                        }else{
                                           System.out.print("Valor inválido, digite novamente!!\n");        
                                        }
                                    }while (sexo<1 || sexo>2);

                                    System.out.print("Especialização: ");
                                    especializacao = ler.nextLine();

                                    System.out.print("Salário: ");
                                    salario = ler.nextFloat();
                                     ler.nextLine();
                                System.out.println("\nAguarde enquanto salvamos seus dados!");
                                funcionario = new Funcionarios (nome,email,fone,idade,sexo,especializacao,salario);
                                funcionario.cadastrar_func();
                                
                                System.out.println("\nCadastro realizado com sucesso!");
                                break;
                                case 2:
                                    System.out.println("\nLista de Profissionais: ");
                                    listaFuncionarios = Funcionarios.getFuncionarios();
                                    for(Funcionarios f:listaFuncionarios){
                                        System.out.println("\n");
                                    f.dados();
                                    }
                                    System.out.println("\n#################################\n"); 
                                 break;  
                                 
                                case 3:
                                    listaFuncionarios = Funcionarios.getFuncionarios();
                                    for(Funcionarios f: listaFuncionarios ){
                                      System.out.println( f.getId() + " - " + f.getNome() );
                                    }
                                    System.out.print("Digite o id do profissional que será excluído: ");
                                    idFuncionario = ler.nextInt();
                                    Funcionarios.excluir_func( idFuncionario );
                                    System.out.print("Funcionário excluido com sucesso");
                                    break;
                                    
                                case 4:
                                    listaFuncionarios = Funcionarios.getFuncionarios();
                                    for(Funcionarios p: listaFuncionarios ){
                                      System.out.println( p.getId() + " - " + p.getNome() );
                                    }
                                    System.out.print("Digite o ID do profissional que será editado: ");
                                    idFuncionario = ler.nextInt();
                                     ler.nextLine();
                                    
                                    System.out.print("\nDigite novamente os dados para atualização do cadastro: \n");
                                    System.out.print("\nDigite o nome Completo: ");
                                    nome = ler.nextLine();

                                    System.out.print("E-mail: ");
                                    email = ler.nextLine();

                                    System.out.print("Fone: ");
                                    fone = ler.nextLine();

                                    System.out.print("Idade: ");
                                    idade = ler.nextInt();

                                    do{
                                    System.out.print("Sexo: 1- Masculino \n      2- Feminino\n => ");
                                    sexo = ler.nextInt();
                                        if(sexo==1){
                                           System.out.println("Sexo: Masculino");
                                        }else if (sexo==2){
                                           System.out.println("Sexo: Feminino");    
                                        }else{
                                           System.out.print("Valor inválido, digite novamente!!\n");        
                                        }
                                    }while (sexo<1 || sexo>2);

                                    System.out.print("Especialização: ");
                                    ler.nextLine();
                                    especializacao = ler.nextLine();

                                    System.out.print("Salário: ");
                                    salario = ler.nextFloat();
                                     ler.nextLine();
                                    System.out.println("\nAguarde enquanto salvamos seus dados!\n");
                                                                                                 
                                    funcionario = new Funcionarios (nome,email,fone,idade,sexo,especializacao,salario);
                                    funcionario.setId( idFuncionario );
                                    funcionario.editar_func();
                                    
                                    System.out.println("\nCadastro atualizado com sucesso!");
                                    System.out.println("\n#################################\n");
                            }break;
                                    
                            
                    case 3:         
                                    System.out.print("\n\tAGENDA SEMANAL\n\tSegunda-feira\n");              
                                    listaAlunos = Alunos.getAlunos();
                                    for(Alunos p: listaAlunos ){                                  
                                    if(p.getD_treinos()==2 || p.getD_treinos()==3||p.getD_treinos()==4)
                                        System.out.print(p.getNome()+"\n");
                                    }
                                    
                                    System.out.print("\n\tTerça-feira\n");              
                                    listaAlunos = Alunos.getAlunos();
                                    for(Alunos p: listaAlunos ){                                  
                                    if(p.getD_treinos()==1 || p.getD_treinos()==3||p.getD_treinos()==4)
                                        System.out.print(p.getNome()+"\n");
                                    }
                                    
                                    System.out.print("\n\tQuarta-feira\n");              
                                    listaAlunos = Alunos.getAlunos();
                                    for(Alunos p: listaAlunos ){                                             
                                    if(p.getD_treinos()==2 || p.getD_treinos()==3)
                                        System.out.print(p.getNome()+"\n");
                                    }
                                    
                                    System.out.print("\n\tQuinta-feira\n");              
                                    listaAlunos = Alunos.getAlunos();
                                    for(Alunos p: listaAlunos ){                           
                                    if(p.getD_treinos()==1 || p.getD_treinos()==3||p.getD_treinos()==4)
                                        System.out.print(p.getNome()+"\n");
                                    }
                                    
                                    System.out.print("\n\tSexta-feira\n");              
                                    listaAlunos = Alunos.getAlunos();
                                    for(Alunos p: listaAlunos ){
                                    if(p.getD_treinos()==2 || p.getD_treinos()==3||p.getD_treinos()==4)
                                        System.out.print(p.getNome()+"\n");
                                    }
                                    System.out.println("\n#################################\n"); 
                            break;  
            }
            } while(menu!=4);
     
            System.out.println("\nPrograma encerrado com sucesso!!\n");         
    } 
}
            
        