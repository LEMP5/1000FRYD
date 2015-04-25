package GUILayer;

public class Languages
{
	private int chooseOfLanguage;
	
	public Languages()
    {
		chooseOfLanguage = 1;
    }
	
	public String weekDays(int i)
	{
		String[] list = null;
		switch(chooseOfLanguage)
		{
			case 1:
				list = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
			break;
			case 2:
				list = new String[] {"Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag", "Søndag"};
			break;
			case 3:
				list = new String[] {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"};
			break;
			case 4:
				list = new String[] {"Luni", "Martzi", "Miercuri", "Joi", "Vineri", "Sambata", "Duminica"};
			break;
			case 5:
				list = new String[] {"", "", "", "", "", "", ""};
			break;
		}
		return list[i];
	}
	
	public String months(int i)
	{
		String[] list = null;
		switch(chooseOfLanguage)
		{
			case 1:
				list = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
			break;
			case 2:
				list = new String[] {"Januar", "Februar", "Marts", "April", "Maj", "Juni", "Juli", "August", "September", "Oktober", "November", "December"};
			break;
			case 3:
				list = new String[] {"Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"};
			break;
			case 4:
				list = new String[] {"Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie", "Iulie", "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie"};
			break;
			case 5:
				list = new String[] {"", "", "", "", "", "", "", "", "", "", "", ""};
			break;
		}
		return list[i];
	}//{"", "", "", "", "", "", "", "", "", "", "", ""};
	
	public String buttoms(int i)
	{
		String[] list = null;
		switch(chooseOfLanguage)
		{
			case 1:
				list = new String[] {"Add", "Remove", "Edit", "Cancel", "Set", "", ""};
			break;
			case 2:
				list = new String[] {"Tilføj", "Fjern", "Rediger", "", "", "", ""};
			break;
			case 3:
				list = new String[] {"Dodaj", "Usuń", "Edytuj", "Anuluj", "Ustaw", "", ""};
			break;
			case 4:
				list = new String[] {"Adauga", "Sterge", "Editeaza", "", "", "", ""};
			break;
			case 5:
				list = new String[] {"", "", "", "", "", "", ""};
			break;
		}
		return list[i];
	}
	
	public String tabs(int i)
	{
		String[] list = null;
		switch(chooseOfLanguage)
		{
			case 1:
				list = new String[] {"Event", "Volunteer", "Sign up", "", "", "", ""};
			break;
			case 2:
				list = new String[] {"Begivenheder", "Frivilig", "Tilmelding", "", "", "", ""};
			break;
			case 3:
				list = new String[] {"Wydarzenie", "Wolotantariusz", "Zapisz się", "", "", "", ""};
			break;
			case 4:
				list = new String[] {"Eveniment", "", "", "", "", "", ""};
			break;
			case 5:
				list = new String[] {"", "", "", "", "", "", ""};
			break;
		}
		return list[i];
	}
	
	public String labelsVolunter(int i)
	{
		String[] list = null;
		switch(chooseOfLanguage)
		{
			case 1:
				list = new String[] {"Name", "Surname", "Email", "Phone", "Privilages", "Phone", "Qualifications", "Bar tokens"};
			break;
			case 2:
				list = new String[] {"Navn", "", "", "", "", "", "", ""};
			break;
			case 3:
				list = new String[] {"Imię", "Nazwisko", "Email", "Telefon", "Uprawnienia", "Telefon", "Kwalifikacje", "Kupony"};
			break;
			case 4:
				list = new String[] {"Nume", "", "", "", "", "", "", ""};
			break;
			case 5:
				list = new String[] {"", "", "", "", "", "", "", ""};
			break;
		}
		return list[i];
	}
	
	public String labelsTopPanel(int i)
	{
		String[] list = null;
		switch(chooseOfLanguage)
		{
			case 1:
				list = new String[] {"Calendar", "Membership", "Accounts", "", "", "", ""};
			break;
			case 2:
				list = new String[] {"", "", "Frivilig", "", "", "", ""};
			break;
			case 3:
				list = new String[] {"Kalendarz", "Członkostwo", "Konta", "", "", "", ""};
			break;
			case 4:
				list = new String[] {"", "", "", "", "", "", ""};
			break;
			case 5:
				list = new String[] {"", "", "", "", "", "", ""};
			break;
		}
		return list[i];
	}
	
	public String infoLabels(int i)
	{
		String[] list = null;
		switch(chooseOfLanguage)
		{
			case 1:
				list = new String[] {"Added", "Removed", "Try once again", "Found", "Password reset", "", "", " "};
			break;
			case 2:
				list = new String[] {"", "", "", "", "", "", "", ""};
			break;
			case 3:
				list = new String[] {"Dodano", "Usunięto", "Spróbuj jeszcze raz", "Znaleziono", "Zresetuj hasło", "", "", ""};
			break;
			case 4:
				list = new String[] {"", "", "", "", "", "", "", ""};
			break;
			case 5:
				list = new String[] {"", "", "", "", "", "", "", ""};
			break;
		}
		return list[i];
	}
}

