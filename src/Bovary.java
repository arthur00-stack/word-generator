import java.util.Random;

public class Bovary {

    static HMap buildTable(String[] files, int n) {
        HMap table = new HMap();

        for (String filename : files) {
            WordReader wr = new WordReader(filename);
            Prefix prefix = new Prefix(n);

            String word = wr.read();
            while (word != null) {
                table.add(prefix, word);
                prefix = prefix.addShift(word);

                word = wr.read();
            }

            table.add(prefix, Prefix.end);
        }

        return table;
    }
    
    static void generate(HMap t, int n) {
        Prefix prefix = new Prefix(n); 
        Random rand = new Random();

        while (true) {
            WordList suivants = t.find(prefix);
            if (suivants == null || suivants.length() == 0) break;

            int choix = rand.nextInt(suivants.length());
            Node cur = suivants.content;
            for (int i = 0; i < choix; i++) {
                cur = cur.next;
            }
            String word = cur.head;
            if (word.equals(Prefix.end)) {
                System.out.println(); 
                break;
            }
            if (word.equals(Prefix.par)) {
                System.out.println(); 
            } else {
                System.out.print(word + " ");
            }

            prefix = prefix.addShift(word);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        String[] files = new String[35];
        for (int i = 0; i < files.length; i++) {
            files[i] = String.format("src/bovary/%02d.txt", i + 1);
        }

        System.out.println("Construction de la table...");
        HMap table = buildTable(files, n);
        System.out.println("Table construite : " + table.nbEntries + " entrées.");

        System.out.println("\n--- Chapitre 36 ---\n");
        generate(table, n);
    }
}