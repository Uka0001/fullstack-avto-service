package com.example.autoservice.repository;

import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {
    @Query(value = "SELECT m.completedOrder FROM Master m"
            + " JOIN FETCH Order o WHERE o.master.id = ?1")
    List<Order> findAllByMasterId(Long id);
}
