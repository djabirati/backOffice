-- Table Equipe
CREATE TABLE equipe (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(255) NOT NULL,
                        ville VARCHAR(100) NOT NULL,
                        logo VARCHAR(255)
);

-- Table Joueur
CREATE TABLE joueur (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(100) NOT NULL,
                        prenom VARCHAR(100) NOT NULL,
                        equipe_id BIGINT,
                        CONSTRAINT FK_Equipe FOREIGN KEY (equipe_id) REFERENCES equipe(id)
);

-- Table Match
CREATE TABLE matches (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         date DATETIME NOT NULL,
                         location VARCHAR(255) NOT NULL,
                         teamA_id BIGINT,
                         teamB_id BIGINT,
                         scoreA INT NOT NULL,
                         scoreB INT NOT NULL,
                         CONSTRAINT FK_TeamA FOREIGN KEY (teamA_id) REFERENCES equipe(id),
                         CONSTRAINT FK_TeamB FOREIGN KEY (teamB_id) REFERENCES equipe(id)
);

-- Table Billet
CREATE TABLE billet (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        type VARCHAR(50) NOT NULL,
                        categorie VARCHAR(50) NOT NULL,
                        prix DECIMAL(10, 2) NOT NULL
);

-- Insertion de données dans la table Equipe
INSERT INTO equipe (nom, ville, logo) VALUES
                                          ('Paris Saint-Germain', 'Paris', 'psg_logo.png'),
                                          ('Real Madrid', 'Madrid', 'real_madrid_logo.png'),
                                          ('FC Barcelona', 'Barcelone', 'barcelona_logo.png'),
                                          ('Manchester United', 'Manchester', 'man_utd_logo.png'),
                                          ('Bayern Munich', 'Munich', 'bayern_logo.png');

-- Insertion de données dans la table Joueur
INSERT INTO joueur (nom, prenom, equipe_id) VALUES
                                                ('Mbappé', 'Kylian', 1),
                                                ('Ramos', 'Sergio', 2),
                                                ('Messi', 'Lionel', 3),
                                                ('Rashford', 'Marcus', 4),
                                                ('Lewandowski', 'Robert', 5),
                                                ('Neymar', 'Junior', 1),
                                                ('Alaba', 'David', 2),
                                                ('De Jong', 'Frenkie', 3),
                                                ('Fernandes', 'Bruno', 4),
                                                ('Müller', 'Thomas', 5);

-- Insertion de données dans la table Match
INSERT INTO matches (date, location, teamA_id, teamB_id, scoreA, scoreB) VALUES
                                                                             ('2024-06-14 18:00:00', 'Parc des Princes', 1, 2, 2, 1),
                                                                             ('2024-06-15 19:00:00', 'Camp Nou', 3, 4, 3, 3),
                                                                             ('2024-06-16 20:00:00', 'Allianz Arena', 5, 2, 1, 2),
                                                                             ('2024-06-17 18:00:00', 'Old Trafford', 4, 1, 1, 0),
                                                                             ('2024-06-18 20:00:00', 'Santiago Bernabéu', 2, 3, 2, 2);

-- Insertion de données dans la table Billet
INSERT INTO billet (type, categorie, prix) VALUES
                                               ('VIP', 'Catégorie A', 300.00),
                                               ('Standard', 'Catégorie B', 150.00),
                                               ('Économique', 'Catégorie C', 75.00),
                                               ('VIP', 'Catégorie A', 320.00),
                                               ('Standard', 'Catégorie B', 160.00),
                                               ('Économique', 'Catégorie C', 80.00),
                                               ('VIP', 'Catégorie A', 350.00),
                                               ('Standard', 'Catégorie B', 170.00),
                                               ('Économique', 'Catégorie C', 85.00),
                                               ('VIP', 'Catégorie A', 280.00);