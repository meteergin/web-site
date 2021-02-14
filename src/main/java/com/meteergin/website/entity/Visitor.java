package com.meteergin.website.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Visitor {
    @Id
    @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "seq_visitor_id",
//            sequenceName = "seq_visitor_id",
//            allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,
//            generator = "seq_visitor_id")
    private Integer id;
    @Basic
    @Column(name = "ip")
    private String ip;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "page")
    private String page;
}
