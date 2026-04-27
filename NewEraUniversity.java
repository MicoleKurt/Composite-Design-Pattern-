package composite;

/**
 * Client - NewEraUniversity
 * Demonstrates the Composite Design Pattern by building a hierarchical
 * structure of Colleges, Departments, Teachers, and Students.
 *
 * New Era University
 * ├── College of Engineering
 * │   ├── Department of Computer Science
 * │   │   ├── Teacher: Mr. Santos (Programming)
 * │   │   ├── Teacher: Ms. Reyes (Data Structures)
 * │   │   ├── Student: Juan dela Cruz
 * │   │   └── Student: Maria Garcia
 * │   ├── Department of Information Technology
 * │   │   ├── Teacher: Mr. Cruz (Networking)
 * │   │   └── Student: Pedro Penduko
 * │   └── Student: Anna Bautista (College-level student)
 * └── College of Business
 *     ├── Teacher: Ms. Lim (Management)
 *     ├── Student: Carlo Ramos
 *     └── College of Accountancy (sub-college)
 *         ├── Teacher: Mr. Tan (Accounting)
 *         └── Student: Bianca Torres
 */
public class NewEraUniversity {

    public static void main(String[] args) {

        // ── Leaf nodes: Teachers ──────────────────────────────────────────
        Teacher tSantos  = new Teacher("Mr. Santos",  "Programming",    55000.00);
        Teacher tReyes   = new Teacher("Ms. Reyes",   "Data Structures", 52000.00);
        Teacher tCruz    = new Teacher("Mr. Cruz",    "Networking",      50000.00);
        Teacher tLim     = new Teacher("Ms. Lim",     "Management",      48000.00);
        Teacher tTan     = new Teacher("Mr. Tan",     "Accounting",      51000.00);

        // ── Leaf nodes: Students ──────────────────────────────────────────
        Student sJuan    = new Student("Juan dela Cruz",  "2021-00001", 25000.00);
        Student sMaria   = new Student("Maria Garcia",    "2021-00002", 25000.00);
        Student sPedro   = new Student("Pedro Penduko",   "2022-00010", 23000.00);
        Student sAnna    = new Student("Anna Bautista",   "2023-00050", 24000.00);
        Student sCarlo   = new Student("Carlo Ramos",     "2020-00088", 27000.00);
        Student sBianca  = new Student("Bianca Torres",   "2021-00099", 26000.00);

        // ── Composite: Departments ────────────────────────────────────────
        Department dCS = new Department("Department of Computer Science");
        dCS.add(tSantos);
        dCS.add(tReyes);
        dCS.add(sJuan);
        dCS.add(sMaria);

        Department dIT = new Department("Department of Information Technology");
        dIT.add(tCruz);
        dIT.add(sPedro);

        // ── Composite: Sub-College ────────────────────────────────────────
        College cAccountancy = new College("College of Accountancy");
        cAccountancy.add(tTan);
        cAccountancy.add(sBianca);

        // ── Composite: Top-Level Colleges ─────────────────────────────────
        College cEngineering = new College("College of Engineering");
        cEngineering.add(dCS);
        cEngineering.add(dIT);
        cEngineering.add(sAnna);   // student enrolled directly at college level

        College cBusiness = new College("College of Business");
        cBusiness.add(tLim);
        cBusiness.add(sCarlo);
        cBusiness.add(cAccountancy);  // sub-college inside College of Business

        // ── University (root composite) ───────────────────────────────────
        College university = new College("New Era University");
        university.add(cEngineering);
        university.add(cBusiness);

        // ══════════════════════════════════════════════════════════════════
        // DEMO 1: Display full university details
        // ══════════════════════════════════════════════════════════════════
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║        NEW ERA UNIVERSITY - FULL DETAILS         ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");
        university.displayDetails("");

        // ══════════════════════════════════════════════════════════════════
        // DEMO 2: Display College of Engineering only
        // ══════════════════════════════════════════════════════════════════
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║       COLLEGE OF ENGINEERING - DETAILS           ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");
        cEngineering.displayDetails("");

        // ══════════════════════════════════════════════════════════════════
        // DEMO 3: Student counts
        // ══════════════════════════════════════════════════════════════════
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║             STUDENT COUNT SUMMARY                ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println("  New Era University        : " + university.getStudentCount()    + " student(s)");
        System.out.println("  College of Engineering    : " + cEngineering.getStudentCount()  + " student(s)");
        System.out.println("  College of Business       : " + cBusiness.getStudentCount()     + " student(s)");
        System.out.println("  Dept. of Computer Science : " + dCS.getStudentCount()           + " student(s)");
        System.out.println("  Dept. of Info. Technology : " + dIT.getStudentCount()           + " student(s)");
        System.out.println("  College of Accountancy    : " + cAccountancy.getStudentCount()  + " student(s)");

        // ══════════════════════════════════════════════════════════════════
        // DEMO 4: Budget summary
        // ══════════════════════════════════════════════════════════════════
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║               BUDGET SUMMARY (PHP)               ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.printf("  New Era University        : PHP %,.2f%n", university.getBudget());
        System.out.printf("  College of Engineering    : PHP %,.2f%n", cEngineering.getBudget());
        System.out.printf("  College of Business       : PHP %,.2f%n", cBusiness.getBudget());
        System.out.printf("  Dept. of Computer Science : PHP %,.2f%n", dCS.getBudget());
        System.out.printf("  Dept. of Info. Technology : PHP %,.2f%n", dIT.getBudget());
        System.out.printf("  College of Accountancy    : PHP %,.2f%n", cAccountancy.getBudget());
        System.out.printf("  Individual - Mr. Santos   : PHP %,.2f%n", tSantos.getBudget());
        System.out.printf("  Individual - Juan dela Cruz: PHP %,.2f%n", sJuan.getBudget());
        System.out.println();
    }
}
