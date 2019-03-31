package classes;

import java.io.*;

public class Arquivo {
	
	private File Arquivo=new File("IMDB.txt");
	private File Arquivo2=new File("IMDB_QB.txt");
	private File arquivoUser =  new File("userCadastrados.txt");
	public void Carrega(TLista L)
	{
		if(Arquivo2Valido())
		{
			CarregaLista(L);
		}
		else
		{
			if(ArquivoValido())
			{
				CarregaArquivo(L);
			}
			else
			{
				System.out.println("Nenhum dos 2 arquivos IMBD_QB.txt e IMDB.txt foi encontrado!!!");
			}
		}
	}
	
	private boolean ArquivoValido()
	{
		if(this.Arquivo.exists()&this.Arquivo.canRead()&this.Arquivo.canWrite()&this.Arquivo.canExecute())
			return true;
		else
			return false;
	}
	
	private boolean Arquivo2Valido()
	{
		if(this.Arquivo2.exists()&this.Arquivo2.canRead()&this.Arquivo2.canWrite()&this.Arquivo2.canExecute())
			return true;
		else
			return false;
	}
	
	private void SalvaLista(TLista L)
	{
		if(L.getCabeca().Item.id>0)
		{
			try
			{
				String st="\t"; //separador
				
				FileWriter fw=new FileWriter(Arquivo2);
				BufferedWriter bw=new BufferedWriter(fw);
				
				TNodo Aux=L.getPrimeiro();
				
				while(Aux!=null)
				{
					bw.write(Aux.Item.Budget+st+Aux.Item.Genres+st+Aux.Item.HomePage+st+Aux.Item.id+st+Aux.Item.Keywords+st+Aux.Item.OriginalLanguage+st+Aux.Item.OriginalTitle+st+Aux.Item.Overview+st+Aux.Item.Popularity+st+Aux.Item.ProductionCompanies+st+Aux.Item.ProductionContries+st+Aux.Item.RealeseDate+st+Aux.Item.Revenue+st+Aux.Item.Runtime+st+Aux.Item.SpokenLanguages+st+Aux.Item.Status+st+Aux.Item.Tagline+st+Aux.Item.Title+st+Aux.Item.VoteAvarage+st+Aux.Item.VoteCount+"\n");
					Aux=Aux.Proximo;
				}
				
				bw.close();
				fw.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void CarregaLista(TLista L)
	{
		if(Arquivo2Valido())
		{
			try
			{
				TInfo Item=new TInfo();
				
				FileReader fr=new FileReader(Arquivo2);
				BufferedReader br=new BufferedReader(fr);
				
				String texto=br.readLine();
				
				while(texto!=null)
				{
					ListaToTInfo(Item,texto);
					L.InsereFinal(Item);
					texto=br.readLine();
				}
				
				br.close();
				fr.close();
				
				SalvaLista(L);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Erro no Arquivo!!!");
		}
	}
	
	private void ListaToTInfo(TInfo Item,String texto)
	{
		String[]Campo=texto.split("\t");
		

		Item.Budget=ConverteTipo.strToLong(Campo[0]);
		
		Item.Genres=Campo[1];
		
		Item.HomePage=Campo[2];
		
		Item.id=ConverteTipo.strToInt(Campo[3]);
		
		Item.Keywords=Campo[4];
		
		Item.OriginalLanguage=Campo[5];
		
		Item.OriginalTitle=Campo[6];
		
		Item.Overview=Campo[7];
		
		Item.Popularity=ConverteTipo.strToLong(Campo[8]);
		
		Item.ProductionCompanies=Campo[9];
		
		Item.ProductionContries=Campo[10];
		
		Item.RealeseDate=Campo[11];
		
		Item.Revenue=ConverteTipo.strToLong(Campo[12]);
		
		Item.Runtime=ConverteTipo.strToInt(Campo[13]);
		
		Item.SpokenLanguages=Campo[14];
		
		Item.Status=Campo[15];
		
		Item.Tagline=Campo[16];
		
		Item.Title=Campo[17];
		
		Item.VoteAvarage=ConverteTipo.strToFloat(Campo[18]);
	
		Item.VoteCount=ConverteTipo.strToInt(Campo[19]);
	}
	
	public void CarregaArquivo(TLista L)
	{
		if(ArquivoValido())
		{
			try
			{
				//TInfo Item=new TInfo(0,0l,"","","","","","",0l,"","","",0l,0,"","","","",0f,0);
				TInfo Item=new TInfo();
				
				FileReader fr=new FileReader(Arquivo);
				BufferedReader br=new BufferedReader(fr);
				
				String texto=br.readLine();
				
				while(texto!=null)
				{
					TextoToTInfo(Item,texto);
					L.InsereFinal(Item);
					texto=br.readLine();
				}
				
				br.close();
				fr.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Erro no Arquivo!!!");
		}
	}
	
	private void TextoToTInfo(TInfo Item,String texto)
	{
		
		String[]Campo=texto.split("\t");
		
		
		Campo[0]=Campo[0].replace(".","");
		Item.Budget=ConverteTipo.strToLong(Campo[0]);
		
		Campo[1]=TrataGenKey(Campo[1]);
		Item.Genres=Campo[1];
		
		Item.HomePage=Campo[2];
		
		Campo[3]=Campo[3].replace(".","");
		Item.id=ConverteTipo.strToInt(Campo[3]);
		
		Campo[4]=TrataGenKey(Campo[4]);
		Item.Keywords=Campo[4];
		
		Item.OriginalLanguage=Campo[5];
		
		Item.OriginalTitle=Campo[6];
		
		Item.Overview=Campo[7];
		
		Campo[8]=Campo[8].replace(".","");
		Item.Popularity=ConverteTipo.strToLong(Campo[8]);
		
		Campo[9]=TrataCompanies(Campo[9]);
		Item.ProductionCompanies=Campo[9];
		
		Campo[10]=TrataContries(Campo[10]);
		Item.ProductionContries=Campo[10];
		
		Item.RealeseDate=Campo[11];
		
		Campo[12]=Campo[12].replace(".","");
		Item.Revenue=ConverteTipo.strToLong(Campo[12]);
		
		Campo[13]=Campo[13].replace(".","");
		Item.Runtime=ConverteTipo.strToInt(Campo[13]);
		
		Campo[14]=TrataLanguages(Campo[14]);
		Item.SpokenLanguages=Campo[14];
		
		Item.Status=Campo[15];
		
		Item.Tagline=Campo[16];
		
		Item.Title=Campo[17];
		
		Item.VoteAvarage=ConverteTipo.strToFloat(Campo[18]);
		
		Campo[19]=Campo[19].replace(".","");
		Item.VoteCount=ConverteTipo.strToInt(Campo[19]);
	}
	
	private String TrataGenKey(String x)
	{
		x=x.replace("[", "");
		x=x.replace("]", "");
		x=x.replace("{", "");
		x=x.replace("}", "");
		x=x.replace("\"", "");
		x=x.replace("0,", "");
		x=x.replace("1,", "");
		x=x.replace("2,", "");
		x=x.replace("3,", "");
		x=x.replace("4,", "");
		x=x.replace("5,", "");
		x=x.replace("6,", "");
		x=x.replace("7,", "");
		x=x.replace("8,", "");
		x=x.replace("9,", "");
		x=x.replace("0", "");
		x=x.replace("1", "");
		x=x.replace("2", "");
		x=x.replace("3", "");
		x=x.replace("4", "");
		x=x.replace("5", "");
		x=x.replace("6", "");
		x=x.replace("7", "");
		x=x.replace("8", "");
		x=x.replace("9", "");
		x=x.replace(":", "");
		x=x.replace("name", "");
		x=x.replace("id", "");
		
		//Alternativa para não remover todos os espaços e retirar espaços desnecessários
		x=x.trim();
		x=x.replace(",   ",",");
		
		//Removendo todos os espaços
		//x=x.replace(" ", ""); 
		//x=x.replace(",", ", ");
		
		//x=x+".";
		return x;
	}
	
	private String TrataCompanies(String x)
	{
		x=x.replace("[", "");
		x=x.replace("]", "");
		x=x.replace("{", "");
		x=x.replace("}", "");
		x=x.replace("\",", "");
		x=x.replace("\"", "");
		x=x.replace("0", "");
		x=x.replace("1", "");
		x=x.replace("2", "");
		x=x.replace("3", "");
		x=x.replace("4", "");
		x=x.replace("5", "");
		x=x.replace("6", "");
		x=x.replace("7", "");
		x=x.replace("8", "");
		x=x.replace("9", "");
		x=x.replace(":", "");
		x=x.replace("name", "");
		x=x.replace("id", "");
		
		//Alternativa para não remover todos os espaços e retirar espaços desnecessários
		x=x.trim();
		x=x.replace("  , ",",");	
		//Removendo todos os espaços
		//x=x.replace(" ", ""); 
		//x=x.replace(",", ", ");
		
		//Adicionando ponto no final e corrigindo os erros causados por isso
		//x=x+".";
		//x=x.replace("..", ".");
		//x=x.replace(".,", ",");
		
		x=x.replace(".", "");
		return x;
	}
	
	private String TrataContries(String x)
	{
		x=x.replace("\",", "");
		x=x.replace("\"", "");
		x=x.replace("[", "");
		x=x.replace("]", "");
		x=x.replace("{", "");
		x=x.replace("},", ",");
		x=x.replace("}", "");
		x=x.replace("_", "");
		x=x.replace("3166", "");
		x=x.replace("1", "");
		x=x.replace(":", "");
		x=x.replace("name", "");
		x=x.replace("iso", "");
		
		x=x.replace("AF", "");
		x=x.replace("AX", "");
		x=x.replace("AL", "");
		x=x.replace("DE", "");
		x=x.replace("AD", "");
		x=x.replace("AO", "");
		x=x.replace("AI", "");
		x=x.replace("AQ", "");
		x=x.replace("AG", "");
		x=x.replace("AN", "");
		x=x.replace("SA", "");
		x=x.replace("DZ", "");
		x=x.replace("AR", "");
		x=x.replace("AM", "");
		x=x.replace("AW", "");
		x=x.replace("AU", "");
		x=x.replace("AT", "");
		x=x.replace("AZ", "");
		x=x.replace("BS", "");
		x=x.replace("BH", "");
		x=x.replace("BD", "");
		x=x.replace("BB", "");
		x=x.replace("BY", "");
		x=x.replace("BE", "");
		x=x.replace("BZ", "");
		x=x.replace("BJ", "");
		x=x.replace("BM", "");
		x=x.replace("BT", "");
		x=x.replace("BO", "");
		x=x.replace("BA", "");
		x=x.replace("BW", "");
		x=x.replace("BV", "");
		x=x.replace("BR", "");
		x=x.replace("BN", "");
		x=x.replace("BG", "");
		x=x.replace("BF", "");
		x=x.replace("BI", "");
		x=x.replace("CV", "");
		x=x.replace("KY", "");
		x=x.replace("KH", "");
		x=x.replace("CM", "");
		x=x.replace("CA", "");
		x=x.replace("CF", "");
		x=x.replace("TD", "");
		x=x.replace("CZ", "");
		x=x.replace("CL", "");
		x=x.replace("CN", "");
		x=x.replace("CY", "");
		x=x.replace("CC", "");
		x=x.replace("CO", "");
		x=x.replace("KM", "");
		x=x.replace("CG", "");
		x=x.replace("CD", "");
		x=x.replace("CK", "");
		x=x.replace("KP", "");
		x=x.replace("KR", "");
		x=x.replace("CI", "");
		x=x.replace("CR", "");
		x=x.replace("HR", "");
		x=x.replace("CU", "");
		x=x.replace("DK", "");
		x=x.replace("DM", "");
		x=x.replace("DO", "");
		x=x.replace("EC", "");
		x=x.replace("EG", "");
		x=x.replace("SV", "");
		x=x.replace("AE", "");
		x=x.replace("ER", "");
		x=x.replace("SK", "");
		x=x.replace("SI", "");
		x=x.replace("ES", "");
		x=x.replace("EA", "");
		x=x.replace("US", "");
		x=x.replace("UM", "");
		x=x.replace("EE", "");
		x=x.replace("ET", "");
		x=x.replace("FO", "");
		x=x.replace("PH", "");
		x=x.replace("FI", "");
		x=x.replace("FJ", "");
		x=x.replace("FR", "");
		x=x.replace("GA", "");
		x=x.replace("GM", "");
		x=x.replace("GE", "");
		x=x.replace("GS", "");
		x=x.replace("GH", "");
		x=x.replace("GI", "");
		x=x.replace("GD", "");
		x=x.replace("GR", "");
		x=x.replace("GL", "");
		x=x.replace("GP", "");
		x=x.replace("GU", "");
		x=x.replace("GT", "");
		x=x.replace("GF", "");
		x=x.replace("GG", "");
		x=x.replace("GN", "");
		x=x.replace("GQ", "");
		x=x.replace("GW", "");
		x=x.replace("GY", "");
		x=x.replace("HT", "");
		x=x.replace("HM", "");
		x=x.replace("HN", "");
		x=x.replace("HK", "");
		x=x.replace("HU", "");
		x=x.replace("IN", "");
		x=x.replace("ID", "");
		x=x.replace("IR", "");
		x=x.replace("IQ", "");
		x=x.replace("IE", "");
		x=x.replace("IS", "");
		x=x.replace("IL", "");
		x=x.replace("IT", "");
		x=x.replace("JM", "");
		x=x.replace("JP", "");
		x=x.replace("JE", "");
		x=x.replace("JO", "");
		x=x.replace("KZ", "");
		x=x.replace("KE", "");
		x=x.replace("KG", "");
		x=x.replace("KI", "");
		x=x.replace("KW", "");
		x=x.replace("LA", "");
		x=x.replace("LS", "");
		x=x.replace("LV", "");
		x=x.replace("LB", "");
		x=x.replace("LR", "");
		x=x.replace("LY", "");
		x=x.replace("LI", "");
		x=x.replace("LT", "");
		x=x.replace("LU", "");
		x=x.replace("MO", "");
		x=x.replace("MK", "");
		x=x.replace("MG", "");
		x=x.replace("MI", "");
		x=x.replace("MW", "");
		x=x.replace("MV", "");
		x=x.replace("ML", "");
		x=x.replace("MT", "");
		x=x.replace("FK", "");
		x=x.replace("IM", "");
		x=x.replace("MP", "");
		x=x.replace("MA", "");
		x=x.replace("MH", "");
		x=x.replace("MQ", "");
		x=x.replace("MU", "");
		x=x.replace("MR", "");
		x=x.replace("YT", "");
		x=x.replace("MX", "");
		x=x.replace("FM", "");
		x=x.replace("MD", "");
		x=x.replace("MC", "");
		x=x.replace("MN", "");
		x=x.replace("ME", "");
		x=x.replace("MS", "");
		x=x.replace("MZ", "");
		x=x.replace("MM", "");
		x=x.replace("NA", "");
		x=x.replace("NR", "");
		x=x.replace("CX", "");
		x=x.replace("NP", "");
		x=x.replace("NI", "");
		x=x.replace("NE", "");
		x=x.replace("NG", "");
		x=x.replace("NU", "");
		x=x.replace("NF", "");
		x=x.replace("NO", "");
		x=x.replace("NC", "");
		x=x.replace("NZ", "");
		x=x.replace("OM", "");
		x=x.replace("NL", "");
		x=x.replace("PK", "");
		x=x.replace("PW", "");
		x=x.replace("PS", "");
		x=x.replace("PA", "");
		x=x.replace("PG", "");
		x=x.replace("PY", "");
		x=x.replace("PE", "");
		x=x.replace("PN", "");
		x=x.replace("PF", "");
		x=x.replace("PL", "");
		x=x.replace("PT", "");
		x=x.replace("PR", "");
		x=x.replace("QA", "");
		x=x.replace("GB", "");
		x=x.replace("RE", "");
		x=x.replace("RW", "");
		x=x.replace("RO", "");
		x=x.replace("RU", "");
		x=x.replace("EH", "");
		x=x.replace("SB", "");
		x=x.replace("WS", "");
		x=x.replace("AS", "");
		x=x.replace("KN", "");
		x=x.replace("SM", "");
		x=x.replace("PM", "");
		x=x.replace("VC", "");
		x=x.replace("SH", "");
		x=x.replace("LC", "");
		x=x.replace("RS", "");
		x=x.replace("SC", "");
		x=x.replace("SL", "");
		x=x.replace("SG", "");
		x=x.replace("SY", "");
		x=x.replace("SO", "");
		x=x.replace("LK", "");
		x=x.replace("SZ", "");
		x=x.replace("ZA", "");
		x=x.replace("SD", "");
		x=x.replace("SE", "");
		x=x.replace("CH", "");
		x=x.replace("SR", "");
		x=x.replace("SJ", "");
		x=x.replace("TH", "");
		x=x.replace("TW", "");
		x=x.replace("TZ", "");
		x=x.replace("TJ", "");
		x=x.replace("TO", "");
		x=x.replace("TF", "");
		x=x.replace("TL", "");
		x=x.replace("TG", "");
		x=x.replace("TK", "");
		x=x.replace("TO", "");
		x=x.replace("TT", "");
		x=x.replace("TN", "");
		x=x.replace("TC", "");
		x=x.replace("TM", "");
		x=x.replace("TR", "");
		x=x.replace("TV", "");
		x=x.replace("UA", "");
		x=x.replace("UG", "");
		x=x.replace("EU", "");
		x=x.replace("UY", "");
		x=x.replace("UZ", "");
		x=x.replace("VU", "");
		x=x.replace("VA", "");
		x=x.replace("VE", "");
		x=x.replace("VN", "");
		x=x.replace("VG", "");
		x=x.replace("VI", "");
		x=x.replace("WF", "");
		x=x.replace("YE", "");
		x=x.replace("DJ", "");
		x=x.replace("ZM", "");
		x=x.replace("ZW", "");
		
		x=x.trim();
		x=x.replace(",   ",",");
		//x=x+".";
		return x;
	}

	private String TrataLanguages(String x)
	{
		x=x.replace("\",", "");
		x=x.replace("\"", "");
		x=x.replace("[", "");
		x=x.replace("]", "");
		x=x.replace("{", "");
		x=x.replace("},", ",");
		x=x.replace("}", "");
		x=x.replace("_", "");
		x=x.replace("639", "");
		x=x.replace("1", "");
		x=x.replace(":", "");
		x=x.replace("name", "");
		x=x.replace("iso", "");
		x=x.trim();
		x=x.replace(",   ",",");
		x=x.replace("  "," ");
		
		x=x.replace("aa ","");
		x=x.replace("ab ","");
		x=x.replace("ae ","");
		x=x.replace("af ","");
		x=x.replace("ak ","");
		x=x.replace("am ","");
		x=x.replace("an ","");
		x=x.replace("ar ","");
		x=x.replace("as ","");
		x=x.replace("av ","");
		x=x.replace("ay ","");
		x=x.replace("az ","");
		x=x.replace("ba ","");
		x=x.replace("be ","");
		x=x.replace("bg ","");
		x=x.replace("bh ","");
		x=x.replace("bi ","");
		x=x.replace("bm ","");
		x=x.replace("bn ","");
		x=x.replace("bo ","");
		x=x.replace("br ","");
		x=x.replace("bs ","");
		x=x.replace("ca ","");
		x=x.replace("ce ","");
		x=x.replace("ch ","");
		x=x.replace("co ","");
		x=x.replace("cr ","");
		x=x.replace("cs ","");
		x=x.replace("cu ","");
		x=x.replace("cv ","");
		x=x.replace("cy ","");
		x=x.replace("da ","");
		x=x.replace("de ","");
		x=x.replace("dv ","");
		x=x.replace("dz ","");
		x=x.replace("ee ","");
		x=x.replace("el ","");
		x=x.replace("en ","");
		x=x.replace("eo ","");
		x=x.replace("es ","");
		x=x.replace("et ","");
		x=x.replace("eu ","");
		x=x.replace("fa ","");
		x=x.replace("ff ","");
		x=x.replace("fi ","");
		x=x.replace("fj ","");
		x=x.replace("fo ","");
		x=x.replace("fr ","");
		x=x.replace("fy ","");
		x=x.replace("ga ","");
		x=x.replace("gd ","");
		x=x.replace("gl ","");
		x=x.replace("gn ","");
		x=x.replace("gu ","");
		x=x.replace("gv ","");
		x=x.replace("ha ","");
		x=x.replace("he ","");
		x=x.replace("hi ","");
		x=x.replace("ho ","");
		x=x.replace("hr ","");
		x=x.replace("ht ","");
		x=x.replace("hu ","");
		x=x.replace("hy ","");
		x=x.replace("hz ","");
		x=x.replace("ia ","");
		x=x.replace("id ","");
		x=x.replace("ie ","");
		x=x.replace("ig ","");
		x=x.replace("ii ","");
		x=x.replace("ik ","");
		x=x.replace("io ","");
		x=x.replace("is ","");
		x=x.replace("it ","");
		x=x.replace("iu ","");
		x=x.replace("ja ","");
		x=x.replace("jv ","");
		x=x.replace("ka ","");
		x=x.replace("kg ","");
		x=x.replace("ki ","");
		x=x.replace("kj ","");
		x=x.replace("kk ","");
		x=x.replace("kl ","");
		x=x.replace("km ","");
		x=x.replace("kn ","");
		x=x.replace("ko ","");
		x=x.replace("kr ","");
		x=x.replace("ks ","");
		x=x.replace("ku ","");
		x=x.replace("kv ","");
		x=x.replace("kw ","");
		x=x.replace("ky ","");
		x=x.replace("la ","");
		x=x.replace("lb ","");
		x=x.replace("lg ","");
		x=x.replace("li ","");
		x=x.replace("ln ","");
		x=x.replace("lo ","");
		x=x.replace("lt ","");
		x=x.replace("lu ","");
		x=x.replace("lv ","");
		x=x.replace("mg ","");
		x=x.replace("mh ","");
		x=x.replace("mi ","");
		x=x.replace("mk ","");
		x=x.replace("ml ","");
		x=x.replace("mn ","");
		x=x.replace("mo ","");
		x=x.replace("mr ","");
		x=x.replace("ms ","");
		x=x.replace("mt ","");
		x=x.replace("my ","");
		x=x.replace("na ","");
		x=x.replace("nb ","");
		x=x.replace("nd ","");
		x=x.replace("ne ","");
		x=x.replace("ng ","");
		x=x.replace("nl ","");
		x=x.replace("nn ","");
		x=x.replace("no ","");
		x=x.replace("nr ","");
		x=x.replace("nv ","");
		x=x.replace("ny ","");
		x=x.replace("oc ","");
		x=x.replace("oj ","");
		x=x.replace("om ","");
		x=x.replace("or ","");
		x=x.replace("os ","");
		x=x.replace("pa ","");
		x=x.replace("pi ","");
		x=x.replace("pl ","");
		x=x.replace("ps ","");
		x=x.replace("pt ","");
		x=x.replace("qu ","");
		x=x.replace("rm ","");
		x=x.replace("rn ","");
		x=x.replace("ro ","");
		x=x.replace("ru ","");
		x=x.replace("rw ","");
		x=x.replace("sa ","");
		x=x.replace("sc ","");
		x=x.replace("sd ","");
		x=x.replace("se ","");
		x=x.replace("sg ","");
		x=x.replace("sh ","");
		x=x.replace("si ","");
		x=x.replace("sk ","");
		x=x.replace("sl ","");
		x=x.replace("sm ","");
		x=x.replace("sn ","");
		x=x.replace("so ","");
		x=x.replace("sq ","");
		x=x.replace("sr ","");
		x=x.replace("ss ","");
		x=x.replace("st ","");
		x=x.replace("su ","");
		x=x.replace("sv ","");
		x=x.replace("sw ","");
		x=x.replace("ta ","");
		x=x.replace("te ","");
		x=x.replace("tg ","");
		x=x.replace("th ","");
		x=x.replace("ti ","");
		x=x.replace("tk ","");
		x=x.replace("tl ","");
		x=x.replace("tn ","");
		x=x.replace("to ","");
		x=x.replace("tr ","");
		x=x.replace("ts ","");
		x=x.replace("tt ","");
		x=x.replace("tw ","");
		x=x.replace("ug ","");
		x=x.replace("uk ","");
		x=x.replace("ur ","");
		x=x.replace("uz ","");
		x=x.replace("ve ","");
		x=x.replace("vi ","");
		x=x.replace("vo ","");
		x=x.replace("wa ","");
		x=x.replace("wo ","");
		x=x.replace("xh ","");
		x=x.replace("yi ","");
		x=x.replace("yo ","");
		x=x.replace("za ","");
		x=x.replace("zh ","");
		x=x.replace("zu ","");
		x=x.replace("xx ","");
		
		//x=x+".";
		return x;
	}
	public void carregaCadastrados(TListaPessoa lista) {
		
		try {
			FileInputStream fi = new FileInputStream(arquivoUser);
			DataInputStream di = new DataInputStream(fi);
			
			int status=-1;
			
			while((status = di.available())>0) {
				TInfoPessoa Item=new TInfoPessoa();				
				Item.setNome(di.readUTF());
				Item.setSenha(di.readUTF());
				Item.setEmail(di.readUTF());//id
				Item.setSexo(di.readUTF());
				Item.setIdade(di.readInt());
				
				lista.InsereFinal(Item);
			}
			di.close();
			fi.close();
		}catch(IOException e) {
			e.printStackTrace();
		}		
		
	
	}
	
	public void salvarArquivo(TListaPessoa l) {
		try {
			FileOutputStream fo = new FileOutputStream(arquivoUser);
			DataOutputStream dout = new DataOutputStream(fo);
			TNodoPessoa aux =  l.Primeiro.Proximo;	
			while(aux!=null) {
				dout.writeUTF(aux.Item.getNome());
				dout.writeUTF(aux.Item.getSenha());
				dout.writeUTF(aux.Item.getEmail());
				dout.writeUTF(aux.Item.getSexo());
				dout.writeInt(aux.Item.getIdade());		 
				aux= aux.Proximo;
			}
			dout.close();
			fo.close();
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
}