package Model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class HabitEntry {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private LocalDate data;

        private double horasSono;

        private String atividadeFisica;

        private String alimentacao;

        private int humor;

        private int minutosLeitura;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public LocalDate getData() {
                return data;
        }

        public void setData(LocalDate data) {
                this.data = data;
        }

        public double getHorasSono() {
                return horasSono;
        }

        public void setHorasSono(double horasSono) {
                this.horasSono = horasSono;
        }

        public String getAtividadeFisica() {
                return atividadeFisica;
        }

        public void setAtividadeFisica(String atividadeFisica) {
                this.atividadeFisica = atividadeFisica;
        }

        public String getAlimentacao() {
                return alimentacao;
        }

        public void setAlimentacao(String alimentacao) {
                this.alimentacao = alimentacao;
        }

        public int getHumor() {
                return humor;
        }

        public void setHumor(int humor) {
                this.humor = humor;
        }

        public int getMinutosLeitura() {
                return minutosLeitura;
        }

        public void setMinutosLeitura(int minutosLeitura) {
                this.minutosLeitura = minutosLeitura;
        }

        public User getUser() {
                return user;
        }

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        public void setUser(User user) {
                this.user = user;
        }
}

