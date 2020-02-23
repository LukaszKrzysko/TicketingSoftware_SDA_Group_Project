package pl.sda.ticketing_software_sda_gp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.ticketing_software_sda_gp.model.Ticket;
import pl.sda.ticketing_software_sda_gp.model.User;

import java.util.Set;


import java.util.Set;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Query("select u from Ticket u where u.ticketStatus.statusId = :statusId")
    Set<Ticket> findAllByTicketStatusIs(Long statusId);

    @Query("select u from Ticket u where u.user.userId = :userId")
    Set<Ticket> findAllByUserIs(Long userId);

    @Query("select u from Ticket u where u.queue.queueId = :queueId and u.ticketStatus.statusId = :statusId")
    Set<Ticket> findAllByQueueAndAndTicketStatusIs(Long queueId, Long statusId);

    @Query(value = "SELECT t from Ticket t WHERE t.queue.queueId = :id")
    Set<Ticket> findAllTicketsFromQueueByQueueId(Long id);
}