package com.mtb.servlet;

import com.mtb.service.SMSService;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class DispatchServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       process(request,response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String requestMessage=request.getParameter("requestMessage");

        SMSService service = new SMSService();

        String responseMessage = service.send(requestMessage);

        out.write("<html>\n" +
                "<body>\n" +
                "<a href=\"/MovieTicketBooking\">Home</a>");
        out.write("<p align=\"center\">"+responseMessage+"</p>");
        out.write("</body>\n" +
                "</html>");

        out.flush();
        out.close();

    }
}