package at.htl.karate.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CourseTypeTest {

    @Karate.Test
    Karate testPersonEndpoint() {
        return Karate.run("coursetype").relativeTo(getClass());
    }
}
