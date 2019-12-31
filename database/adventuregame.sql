DROP TABLE IF EXISTS players;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS backpack;
DROP TABLE IF EXISTS weapons;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS collectables;
DROP TABLE IF EXISTS treasurechests;
DROP TABLE IF EXISTS monsters;
DROP TABLE IF EXISTS npcs;


DROP SEQUENCE IF EXISTS reservation_reservation_id_seq;
DROP SEQUENCE IF EXISTS site_site_id_seq;
DROP SEQUENCE IF EXISTS campground_campground_id_seq;
DROP SEQUENCE IF EXISTS park_park_id_seq;

CREATE SEQUENCE park_park_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE players (
  park_id integer DEFAULT nextval('park_park_id_seq'::regclass) NOT NULL,
  name varchar(80) NOT NULL,          -- Name of the player/character
  health integer(100) NOT NULL,       -- Health of character at last save
  location varchar(50) NOT NULL,      -- Location of player at last save
  save_date date NOT NULL,             -- Date last save was created
  play_time varchar(50) NOT NULL,          -- Total elapsed play time
  score integer NOT NULL
);

CREATE SEQUENCE campground_campground_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE TABLE locations (
  location_id integer NOT NULL,
  name varchar(100) NOT NULL,
  treasures integer[],
  monsters integer[],
  entryways integer[] NOT NULL,
  description varchar(500) NOT NULL
);
  

CREATE TABLE backpack (
  backpack_id integer NOT NULL,          
  storage_size integer NOT NULL,              
  items integer[]
  
);


CREATE TABLE site (
  site_id integer DEFAULT nextval('site_site_id_seq'::regclass) NOT NULL,
  campground_id integer NOT NULL,
  site_number integer NOT NULL,                   -- Site numbers are
  max_occupancy integer NOT NULL DEFAULT 6,       -- Sites are limited to 6 people, however some sites are "doubled" (12 people)
  accessible boolean NOT NULL DEFAULT FALSE,      -- Accessible site, reserved for campers with disabilities
  max_rv_length integer NOT NULL DEFAULT 0,       -- RVs/Trailers not permitted if length is 0
  utilities boolean NOT NULL DEFAULT FALSE,       -- Electricity, running water available.
  CONSTRAINT pk_site_site_number_campground_id PRIMARY KEY (site_id)
);

CREATE SEQUENCE reservation_reservation_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE reservation (
  reservation_id integer DEFAULT nextval('reservation_reservation_id_seq'::regclass) NOT NULL,
  site_id integer NOT NULL,
  name varChar(80) NOT NULL,
  from_date date NOT NULL,
  to_date date NOT NULL,
  create_date date NOT NULL DEFAULT now(),
  CONSTRAINT pk_reservation_reservation_id PRIMARY KEY (reservation_id)
);