package at.htl.karate.control;

import at.htl.karate.entity.Course;
import at.htl.karate.entity.CourseType;
import at.htl.karate.entity.Dog;
import at.htl.karate.entity.Person;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class InitBean {


    private final String FILE_NAME = "/home/johann/quarkus-karate-demo/src/main/resources/courses.csv";

    @Inject
    CourseTypeDao courseTypeDao;

    @Inject
    PersonDao personDao;


    @Inject
    CourseDao courseDao;

    @Inject
    DogDao dogDao;


    @Transactional
    public void init(@Observes StartupEvent event) {
        initDb();
    }

    private void initDb() {

            Person matt = new Person("Matt", "Murdock");
            Person mathilda = new Person("Mathilda", "Lando");

            personDao.persist(matt);
            personDao.persist(mathilda);

            dogDao.persist(new Dog("Timmy", matt));
            dogDao.persist(new Dog("Tino", matt));
            dogDao.persist(new Dog("Arko", mathilda));
            dogDao.persist(new Dog("Rex", mathilda));
            dogDao.persist(new Dog("Edi", mathilda));

            CourseType welpenkurs = new CourseType("Welpenkurs", "w");
            CourseType begleithunde1 = new CourseType("Begleithunde1", "bg1");
            CourseType begleithunde2 = new CourseType("Begleithunde2", "bg2");
            courseTypeDao.persist(welpenkurs);
            courseTypeDao.persist(begleithunde1);
            courseTypeDao.persist(begleithunde2);
            readCsv();
    }


    /**
     * Einlesen des csv-Files und speichern in der DB.
     * Das Course-Objekt wird unter Verwendung der Methode parseCourse(...) erstellt,
     * und anschließend in dieser Methode persistiert
     * <p>
     * ACHTUNG: Doppelte Kurse dürfen nicht eingelesen werden
     * (dh name, startdatetime, price und no_of_days sind gleich)
     */
    private void readCsv() {
        try (Stream<String> stream = Files.lines(Paths.get(FILE_NAME))) {
            stream
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(elems -> parseCourse(elems))
                    .limit(6)
                    .collect(Collectors.toList())
                    .forEach(courseDao.getEntityManager()::merge);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * parse one line of the csv-file and create a course-object
     * <p>
     * we are using ISO-8601 for the datetime-field
     * <p>
     * Use for getteing the coursetype a named-jpa-query
     *
     * @return the new Course-object
     */
    private Course parseCourse(String[] elems) {
        Course course = new Course(elems[4], LocalDateTime.parse(elems[1], DateTimeFormatter.ISO_LOCAL_DATE_TIME), Double.parseDouble(elems[2]), Integer.parseInt(elems[3]), courseTypeDao.findByName(elems[0]));
        courseDao.persist(course);
        return course;
    }
}