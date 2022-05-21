package com.example.caisse.Services;

import com.example.caisse.Models.TicketModel;

import java.util.List;
import java.util.Map;

public interface TicketServiceInterface {
    public List<TicketModel> findAllTickets();
    public TicketModel AddTicket( TicketModel ticketModel);
    public TicketModel findTicketById( Long id);

    public Map<String,Boolean> deleteTicket(Long id);
}