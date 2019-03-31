package classes;


public class TLista {
	public TNodo Primeiro;
	private TNodo Ultimo;

	public TLista() {
		Cria();
	}

	public int getTotalElmentos()
	{
		return this.Primeiro.Item.id;
	}
	
	public TNodo getCabeca()
	{
		return this.Primeiro;
	}
	
	public TNodo getPrimeiro()
	{
		return this.Primeiro.Proximo;
	}
	
	public TNodo getUltimo()
	{
		return this.Ultimo;
	}
	
	private boolean Vazia() {
		return this.Primeiro == this.Ultimo ? true : false;
	}

	private void msgVazia() {
		System.out.println("Lista Vazia!!!");
	}

	private void msgRemovido(TNodo X) {
		System.out.println("Elemento Removido: " + X.Item.id);
	}

	private void Cria() {
		TInfo Item = new TInfo(0, 0l, "", "", "", "", "", "", 0l, "", "", "", 0l, 0, "", "", "", "", 0f, 0);
		this.Primeiro = new TNodo(Item);
		this.Ultimo = this.Primeiro;
		this.Primeiro.Proximo = null;
		this.Primeiro.Anterior = null;
	}

	public void InsereInicio(TInfo Item) {
		TNodo P = this.Primeiro.Proximo; // Primeiro Elemento da Lista
		TNodo N = new TNodo(Item); // Novo Elemento
		N.Proximo = P;
		N.Anterior = null;
		this.Primeiro.Proximo = N;
		if (P == null)
			this.Ultimo = N;
		else
			P.Anterior = N;
		this.Primeiro.Item.id++;
	}

	public void InsereFinal(TInfo Item) {
		TNodo N = new TNodo(Item); // Novo Elemento
		N.Proximo = null;
		if (Vazia())
			N.Anterior = null;
		else
			N.Anterior = this.Ultimo;
		this.Ultimo.Proximo = N;
		this.Ultimo = N;
		this.Primeiro.Item.id++;
	}

	public void InserePosicao(int pos, TInfo Item) {
		int tot = this.Primeiro.Item.id;
		if (pos < 0 || pos > tot) {
			System.out.println("Posição Inválida!!!");
		} else {
			if (pos == 0) {
				InsereInicio(Item);
			} else {
				TNodo Aux = this.Primeiro;
				// Percorre da posição 0 a tot-1 da Lista. Começando com i=1 e
				// aux=Lista.Primeiro->Proximo não passaria pela posição 0.
				for (int i = 0; i < pos; i++)
					Aux = Aux.Proximo;
				if (Aux.Proximo == null) {
					InsereFinal(Item);
				} else {
					// Nota: aux possui o valor do endereço da posição anterior a que foi informado,
					// exemplo se foi informada a posição 3 aux tem o endereço da posição 2
					// P: possui o endereço da posição informada, a qual passara a ser a posição do
					// Novo valor;
					TNodo P = Aux.Proximo;
					TNodo N = new TNodo(Item);

					N.Proximo = Aux.Proximo;
					N.Anterior = Aux;
					Aux.Proximo = N;
					P.Anterior = N;

					this.Primeiro.Item.id++;
				}
			}
		}
	}

	public void RemoveInicio() {
		if (Vazia())
			msgVazia();
		else {
			// P primeiro elemento | S segundo elemento
			TNodo P = this.Primeiro.Proximo;
			TNodo S = P.Proximo;
			this.Primeiro.Proximo = S;
			if (S == null)
				this.Ultimo = this.Primeiro;
			else
				S.Anterior = null;
			this.Primeiro.Item.id--;
			msgRemovido(P);
		}

	}

	public void RemoveFinal() {
		if (Vazia()) {
			msgVazia();
		} else {
			// Úlltimo | P=Penúltimo
			TNodo U = this.Ultimo;
			TNodo P = U.Anterior;
			if (P == null) {
				this.Primeiro.Proximo = null;
				this.Ultimo = this.Primeiro;
			} else {
				P.Proximo = U.Proximo;
				this.Ultimo = P;
			}
			msgRemovido(U);
			this.Primeiro.Item.id--;
		}
	}

	public void PesquisaRemove(TInfo Item) {
		int found = 0; // usado para identificar se o elemento foi encontrado 0 para não 1 para sim
		boolean control = true; // usado para excluir todas as repetições do elemento informado
		if (Vazia()) {
			msgVazia();
		} else {
			while (control) {
				control = false;
				TNodo P = this.Primeiro.Proximo;
				while (P != null) {
					if (P.Item.id == Item.id) {
						if (P.Anterior == null) {
							RemoveInicio();
						} else {
							if (P.Proximo == null) {
								RemoveFinal();
							} else {
								TNodo Prox = P.Proximo;
								TNodo Ant = P.Anterior;
								Ant.Proximo = Prox;
								Prox.Anterior = Ant;

								this.Primeiro.Item.id--;
								msgRemovido(P);
							}
						}
						found = 1;
						control = true;
						break;
					}
					P = P.Proximo;
				}
			}
			if (found == 0)
				System.out.println("Elemento não está na Lista!!!");
		}
	}

