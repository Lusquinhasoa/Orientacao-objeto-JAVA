import java.util.Scanner;

public class Gerenciaelevador{

    Scanner in = new Scanner(System.in);

    int andares = 0;
    int passageiros = 0;
    int choose = 0 ;

    public int andar; 
    public int totalAndares; 
    public int capacidade; 
    public int totalPessoas;  

    public static void main(String[] args) {


        Gerenciaelevador senac = new Gerenciaelevador();
        senac.andar = 2;
        senac.totalAndares = 5;
        senac.capacidade = 18;
        senac.totalPessoas = 4;

        
        senac.Choose();

    }
    
    public void Choose()
    {
        System.out.println("O elevador está no " + this.andar + "º andar");
        System.out.println("Tem " + this.totalPessoas + " pessoas dentro do elevador");

        System.out.print("Para qual andar quer ir? 0 - descer ou 1 - subir: ");
        choose = in.nextInt();

        while( choose > 1 || choose < 0  ){

            System.out.println("Número incorreto");

            System.out.print("Para qual andar quer ir? 0 - descer ou 1 - subir: ");
            choose = in.nextInt();
        }

        if(choose == 0){
                Descer();
        }
            else{
                Subir();
        }

    }

    
    public void Entrar()
    {
        System.out.print("Quantos passageiros entraram ? ");
        passageiros = in.nextInt();
        System.out.println("Entraram " + passageiros + " pessoas.");
        this.totalPessoas = this.totalPessoas + passageiros;

        if(this.totalPessoas > this.capacidade ){

            System.out.println("Elevador lotado !!");
            System.out.println( (this.totalPessoas - this.capacidade) + "Pessoas vão ficar do lado de fora ");

        }else{

            System.out.println("Elevador está com " + this.totalPessoas + " a bordo.");

        }

    }

 
    public void Sair()
    {

        System.out.print("Quantas pessoas sairam ? ");
        passageiros = in.nextInt();
        this.totalPessoas = this.totalPessoas - passageiros;

        if(this.totalPessoas == 0){

            System.out.println("Elevador vazio !!!");
        
        }else if( this.totalPessoas <= -1 ){
            System.out.println("Número menor que o esperado");
            System.out.print("Quantas pessoas sairam ? ");
            passageiros = in.nextInt();
            totalPessoas = 4;
            this.totalPessoas = this.totalPessoas - passageiros;
            
        }else{

            System.out.println("Elevador está com " + this.totalPessoas + " pessoas a bordo.");
        }
  
    }


    public void Subir()
    {
        System.out.print("Vai subir até qual andar ? ");
        andares = in.nextInt();

        this.andar = this.andar + (andares - this.andar);

        if( this.andar >= this.totalAndares){

            this.andar = this.totalAndares;
            System.out.println("Estamos no último andar, " + this.andar + "º" );

        }else{

            System.out.println("Subindo até o " + this.andar);

        }

        if ( this.andar == 3){
            System.out.println("Cuidado!! Gabriel está por aí querendo bolo de cenoura");
        }

        Sair();
        Entrar();
        Choose();

        
    }

 
    public void Descer()
    {

        System.out.print("Vai descer até qual andar ? ");
        andares = in.nextInt();

        while( andares >= this.andar ){
            System.out.print("Andar inválido, escolha outro ");
            andares = in.nextInt();
        }

        this.andar = (andares + this.andar) - this.andar ;
        
        if( this.andar == 0 ){

            System.out.println("Descendo até o térreo");
            this.andar = 0;

        }
        else if( this.andar < 0){
            System.out.println("Indo ao subsolo");
        }
        else{
            System.out.println("Descendo até " + this.andar + "º");
        }


        Sair();
        Entrar();
        Choose();

    }

}
