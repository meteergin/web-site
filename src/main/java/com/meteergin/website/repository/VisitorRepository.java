package com.meteergin.website.repository;

import com.meteergin.website.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer> {

    @Query(value = "SELECT nextval('seq_visitor_id')", nativeQuery = true)
    public Integer getNextValSeqVisitorId();

    @Modifying
    @Query(value = "INSERT INTO visitor (id, ip, \"date\", page) VALUES(:id, :ip, :date, :page)", nativeQuery = true)
    @Transactional
    void insertVisitor(@Param("id") Integer id, @Param("ip") String ip,
                       @Param("date") Timestamp date, @Param("page") String page);

}
