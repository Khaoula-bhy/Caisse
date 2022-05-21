package com.example.caisse.Services;

import com.example.caisse.Exceptions.ResourcesNotfoundException;
import com.example.caisse.Models.TicketModel;
import com.example.caisse.Repositories.ProductRepository;
import com.example.caisse.Repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TicketServiceImpl implements  TicketServiceInterface{
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    private TicketRepository ticketRepository;



    @Override
    public List<TicketModel> findAllTickets() {

        return ticketRepository.findAll();
    }

    @Override
    public TicketModel AddTicket(TicketModel ticketModel) {
        return ticketRepository.save(ticketModel);
    }

    @Override
    public TicketModel findTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(()-> new ResourcesNotfoundException("Product doesn't exist with id:"+ id));
    }



    @Override
    public Map<String, Boolean> deleteTicket(Long id) {
        TicketModel ticket=findTicketById(id);
        ticketRepository.delete(ticket);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

}
