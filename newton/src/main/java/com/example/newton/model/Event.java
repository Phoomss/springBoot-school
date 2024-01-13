package com.example.newton.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "camera_id")
    private Camera camera;

    public Event(int amount, Camera camera) {
        this.amount = amount;
        this.camera = camera;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }
}
