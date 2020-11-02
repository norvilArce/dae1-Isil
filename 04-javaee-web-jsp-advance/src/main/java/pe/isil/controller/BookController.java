package pe.isil.controller;

import pe.isil.model.dao.BookDao;
import pe.isil.model.dao.DaoFactory;
import pe.isil.model.entities.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookController extends HttpServlet {

    private static final String LIST_BOOK = "/listBook.jsp";
    private static final String INSERT_OR_EDIT = "book.jsp";

    BookDao bookDao;

    public BookController() {
        super();
        bookDao = DaoFactory.createBookDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String forward = "";
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            forward = LIST_BOOK;
            String isbn = req.getParameter("isbn");
            bookDao.deleteById(isbn);
            req.setAttribute("books", bookDao.findAll());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            String isbn = req.getParameter("isbn");
            Book book = bookDao.findById(isbn);
            req.setAttribute("book", book);

        } else if (action.equalsIgnoreCase("listBook")) {
            forward = LIST_BOOK;
            req.setAttribute("books", bookDao.findAll());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = new Book();
        book.setIsbn(req.getParameter("isbn"));
        book.setTitulo(req.getParameter("titulo"));
        book.setCategoria(req.getParameter("categoria"));

        Book currentBook = bookDao.findById(book.getIsbn());

        if (currentBook != null) {
            //actualizar
            bookDao.update(book);
        } else {
            //insertar
            bookDao.insert(book);
        }

        RequestDispatcher view = req.getRequestDispatcher(LIST_BOOK);
        req.setAttribute("books", bookDao.findAll());
        view.forward(req, resp);
    }
}
