package Model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class goodHabits {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private LocalDate data;

        private double horasSono;

        private String atividadeFisica;

        private String alimentacao;

        private int humor;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;
    }

