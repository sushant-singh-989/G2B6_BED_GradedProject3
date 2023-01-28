package com.greatlearning.tta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greatlearning.tta.entity.Ticket;

public interface TicketRepository 
extends JpaRepository<Ticket, Long> {
	
	// Custom query
		@Query(value = "select * from tickets where tickets.title like %:keyword% or tickets.short_description like %:keyword%", nativeQuery = true)
		 List<Ticket> findByKeyword(@Param("keyword") String keyword);



}
