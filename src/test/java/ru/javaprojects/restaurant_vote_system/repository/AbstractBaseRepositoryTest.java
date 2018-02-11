package ru.javaprojects.restaurant_vote_system.repository;

import org.assertj.core.api.Assertions;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.Stopwatch;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javaprojects.restaurant_vote_system.TimingRules;

@ContextConfiguration({
        "classpath:spring/spring-database.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = {"/db/init_db_hsql.sql", "/db/populate_db_with_test_data_hsql.sql"}, config = @SqlConfig(encoding = "UTF-8"))
public abstract class AbstractBaseRepositoryTest extends Assertions {
    @ClassRule
    public static ExternalResource SUMMARY = TimingRules.SUMMARY;

    @Rule
    public Stopwatch stopwatch = TimingRules.STOPWATCH;
}
