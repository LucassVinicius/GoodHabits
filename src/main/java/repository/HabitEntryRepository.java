package repository;
import Model.HabitEntry;
import Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

    public interface HabitEntryRepository extends JpaRepository<HabitEntry, Long> {
        List<HabitEntry> findByUser(User user);
        List<HabitEntry> findByUserAndDataBetween(User user, LocalDate start, LocalDate end);
    }

