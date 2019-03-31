package classes;
import views.*;
public class MainProgram {
	
	public static void main(String[]args)
	{
		
		Arquivo arquivo=new Arquivo();
		TLista L=new TLista();
		arquivo.Carrega(L);
		long tempoI = System.currentTimeMillis();
		int numeroComparacao = 0;
		

	
		
//		viewLogin openProject = new viewLogin();
//		openProject.setVisible(true);

		/*
		//Modulo Bubble vs Merge único caso que merge ganha
		
		TLista L=new TLista();
		arquivo.Carrega(L);
		long tempoInicial = System.currentTimeMillis();
		L.BubbleSort_Popularity();
		System.out.print("Tempo Bubble: ");
       	System.out.print(System.currentTimeMillis() - tempoInicial);
		System.out.println();
		
		L=new TLista();
		arquivo.Carrega(L);
		tempoInicial = System.currentTimeMillis();
		L.MergeSort_Popularity();
		System.out.print("Tempo Merge: ");
       	System.out.print(System.currentTimeMillis() - tempoInicial);
       	System.out.println();
       	*/
       
		/*
		//Modulo para testar o tempo de carregamento do arquivo base para um já quebrado
		 
		Arquivo arquivo=new Arquivo();
		
		TLista L=new TLista();
		long tempoInicial = System.currentTimeMillis();
		arquivo.Carrega(L);
		System.out.print("Tempo para carregar IMDB.txt: ");
       	System.out.print(System.currentTimeMillis() - tempoInicial);
       	
       	arquivo.SalvaLista(L);
       	System.out.println();
       	       	
       	L=new TLista();
       	tempoInicial = System.currentTimeMillis();
		arquivo.Carrega(L);
		System.out.print("Tempo para carregar IMDB_QB.txt: ");
       	System.out.print(System.currentTimeMillis() - tempoInicial);
       	*/
		
	}
}
