package br.edu.ifsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.model.domain.Car;
import br.edu.ifsp.model.domain.ParkingLot;
import br.edu.ifsp.model.dao.CarDao;
import br.edu.ifsp.model.dao.ParkingLotDao;

@WebServlet(name="carServlet", value="/cars")
public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String licensePlate = req.getParameter("licensePlate");
        int parkingLot = Integer.parseInt(req.getParameter("parkingLot"));
        String brand = req.getParameter("brand");
        String color = req.getParameter("color");
        String owner = req.getParameter("owner");
        String location = req.getParameter("location");
        ParkingLot pl = new ParkingLot(parkingLot);

        CarDao dao = new CarDao();
        dao.delete(licensePlate);
        resp.sendRedirect("carlist.jsp");

    }

    @Override
    public void init() throws ServletException {
        CarDao dao = new CarDao();
        dao.createTable();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String licensePlate = req.getParameter("licensePlate");
        int parkingLot = Integer.parseInt(req.getParameter("parkingLot"));
        String brand = req.getParameter("brand");
        String color = req.getParameter("color");
        String owner = req.getParameter("owner");
        String location = req.getParameter("location");
        String send = req.getParameter("send");

        ParkingLot pl = new ParkingLot(parkingLot);

        CarDao dao = new CarDao();
        Car c = new Car(licensePlate, pl, brand, 
            color, owner, location);

        if (send.contains("Save")) {
            dao.insert(c);
        } else {
            dao.update(c);
        }
    }
    

    
}
