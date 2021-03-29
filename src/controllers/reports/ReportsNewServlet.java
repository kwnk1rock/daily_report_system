package controllers.reports;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Report;
import models.TimeCard;

/**
 * Servlet implementation class ReportsNewServlet
 */
@WebServlet("/reports/new")
public class ReportsNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());

        Report r = new Report();
        r.setReport_date(new Date(System.currentTimeMillis()));
        request.setAttribute("report", r);

        TimeCard t = new TimeCard();
        Calendar ds_at = Calendar.getInstance();
            ds_at.set(Calendar.HOUR_OF_DAY, 9);ds_at.set(Calendar.MINUTE, 0);ds_at.set(Calendar.SECOND, 0);
        Calendar de_at = Calendar.getInstance();
            de_at.set(Calendar.HOUR_OF_DAY, 17);de_at.set(Calendar.MINUTE, 0);de_at.set(Calendar.SECOND, 0);
        t.setStarted_at(new Timestamp(ds_at.getTimeInMillis()));
        t.setEnded_at(new Timestamp(de_at.getTimeInMillis()));
        request.setAttribute("timecard", t);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/new.jsp");
        rd.forward(request, response);
    }

}
