package ch.zli.m223.punchclock.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titel;

    @Column(nullable = false)
    private LocalDate datum;

    @Column(nullable = false)
    private ArrayList<Kuenstler> kuenstlers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public ArrayList<Kuenstler> getKuenstlers() {
        return kuenstlers;
    }

    public void setKuenstlers(ArrayList<Kuenstler> kuenstlers) {
        this.kuenstlers = kuenstlers;
    }
}
