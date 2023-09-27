/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet1;

import controller.DBConnection;
import model.Brand;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author march
 */
@WebServlet(name = "AddNewBrand", urlPatterns = {"/AddNewBrand"})
public class AddBrand extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            HttpSession session = request.getSession();
            Brand brand = (Brand) session.getAttribute("brand");

            if (brand == null) {
                String name = request.getParameter("name");
                String type = request.getParameter("type");
                int price = Integer.parseInt(request.getParameter("price"));

                brand = new Brand();
                brand.setName(name);
                brand.setType(type);
                brand.setPrice(price);

                DBConnection dbConnection = new DBConnection();
                if (!dbConnection.insertNewBrand(brand)) {
                    System.out.println(">>> AddBrand ERROR");
                }

                session.setAttribute("brands", brand);
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/addNewBrand.html");
                rd.forward(request, response);

                out.println("<html><body>");
                out.println("<form action='AddBrand'>");
                out.println(brand.getName() + " " + brand.getType() + " " + brand.getPrice() + "<br/");
                out.println("<input type='submit' value='Edit'>");
                out.println("</form></body></html>");
            } else {
//                out.println("<html><body>");
                out.println("<form action='AddBrand'>");
                out.println("name: <input type='text' name='name' value='"
                        + brand.getName() + "'>");
                out.println("type: <input type='text' name='type' value='"
                        + brand.getType() + "'>");
                out.println("price: <input type='text' name='price' value='"
                        + brand.getPrice() + "'>");
                out.println("<input type='submit' value='Edit'>");
                out.println("</form></body></html>");

                session.removeAttribute("brands");
            }

        } catch (Exception e) {
            response.sendRedirect("error.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
