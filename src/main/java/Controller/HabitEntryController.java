package Controller;
import Model.HabitEntry;
import Model.User;
import Service.HabitEntryService;
import Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/habits")
public class HabitEntryController {

    private final HabitEntryService habitEntryService;
    private final UserService userService;

    public HabitEntryController(HabitEntryService habitEntryService, UserService userService) {
        this.habitEntryService = habitEntryService;
        this.userService = userService;
    }

    @PostMapping("/{userId}")
    public HabitEntry createHabit(@PathVariable Long userId, @RequestBody HabitEntry habitEntry) {
        User user = userService.findById(userId);
        habitEntry.setUser(user);
        return habitEntryService.save(habitEntry);
    }

    @GetMapping("/{userId}")
    public List<HabitEntry> getHabitsByUser(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return habitEntryService.getHabitsByUser(user);
    }

    @GetMapping("/{userId}/last7days")
    public List<HabitEntry> getHabitsLast7Days(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return habitEntryService.getHabitsLast7Days(user);
    }
}
