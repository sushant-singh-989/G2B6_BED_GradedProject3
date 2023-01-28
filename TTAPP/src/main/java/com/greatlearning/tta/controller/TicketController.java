package com.greatlearning.tta.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.service.TicketService;

@Controller
public class TicketController {

public TicketService ticketService;
	
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	//get list of tickets on home-page
	
	@GetMapping("/tickets")
	public String listOfTickets(Model model) {
		List<Ticket> ticket = ticketService.listOfTickets();
		model.addAttribute("tickets", ticket);
		return "tickets";
	}
	
	//add new ticket
	@GetMapping("/newTicket")
	public String newTicketButtonClicked(Model model) {

		Ticket tickets = new Ticket();
		
		model.addAttribute("ticket", tickets);
		return "new-ticket";

	}

	@PostMapping("/tickets")
	public String submitButtonClickedForAddTicket(
			@ModelAttribute("ticket") Ticket tickets) {

		ticketService.saveTicket(tickets);
		return "redirect:/tickets";
	}
	
	//edit ticket 
	
		@GetMapping("/tickets/edit/{id}")
		public String editButtonclicked(@PathVariable Long id, Model model) {

			Ticket selectedtkt = ticketService.getTicketById(id);

			model.addAttribute("ticket", selectedtkt);

			return "edit-ticket";
		}

		@PostMapping("/tickets/{id}")
		public String submitButtonForEditClicked(
				@PathVariable Long id, @ModelAttribute("ticket") Ticket ticket) {

			Ticket existingtkt= ticketService.getTicketById(id);

			existingtkt.setTitle(ticket.getTitle());
			existingtkt.setShortDescription(ticket.getShortDescription());
			existingtkt.setCreatedOn(ticket.getCreatedOn());

			ticketService.editTicket(ticket);

			return "redirect:/tickets";
		}

		// delete ticket

		@GetMapping("/tickets/{id}")
		public String deleteEmployee(@PathVariable Long id) {

			ticketService.deleteTicketById(id);

			return "redirect:/tickets";
		}
	
	
	//search bar
	
		@GetMapping(path = {"/tickets/search"})
		 public String home(Ticket ticket, Model model, String keyword) {
		  if(keyword!=null) {
		   List<Ticket> list =ticketService.getByKeyword(keyword);
		   
		   model.addAttribute("tickets", list);
		   
		  }else {
			  
		  List<Ticket> list = ticketService.listOfTickets();
		  model.addAttribute("tickets", list);
		  }
		  return "tickets";
		 }
		
		//view ticket
		
		@GetMapping("/tickets/view/{id}")
		public String viewButtonclicked(@PathVariable Long id, Model model) {

			Ticket selectedtkt = ticketService.getTicketById(id);

			model.addAttribute("ticket", selectedtkt);

			return "view-ticket";
		}

}
