package classes;
public class TNodo {
	public TInfo Item;
	public TNodo Proximo;
	public TNodo Anterior;
	
	TNodo(TInfo Item)
	{
		this.Item=new TInfo(Item.id,Item.Budget,Item.Genres,Item.HomePage,Item.Keywords,Item.OriginalLanguage,Item.OriginalTitle,Item.Overview,Item.Popularity,Item.ProductionCompanies,Item.ProductionContries,Item.RealeseDate,Item.Revenue,Item.Runtime,Item.SpokenLanguages,Item.Status,Item.Tagline,Item.Title,Item.VoteAvarage,Item.VoteCount);
		this.Proximo=null;
		this.Anterior=null;
	}

}
