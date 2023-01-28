package com.greatlearning.tta.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.repository.TicketRepository;
import com.greatlearning.tta.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

private TicketRepository ticketRepository;
	
	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> listOfTickets() {
	
		return ticketRepository.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
	
		return ticketRepository.save(ticket);
	}
	
		

		@Override
		public Ticket editTicket(Ticket ticket) {
			
			return ticketRepository.save(ticket);
		}

		@Override
		public Ticket getTicketById(Long id) {
		
			return ticketRepository.findById(id).get();
		}

		@Override
		public void deleteTicketById(Long id) {
			ticketRepository.deleteById(id);
			
		}

		@Override
		public List<Ticket> getByKeyword(String keyword) {
			
				  return ticketRepository.findByKeyword(keyword);
			
		}

}