	public void Imprime() {

		if (Vazia()) {
			msgVazia();
		} else {
			int i = 0;
			System.out.println("------------------------------------------------");
			System.out.println("Lista Impressa\n");
			TNodo aux = this.Primeiro.Proximo;
			while (aux != null) {
				System.out.println(i + "º= " + aux.Item.Popularity);
				aux = aux.Proximo;
				i++;
			}
			System.out.println("------------------------------------------------");
		}
	}

	public void ImprimeInversa() {
		if (Vazia()) {
			msgVazia();
		} else {
			int i = this.Primeiro.Item.id - 1;
			System.out.println("------------------------------------------------");
			System.out.println("Lista Inversa\n");
			TNodo Inversa = this.Ultimo;
			do {
				System.out.println(i + "º= " + Inversa.Item.id);
				i--;
				Inversa = Inversa.Anterior;
			} while (Inversa != null);
			System.out.println("------------------------------------------------");
		}
	}

	public void ImprimeAllAtributos() {
		if (Vazia()) {
			msgVazia();
		} else {
			int i = 0;
			System.out.println("------------------------------------------------");
			System.out.println("Lista Impressa\n");
			TNodo aux = this.Primeiro.Proximo;
			while (aux != null) {
				System.out.println("------------------------------------------------");
				System.out.println("Filme " + i + "\n");
				aux.Item.Status();
				try {Thread.sleep(1000);} catch (InterruptedException ex) {}
				aux = aux.Proximo;
				i++;
			}
			System.out.println("------------------------------------------------");
		}
	}

	public TLista CopyList()
	{
		if(!Vazia())
		{
			TLista Local=new TLista();
			
			TNodo Aux=this.getPrimeiro();
			while(Aux!=null)
			{
				Local.InsereFinal(Aux.Item);
				Aux=Aux.Proximo;
			}
			
			return Local;
		}
		return null;
	}
//-------------------------------------Algoritmos de Pesquisa----------------------------------------------------------------------------------------

	public TNodo BuscaBinaria(int ElementoBuscado) // Feita por id pois é unico.
	{
		if (Vazia()) {
			return null;
		} else {
			TNodo Aux = null;
			return BuscaBIN(Aux, ElementoBuscado, 0, this.Primeiro.Item.id - 1);
		}
	}

	private TNodo BuscaBIN(TNodo Aux, int ElementoBuscado, int i, int j) {
		int metade = (i + j) / 2;
		Aux = getPositionList(metade);
		if (i > j)
			return null;
		else {
			if (Aux.Item.id == ElementoBuscado) // adaptar
				return Aux;
			else {
				if (ElementoBuscado < Aux.Item.id) // adaptar
					Aux = BuscaBIN(Aux, ElementoBuscado, i, metade - 1);
				else
					Aux = BuscaBIN(Aux, ElementoBuscado, metade + 1, j);
			}
		}
		return Aux;
	}

	public TNodo getPositionList(int pos) {
		TNodo Position = this.Primeiro.Proximo;
		for (int i = 0; i < pos; i++) {
			Position = Position.Proximo;
		}
		return Position;
	}
	
	public TNodo getPositionListInversa(int pos)
	{
		TNodo Position=this.Ultimo;
		for(int i=this.Primeiro.Item.id-1;i>pos;i--)
		{
			Position=Position.Anterior;
		}
		return Position;
	}

	public TNodo BuscaSequencial_id(int ElementoBuscado) {
		if (Vazia()) {
			msgVazia();
		} else {
			TNodo Aux = this.Primeiro.Proximo;
			while (Aux != null) {
				
				if (Aux.Item.id == ElementoBuscado) // adaptar
					return Aux;
				Aux = Aux.Proximo;
			}
		}
		return null;
	}

	
//----------------------------Metodos Usados em Bubblesort e Mergesort---------------------------------------------------------------------------------------
	private void SwapItem(TNodo X, TNodo Y) 
	{
		TInfo Aux;
		Aux = X.Item;
		X.Item = Y.Item;
		Y.Item = Aux;
	}

