package java8.ex06;


import java8.data.Data;
import java8.data.Person;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    // tag::formatAge[]
    // TODO compléter la méthode
    // TODO la méthode retourne une chaîne de caractères de la forme [age=<AGE>] (exemple : [age=12])
    String formatAge(Supplier<Person> supplier) {
        Person p = supplier.get();
        return "[age=" + p.getAge() + "]";
    }
    // end::formatAge[]


    @Test
    public void test_supplier_formatAge() throws Exception {
        // TODO compléter le test unitaire pour qu'il soit passant
        Supplier <Person> supplier = () -> new Person("Armor", "France", 35, "123456789");
        String result = formatAge(supplier);

        assertThat(result, is("[age=35]"));
    }

    @Test
    public void test_supplier_requireNonNull() throws Exception {

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("require non null object");

        // TODO compléter le test unitaire pour qu'il soit passant
        Supplier<String> supplier = () -> {
        	return "require non null object";
        };

        // Avec un paramètre null, cette méthode déclenche un NullPointerException
        Objects.requireNonNull(null, supplier);

    }

}
