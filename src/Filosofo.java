
public class Filosofo extends Thread {
	
   final static int TEMPO_MAXIMO = 100;
   Mesa mesa;
   int filosofo;

   public Filosofo (String nome, Mesa mesadejantar, int fil) {
      super(nome);
      mesa = mesadejantar;
      filosofo = fil;
   }

   public void run () {
      
	  int tempo = 0;
      while (true) {
         tempo = (int) (Math.random() * TEMPO_MAXIMO);
         pensar(tempo);
         getGarfos();
         tempo = (int) (Math.random() * TEMPO_MAXIMO);
         comer(tempo);
         returnGarfos();
      }
   }


private void returnGarfos() {
	mesa.pegarGarfos(filosofo);
}

private void getGarfos() {
	mesa.returningGarfos(filosofo);
}

public void pensar (int tempo){  
	  try {
         sleep(tempo);
      }
      catch (InterruptedException e) {
         System.out.println("O Fil�foso pensou em demasia");
      }
   }

   public void comer (int tempo) {
	   try {
         sleep(tempo);
      }
      catch (InterruptedException e) {
         System.out.println("O Fil�sofo comeu em demasia");
      }
   }
}