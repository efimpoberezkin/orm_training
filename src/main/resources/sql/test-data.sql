INSERT INTO "AIRPLANE" ("ID", "MODEL_NUMBER", "CAPACITY")
VALUES
(1, 'Boeing737', 150),
(2, 'Boeing777', 200);

INSERT INTO "FLIGHT" ("ID", "FROMLOC", "TOLOC", "DEPARTURE", "ARRIVAL", "AIRPLANE_ID")
VALUES
(1, 'A', 'B', '2017-10-10 10:00:00', '2017-10-10 13:00:00', 1),
(2, 'A', 'C', '2017-10-11 10:00:00', '2017-10-11 13:00:00', 2),
(3, 'B', 'A', '2017-10-16 10:00:00', '2017-10-16 13:00:00', 1),
(4, 'A', 'B', '2017-10-14 10:00:00', '2017-10-14 13:00:00', 1),
(5, 'B', 'A', '2017-10-12 10:00:00', '2017-10-12 13:00:00', 1),
(6, 'C', 'D', '2017-10-13 10:00:00', '2017-10-13 13:00:00', 2),
(7, 'D', 'A', '2017-10-15 10:00:00', '2017-10-15 13:00:00', 2);


INSERT INTO "PASSENGER" ("ID", "NAME", "GENDER")
VALUES
(1, 'John', 'MALE'),
(2, 'Emily', 'FEMALE'),
(3, 'Logan', 'MALE'),
(4, 'Jack', 'MALE'),
(5, 'Jaime', 'MALE'),
(6, 'Robin', 'FEMALE'),
(7, 'Anna', 'FEMALE'),
(8, 'Joanne', 'FEMALE'),
(9, 'Clark', 'MALE');

INSERT INTO "PASSENGER_CONTACT_INFO" ("PASSENGER_ID", "EMAIL", "PHONE")
VALUES
(2, 'Emilys email', 'Emilys phone'),
(3, 'Logans email', 'Logans phone'),
(5, 'Jaimes email', 'Jaimes phone'),
(6, 'Robins email', 'Robins phone'),
(7, 'Annas email', 'Annas email');

INSERT INTO "BOOKING" ("ID", "FLIGHT_ID", "PASSENGER_ID")
VALUES
(1, 1, 1),
(2, 1, 4),
(3, 1, 8),
(4, 2, 2),
(5, 2, 9),
(6, 2, 8),
(7, 3, 2),
(8, 3, 3),
(9, 4, 3),
(10, 4, 4),
(11, 4, 6),
(12, 4, 7),
(13, 5, 4),
(14, 5, 5),
(15, 5, 6),
(16, 6, 8),
(17, 6, 7),
(18, 7, 6),
(19, 7, 3),
(20, 7, 1),
(21, 7, 9),
(22, 7, 5);