package com.substring.database;

import com.substring.database.dao.BookDao;
import com.substring.database.dao.UserDao;
import com.substring.database.entity.Book;
import com.substring.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SubstringDatabaseProjectApplication implements CommandLineRunner {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    public static void main(String[] args) {
        SpringApplication.run(SubstringDatabaseProjectApplication.class, args);
    }

    //this is the console based starter point
    //when we start our application, this run method starts by its own
    @Override
    public void run(String... args) throws Exception {
        //Here, we have to write all the console based application
        System.out.println("Application started");

        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            try {

                System.out.println("-----Library Management System");
                System.out.println("Press 1 to enter book");
                System.out.println("Press 2 to view all books");
                System.out.println("Press 3 to search a book");
                System.out.println("Press 4 to update a book");
                System.out.println("Press 5 to delete a book");
				System.out.println("Press 6 to search a book");
                System.out.println("Press 7 to Exit");

                System.out.println("Press 8 to issue book to user");
                System.out.println("Press 9 to return book from user");
                System.out.println("Press 10 to view all issued books");

                System.out.println("Enter your choice");

                int choice = Integer.parseInt(bufferReader.readLine());

                if (choice == 1) {
                    //book add - logic
                    System.out.println("Enter the book title: ");
                    String title = bufferReader.readLine();

                    System.out.println("Enter the book about: ");
                    String about = bufferReader.readLine();

                    System.out.println("Enter the book author: ");
                    String author = bufferReader.readLine();

                    System.out.println("Enter the book available: [T/F]");
                    String available = bufferReader.readLine();
                    boolean isAvailable = available.equalsIgnoreCase("T");

                    System.out.println("Enter the book language");
                    String language = bufferReader.readLine();




                    Book book = new Book();
                    book.setTitle(title);
                    book.setAbout(about);
                    book.setAvailable(isAvailable);
                    book.setAuthor(author);
                    book.setLanguage(language);

                    bookDao.save(book);
					System.out.println("Book added successfully");
					System.out.println("--------------------------------");
					System.out.println();
                } else if (choice == 2) {
                    //book view - logic
					System.out.println("All books in the library");
					System.out.println("-------------------------");
					System.out.println();
					System.out.println("ID | Title");
					List<Book> all = bookDao.getAll();
					all.forEach(book -> {
						System.out.println(book.getId() +" |" + book.getTitle());
					});
					System.out.println("-------------------");
					System.out.println();
                } else if (choice == 3) {
                    //book search -- search logic
                    System.out.println("Enter the book title to search:");
                    String titleKeyword = bufferReader.readLine();

                    List<Book> search  = bookDao.search(titleKeyword);
                    System.out.println("ID | Title");
                    search.forEach(book -> {
                        System.out.println(book.getId()+ " | "+ book.getTitle());
                    });


                } else if (choice == 4) {
                    //book update -- update logic

                } else if (choice == 5) {
                    //delete book -- delete logic
                    System.out.println("Enter the book id: ");
                    int bookId = Integer.parseInt(bufferReader.readLine());

                    bookDao.delete(bookId);
                    System.out.println("Book deleted successfully");
                    System.out.println("-------------------------");
                    System.out.println();
                }
				else if(choice==6){
					//view single book detail
					System.out.println("Enter the book id: ");
					int bookId = Integer.parseInt(bufferReader.readLine());

					Book book = bookDao.get(bookId);

					System.out.println("-------------------");
					System.out.println("Book ID: " + book.getId());
					System.out.println("Book Title: " + book.getTitle());
					System.out.println("Book About: " + book.getAbout());
					System.out.println("Book Author: " + book.getAuthor());
					System.out.println("Book Language" + book.getLanguage());
					System.out.println("Book Available: " + (book.getAvailable() ? "Yes": "No"));
				}

				else if (choice == 7) {
                    System.out.println("Exiting the application...");
                    break;
                }

                else if(choice==8){
                    //issue book
                    //get book details from user id
                    System.out.println("Enter the book id");
                    int bookId = Integer.parseInt(bufferReader.readLine());
                    Book book = bookDao.get(bookId);

                    if(!book.getAvailable()){
                        System.out.println("Book is not available for issue");
                    }

                    else{
                        //issue book logic
                        System.out.println("Enter the user id: ");
                        int userid = Integer.parseInt(bufferReader.readLine());

                        User user = userDao.get(userid);

                        LocalDate issueDate = LocalDate.now();
                    }

                }

                else {
                    System.out.println("Invalid Choice. Please try again");
                }
            } catch (Exception e) {
                System.out.println("Error occured " + e.getMessage());
            }
        }


    }
}