	private String InverteData(String s)
	{
		s=s.replace(" ","");
		String[] data=s.split("/");
		if(data.length==3)
		{
			String temp=data[2];
			data[2]=data[0];
			data[0]=temp;
			s="";
			for(int i=0;i<data.length;i++)
				s+=data[i];
		}
		return s;
	}

//--------------------------------------Algoritmos de Ordenação---------------------------------------------------------------------------------------
	public void BubbleSort_id(int cont)
	{
		if(!Vazia())
		{
			TNodo Ultimo=this.Ultimo;
			while(Ultimo!=this.Primeiro.Proximo)
			{
				TNodo Pos=this.Primeiro.Proximo;
				while(Pos!=Ultimo)
				{
					if(Pos.Item.id>Pos.Proximo.Item.id) //Adaptar
					{
						cont++;
						SwapItem(Pos,Pos.Proximo);
					}
					Pos=Pos.Proximo;
				}
				Ultimo=Ultimo.Anterior;
	        }
		}
	}
	public void BubbleSort_title()
	{
		if(!Vazia())
		{
			TNodo Ultimo=this.Ultimo;
			while(Ultimo!=this.Primeiro.Proximo)
			{
				TNodo Pos=this.Primeiro.Proximo;
				while(Pos!=Ultimo){
					if(Pos.Item.Title.compareTo(Pos.Proximo.Item.Title)>0){
						SwapItem(Pos,Pos.Proximo);
					}
					Pos=Pos.Proximo;
				}
				Ultimo=Ultimo.Anterior;
	        }
		}
	}
	
	public void BubbleSort_Nota()
	{
		if(!Vazia())
		{
			TNodo Ultimo=this.Ultimo;
			while(Ultimo!=this.Primeiro.Proximo)
			{
				TNodo Pos=this.Primeiro.Proximo;
				while(Pos!=Ultimo)
				{
					if(Pos.Item.VoteAvarage<Pos.Proximo.Item.VoteAvarage) //Adaptar
					{
						SwapItem(Pos,Pos.Proximo);
					}
					Pos=Pos.Proximo;
				}
				Ultimo=Ultimo.Anterior;
	        }
		}
	}
	
	public void BubbleSort_Popularity()
	{
		if(!Vazia())
		{
			TNodo Ultimo=this.Ultimo;
			while(Ultimo!=this.Primeiro.Proximo)
			{
				TNodo Pos=this.Primeiro.Proximo;
				while(Pos!=Ultimo)
				{
					if(Pos.Item.Popularity<Pos.Proximo.Item.Popularity) //Adaptar
					{
						SwapItem(Pos,Pos.Proximo);
					}
					Pos=Pos.Proximo;
				}
				Ultimo=Ultimo.Anterior;
	        }
		}
	}
	
	public void BubbleSort_Revenue()
	{
		if(!Vazia())
		{
			TNodo Ultimo=this.Ultimo;
			while(Ultimo!=this.Primeiro.Proximo)
			{
				TNodo Pos=this.Primeiro.Proximo;
				while(Pos!=Ultimo)
				{
					if(Pos.Item.Revenue<Pos.Proximo.Item.Revenue) //Adaptar
					{
						SwapItem(Pos,Pos.Proximo);
					}
					Pos=Pos.Proximo;
				}
				Ultimo=Ultimo.Anterior;
	        }
		}
	}
	
	public void BubbleSort_Budget()
	{
		if(!Vazia())
		{
			TNodo Ultimo=this.Ultimo;
			while(Ultimo!=this.Primeiro.Proximo)
			{
				TNodo Pos=this.Primeiro.Proximo;
				while(Pos!=Ultimo)
				{
					if(Pos.Item.Budget<Pos.Proximo.Item.Budget) //Adaptar
					{
						SwapItem(Pos,Pos.Proximo);
					}
					Pos=Pos.Proximo;
				}
				Ultimo=Ultimo.Anterior;
	        }
		}
	}
	
	public void BubbleSort_Ano()
	{
		if(!Vazia())
		{
			TNodo Ultimo=this.Ultimo;
			while(Ultimo!=this.Primeiro.Proximo)
			{
				TNodo Pos=this.Primeiro.Proximo;
				while(Pos!=Ultimo)
				{
					int Data1=ConverteTipo.strToInt(InverteData(Pos.Item.RealeseDate));
					int Data2=ConverteTipo.strToInt(InverteData(Pos.Proximo.Item.RealeseDate));
					if(Data1<Data2)
		    		{
		    			SwapItem(Pos,Pos.Proximo);
		    		}
					Pos=Pos.Proximo;
				}
				Ultimo=Ultimo.Anterior;
	        }
		}
	}
	
//--------------------------------------MergeSort----------------------------------------------------------------------------------------------------------
	public void MergeSort_id() {
		Merge_id(0, this.Primeiro.Item.id - 1);
	}

	private void Merge_id(int Inicio, int Fim) {

		if (Inicio < Fim) {
			int Meio = (Inicio + Fim) / 2;

			Merge_id(Inicio, Meio);
			Merge_id(Meio + 1, Fim);
			Intercala_id(Inicio, Meio, Fim);
		}
	}

