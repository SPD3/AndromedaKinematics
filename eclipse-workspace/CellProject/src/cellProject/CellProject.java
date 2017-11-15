package cellProject;

import java.io.Reader;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class CellProject {

	public static class FlashCard {
		public String organelle;

		public Vector<String> function = new Vector<String>();
		public String analogy;
		public String wrongAnswerMessage;
	}

	private static Vector<FlashCard> organelles = new Vector<FlashCard>();
	private static Vector<FlashCard> usedOrganelles = new Vector<FlashCard>();

	private static FlashCard nucleus = new FlashCard();
	private static FlashCard nucleolus = new FlashCard();
	private static FlashCard nuclearMembrane = new FlashCard();
	private static FlashCard freeFloatingRibosomes = new FlashCard();
	private static FlashCard roughEndoplasmicReticulum = new FlashCard();
	private static FlashCard smoothEndoplasmicReticulum = new FlashCard();
	private static FlashCard golgiApparatus = new FlashCard();
	private static FlashCard vesicle = new FlashCard();
	private static FlashCard plasmaMembrane = new FlashCard();
	private static FlashCard mitochondrion = new FlashCard();
	private static FlashCard lysosome = new FlashCard();
	private static FlashCard centralVacuole = new FlashCard();
	private static FlashCard cellWall = new FlashCard();
	private static FlashCard chloroplast = new FlashCard();

	public static enum QuestionType {
		definitionQuestion, functionQuestion, analogyQuetion;
	}

	public static enum Answers {
		A, B, C, D
	}

	public static void main(String[] args) {
		nucleus.organelle = "Nucleus";
		nucleus.function.add("Protects DNA");
		nucleus.analogy = "Control room";
		nucleus.wrongAnswerMessage = "The nucleus is the organelle found in the center of eukaryotic cells. \n"
				+ "It protects the cell's DNA which is why it is sometimes compared to a control room. DNA is \n"
				+ "what detemines what kind of proteins are made in the same way that a control room of a \n"
				+ "factory controls what products are made.";

		nucleolus.organelle = "Nucleolus";
		nucleolus.function.add("Creates ribosomes");
		nucleolus.analogy = "Assembly worker's boss";
		nucleolus.wrongAnswerMessage = "The nucleolus is found at the center of the nucleus and it is where \n"
				+ "ribosomes are made. It can be compared to an assembly worker's boss in a factory because \n"
				+ "the boss is the one who hires the workers and in the same way the nucleolus is the \n"
				+ "organelle that creates the ribosomes.";

		nuclearMembrane.organelle = "Nuclear Membrane";
		nuclearMembrane.function.add("Controls what goes into and out of the nucleus");
		nuclearMembrane.analogy = "Control room door";
		nuclearMembrane.wrongAnswerMessage = "The nuclear membrane is the membrane which surrounds the nucleus.\n"
				+ "It's job is to control what goes into and out of a cell's nucleus and can be compared to a \n"
				+ "control room door in a factory because the door is what determines who goes into the control \n"
				+ "room in the same way that the nuclear membrane determines what goes into and out of the \n"
				+ "nucleus.";

		freeFloatingRibosomes.organelle = "Free Floating Ribosomes";
		freeFloatingRibosomes.function.add("Sythesize proteins");
		freeFloatingRibosomes.analogy = "Assembly workers";
		freeFloatingRibosomes.wrongAnswerMessage = "The free floating ribosomes create proteins. They can be \n"
				+ "found all over the cytoplasm and can be compared to assembly workers because in the same \n"
				+ "way that assembly workers are the ones creating the products the ribosomes are the ones \n"
				+ "creating the proteins, the products of cells.";

		roughEndoplasmicReticulum.organelle = "Rough Endoplasmic Reticulum";
		roughEndoplasmicReticulum.function.add("Chemically modifies proteins from ribosomes");
		roughEndoplasmicReticulum.analogy = "Assembly line for proteins";
		roughEndoplasmicReticulum.wrongAnswerMessage = "The rough endoplamic reticulum is where proteins from \n"
				+ "ribosomes go if the proteins are meant to be released or secreted from the cell or have a \n"
				+ "special function. It can be compared to an assembly line for proteins because it is where \n"
				+ "proteins are modified in the same way that an assembly line is where products are modified";

		smoothEndoplasmicReticulum.organelle = "Smooth Endoplasmic Reticulum";
		smoothEndoplasmicReticulum.function.add("Sythesizes membrane lipids");
		smoothEndoplasmicReticulum.function.add("Detoxifies drugs");
		smoothEndoplasmicReticulum.analogy = "Assembly line creating lipids";
		smoothEndoplasmicReticulum.wrongAnswerMessage = "The smooth endoplasmic reticulum is where membrane \n"
				+ "lipids are created and also where drugs are detoxified. It can be compared to an assembly \n"
				+ "line with lipids as products because the smooth endoplasmic reticulum creates lipids in \n"
				+ "the same way that an assembly line for creating lipids would also create lipids.";

		golgiApparatus.organelle = "Golgi Apparatus";
		golgiApparatus.function
				.add("Modifies, sorts, and packages proteins and lipids for storage or transport out of the cell");
		golgiApparatus.analogy = "Shipping department";
		golgiApparatus.wrongAnswerMessage = "The gogli apparatus is where proteins and lipids are modified, \n"
				+ "sorted, and packaged for storage or transport out of the cell. It can be compared to a \n"
				+ "shipping department of a factory because in the same way that the shipping department is \n"
				+ "where products are prepared to be shipped out of the factory the golgi apperatus is where \n"
				+ "products of a cell are prepared to be transported out of a cell.";

		vesicle.organelle = "Vesicle";
		vesicle.function.add(
				"Buds from the rough endoplasmic reticulum and from the gogli apparatus designed to transport proteins");
		vesicle.analogy = "Box in which proteins are packaged in";
		vesicle.wrongAnswerMessage = "The vesicle is the substance inside of the cell that proteins are \n"
				+ "transported in in order to move from organelle to organelle. A vesicle can be compared \n"
				+ "to shipping boxes in a factory because vesicles are buds used to transport proteins safely \n"
				+ "in the same way that boxes are used to transport products safely.";

		plasmaMembrane.organelle = "Plasma Membrane";
		plasmaMembrane.function.add("Regulates what enters and leaves the cell");
		plasmaMembrane.function.add("Protects the cell");
		plasmaMembrane.analogy = "Security fence (found in both animal and plant cells)";
		plasmaMembrane.wrongAnswerMessage = "The plasma membrane is the organelle in a cell which regulates \n"
				+ "what goes into and out of a cell. It can be compared to a security fence for a factory \n"
				+ "because in the same way that a security fence protects a factory from unwanted intruders \n"
				+ "the cell membrane protects the cell from unwanted substances entering the cell.";

		mitochondrion.organelle = "Mitochondrion";
		mitochondrion.function.add("Converts chemical energy in food into usable compounds");
		mitochondrion.analogy = "Power generator";
		mitochondrion.wrongAnswerMessage = "The mitochondrion is the organelle in the cell which creates \n"
				+ "energy for the cell by converting chemical energy in food into usable compounds. It can be \n"
				+ "compared to a power generator in a factory because in the same way that a power generator \n"
				+ "creates energy for a factory mitochondria create energy for the cell.";

		lysosome.organelle = "Lysosome";
		lysosome.function.add(
				"Breaks down lipids, carbohydrates and proteins into small molecules that can be used by the rest of the cell");
		lysosome.function.add("Breaks down organelles which have outlived their usefullness");
		lysosome.analogy = "Custodian";
		lysosome.wrongAnswerMessage = "The lysosome is the organelle inside of a cell which breaks down lipids. \n"
				+ "carbs, and proteins into small molecules that can be used by the rest of the cell and it also \n"
				+ "breaks down organelles which have outlived their usefullness. It can be compared to a \n"
				+ "custodian of a factory because a lysosome cleans up the cell by breaking down substances \n"
				+ "in the same way that custodians clean up a factory in order to maintain it.";

		centralVacuole.organelle = "Central Vacuole";
		centralVacuole.function.add("Stores water, salts, proteins and carbohydrates");
		centralVacuole.function.add("Adds rigidity to a plant");
		centralVacuole.analogy = "Warehouse for storage of products";
		centralVacuole.wrongAnswerMessage = "The central vacuole is the organelle in the cell which stores \n"
				+ "substances such as water, salt, proteins and carbs. It is only found in a plant cell and \n"
				+ "it also adds rigidity to the cell. It can be compared to a warehouse for products in a \n"
				+ "factory because in the same way that a warehouse is where products are stored the vacuole \n"
				+ "is where substances in a cell are stored.";

		cellWall.organelle = "Cell Wall";
		cellWall.function.add("Shapes, supports, and protects the cell");
		cellWall.analogy = "Security fence (only found in plant cells)";
		cellWall.wrongAnswerMessage = "The cell wall is only found in plant cells and it's function is to \n"
				+ "shape, support and protect the cell. It can be compared to a security fence because in \n"
				+ "the same way that a security fence protects a factory from unwanted visitors a cell \n"
				+ "membrane protects a cell from unwanted substances entering it.";

		chloroplast.organelle = "Chloroplast";
		chloroplast.function.add("Converts solar energy to chemical energy stored in food");
		chloroplast.analogy = "Solar panel";
		chloroplast.wrongAnswerMessage = "The chloroplast is the organelle in a plant cell which takes solar \n"
				+ "energy and converts it to chemical energy. It can be compared to solar panels on a factory \n"
				+ "because solar panels also take solar energy from the sun and converts it to energy that \n"
				+ "powers the factory.";

		organelles.add(nucleus);
		organelles.add(nucleolus);
		organelles.add(nuclearMembrane);
		organelles.add(freeFloatingRibosomes);
		organelles.add(roughEndoplasmicReticulum);
		organelles.add(smoothEndoplasmicReticulum);
		organelles.add(golgiApparatus);
		organelles.add(vesicle);
		organelles.add(plasmaMembrane);
		organelles.add(mitochondrion);
		organelles.add(lysosome);
		organelles.add(centralVacuole);
		organelles.add(cellWall);
		organelles.add(chloroplast);
		boolean firstTimeThru = true;
		boolean shouldContinue = false;
		for (int numberCorrectInARow = 0; numberCorrectInARow < organelles.size(); numberCorrectInARow++) {
			if (firstTimeThru || shouldContinue) {
				firstTimeThru = false;
			} else {
				System.out.println(
						"You have: " + numberCorrectInARow + "/" + organelles.size() + " correct answers in a row");
			}
			Random random = new Random();
			int organelleInt = random.nextInt(organelles.size());
			FlashCard organelle = organelles.get(organelleInt);
			QuestionType questionType = null;
			String Answer = null;
			FlashCard wrongAnswerOrganelle1;
			FlashCard wrongAnswerOrganelle2;
			FlashCard wrongAnswerOrganelle3;
			String wrongAnswer1 = null;
			String wrongAnswer2 = null;
			String wrongAnswer3 = null;
			Answers correctAnswer = null;
			shouldContinue = false;
			for (int i = 0; i < usedOrganelles.size(); i++) {
				FlashCard tempOrganelle = usedOrganelles.get(i);
				if (organelle == tempOrganelle) {
					numberCorrectInARow--;
					shouldContinue = true;
					break;
				}
			}
			if (shouldContinue) {
				continue;
			}
			int questionDeterminer = random.nextInt(3);
			if (questionDeterminer == 0) {
				questionType = QuestionType.definitionQuestion;
			} else if (questionDeterminer == 1) {
				questionType = QuestionType.functionQuestion;
			} else {
				questionType = QuestionType.analogyQuetion;
			}
			int answerDeterminer = random.nextInt(4);

			int wrongAnswer1Int = random.nextInt(organelles.size());
			while (wrongAnswer1Int == organelleInt) {
				wrongAnswer1Int = random.nextInt(organelles.size());
			}
			wrongAnswerOrganelle1 = organelles.get(wrongAnswer1Int);

			int wrongAnswer2Int = random.nextInt(organelles.size());
			while (wrongAnswer2Int == organelleInt || wrongAnswer2Int == wrongAnswer1Int) {
				wrongAnswer2Int = random.nextInt(organelles.size());
			}
			wrongAnswerOrganelle1 = organelles.get(wrongAnswer1Int);

			int wrongAnswer3Int = random.nextInt(organelles.size());
			while (wrongAnswer3Int == organelleInt || wrongAnswer3Int == wrongAnswer2Int
					|| wrongAnswer3Int == wrongAnswer1Int) {
				wrongAnswer3Int = random.nextInt(organelles.size());
			}

			wrongAnswerOrganelle1 = organelles.get(wrongAnswer1Int);
			wrongAnswerOrganelle2 = organelles.get(wrongAnswer2Int);
			wrongAnswerOrganelle3 = organelles.get(wrongAnswer3Int);

			switch (questionType) {
			case definitionQuestion:
				System.out.println("What is the funtion of a(n) " + organelle.organelle);
				Answer = organelle.function.get(random.nextInt(organelle.function.size()));
				wrongAnswer1 = wrongAnswerOrganelle1.function
						.get(random.nextInt(wrongAnswerOrganelle1.function.size()));
				wrongAnswer2 = wrongAnswerOrganelle2.function
						.get(random.nextInt(wrongAnswerOrganelle2.function.size()));
				wrongAnswer3 = wrongAnswerOrganelle3.function
						.get(random.nextInt(wrongAnswerOrganelle3.function.size()));
				break;

			case functionQuestion:
				System.out.println("What organelle has this function: "
						+ organelle.function.get(random.nextInt(organelle.function.size())));
				Answer = organelle.organelle;
				wrongAnswer1 = wrongAnswerOrganelle1.organelle;
				wrongAnswer2 = wrongAnswerOrganelle2.organelle;
				wrongAnswer3 = wrongAnswerOrganelle3.organelle;

				break;

			case analogyQuetion:
				System.out.println("A Factory is to a cell as a(n) " + organelle.analogy + " is to a(n) ");
				Answer = organelle.organelle;
				wrongAnswer1 = wrongAnswerOrganelle1.organelle;
				wrongAnswer2 = wrongAnswerOrganelle2.organelle;
				wrongAnswer3 = wrongAnswerOrganelle3.organelle;

				break;
			}

			if (answerDeterminer == 0) {
				System.out.println("A. " + Answer);
				System.out.println("B. " + wrongAnswer1);
				System.out.println("C. " + wrongAnswer2);
				System.out.println("D. " + wrongAnswer3);
				correctAnswer = Answers.A;
			} else if (answerDeterminer == 1) {
				System.out.println("A. " + wrongAnswer1);
				System.out.println("B. " + Answer);
				System.out.println("C. " + wrongAnswer2);
				System.out.println("D. " + wrongAnswer3);
				correctAnswer = Answers.B;
			} else if (answerDeterminer == 2) {
				System.out.println("A. " + wrongAnswer2);
				System.out.println("B. " + wrongAnswer1);
				System.out.println("C. " + Answer);
				System.out.println("D. " + wrongAnswer3);
				correctAnswer = Answers.C;
			} else {
				System.out.println("A. " + wrongAnswer3);
				System.out.println("B. " + wrongAnswer1);
				System.out.println("C. " + wrongAnswer2);
				System.out.println("D. " + Answer);
				correctAnswer = Answers.D;
			}
			Scanner reader = new Scanner(System.in);
			String userAnswerString = reader.next();
			Answers userAnswer = null;
			if (userAnswerString.equals("A") || userAnswerString.equals("a")) {
				userAnswer = Answers.A;
			} else if (userAnswerString.equals("B") || userAnswerString.equals("b")) {
				userAnswer = Answers.B;
			} else if (userAnswerString.equals("C") || userAnswerString.equals("c")) {
				userAnswer = Answers.C;
			} else {
				userAnswer = Answers.D;
			}
			if (userAnswer == correctAnswer) {
				System.out.println("Correct! Nice Job!");
				usedOrganelles.add(organelle);
			} else {
				System.out.println("Whoops, not quite. The correct answer is: " + Answer);
				System.out.println("Remember: " + organelle.wrongAnswerMessage);
				numberCorrectInARow = -1;
				usedOrganelles.clear();
				System.out.println("Press any key and then hit return to continue.");
				String enterKey = reader.next();
				
			}

		}
		System.out.println("Congratulations you have completed the quiz");
	}
}
