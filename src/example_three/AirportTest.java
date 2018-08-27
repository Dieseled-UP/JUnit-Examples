package example_three;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

class AirportTest {

	@DisplayName("Given there is an economy flight")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight(1);
            mike  = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a ordinary passenger")
        class OrdinaryPassenger {

            @Test
            @DisplayName("Then you can add and remove him from an economy flight")
            public void testEconomyFlightOrdinaryPassenger() {
                assertAll("Verify all conditions for a ordinary passenger and an economy flight",
                        () -> assertEquals(1, economyFlight.getId()),
                        () -> assertTrue(economyFlight.addPassenger(mike)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(mike)),
                        () -> assertTrue(economyFlight.removePassenger(mike)),
                        () -> assertEquals(0, economyFlight.getPassengersSet().size())
                );
            }
        }
        
        @DisplayName("Then you cannot add him to an economy flight more than once")
        @RepeatedTest(5)
        //@Disabled
        public void testEconomyFlightOrdinaryPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
            for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                economyFlight.addPassenger(mike);
            }
            assertAll("Verify a ordinary passenger can be added to an economy flight only once",
                    () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                    () -> assertTrue(economyFlight.getPassengersSet().contains(mike)),
                    () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Mike"))
            );
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add him but cannot remove him from an economy flight")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and an economy flight",
                        () -> assertEquals(1, economyFlight.getId()),
                        () -> assertTrue(economyFlight.addPassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(john)),
                        () -> assertFalse(economyFlight.removePassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size())
                );

            }
        }
    }

    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight(2);
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a ordinary passenger")
        class OrdinaryPassenger {

            @Test
            @DisplayName("Then you cannot add or remove him from a business flight")
            public void testBusinessFlightOrdinaryPassenger() {
                assertAll("Verify all conditions for a ordinary passenger and a business flight",
                        () -> assertFalse(businessFlight.addPassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengersSet().size()),
                        () -> assertFalse(businessFlight.removePassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengersSet().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {

            @Test
            @DisplayName("Then you can add him but cannot remove him from a business flight")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and a business flight",
                        () -> assertTrue(businessFlight.addPassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertFalse(businessFlight.removePassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size())
                );
            }
        }
    }
    
    @DisplayName("Given there is a premium flight")
    @Nested
    class PremiumFlightTest {
        private Flight premiumFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight(3);
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a ordinary passenger")
        class OrdinaryPassenger {

            @Test
            @DisplayName("Then you cannot add or remove him from a premium flight")
            public void testPremiumFlightOrdinaryPassenger() {
                assertAll("Verify all conditions for a ordinary passenger and a premium flight",
                        () -> assertFalse(premiumFlight.addPassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size()),
                        () -> assertFalse(premiumFlight.removePassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {

            @Test
            //@Disabled
            @DisplayName("Then you can add and remove him from a premium flight")
            public void testPremiumFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and a premium flight",
                        () -> assertTrue(premiumFlight.addPassenger(john)),
                        () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                        () -> assertTrue(premiumFlight.removePassenger(john)),
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size())
                );
            }
        }
    }

}
