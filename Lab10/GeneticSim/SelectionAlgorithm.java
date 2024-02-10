import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SelectionAlgorithm {
    public List<Organism> selectReproductionCandidates(List<Organism> population) {
        // Sort the population based on HeaLth (descending order)
        population.sort(Comparator.comparingInt(Organism::getHealth).reversed());

        // Select the top-performing individuals for reproduction
        int selectionSize = Math.min(population.size() / 2, 2); // For simplicity, selecting top 2 or half of the population
        List<Organism> selectedCandidates = new ArrayList<>(population.subList(0, selectionSize));

        return selectedCandidates;
    }
}
