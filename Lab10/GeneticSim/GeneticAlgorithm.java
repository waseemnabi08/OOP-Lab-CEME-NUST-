import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GeneticAlgorithm {
    public void modelReproduction(Reproducer reproducer) {
        reproducer.reproduce();
    }

    public void modelMutation(Mutator mutator) {
        mutator.mutate();
    }

    // Natural selection function
    public void modelNaturalSelection(List<Organism> organisms) {
        // Create a copy of the list to avoid ConcurrentModificationException
        List<Organism> copyOfOrganisms = new ArrayList<>(organisms);

        // Evaluate the fitness of each organism
        evaluateFitness(copyOfOrganisms);

        // Sort the copy based on fitness (descending order)
        copyOfOrganisms.sort(Comparator.comparingInt(Organism::getHealth).reversed());

        // Select the top-performing individuals for the next generation
        int selectionSize = Math.min(copyOfOrganisms.size() / 2, 2); // For simplicity, selecting top 2 or half of the population
        List<Organism> selectedOrganisms = new ArrayList<>(copyOfOrganisms.subList(0, selectionSize));

        // Replace the original population with the selected individuals
        organisms.clear();
        organisms.addAll(selectedOrganisms);

        // Additional logic for creating offspring, crossover, etc., can be added here
    }

    // Helper method to evaluate the fitness of organisms (example implementation)
    private void evaluateFitness(List<Organism> organisms) {
        for (Organism organism : organisms) {
            // For simplicity, using a random value as fitness (replace with actual fitness evaluation logic)
            int health = (int) (Math.random() * 100);
            organism.setHealth(health);
        }
    }
}
