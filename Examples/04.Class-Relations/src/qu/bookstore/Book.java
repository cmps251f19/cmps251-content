package qu.bookstore;

public class Book
{
    private String code;
    private String description;
    private double price;

    public Book()
    {
        code = "";
        description = "";
        price = 0;
    }

    public Book(String code, String description, double price)
    {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public String getFormattedPrice()
    {
        return String.format("QR %.2f" , price);
    }

}