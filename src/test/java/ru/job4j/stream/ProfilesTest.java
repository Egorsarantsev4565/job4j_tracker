package ru.job4j.stream;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
  profiles.add(new Profile("Nizhniy Novgorod", "Karla Marksa", 2, 48));
  profiles.add(new Profile("Nizhniy Novgorod", "Karla Marksa", 2, 48));
  profiles.add(new Profile("Kaliningrad", "Lenina", 5, 89));
  profiles.add(new Profile("Nizhniy Novgorod", "Akimova", 37, 73));
  profiles.add(new Profile("Moscow", "Lubyanka", 4, 50));
    }

    @Test
    public void tourists() {
        List<Address> rsl = new Profiles().collect(profiles);
        List<Address> expected = List.of(
                new Address("Kaliningrad", "Lenina", 5, 89),
                new Address("Moscow", "Lubyanka", 4, 50),
                new Address("Nizhniy Novgorod", "Karla Marksa", 2, 48),
                new Address("Nizhniy Novgorod", "Akimova", 37, 73)

        );
        assertThat(rsl, is(expected));
    }
    }

