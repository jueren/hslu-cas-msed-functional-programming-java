package ch.hslu.cas.msed.fp.handson;

import java.util.List;

public class DeveloperBuilderMain
{
    public static void main(String[] args)
    {
        /*
        * Excercise / Todo:
            Developer-Klasse erweitern:
            Neue Developer-Felder: Salary, #Cups of Coffee per Day
            Berechnung von Average Salary und Total Cups of Coffee
        */

        // 2) Stream-API
        List<Developer> developers = List.of(new Developer("Dan", "Stravinski", "dan@google.com"),
                new Developer("Samantha", "Jones", "sj@dev.to"),
                new Developer("Ray", "Brown", "music@jazznight.info")
        );
        // Using Lambdas
        Developer dev = developers.stream().filter(x -> x.Firstname.equals("Dan")).findFirst().get();
        System.out.println(dev.Firstname + " " + dev.Lastname + " " + dev.Email);

        // 3) Fluent API, DSLs, ...
        DeveloperBuilder builder = new DeveloperBuilder();
        Developer buildDev = builder.FirstName("Dan").LastName("Stravinski").Email("dan@google.com").build();
        System.out.println(buildDev.Firstname + " " + buildDev.Lastname + " " + buildDev.Email);

        // 4) Custom DSLs, ...
        DeveloperQL ql = new DeveloperQL(developers);
        List<String> results = ql.Select(QueryFieldSelector.EMAIL)
                .Where(QueryFieldSelector.FIRSTNAME, "Ray")
                .Fetch();

        results.forEach(System.out::println);
    }
}