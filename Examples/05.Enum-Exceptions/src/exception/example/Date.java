package exception.example;

class Date {
	 int day, month;
	 
	 Date(int day, int month) {
		 setDay(day);
		 setMonth(month);
	 }
	 
	//setDay assigns its argument to the private member day.
	public void setDay(int day)
	{
		if (day >= 1 && day <= 31)
			this.day = day;
		else
			throw new IllegalArgumentException("The day must me between 1 and 31");
	}
	
	//setMonth assigns its argument to the private member month.
	public void setMonth(int month)
	{
		if (month >= 1 && month <= 12)
			this.month = month;
		else
			 throw new IllegalArgumentException("The month must me between 1 and 12");
	} 
}