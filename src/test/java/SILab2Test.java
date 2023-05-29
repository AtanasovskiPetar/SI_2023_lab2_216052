import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    static User user1, user2, user3, user4, user5, user6, user7, user8, user9;

    @BeforeAll
    public static void initializeUsers(){
        user1 = new User("patan", "Petar123&", "petaratanasovski@gmail.com");
        user2 = new User("aatan", "Andrej123&", "andrejatanasovski@gmail.com");
        user3 = new User("jjov", "Jovana123&", "jovanajovanovska@gmail.com");
        user4 = new User("vkol", "Violeta123&", "violetakoloska@gmail.com");
        user5 = new User(null, "Vojo123", "vojoatanasovski%gmail.com");
        user6 =new User("patan", "Petar123", "petaratanasovski@gmail.com");
        user7 =new User("jug", "Juzejuz 12", "jugoslav@gmail.com");
        user8 = new User("patan", null, "petaratanasovski@gmail.com");
        user9 = new User("patan", "Petar123&", null);
    }

    @Test
    public void everyBranch() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, List.of(user1, user3, user4)));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        assertTrue(SILab2.function(user1, List.of(user2, user3, user4)));

        assertFalse(SILab2.function(user5, List.of(user1, user3, user4)));

        assertFalse(SILab2.function(user6, List.of(user1, user3, user4)));

        assertFalse(SILab2.function(user7, List.of(user1, user3, user4)));
    }

    @Test
    public void multipleCondition(){
        RuntimeException ex1 = assertThrows(RuntimeException.class, () -> SILab2.function(null, List.of( user1, user2, user3)));
        assertTrue(ex1.getMessage().contains("Mandatory information missing!"));

        RuntimeException ex2 = assertThrows(RuntimeException.class, () -> SILab2.function(user8, List.of( user1, user2, user3)));
        assertTrue(ex2.getMessage().contains("Mandatory information missing!"));

        RuntimeException ex3 = assertThrows(RuntimeException.class, () -> SILab2.function(user9, List.of( user1, user2, user3)));
        assertTrue(ex3.getMessage().contains("Mandatory information missing!"));

        assertTrue(SILab2.function(user1, List.of(user2, user3, user4)));
    }
}