	private void Intercala_id(int Inicio, int Meio, int Fim) {

		TLista Local = new TLista();

		int InicialEsquerda = Inicio;
		int InicialDireita = Meio + 1;

		TNodo ListaEsquerda;
		if(InicialEsquerda<this.getTotalElmentos()/2)
			ListaEsquerda = getPositionList(InicialEsquerda);
		else
			ListaEsquerda = getPositionListInversa(InicialEsquerda);
		TNodo ListaDireita;
		if(InicialDireita<this.getTotalElmentos()/2)
			ListaDireita = getPositionList(InicialDireita);
		else
			ListaDireita = getPositionListInversa(InicialDireita);

		while (InicialEsquerda <= Meio && InicialDireita <= Fim) {

			if (ListaEsquerda.Item.id < ListaDireita.Item.id) {
				Local.InsereFinal(ListaEsquerda.Item);
				InicialEsquerda++;
				ListaEsquerda = ListaEsquerda.Proximo;
			} else {
				Local.InsereFinal(ListaDireita.Item);
				InicialDireita++;
				ListaDireita = ListaDireita.Proximo;
			}
		}
		
		//Caso ainda haja elementos na metade esquerda
		while (InicialEsquerda <= Meio) {
			Local.InsereFinal(ListaEsquerda.Item);
			InicialEsquerda++;
			ListaEsquerda = ListaEsquerda.Proximo;
		}
		
		//Caso ainda haja elementos na metade direita
		while (InicialDireita <= Fim) {
			Local.InsereFinal(ListaDireita.Item);
			InicialDireita++;
			ListaDireita = ListaDireita.Proximo;
		}
		
		TNodo ListaOriginal; //Recebe a posição inicial para essa parte da Lista Original
		if(Inicio<this.getTotalElmentos()/2)
			ListaOriginal = getPositionList(Inicio); 
		else
			ListaOriginal = getPositionListInversa(Inicio); 
		TNodo ListaLocal = Local.getPositionList(0); //Recebe a posição inicial da lista local

		//Passar da Lista Auxiliar para a lista Original deve ir da posição armazenada em inicio até a armazenada em Fim
		for (int i = Inicio; i <= Fim; i++) {
			ListaOriginal.Item = ListaLocal.Item;
			ListaOriginal = ListaOriginal.Proximo;
			ListaLocal = ListaLocal.Proximo;
		}
	}
	
	public void MergeSort_title() {
		Merge_title(0, this.Primeiro.Item.id - 1);
	}

	private void Merge_title(int Inicio, int Fim) {

		if (Inicio < Fim) {
			int Meio = (Inicio + Fim) / 2;

			Merge_title(Inicio, Meio);
			Merge_title(Meio + 1, Fim);
			Intercala_title(Inicio, Meio, Fim);
		}
	}

	private void Intercala_title(int Inicio, int Meio, int Fim) {

		TLista Local = new TLista();

		int InicialEsquerda = Inicio;
		int InicialDireita = Meio + 1;

		TNodo ListaEsquerda;
		if(InicialEsquerda<this.getTotalElmentos()/2)
			ListaEsquerda = getPositionList(InicialEsquerda);
		else
			ListaEsquerda = getPositionListInversa(InicialEsquerda);
		TNodo ListaDireita;
		if(InicialDireita<this.getTotalElmentos()/2)
			ListaDireita = getPositionList(InicialDireita);
		else
			ListaDireita = getPositionListInversa(InicialDireita);

		while (InicialEsquerda <= Meio && InicialDireita <= Fim) {

			if (ListaEsquerda.Item.Title.compareTo(ListaDireita.Item.Title)<0) {
				Local.InsereFinal(ListaEsquerda.Item);
				InicialEsquerda++;
				ListaEsquerda = ListaEsquerda.Proximo;
			} else {
				Local.InsereFinal(ListaDireita.Item);
				InicialDireita++;
				ListaDireita = ListaDireita.Proximo;
			}
		}
		
		//Caso ainda haja elementos na metade esquerda
		while (InicialEsquerda <= Meio) {
			Local.InsereFinal(ListaEsquerda.Item);
			InicialEsquerda++;
			ListaEsquerda = ListaEsquerda.Proximo;
		}
		
		//Caso ainda haja elementos na metade direita
		while (InicialDireita <= Fim) {
			Local.InsereFinal(ListaDireita.Item);
			InicialDireita++;
			ListaDireita = ListaDireita.Proximo;
		}
		
		TNodo ListaOriginal; //Recebe a posição inicial para essa parte da Lista Original
		if(Inicio<this.getTotalElmentos()/2)
			ListaOriginal = getPositionList(Inicio); 
		else
			ListaOriginal = getPositionListInversa(Inicio); 
		TNodo ListaLocal = Local.getPositionList(0); //Recebe a posição inicial da lista local

		//Passar da Lista Auxiliar para a lista Original deve ir da posição armazenada em inicio até a armazenada em Fim
		for (int i = Inicio; i <= Fim; i++) {
			ListaOriginal.Item = ListaLocal.Item;
			ListaOriginal = ListaOriginal.Proximo;
			ListaLocal = ListaLocal.Proximo;
		}
	}
	
