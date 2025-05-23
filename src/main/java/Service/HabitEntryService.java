package Service;
import Model.User;
import Model.HabitEntry;
import repository.HabitEntryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HabitEntryService {

    private final HabitEntryRepository habitEntryRepository;

    public HabitEntryService(HabitEntryRepository habitEntryRepository) {
        this.habitEntryRepository = habitEntryRepository;
    }

    public HabitEntry save(HabitEntry habitEntry) {
        return habitEntryRepository.save(habitEntry);
    }

    public List<HabitEntry> getHabitsByUser(User user) {
        return habitEntryRepository.findByUser(user);
    }

    public List<HabitEntry> getHabitsLast7Days(User user) {
        LocalDate now = LocalDate.now();
        return habitEntryRepository.findByUserAndDataBetween(user, now.minusDays(7), now);
    }
}
