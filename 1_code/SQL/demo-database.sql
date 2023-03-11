DROP DATABASE IF EXISTS sql_ticket_manager;
CREATE DATABASE sql_ticket_manager;
USE sql_ticket_manager;

CREATE TABLE seating_mode (
	id INT NOT NULL AUTO_INCREMENT,
    seating VARCHAR(10),
    PRIMARY KEY (id)
);

INSERT INTO seating_mode (seating)
	VALUES
		('Standard'),
        ('Priority'),
        ('Assigned'),
        ('Restricted');

CREATE TABLE rooms (
	id INT NOT NULL AUTO_INCREMENT,
	room_name VARCHAR(255) NOT NULL,
    showing VARCHAR(255),
    seat_rows INT NOT NULL,
    seat_columns INT NOT NULL,
    total_capacity INT NOT NULL,
    used_seats INT NOT NULL DEFAULT 0,
    seating_mode INT NOT NULL DEFAULT 1,
    
    PRIMARY KEY (id),
    FOREIGN KEY (seating_mode) REFERENCES seating_mode(id)
);

INSERT INTO rooms (room_name, showing, total_capacity, seat_rows, seat_columns, seating_mode)
	VALUES
		('West Wing', 'Jaws', 200, 20, 10, 1),
		('East Wing', 'Raiders of the Lost Ark', 150, 10, 15, 1),
		('Central Room', 'Jurrasic Park', 156, 12, 13, 3);

SELECT * FROM rooms;

UPDATE rooms
	SET seating_mode = 2
	WHERE id = 2;

SELECT * FROM rooms;

INSERT INTO rooms (room_name, showing, total_capacity, seat_rows, seat_columns)
	VALUES ('New Room', 'Avengers', 100, 20, 5);

SELECT * FROM rooms;