	public void MergeSort_Nota() {
		Merge_Nota(0, this.Primeiro.Item.id - 1);
	}

	private void Merge_Nota(int Inicio, int Fim) {

		if (Inicio < Fim) {
			int Meio = (Inicio + Fim) / 2;

			Merge_Nota(Inicio, Meio);
			Merge_Nota(Meio + 1, Fim);
			Intercala_Nota(Inicio, Meio, Fim);
		}
	}

	private void Intercala_Nota(int Inicio, int Meio, int Fim) {

		TLista Local = new TLista();

		int InicialEsquerda = Inicio;
		int InicialDireita = Meio + 1;

		TNodo ListaEsquerda;
		if(InicialEsquerda<this.getTotalElmentos()/2)
			ListaEsquerda = getPositionList(InicialEsquerda);
		else
			ListaEsquerda = getPositionListInversa(InicialEsquerda);
		TNodo ListaDireita;
		if(InicialDireita<this.getTotalElmentos()/2)
			ListaDireita = getPositionList(InicialDireita);
		else
			ListaDireita = getPositionListInversa(InicialDireita);


		while (InicialEsquerda <= Meio && InicialDireita <= Fim) {

			if (ListaEsquerda.Item.VoteAvarage > ListaDireita.Item.VoteAvarage) {
				Local.InsereFinal(ListaEsquerda.Item);
				InicialEsquerda++;
				ListaEsquerda = ListaEsquerda.Proximo;
			} else {
				Local.InsereFinal(ListaDireita.Item);
				InicialDireita++;
				ListaDireita = ListaDireita.Proximo;
			}
		}
		
		//Caso ainda haja elementos na metade esquerda
		while (InicialEsquerda <= Meio) {
			Local.InsereFinal(ListaEsquerda.Item);
			InicialEsquerda++;
			ListaEsquerda = ListaEsquerda.Proximo;
		}
		
		//Caso ainda haja elementos na metade direita
		while (InicialDireita <= Fim) {
			Local.InsereFinal(ListaDireita.Item);
			InicialDireita++;
			ListaDireita = ListaDireita.Proximo;
		}
		TNodo ListaOriginal; //Recebe a posição inicial para essa parte da Lista Original
		if(Inicio<this.getTotalElmentos()/2)
			ListaOriginal = getPositionList(Inicio); 
		else
			ListaOriginal = getPositionListInversa(Inicio); 
		TNodo ListaLocal = Local.getPositionList(0); //Recebe a posição inicial da lista local

		//Passar da Lista Auxiliar para a lista Original deve ir da posição armazenada em inicio até a armazenada em Fim
		for (int i = Inicio; i <= Fim; i++) {
			ListaOriginal.Item = ListaLocal.Item;
			ListaOriginal = ListaOriginal.Proximo;
			ListaLocal = ListaLocal.Proximo;
		}

	}
	public void MergeSort_Popularity() {
		Merge_Popularity(0, this.Primeiro.Item.id - 1);
	}

	private void Merge_Popularity(int Inicio, int Fim) {

		if (Inicio < Fim) {
			int Meio = (Inicio + Fim) / 2;

			Merge_Popularity(Inicio, Meio);
			Merge_Popularity(Meio + 1, Fim);
			Intercala_Popularity(Inicio, Meio, Fim);
		}
	}

