package com.epam.salon.controller.commands;

import com.epam.salon.model.Request;
import com.epam.salon.model.User;
import com.epam.salon.services.RequestService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewRequestCommand extends FrontCommand {
    private static final Logger LOGGER = Logger.getLogger(NewRequestCommand.class);

    @Override
    public void process() throws ServletException, IOException {
        if ("POST".equalsIgnoreCase(request.getMethod())){

            response.setContentType("text/html");

            RequestService requestService = new RequestService();

            User user = (User) request.getSession().getAttribute("user");
            Long clientId = user.getId();

            String masterId = request.getParameter("master_id");

            String date = request.getParameter("date");
            String time = request.getParameter("time");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(String.format("%s %s", date, time), formatter);

            //2018-05-16
            //15:03

            requestService.create(new Request(
                    dateTime,
                    clientId,
                    Long.parseLong(masterId)
            ));

            PrintWriter writer = response.getWriter();

            StringBuilder builder = new StringBuilder();

            builder.append(clientId).append("<br>")
                    .append(masterId).append("<br>")
                    .append(date).append("<br>")
                    .append(time);


            writer.println(builder.toString());
            writer.close();


        } else {
            forward("newrequest");
        }
    }
}
