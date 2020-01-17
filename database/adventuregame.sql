DROP TABLE IF EXISTS players;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS backpack;
DROP TABLE IF EXISTS weapons;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS collectables;
DROP TABLE IF EXISTS treasure_chests;
DROP TABLE IF EXISTS monsters;
DROP TABLE IF EXISTS npcs;


DROP SEQUENCE IF EXISTS players_player_id_seq;

CREATE SEQUENCE players_player_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE players (
  player_id integer DEFAULT nextval('players_player_id_seq'::regclass) NOT NULL,
  player_name varchar(80) NOT NULL,          -- Name of the player/character
  health integer NOT NULL,       -- Health of character at last save
  damage integer, 
  experience int NOT NULL,
  level int NOT NULL,
  player_location integer NOT NULL,      -- Location of player at last save
  save_date date NOT NULL,             -- Date last save was created
  play_time varchar(50) NOT NULL,          -- Total elapsed play time
  score integer NOT NULL
  
);

  
CREATE TABLE locations (
  location_id integer NOT NULL,
  location_name varchar(100) NOT NULL,
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

CREATE TABLE weapons (
  weapon_name varchar(100) NOT NULL,
  description varchar(500) NOT NULL, 
  damage integer NOT NULL,
  durability integer NOT NULL, 
  has_magic boolean, 
  has_curse boolean 
);

CREATE TABLE items (
  item_id integer NOT NULL,
  name varchar(100) NOT NULL, 
  description varchar(500) NOT NULL, 
  quantity integer NOT NULL,
  has_damage boolean, 
  damage integer,
  has_poison boolean, 
  poison_damage integer, 
  has_heal boolean, 
  heal integer,
  has_boost boolean, 
  boost integer 
);


CREATE TABLE collectables (
  name varchar(100) NOT NULL, 
  description varchar(500) NOT NULL, 
  effect varchar(100) NOT NULL, 
  effect_amount integer 
);

CREATE TABLE treasure_chests ( 
  name varchar(100), 
  location integer NOT NULL,
  description varchar(500) NOT NULL,
  needs_key boolean NOT NULL, 
  items integer[],
  collectables integer[]
);

CREATE TABLE monsters (
  name varchar(100) NOT NULL, 
  description varchar(500) NOT NULL,
  health integer NOT NULL,
  damage integer NOT NULL, 
  defense integer NOT NULL, 
  weakness varchar(100), 
  magic_effect varchar(100)
);

CREATE TABLE npcs (
  name varchar(100) NOT NULL, 
  description varchar(500) NOT NULL,
  greeting varchar(500),
  health integer NOT NULL,
  damage integer NOT NULL, 
  defense integer NOT NULL, 
  weakness varchar(100), 
  magic_effect varchar(100), 
  sale_items integer[], 
  advice varchar(500), 
  money integer
);

INSERT into locations (location_id, location_name, entryways, description) values (1, 'Wooded Path', '{2, 3, 4}', 'You are standing on a dirt path, with dark pine forests surrounding you. Your head throbs, and you cannot remember how you got here. Behind you, a sheer cliff face into blackness. Ahead lies a fork in the path. To the left, a twisting path leads up rocky mountains to what looks like a massive glass building through the clearing in the trees. To the right, the path leads down into the depths of the woods, with what sounds like water rushing swiftly through a canyon.');