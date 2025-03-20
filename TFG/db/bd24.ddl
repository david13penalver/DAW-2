DROP DATABASE IF EXISTS besport24;
CREATE DATABASE besport24;
USE besport24;

CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    date_register TIMESTAMP NOT NULL
);

CREATE TABLE sessions (
    session_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    date_creation TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE exercises (
    exercise_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type_id INT NOT NULL,
    subtype_id INT,
    is_global BOOLEAN DEFAULT TRUE, /* Para los ejercicios de fuerza que puedan ser globales o analíticos */
    description VARCHAR(500),
    video_url VARCHAR(255),
    image_url VARCHAR(255),
    FOREIGN KEY (type_id) REFERENCES exercise_types(type_id) ON DELETE CASCADE,
    FOREIGN KEY (subtype_id) REFERENCES exercise_subtypes(subtype_id) ON DELETE CASCADE
);

CREATE TABLE sessions_exercises (
    sessions_exercises_id INT AUTO_INCREMENT PRIMARY KEY,
    session_id INT NOT NULL,
    exercise_id INT NOT NULL,
    num_sets INT,
    num_reps INT,
    rest_seconds INT,
    FOREIGN KEY (session_id) REFERENCES sessions(session_id) ON DELETE CASCADE,
    FOREIGN KEY (exercise_id) REFERENCES exercises(exercise_id) ON DELETE CASCADE
);

CREATE TABLE trainings (
    training_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    session_id INT NOT NULL,
    date_creation TIMESTAMP NOT NULL,
    training_duration_seconds INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (session_id) REFERENCES sessions(session_id) ON DELETE CASCADE
);

CREATE TABLE exercise_types (
    type_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);
/*
type_id name
1 Fuerza
2 Cardio
3 Movilidad
*/

CREATE TABLE exercise_subtypes (
    subtype_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
);
/*
subtype_id type_id name
1 1 Pecho
2 1 Espalda
3 1 Hombros
4 2 HIIT
5 2 SIT
6 2 LISS
7 3 Estiramiento estático
8 3 Estiramiento dinámico
9 3 Estiramiento balístico
10 3 Estiramiento pasivo
...
*/


/*
Futuras ampliaciones:
- Equipamiento
- Historial de progreso
- Programas semanales
- Multidioma
*/