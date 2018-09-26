CREATE DATABASE IF NOT EXISTS test;
USE test;
DROP TABLE IF EXISTS part;
CREATE TABLE part(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    necessary boolean NOT NULL,
    count int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE part CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE UNIQUE INDEX part_name_uindex ON part (name);


INSERT INTO test.part (name, necessary, count) VALUES ('Motherboard', 1, 20);

INSERT INTO test.part (name, necessary, count) VALUES ('Soundboard', 0, 94);

INSERT INTO test.part (name, necessary, count) VALUES ('Video Card', 0, 94);

INSERT INTO test.part (name, necessary, count) VALUES ('Processor', 1, 20);

INSERT INTO test.part (name, necessary, count) VALUES ('Wi-Fi card', 0, 50);

INSERT INTO test.part (name, necessary, count) VALUES ('SATA Controller PCI-E', 0, 10);

INSERT INTO test.part (name, necessary, count) VALUES ('SATA Controller PCI', 0, 10);

INSERT INTO test.part (name, necessary, count) VALUES ('HDD', 1, 150);

INSERT INTO test.part (name,necessary, count) VALUES ('SSD', 0, 33);

INSERT INTO test.part (name,necessary, count) VALUES ('FDD', 0, 5);

INSERT INTO test.part (name,necessary, count) VALUES ('Mouse', 0, 150);

INSERT INTO test.part (name,necessary, count) VALUES ('Keyboard', 0, 200);

INSERT INTO test.part (name,necessary, count) VALUES ('Mid Tower for ATX', 1, 122);

INSERT INTO test.part (name,necessary, count) VALUES ('Card reader', 0, 27);

INSERT INTO test.part (name,necessary, count) VALUES ('CPU cooler', 1, 75);

INSERT INTO test.part (name,necessary, count) VALUES ('Tower cooler', 0, 75);

INSERT INTO test.part (name,necessary, count) VALUES ('RAID controller PCI', 0, 5);

INSERT INTO test.part (name,necessary, count) VALUES ('Monitor', 0, 57);

INSERT INTO test.part (name,necessary, count) VALUES ('LED for mid tower', 0, 85);

INSERT INTO test.part (name,necessary, count) VALUES ('RAM', 1, 60);

INSERT INTO test.part (name,necessary, count) VALUES ('TV tuner', 0, 130);

INSERT INTO test.part (name,necessary, count) VALUES ('COM controller PCI', 0, 10);

INSERT INTO test.part (name,necessary, count) VALUES ('LPT controller PCI', 0, 3);

INSERT INTO test.part (name,necessary, count) VALUES ('COM controller PCI-E', 0, 20);

INSERT INTO test.part (name,necessary, count) VALUES ('SAS controller PCI-E', 0, 9);

INSERT INTO test.part (name,necessary, count) VALUES ('USB 3.1/type-c controller', 0, 23);

INSERT INTO test.part (name,necessary, count) VALUES ('DVD-ROM', 0, 40);

INSERT INTO test.part (name,necessary, count) VALUES ('Power supply', 0, 120);