	private void Intercala_Popularity(int Inicio, int Meio, int Fim) {

		TLista Local = new TLista();

		int InicialEsquerda = Inicio;
		int InicialDireita = Meio + 1;

		TNodo ListaEsquerda;
		if(InicialEsquerda<this.getTotalElmentos()/2)
			ListaEsquerda = getPositionList(InicialEsquerda);
		else
			ListaEsquerda = getPositionListInversa(InicialEsquerda);
		TNodo ListaDireita;
		if(InicialDireita<this.getTotalElmentos()/2)
			ListaDireita = getPositionList(InicialDireita);
		else
			ListaDireita = getPositionListInversa(InicialDireita);

		while (InicialEsquerda <= Meio && InicialDireita <= Fim) {

			if (ListaEsquerda.Item.Popularity > ListaDireita.Item.Popularity) {
				Local.InsereFinal(ListaEsquerda.Item);
				InicialEsquerda++;
				ListaEsquerda = ListaEsquerda.Proximo;
			} else {
				Local.InsereFinal(ListaDireita.Item);
				InicialDireita++;
				ListaDireita = ListaDireita.Proximo;
			}
		}
		
		//Caso ainda haja elementos na metade esquerda
		while (InicialEsquerda <= Meio) {
			Local.InsereFinal(ListaEsquerda.Item);
			InicialEsquerda++;
			ListaEsquerda = ListaEsquerda.Proximo;
		}
		
		//Caso ainda haja elementos na metade direita
		while (InicialDireita <= Fim) {
			Local.InsereFinal(ListaDireita.Item);
			InicialDireita++;
			ListaDireita = ListaDireita.Proximo;
		}
		TNodo ListaOriginal; //Recebe a posição inicial para essa parte da Lista Original
		if(Inicio<this.getTotalElmentos()/2)
			ListaOriginal = getPositionList(Inicio); 
		else
			ListaOriginal = getPositionListInversa(Inicio); 
		TNodo ListaLocal = Local.getPositionList(0); //Recebe a posição inicial da lista local

		//Passar da Lista Auxiliar para a lista Original deve ir da posição armazenada em inicio até a armazenada em Fim
		for (int i = Inicio; i <= Fim; i++) {
			ListaOriginal.Item = ListaLocal.Item;
			ListaOriginal = ListaOriginal.Proximo;
			ListaLocal = ListaLocal.Proximo;
		}
	}
	
	public void MergeSort_Budget() {
		Merge_Budget(0, this.Primeiro.Item.id - 1);
	}

	private void Merge_Budget(int Inicio, int Fim) {

		if (Inicio < Fim) {
			int Meio = (Inicio + Fim) / 2;

			Merge_Budget(Inicio, Meio);
			Merge_Budget(Meio + 1, Fim);
			Intercala_Budget(Inicio, Meio, Fim);
		}
	}

	private void Intercala_Budget(int Inicio, int Meio, int Fim) {

		TLista Local = new TLista();

		int InicialEsquerda = Inicio;
		int InicialDireita = Meio + 1;

		TNodo ListaEsquerda;
		if(InicialEsquerda<this.getTotalElmentos()/2)
			ListaEsquerda = getPositionList(InicialEsquerda);
		else
			ListaEsquerda = getPositionListInversa(InicialEsquerda);
		TNodo ListaDireita;
		if(InicialDireita<this.getTotalElmentos()/2)
			ListaDireita = getPositionList(InicialDireita);
		else
			ListaDireita = getPositionListInversa(InicialDireita);

		while (InicialEsquerda <= Meio && InicialDireita <= Fim) {

			if (ListaEsquerda.Item.Budget > ListaDireita.Item.Budget) {
				Local.InsereFinal(ListaEsquerda.Item);
				InicialEsquerda++;
				ListaEsquerda = ListaEsquerda.Proximo;
			} else {
				Local.InsereFinal(ListaDireita.Item);
				InicialDireita++;
				ListaDireita = ListaDireita.Proximo;
			}
		}
		
		//Caso ainda haja elementos na metade esquerda
		while (InicialEsquerda <= Meio) {
			Local.InsereFinal(ListaEsquerda.Item);
			InicialEsquerda++;
			ListaEsquerda = ListaEsquerda.Proximo;
		}
		
		//Caso ainda haja elementos na metade direita
		while (InicialDireita <= Fim) {
			Local.InsereFinal(ListaDireita.Item);
			InicialDireita++;
			ListaDireita = ListaDireita.Proximo;
		}
		TNodo ListaOriginal; //Recebe a posição inicial para essa parte da Lista Original
		if(Inicio<this.getTotalElmentos()/2)
			ListaOriginal = getPositionList(Inicio); 
		else
			ListaOriginal = getPositionListInversa(Inicio);
		TNodo ListaLocal = Local.getPositionList(0); //Recebe a posição inicial da lista local

		//Passar da Lista Auxiliar para a lista Original deve ir da posição armazenada em inicio até a armazenada em Fim
		for (int i = Inicio; i <= Fim; i++) {
			ListaOriginal.Item = ListaLocal.Item;
			ListaOriginal = ListaOriginal.Proximo;
			ListaLocal = ListaLocal.Proximo;
		}
	}
	
	public void MergeSort_Revenue() {
		Merge_Revenue(0, this.Primeiro.Item.id - 1);
	}

	private void Merge_Revenue(int Inicio, int Fim) {

		if (Inicio < Fim) {
			int Meio = (Inicio + Fim) / 2;

			Merge_Revenue(Inicio, Meio);
			Merge_Revenue(Meio + 1, Fim);
			Intercala_Revenue(Inicio, Meio, Fim);
		}
	}

