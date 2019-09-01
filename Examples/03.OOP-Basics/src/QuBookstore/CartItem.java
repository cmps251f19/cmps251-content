package QuBookstore;

public class CartItem
{
    private Book book;
    private int quantity;

    public CartItem()
    {
        this.book = new Book();
        this.quantity = 0;
    }

    public CartItem(Book book, int quantity)
    {
        this.book = book;
        this.quantity = quantity;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    public Book getBook()
    {
        return book;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getTotal()
    {
        return quantity * book.getPrice();
    }

    public String getFormattedTotal()
    {
        return String.format("QR %4.2f" , getTotal());
    }
}