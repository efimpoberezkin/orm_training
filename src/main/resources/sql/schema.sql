CREATE TABLE "flight" (
	"id" integer PRIMARY KEY,
 	"from" varchar(20),
 	"to" varchar(20),
 	"departure" timestamp,
 	"arrival" timestamp,
 	"airplane_id" integer
);

CREATE TABLE "passenger" (
 	"id" integer PRIMARY KEY,
 	"name" varchar(20),
 	"gender" varchar(20)
);

CREATE TABLE "passenger_contact_info" (
 	"id" integer NOT NULL,
 	"email" varchar(20),
 	"phone" varchar(20)
);

CREATE TABLE "airplane" (
	"id" integer PRIMARY KEY,
	"model_number" varchar(20),
 	"capacity" integer
);

CREATE TABLE "booking" (
 	"id" integer PRIMARY KEY,
 	"flight_id" integer,
 	"passenger_id" integer
);


ALTER TABLE "flight" ADD CONSTRAINT "flies" FOREIGN KEY ("airplane_id")
 	REFERENCES "airplane"("id")
 	MATCH SIMPLE
 	ON DELETE NO ACTION
 	ON UPDATE NO ACTION;

ALTER TABLE "passenger_contact_info" ADD CONSTRAINT "has_contact_info" FOREIGN KEY ("id")
	REFERENCES "passenger"("id")
 	MATCH SIMPLE
 	ON DELETE NO ACTION
 	ON UPDATE NO ACTION;

ALTER TABLE "booking" ADD CONSTRAINT "has_booking" FOREIGN KEY ("flight_id")
 	REFERENCES "flight"("id")
 	MATCH SIMPLE
 	ON DELETE NO ACTION
 	ON UPDATE NO ACTION;

ALTER TABLE "booking" ADD CONSTRAINT "books" FOREIGN KEY ("passenger_id")
	REFERENCES "passenger"("id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION;