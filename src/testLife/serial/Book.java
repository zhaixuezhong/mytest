package testLife.serial;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

import java.io.*;
import java.math.BigDecimal;

/**
 * Created by zhaixuezhong on 11/7/16.
 */
public class Book implements Serializable{
    private String bookName;

    private String auther;

    private BigDecimal price;

    private static final long serialVersionUID = 1L;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String toString(){
        return "book name: " + bookName + "\nauther: " +auther + "\nprise: " + price;
    }
}



class Test{

    public static void main(String[] args){


        Book book = new Book();
        book.setBookName("my two world!");
        book.setAuther("ShiminFang");
        book.setPrice(new BigDecimal(36));

        FileOutputStream fos = null;
        ObjectOutputStream ops = null;
        try{
            fos = new FileOutputStream("book.txt");
            ops = new ObjectOutputStream(fos);
            ops.writeObject(book);

            System.out.println(new File("book.txt").length());

            ops.flush();
            ops.writeObject(book);

            System.out.println(new File("book.txt").length());


        }catch(Exception e){

        }finally {
            try{
                ops.close();
                fos.close();
            }catch (Exception e){
                System.out.print("error when close output stream!");
            }

        }



        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("book.txt");
            ois = new ObjectInputStream(fis);
            Book readBook = (Book)ois.readObject();
            Book readBook2 = (Book)ois.readObject();


            System.out.println(readBook.toString());
            System.out.println(readBook2.toString());
            System.out.println("equals?" + readBook2.equals(readBook));

        }catch(Exception e){

        }finally {
            try{
                ois.close();
                fis.close();
            }catch (Exception e){
                System.out.print("error when close input stream!");
            }

        }




    }
}