	private void Intercala_Revenue(int Inicio, int Meio, int Fim) {

		TLista Local = new TLista();

		int InicialEsquerda = Inicio;
		int InicialDireita = Meio + 1;

		TNodo ListaEsquerda;
		if(InicialEsquerda<this.getTotalElmentos()/2)
			ListaEsquerda = getPositionList(InicialEsquerda);
		else
			ListaEsquerda = getPositionListInversa(InicialEsquerda);
		TNodo ListaDireita;
		if(InicialDireita<this.getTotalElmentos()/2)
			ListaDireita = getPositionList(InicialDireita);
		else
			ListaDireita = getPositionListInversa(InicialDireita);
		
		while (InicialEsquerda <= Meio && InicialDireita <= Fim) {

			if (ListaEsquerda.Item.Revenue > ListaDireita.Item.Revenue) {
				Local.InsereFinal(ListaEsquerda.Item);
				InicialEsquerda++;
				ListaEsquerda = ListaEsquerda.Proximo;
			} else {
				Local.InsereFinal(ListaDireita.Item);
				InicialDireita++;
				ListaDireita = ListaDireita.Proximo;
			}
		}
		
		//Caso ainda haja elementos na metade esquerda
		while (InicialEsquerda <= Meio) {
			Local.InsereFinal(ListaEsquerda.Item);
			InicialEsquerda++;
			ListaEsquerda = ListaEsquerda.Proximo;
		}
		
		//Caso ainda haja elementos na metade direita
		while (InicialDireita <= Fim) {
			Local.InsereFinal(ListaDireita.Item);
			InicialDireita++;
			ListaDireita = ListaDireita.Proximo;
		}
		TNodo ListaOriginal; //Recebe a posição inicial para essa parte da Lista Original
		if(Inicio<this.getTotalElmentos()/2)
			ListaOriginal = getPositionList(Inicio); 
		else
			ListaOriginal = getPositionListInversa(Inicio);
		TNodo ListaLocal = Local.getPositionList(0); //Recebe a posição inicial da lista local

		//Passar da Lista Auxiliar para a lista Original deve ir da posição armazenada em inicio até a armazenada em Fim
		for (int i = Inicio; i <= Fim; i++) {
			ListaOriginal.Item = ListaLocal.Item;
			ListaOriginal = ListaOriginal.Proximo;
			ListaLocal = ListaLocal.Proximo;
		}
	}

	public void MergeSort_Ano() {
		Merge_Ano(0, this.Primeiro.Item.id - 1);
	}

	private void Merge_Ano(int Inicio, int Fim) {

		if (Inicio < Fim) {
			int Meio = (Inicio + Fim) / 2;

			Merge_Ano(Inicio, Meio);
			Merge_Ano(Meio + 1, Fim);
			Intercala_Ano(Inicio, Meio, Fim);
		}
	}

