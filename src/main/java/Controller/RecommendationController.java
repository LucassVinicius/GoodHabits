package Controller;
import Model.HabitEntry;
import Model.User;
import Service.HabitEntryService;
import Service.OpenAIService;
import Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final OpenAIService openAIService;
    private final HabitEntryService habitEntryService;
    private final UserService userService;

    public RecommendationController(OpenAIService openAIService, HabitEntryService habitEntryService, UserService userService) {
        this.openAIService = openAIService;
        this.habitEntryService = habitEntryService;
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public String getRecomendacao(@PathVariable Long userId) {
        User user = userService.findById(userId);
        List<HabitEntry> habitos = habitEntryService.getHabitsLast7Days(user);

        StringBuilder prompt = new StringBuilder("Sou um usuário que nos últimos dias teve os seguintes hábitos:\n");

        for (HabitEntry h : habitos) {
            prompt.append(String.format("- Em %s: Dormi %.1f horas, Li %.1f minutos, Me senti %d de humor, Me alimentei: %s\n",
                    h.getData(), h.getHorasSono(), h.getMinutosLeitura(), h.getHumor(), h.getAlimentacao()));
        }

        prompt.append("Com base nesses hábitos, me recomende melhorias para saúde, bem-estar e produtividade.");

        return openAIService.gerarRecomendacao(prompt.toString());
    }
}

