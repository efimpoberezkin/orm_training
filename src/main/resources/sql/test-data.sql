INSERT INTO airplane (id, model_number, capacity)
VALUES
(1, "Boeing737", 150),
(2, "Boeing777", 200);

INSERT INTO flight (id, from, to, departure, arrival, airplane_id)
VALUES
(1, "A", "B", "2017-10-10 10:00:00", "2017-10-10 13:00:00", 1),
(2, "B", "A", "2017-10-12 10:00:00", "2017-10-12 13:00:00", 1),
(3, "C", "D", "2017-10-14 10:00:00", "2017-10-14 13:00:00", 2);

INSERT INTO passenger (id, name, gender)
VALUES
(1, "John", "MALE"),
(2, "Jack", "MALE"),
(3, "Emily", "FEMALE"),
(4, "Susan", "FEMALE");

INSERT INTO passenger_contact_info (id, email, phone)
VALUES
(2, "Jack's email", "Jack's phone"),
(3, "Emily's email", "Emily's phone");

INSERT INTO booking (id, flight_id, passenger_id)
VALUES
(1, 1, 1),
(2, 1, 3),
(3, 2, 1),
(4, 2, 3),
(5, 2, 4),
(6, 3, 2),
(7, 3, 4);