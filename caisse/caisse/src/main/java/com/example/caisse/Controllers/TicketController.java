package com.example.caisse.Controllers;



import com.example.caisse.Models.TicketModel;
import com.example.caisse.Services.TicketServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")

@RestController
@RequestMapping("/api/v1")
public class TicketController {
    public TicketServiceInterface ticketService;

    @Autowired

    public TicketController(TicketServiceInterface ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketModel>> getAllTickets(){
        List<TicketModel> tickets= ticketService.findAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
    @GetMapping("/tickets/{id}")
    public ResponseEntity<TicketModel> getTicketById(@PathVariable Long id){
        TicketModel ticket =ticketService.findTicketById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);

    }
    @PostMapping("/tickets")
    public ResponseEntity<TicketModel> createProduct(@RequestBody TicketModel ticketModel){
        TicketModel ticket=ticketService.AddTicket(ticketModel);
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }

    @DeleteMapping("/tickets/{id}")
        public ResponseEntity<Map<String,Boolean>> deleteTicket(@PathVariable Long id){
        Map<String,Boolean> response=ticketService.deleteTicket(id);
        return  ResponseEntity.ok(response);
    }
}
