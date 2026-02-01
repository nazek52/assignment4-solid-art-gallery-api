DROP TABLE IF EXISTS artworks;
DROP TABLE IF EXISTS artists;

CREATE TABLE artists (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE artworks (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    type VARCHAR(50) NOT NULL,
    technique VARCHAR(100),
    weight INT,
    ascii_art TEXT,
    artist_id INT,
    CONSTRAINT fk_artist
        FOREIGN KEY (artist_id)
        REFERENCES artists(id)
        ON DELETE SET NULL
);

INSERT INTO artists (name) VALUES
('Vincent van Gogh'),
('Leonardo da Vinci'),
('Auguste Rodin');
