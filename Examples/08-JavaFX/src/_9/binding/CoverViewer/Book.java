package _9.binding.CoverViewer;

public class Book {
   private String title; // book title
   private String thumbImage; // source of book cover's thumbnail image
   private String largeImage; // source of book cover's full-size image

   public Book(String title, String thumbImage, String largeImage) {
      this.title = title;
      this.thumbImage = thumbImage;
      this.largeImage = largeImage;
   }
   
   public String getTitle() {return title;}

   public void setTitle(String title) {this.title = title;}
   
   public String getThumbImage() {return thumbImage;}

   public void setThumbImage(String thumbImage) {this.thumbImage = thumbImage;}

   public String getLargeImage() {return largeImage;}

   public void setLargeImage(String largeImage) {this.largeImage = largeImage;}
   
   @Override
   public String toString() {return getTitle();}
}