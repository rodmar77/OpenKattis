import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Genealogical {

    private static final Pattern BIRTH = Pattern.compile("BIRTH (.+) : (.+) : (.+) : (.+)");
    private static final Pattern DEATH = Pattern.compile("DEATH (.+) : (.+)");

    private static final Pattern ANCESTORS = Pattern.compile("ANCESTORS (.+)");
    private static final Pattern DESCENDANTS = Pattern.compile("DESCENDANTS (.+)");

    private static class Person implements Comparable<Person> {
        private final String name;
        private final Collection<Person> children;
        private final Collection<Person> parents;

        private String dateOfBirth;
        private String dateOfDeath;

        Person(final String name, final String dateOfBirth) {
            this(name);
            this.dateOfBirth = dateOfBirth;
        }

        Person(final String name) {
            this.name = name;
            this.children  = new TreeSet<>();
            this.parents = new TreeSet<>();
        }

        public void setParents(final Person father, final Person mother) {
            this.parents.add(father);
            this.parents.add(mother);
        }

        public void addChild(final Person child) {
            this.children.add(child);
        }

        public void setDateOfDeath(final String dateOfDeath) {
            this.dateOfDeath = dateOfDeath;
        }

        public int compareTo(final Person that) {
            return this.name.compareTo(that.name);
        }
    }

    public static void main(String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            final Map<String, Person> people = new HashMap<>();
            boolean firstCommand = true;
            while (in.hasNextLine()) {
                final String line = in.nextLine();
                if (line.startsWith("BIRTH")) {
                    final Matcher matcher = BIRTH.matcher(line);
                    if (matcher.find()) {
                        final Person person = getOrCreate(people, matcher.group(1), matcher.group(2));
                        final Person mother = getOrCreate(people, matcher.group(3));
                        final Person father = getOrCreate(people, matcher.group(4));

                        person.setParents(father, mother);
                        mother.addChild(person);
                        father.addChild(person);
                    }
                } else if (line.startsWith("DEATH")) {
                    final Matcher matcher = DEATH.matcher(line);
                    if (matcher.find()) {
                        final Person person = getOrCreate(people, matcher.group(1));
                        person.setDateOfDeath(matcher.group(2));
                    }
                } else if (line.startsWith("ANCESTORS")) {
                    if (firstCommand) firstCommand = false; else System.out.println();
                    final Matcher matcher = ANCESTORS.matcher(line);
                    if (matcher.find()) {
                        final Person person = people.get(matcher.group(1));
                        System.out.println("ANCESTORS of " + person.name);
                        printAncestry(person.parents, 2, 1);
                    }
                } else if (line.startsWith("DESCENDANTS")) {
                    if (firstCommand) firstCommand = false; else System.out.println();
                    final Matcher matcher = DESCENDANTS.matcher(line);
                    if (matcher.find()) {
                        final Person person = people.get(matcher.group(1));
                        System.out.println("DESCENDANTS of " + person.name);
                        printAncestry(person.children, 2, 2);
                    }
                } else if (line.startsWith("QUIT")) {
                    break;
                }
            }
        }
    }

    private static void printAncestry(final Collection<Person> ancestry, final int spaces, final int code) {
        for (final Person person : ancestry) {
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }

            System.out.print(person.name);
            if (person.dateOfBirth != null) {
                System.out.print(" " + person.dateOfBirth + " -");
            }

            if (person.dateOfDeath != null) {
                System.out.print(" " + person.dateOfDeath);
            }

            System.out.println();
            if (code == 1) {
                if (!person.parents.isEmpty()) {
                    printAncestry(person.parents, spaces + 2, code);
                }
            } else if (code == 2) {
                if (!person.children.isEmpty()) {
                    printAncestry(person.children, spaces + 2, code);
                }
            }
        }
    }

    private static Person getOrCreate(final Map<String, Person> people, final String name) {
        return getOrCreate(people, name, null);
    }

    private static Person getOrCreate(final Map<String, Person> people, final String name, final String dateOfBirth) {
        if (people.containsKey(name)) {
            return people.get(name);
        } else {
            final Person person = new Person(name, dateOfBirth);
            people.put(name, person);
            return person;
        }
    }
}