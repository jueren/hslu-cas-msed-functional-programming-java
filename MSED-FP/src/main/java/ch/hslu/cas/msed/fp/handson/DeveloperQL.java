package ch.hslu.cas.msed.fp.handson;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

enum QueryFieldSelector
{
    FIRSTNAME, LASTNAME, EMAIL
}

public class DeveloperQL
{
    private List<Developer> dataSource;
    private QueryFieldSelector currentSelectFieldSelector;
    private QueryFieldSelector currentWhereFieldSelector;
    private String currentWhereFieldValue;

    public DeveloperQL(List<Developer> dataSource)
    {
        this.dataSource = dataSource;
    }

    public DeveloperQL Select(QueryFieldSelector selector)
    {
        this.currentSelectFieldSelector = selector;
        return this;
    }

    public DeveloperQL Where(QueryFieldSelector selector, String value)
    {
        this.currentWhereFieldSelector = selector;
        this.currentWhereFieldValue = value;
        return this;
    }

    public List<String> Fetch()
    {
        Predicate<Developer> currentWhereSelector = x -> true;

        Predicate<Developer> firstNameWhereSelector = x -> x.Firstname.equals(this.currentWhereFieldValue);
        Predicate<Developer> lastNameWhereSelector = x -> x.Lastname.equals(this.currentWhereFieldValue);
        Predicate<Developer> emailWhereSelector = x -> x.Email.equals(this.currentWhereFieldValue);

        switch (this.currentWhereFieldSelector)
        {
            case FIRSTNAME -> currentWhereSelector = firstNameWhereSelector;
            case LASTNAME -> currentWhereSelector = lastNameWhereSelector;
            case EMAIL -> currentWhereSelector = emailWhereSelector;
        }

        Function<Developer, String> currentSelector = x -> "";

        Function<Developer, String> firstNameSelector = x -> x.Firstname;
        Function<Developer, String> lastNameSelector = x -> x.Lastname;
        Function<Developer, String> emailNameSelector = x -> x.Email;

        switch (this.currentSelectFieldSelector)
        {
            case FIRSTNAME -> currentSelector = firstNameSelector;
            case LASTNAME -> currentSelector = lastNameSelector;
            case EMAIL -> currentSelector = emailNameSelector;
        }

        return this.dataSource.stream().filter(currentWhereSelector).map(currentSelector).collect(Collectors.toList());
    }
}