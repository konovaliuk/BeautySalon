package com.kpi.salon.controller.commands;

import com.kpi.salon.model.Admin;
import com.kpi.salon.services.IEmailService;
import com.kpi.salon.services.impl.EmailService;
import com.kpi.salon.services.impl.SmsService;
import com.kpi.salon.services.impl.UserService;
import com.kpi.salon.services.impl.ValidationService;
import com.kpi.salon.utils.ResourcesManager;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

public class TestCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
//        EmailService emailService = new EmailService();
//        emailService.send("dron.sh1@gmail.com");
//
//        SmsService smsService = new SmsService();
//        smsService.sendSms("4444", "380631066143");
//

//        ValidationService validationService = new ValidationService();

        new ResourcesManager();

        //forward("test");
    }
}
