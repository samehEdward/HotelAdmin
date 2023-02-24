package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import java.time.LocalDateTime;


public class TestFixtures {

  /* ----------------------------- Booking --------------------------------------------------- */

  public static Booking bk1() {
    return new Booking("Booking1: 2 Persons", 3,
            LocalDateTime.of(2022, 2, 28, 16, 30),
            LocalDateTime.of(2022, 3, 3, 10, 15),
            BookingStatus.PENDING);
  }

  public static Booking bk2() {
    return new Booking("Booking2: 1 Person", 7,
            LocalDateTime.of(2021, 12, 27, 17, 30),
            LocalDateTime.of(2022, 1, 3, 10, 30),
            BookingStatus.CONFIRMED);
  }

  public static Booking bk3() {
    return new Booking("Booking3: 3 Persons", 5,
            LocalDateTime.of(2022, 2, 23, 15, 30),
            LocalDateTime.of(2022, 2 , 28, 8, 30),
            BookingStatus.PENDING);
  }

  public static Booking bk4() {
    return new Booking("Booking4: 5 Persons", 6,
            LocalDateTime.of(2021, 12, 25, 14, 30),
            LocalDateTime.of(2022, 1, 31, 9, 30),
            BookingStatus.CANCELED);
  }

  /* ----------------------------- Account --------------------------------------------------- */

  public static Account bc() {
    return new Account("Brietta_Cord", "b5665c", false, AccountType.GUEST);
  }

  public static Account jh() {
    return new Account("Jame_Host", "j1221h", false, AccountType.GUEST);
  }

  public static Account se() {
    return new Account("Sabina_Eden", "s3443e", false, AccountType.GUEST);
  }

  public static Account gb() {
    return new Account("Gardie_Brehat", "gb1002", true, AccountType.MEMBER);
  }

  public static Account lh() {
    return new Account("Leola_Husset", "lh8998", true, AccountType.MEMBER);
  }

  public static Account sd() {
    return new Account("Steffen_Dillingston", "sd9009", true, AccountType.MEMBER);
  }

  public static Account bg() {
    return new Account("Bernadene_Gardner", "B8778G", true, AccountType.ADMIN);
  }

  public static Account jr() {
    return new Account("Justin_Roan", "J7887R", true, AccountType.ADMIN);
  }


  /* ----------------------------- Room ------------------------------------------------------ */

  public static Room rm1() {
    return new Room("Room1", 80, false, true, false, RoomCategory.STANDARD);
  }

  public static Room rm2() {
    return new Room("Room2", 100, true, false, true, RoomCategory.STANDARD);
  }

  public static Room rm3() {
    return new Room("Room3", 150, false, true, false, RoomCategory.DELUXE);
  }

  public static Room rm4() {
    return new Room("Room4", 200, false, true, false, RoomCategory.FAMILY_SUITE);
  }

  public static Room rm5() {
    return new Room("Room5", 300, false, true, false,  RoomCategory.FAMILY_SUITE);
  }

  public static Room rm6() {
    return new Room("Room6", 250, true, false, true, RoomCategory.BUSINESS_SUITE);
  }
}
