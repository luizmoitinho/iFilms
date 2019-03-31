package classes;
public class TInfo {
	public int id;
	public long Budget;
	public String Genres;
	public String HomePage;
	public String Keywords;
	public String OriginalLanguage;
	public String OriginalTitle;
	public String Overview;
	public long Popularity; //Eliminar os pontos com replace all e converter para long.
	public String ProductionCompanies;
	public String ProductionContries;
	public String RealeseDate;
	public long Revenue;
	public int Runtime;
	public String SpokenLanguages;
	public String Status;
	public String Tagline;
	public String Title;
	public float VoteAvarage;
	public int VoteCount;
	
	public TInfo() {}
	public TInfo(int id,long Budget,String Genres,String Homepage,String Keywords,String OriginalLanguage,String OriginalTitle,String Overview,long Popularity,String ProductionCompanies,String ProductionContries,String ReleaseDate,long Revenue,int Runtime,String SpokenLanguages,String Status,String Tagline,String Title,float VoteAvarage,int VoteCount)
	{
		this.id=id;
		this.Budget=Budget;
		this.Genres=Genres;
		this.HomePage=Homepage;
		this.Keywords=Keywords;
		this.OriginalLanguage=OriginalLanguage;
		this.OriginalTitle=OriginalTitle;
		this.Overview=Overview;
		this.Popularity=Popularity;
		this.ProductionCompanies=ProductionCompanies;
		this.ProductionContries=ProductionContries;
		this.RealeseDate=ReleaseDate;
		this.Revenue=Revenue;
		this.Runtime=Runtime;
		this.SpokenLanguages=SpokenLanguages;
		this.Status=Status;
		this.Tagline=Tagline;
		this.Title=Title;
		this.VoteAvarage=VoteAvarage;
		this.VoteCount=VoteCount;
	}
	
	public void Status()
	{
		System.out.println("Title: "+this.Title);
		System.out.println("ID: "+this.id);
		System.out.println("Budget: "+this.Budget);
		System.out.println("Genres: "+this.Genres);
		System.out.println("HomePage: "+this.HomePage);
		System.out.println("Keywords: "+this.Keywords);
		System.out.println("OriginalLanguage: "+this.OriginalLanguage);
		System.out.println("OriginalTitle: "+this.OriginalTitle);
		System.out.println("Overview: "+this.Overview);
		System.out.println("Popularity: "+this.Popularity);
		System.out.println("ProductionCompanies: "+this.ProductionCompanies);
		System.out.println("ProductionContries: "+this.ProductionContries);
		System.out.println("ReleaseDate: "+this.RealeseDate);
		System.out.println("Revenue: "+this.Revenue);
		System.out.println("Runtime: "+this.Runtime);
		System.out.println("SpokenLanguages: "+this.SpokenLanguages);
		System.out.println("Status: "+this.Status);
		System.out.println("Tagline: "+this.Tagline);
		System.out.println("VoteAvarage: "+this.VoteAvarage);
		System.out.println("VoteCount: "+this.VoteCount);
	}
}
