package qu.bookstore;

public class CartItem
{
    private Book book;
    private int quantity;

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
}