import java.util.ArrayList;
import java.util.List;

public class TestGeneticSim {
    public static void main(String[] args) {
        // Create a list of organisms
        List<Organism> organisms = new ArrayList<>();

        // Create instances of different organism subclasses
        Mammal mammal1 = new Mammal("ABC123", "MammalOne", 5, 80, 100, true, 4);
        Plant plant1 = new Plant("DEF456", "PlantOne", 2, 60, 80, true, "Taproot");
        Reptile reptile1 = new Reptile("GHI789", "ReptileOne", 8, 90, 110, true, "Scales");
        Bacteria bacteria1 = new Bacteria("JKL012", "BacteriaOne", 1, 40, 50, false, "Rod");

        // Add organisms to the list
        organisms.add(mammal1);
        organisms.add(plant1);
        organisms.add(reptile1);
        organisms.add(bacteria1);

        // Demonstrate some interactions
        for (Organism organism : organisms) {
            organism.eat();
            organism.sleep();
            organism.die();
            // Additional interactions specific to each organism type
            if (organism instanceof Mammal) {
                ((Mammal) organism).giveBirth();
            } else if (organism instanceof Plant) {
                ((Plant) organism).photosynthesize();
            } else if (organism instanceof Reptile) {
                ((Reptile) organism).baskInSun();
            } else if (organism instanceof Bacteria) {
                ((Bacteria) organism).exchangeGeneticMaterial();
            }
        }

        // Demonstrate genetic algorithm and natural selection
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        geneticAlgorithm.modelReproduction(mammal1);
        geneticAlgorithm.modelMutation(bacteria1);
        geneticAlgorithm.modelNaturalSelection(organisms);

        // Demonstrate population tracking and evolution analysis
        PopulationObserver populationObserver = new PopulationObserver();
        populationObserver.trackPopulation(organisms);
        populationObserver.analyzeEvolution(organisms);

        // Demonstrate selection algorithm
        SelectionAlgorithm selectionAlgorithm = new SelectionAlgorithm();
        List<Organism> selectedCandidates = selectionAlgorithm.selectReproductionCandidates(organisms);
        System.out.println("Selected Reproduction Candidates:");
        for (Organism candidate : selectedCandidates) {
            System.out.println(candidate.getName() + " - Health: " + candidate.getHealth());
        }
    }
}
