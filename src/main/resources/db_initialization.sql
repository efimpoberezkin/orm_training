CREATE TABLE "flight" (
	"id" SERIAL NOT NULL,
	"from" varchar NOT NULL,
	"to" varchar NOT NULL,
	"departure" timestamp NOT NULL,
	"arrival" timestamp NOT NULL,
	"airplane_id" int4 NOT NULL,
	PRIMARY KEY("id")
);

CREATE TABLE "passenger" (
	"id" SERIAL NOT NULL,
	"name" varchar NOT NULL,
	"gender" varchar NOT NULL,
	PRIMARY KEY("id")
);

CREATE TABLE "passenger_contact_info" (
	"id" int4 NOT NULL,
	"email" varchar,
	"phone" varchar,
	PRIMARY KEY("id")
);

CREATE TABLE "airplane" (
	"id" SERIAL NOT NULL,
	"model_number" varchar NOT NULL,
	"capacity" int4 NOT NULL,
	PRIMARY KEY("id")
);

CREATE TABLE "booking" (
	"id" SERIAL NOT NULL,
	"flight_id" int4 NOT NULL,
	"passenger_id" int4 NOT NULL
);


ALTER TABLE "flight" ADD CONSTRAINT "flies" FOREIGN KEY ("airplane_id")
	REFERENCES "airplane"("id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "passenger_contact_info" ADD CONSTRAINT "has_contact_info" FOREIGN KEY ("id")
	REFERENCES "passenger"("id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "booking" ADD CONSTRAINT "has_booking" FOREIGN KEY ("flight_id")
	REFERENCES "flight"("id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "booking" ADD CONSTRAINT "books" FOREIGN KEY ("passenger_id")
	REFERENCES "passenger"("id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;