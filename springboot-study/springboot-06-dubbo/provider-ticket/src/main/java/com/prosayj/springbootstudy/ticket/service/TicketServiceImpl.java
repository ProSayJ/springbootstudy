package com.prosayj.springbootstudy.ticket.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service    // (dubbo)将服务发布出去
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "<厉害了 科学>";
    }
}