	private void Intercala_Ano(int Inicio, int Meio, int Fim) 
	{

		TLista Local = new TLista();

		int InicialEsquerda = Inicio;
		int InicialDireita = Meio + 1;

		TNodo ListaEsquerda;
		if(InicialEsquerda<this.getTotalElmentos()/2)
			ListaEsquerda = getPositionList(InicialEsquerda);
		else
			ListaEsquerda = getPositionListInversa(InicialEsquerda);
		TNodo ListaDireita;
		if(InicialDireita<this.getTotalElmentos()/2)
			ListaDireita = getPositionList(InicialDireita);
		else
			ListaDireita = getPositionListInversa(InicialDireita);

		
		int Data1;
		int Data2;
		
		while (InicialEsquerda <= Meio && InicialDireita <= Fim) 
		{
			
			Data1=ConverteTipo.strToInt(InverteData(ListaEsquerda.Item.RealeseDate));
			Data2=ConverteTipo.strToInt(InverteData(ListaDireita.Item.RealeseDate));
			
    		if(Data1>Data2)
    		{
				Local.InsereFinal(ListaEsquerda.Item);
				InicialEsquerda++;
				ListaEsquerda = ListaEsquerda.Proximo;
			} else {
				Local.InsereFinal(ListaDireita.Item);
				InicialDireita++;
				ListaDireita = ListaDireita.Proximo;
			}
		}
		
		//Caso ainda haja elementos na metade esquerda
		while (InicialEsquerda <= Meio) {
			Local.InsereFinal(ListaEsquerda.Item);
			InicialEsquerda++;
			ListaEsquerda = ListaEsquerda.Proximo;
		}
		
		//Caso ainda haja elementos na metade direita
		while (InicialDireita <= Fim) {
			Local.InsereFinal(ListaDireita.Item);
			InicialDireita++;
			ListaDireita = ListaDireita.Proximo;
		}
		TNodo ListaOriginal; //Recebe a posição inicial para essa parte da Lista Original
		if(Inicio<this.getTotalElmentos()/2)
			ListaOriginal = getPositionList(Inicio); 
		else
			ListaOriginal = getPositionListInversa(Inicio); 
		TNodo ListaLocal = Local.getPositionList(0); //Recebe a posição inicial da lista local

		//Passar da Lista Auxiliar para a lista Original deve ir da posição armazenada em inicio até a armazenada em Fim
		for (int i = Inicio; i <= Fim; i++) 
		{
			ListaOriginal.Item = ListaLocal.Item;
			ListaOriginal = ListaOriginal.Proximo;
			ListaLocal = ListaLocal.Proximo;
		}

	}
//-------------------------------------Impressão por genero---------------------------------------------------------------------------------------
	public TLista BuscaGenero(String Genero) 
	{
		TLista Local = new TLista();
		TNodo Aux;
		Aux = this.Primeiro.Proximo;
		String Separar[];

		while (Aux != null) 
		{
			Separar = Aux.Item.Genres.split(",");
			for (int i = 0; i < Separar.length; i++) 
			{
				Separar[i] = Separar[i].trim();
				Separar[i] = Separar[i].replace(".", "");
				if (Separar[i].equals(Genero)) {
					Local.InsereFinal(Aux.Item);
				}
			}
			Aux = Aux.Proximo;
		}
		Local.BubbleSort_Nota();
		return Local;
	}

//-----------------------------------Impressão por Ano-----------------------------------------------------------------
	public TLista BuscaAno(String Ano) 
	{
		if (Vazia())
			msgVazia();
		else 
		{
			TLista ListaAno = new TLista();
			TNodo Aux = this.Primeiro.Proximo;
			Ano = Ano.trim();
			while (Aux != null) 
			{
				String[] Year = Aux.Item.RealeseDate.split("/");
				Year[Year.length - 1] = Year[Year.length - 1].trim();
				if (Ano.equals(Year[Year.length - 1]))
					ListaAno.InsereFinal(Aux.Item);
				Aux = Aux.Proximo;
			}
			//ListaAno.BubbleSort_Ano();
			return ListaAno;
		}
		return null;
	}
	//-----------------------------------Impressão por Ano----------
	public TLista BuscaNota(float Min,float Max) {
		if (Vazia())
			msgVazia();
		else 
		{
			TLista listaNota = new TLista();
			TNodo Aux = this.Primeiro.Proximo;
		
			while (Aux != null) 
			{
				
				if (Aux.Item.VoteAvarage>=Min & Aux.Item.VoteAvarage<=Max)
					listaNota.InsereFinal(Aux.Item);
				Aux = Aux.Proximo;
			}

			return listaNota;
		}
		return null;
	}
	
	//------------------------------LUIZ-----------------------------
	public void searchByTitle(String search, TLista listMovies){
		
		boolean check=false;
		TNodo aux = this.Primeiro.Proximo;


		//-------------------------busca sequencial
		while(aux!=null) {
			if(aux.Item.Title.toUpperCase().startsWith(search.toUpperCase())) { 
				listMovies.InsereFinal(aux.Item);
				check=true;
			}
			aux = aux.Proximo;
		}
		//----------------------------------------
		if(!check)
			System.out.println("Filme não localizado!");
		
	}	

	public TLista BuscaPopularity(long Min,long Max) 
	{
		if (Vazia())
			msgVazia();
		else 
		{
			TLista ListaPopularity = new TLista();
			TNodo Aux = this.Primeiro.Proximo;
		
			while (Aux != null) 
			{
				
				if (Aux.Item.Popularity>=Min & Aux.Item.Popularity<=Max)
					ListaPopularity.InsereFinal(Aux.Item);
				Aux = Aux.Proximo;
			}
			//ListaPopularity.BubbleSort_Popularity();
			//ListaPopularity.MergeSort_Popularity();
			return ListaPopularity;
		}
		return null;
	}
	
	public TLista BuscaBudget(long Min, long Max) {
		if (Vazia())
			msgVazia();
		else {
			TLista ListaBudget = new TLista();
			TNodo Aux = this.Primeiro.Proximo;

			while (Aux != null) {

				if (Aux.Item.Budget >= Min & Aux.Item.Budget <= Max)
					ListaBudget.InsereFinal(Aux.Item);
				Aux = Aux.Proximo;
			}
			//ListaBudget.BubbleSort_Budget();
			// ListaBudget.MergeSort_Budget();
			return ListaBudget;
		}
		return null;
	}

	public TLista BuscaRevenue(long Min, long Max) {
		if (Vazia())
			msgVazia();
		else {
			TLista ListaRevenue = new TLista();
			TNodo Aux = this.Primeiro.Proximo;

			while (Aux != null) {
				if (Aux.Item.Revenue >= Min & Aux.Item.Revenue <= Max)
					ListaRevenue.InsereFinal(Aux.Item);
				Aux = Aux.Proximo;
			}
			//ListaRevenue.BubbleSort_Revenue();
			// ListaRevenue.MergeSort_Revenue();
			return ListaRevenue;
		}
		return null;
	}

}