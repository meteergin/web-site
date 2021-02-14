package com.meteergin.website.service;

import com.meteergin.website.entity.Visitor;
import com.meteergin.website.repository.VisitorRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public Visitor saveVisitor(Visitor v) throws Exception {
        if (v.getId() == null) {
            v.setId(visitorRepository.getNextValSeqVisitorId());
            visitorRepository.insertVisitor(v.getId(), v.getIp(), v.getDate(), v.getPage());
        }else{
            visitorRepository.save(v);
        }
        return v;
    }

    public Visitor saveVisitor(String page, String clientIp) throws Exception {
        Visitor visitor = new Visitor();
        visitor.setIp(clientIp);
        visitor.setDate(Timestamp.valueOf(LocalDateTime.now()));
        visitor.setPage(page);
        return saveVisitor(visitor);
    }
}
