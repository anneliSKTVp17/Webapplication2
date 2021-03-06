/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entiti.Book;
import entiti.History;
import entiti.Reader;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BookFacade;
import session.HistoryFacade;
import session.ReaderFacade;

/**
 *
 * @author user
 */
@WebServlet(name = "WebController", urlPatterns = {
    "/",
    "/showAddBook",
    "/createBook",
    "/listBooks",
    "/showAddReader","/createReader","/listReaders",
    "/showCreateHistory","/createHistory","/listHistory",
    
})
public class WebController extends HttpServlet {
@EJB BookFacade bookFacade;
@EJB ReaderFacade readerFacade;
@EJB HistoryFacade historyFacade;
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path) {
             case "/":
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/showAddBook":
                request.getRequestDispatcher("/showAddBook.jsp")
                        .forward(request, response);
                break;
            case "/createBook":
                String name=request.getParameter("name");
                String author = request.getParameter("author");
                String isbn = request.getParameter("isbn");
                String publishedYear = request.getParameter("publishedYear");
                String quantity = request.getParameter("quantity");
                Book book = new Book(
                        name, 
                        author, 
                        isbn, 
                        new Integer(publishedYear),
                        new Integer(quantity), 
                        new Integer(quantity)
                );
                bookFacade.create(book);
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
            case "/listBooks":
                List<Book> listBooks = bookFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.getRequestDispatcher("/listBooks.jsp")
                        .forward(request, response);
            break;
            case "/showAddReader":
                request.getRequestDispatcher("/showAddReader.jsp").forward(request, response);
            break;
            case "/createReader":
                String firstname=request.getParameter("name");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phone");
                Reader rdr=new Reader(firstname,lastname,phone);
                readerFacade.create(rdr);
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
            break;
            case "/listReaders":
                List<Reader> listReaders = readerFacade.findAll();
                request.setAttribute("listReaders", listReaders);
                request.getRequestDispatcher("/listReaders.jsp").forward(request, response);
            break;
            
            
            
            case "/showCreateHistory":
                listBooks = bookFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                listReaders = readerFacade.findAll();
                request.setAttribute("listReaders", listReaders);
                request.getRequestDispatcher("/showCreateHistory.jsp").forward(request, response);
            break;
            case "/createHistory":
                String strReaderId=request.getParameter("readerId");
                String strBookId = request.getParameter("bookId");
                rdr=readerFacade.find( Long.parseLong(strReaderId) );
                book=bookFacade.find( Long.parseLong(strBookId) );
                GregorianCalendar clnd=new GregorianCalendar();
                History history = new History(rdr, book, new Date(), new Date());
                historyFacade.create(history);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            break;
            case "/listHistory":
               List<History> listHistory = historyFacade.findAll();
                request.setAttribute("listHistory", listHistory);
                request.getRequestDispatcher("/listHistory.jsp").forward(request, response);
            break;
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}