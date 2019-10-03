package exception.throwexample;

class Date {
	 private int day, month, year;
	 
	 public Date(int day, int month, int year) {
		 setDay(day);
		 setMonth(month);
		 setYear(year);
	 }
	 
	//setDay assigns its argument to the private member day.
	public void setDay(int day)
	{
		if (day >= 1 && day <= 31)
			this.day = day;
		else
			throw new IllegalArgumentException("The day must be between 1 and 31");
	}
	
	//setMonth assigns its argument to the private member month.
	public void setMonth(int month)
	{
		if (month >= 1 && month <= 12)
			this.month = month;
		else
			 throw new IllegalArgumentException("The month must be between 1 and 12");
	}
	
	public void setYear(int year)
	{
		if (year > 0)
			this.year = year;
		else
			throw new IllegalArgumentException("The year must be greater than 0");
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
}