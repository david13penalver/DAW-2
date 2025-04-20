-- USERS
INSERT INTO users (name, email, password, date_register) VALUES ('David Peñalver', 'david@mail.com', 'root1234', '2020-03-23 00:00:00'); -- 1
INSERT INTO users (name, email, password, date_register) VALUES ('Juan Pérez', 'juan@mail.com', 'root1234', '2020-04-24 00:00:00'); -- 2
INSERT INTO users (name, email, password, date_register) VALUES ('Cami del Castillo', 'cami@mail.com', 'root1234', '2020-05-25 00:00:00'); -- 3

-- SESSIONS
INSERT INTO sessions (user_id, name, description, date_creation) VALUES (1, 'Resistance 1', 'Full-body session', '2020-03-23 00:00:00'); -- 1
INSERT INTO sessions (user_id, name, description, date_creation) VALUES (1, 'Resistance 2', 'Upper-body session', '2020-03-24 00:00:00'); -- 2
INSERT INTO sessions (user_id, name, description, date_creation) VALUES (1, 'Resistance 3', 'Lower-body session', '2020-04-24 00:00:00'); -- 3
INSERT INTO sessions (user_id, name, description, date_creation) VALUES (1, 'HIIT 1', 'Extensive HIIT session', '2020-04-25 00:00:00'); -- 4
INSERT INTO sessions (user_id, name, description, date_creation) VALUES (1, 'HIIT 2', 'Intensive HIIT session', '2020-05-25 00:00:00'); -- 5
INSERT INTO sessions (user_id, name, description, date_creation) VALUES (1, 'SIT 2', 'Sprint Interval Training session', '2020-05-25 00:00:00'); -- 6
INSERT INTO sessions (user_id, name, description, date_creation) VALUES (1, 'Mobility 1', 'Ankle and hip mobility session', '2020-03-23 00:00:00'); -- 7
INSERT INTO sessions (user_id, name, description, date_creation) VALUES (1, 'Mobility 2', 'Shoulders mobility session', '2020-03-24 00:00:00'); -- 8
INSERT INTO sessions (user_id, name, description, date_creation) VALUES (1, 'Endurance 1', 'Sesión de resistencia extensiva', '2020-04-24 00:00:00'); -- 9
INSERT INTO sessions (user_id, name, description, date_creation) VALUES (1, 'Endurance 2', 'Sesión de resistencia extensiva', '2020-04-25 00:00:00'); -- 10

-- EXERCISE TYPES
INSERT INTO exercise_types (name) VALUES ('Resistance'); -- 1
INSERT INTO exercise_types (name) VALUES ('Endurance'); -- 2
INSERT INTO exercise_types (name) VALUES ('Mobility'); -- 3

-- EXERCISE SUBTYPES
INSERT INTO exercise_subtypes (name) VALUES ('Chest'); -- 1
INSERT INTO exercise_subtypes (name) VALUES ('Back'); -- 2
INSERT INTO exercise_subtypes (name) VALUES ('Shoulders'); -- 3
INSERT INTO exercise_subtypes (name) VALUES ('HIIT'); -- 4
INSERT INTO exercise_subtypes (name) VALUES ('SIT'); -- 5
INSERT INTO exercise_subtypes (name) VALUES ('LISS'); -- 6
INSERT INTO exercise_subtypes (name) VALUES ('Static Stretching'); -- 7
INSERT INTO exercise_subtypes (name) VALUES ('Dynamic Stretching'); -- 8
INSERT INTO exercise_subtypes (name) VALUES ('Ballistic Stretching'); -- 9
INSERT INTO exercise_subtypes (name) VALUES ('Passive Stretching'); -- 10
INSERT INTO exercise_subtypes (name) VALUES ('Leg'); -- 11
INSERT INTO exercise_subtypes (name) VALUES ('Core'); -- 12
INSERT INTO exercise_subtypes (name) VALUES ('Biceps'); -- 13
INSERT INTO exercise_subtypes (name) VALUES ('Glutes'); -- 14
INSERT INTO exercise_subtypes (name) VALUES ('Calves'); -- 15
INSERT INTO exercise_subtypes (name) VALUES ('Quadriceps'); -- 16
INSERT INTO exercise_subtypes (name) VALUES ('Hamstrings'); -- 17
INSERT INTO exercise_subtypes (name) VALUES ('Triceps'); -- 18


-- EXERCISES
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Squat', 1, 11, TRUE, '
{
  \"what_is\": "A squat is a fundamental strength exercise where you lower your hips from a standing position and then return to standing. It is widely used in fitness and sports training.",
  \"muscles_involved\": "Squats primarily work the quadriceps, hamstrings, and glutes. They also engage the core, lower back, and calves for stability and balance.",
  \"steps\": [
    \"Stand tall with your feet shoulder-width apart, toes slightly pointing outward.\",
    \"Engage your core and keep your chest up while maintaining a neutral spine.\",
    \"Lower your body by bending your knees and pushing your hips back, as if sitting on a chair.\",
    \"Go down until your thighs are at least parallel to the ground, keeping your knees aligned with your toes.\",
    \"Push back up by driving through your heels and straightening your legs.\",
    \"Return to the starting position and repeat for the desired number of repetitions.\"
  ]
}', 'https://www.youtube.com/watch?v=QKKZ9AGYTi4', 'https://www.google.com'); -- 1
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Dumbbell Bench Press', 1, 1, TRUE, '
{
    "what_is": "The dumbbell bench press is a strength training exercise that targets the chest, shoulders, and triceps by pressing dumbbells from a lying position.",
    "muscles_involved": "It primarily works the pectoral muscles (chest), anterior deltoids (front shoulders), and triceps. The stabilizing muscles, including the core, also play a role.",
    "steps": [
      "Lie on a bench with a dumbbell in each hand, palms facing forward.",
      "Position the dumbbells at chest level with elbows bent at about 90 degrees.",
      "Engage your core and push the dumbbells upward until your arms are fully extended.",
      "Slowly lower the dumbbells back to the starting position with control.",
      "Repeat for the desired number of repetitions."
    ]
}', 'https://youtu.be/7f5qqKgtTIU', 'https://www.google.com'); -- 2
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Single-Arm Dumbbell Row', 1, 2, TRUE, '
{
    "what_is": "The single-arm dumbbell row is an upper-body pulling exercise that targets the back and biceps while improving stability.",
    "muscles_involved": "It mainly targets the latissimus dorsi (lats), rhomboids, trapezius, and biceps. The core and lower back assist in stabilization.",
    "steps": [
      "Place your right knee and right hand on a bench for support, keeping your back straight.",
      "Hold a dumbbell in your left hand with your arm fully extended.",
      "Pull the dumbbell towards your torso by bending your elbow and squeezing your shoulder blade.",
      "Slowly lower the dumbbell back to the starting position.",
      "Repeat for the desired reps, then switch sides."
    ]
}', 'https://youtu.be/YB49K29o4UE', 'https://www.google.com'); -- 3
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Dumbbell Fly', 1, 1, FALSE, '
{
    "what_is": "The dumbbell fly is an isolation exercise that stretches and strengthens the chest muscles.",
    "muscles_involved": "It primarily works the pectoral muscles, with secondary engagement of the front deltoids and biceps.",
    "steps": [
      "Lie on a bench holding a dumbbell in each hand, palms facing inward.",
      "Extend your arms above your chest with a slight bend in the elbows.",
      "Lower the dumbbells in a wide arc until your chest feels a stretch.",
      "Bring the dumbbells back to the starting position by squeezing your chest muscles.",
      "Repeat for the desired number of repetitions."
    ]
}', 'https://youtu.be/OBP4efoGK50', 'https://www.google.com'); -- 4
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Dumbbell Shoulder Press', 1, 3, TRUE, '
{
    "what_is": "The dumbbell shoulder press is a strength training exercise that targets the shoulders and triceps by pressing dumbbells overhead.",
    "muscles_involved": "It primarily works the deltoid muscles (especially the anterior deltoid) and the triceps, with secondary engagement of the upper chest.",
    "steps": [
      "Sit or stand with a dumbbell in each hand at shoulder height, palms facing forward.",
      "Engage your core and press the dumbbells overhead until your arms are fully extended.",
      "Slowly lower the dumbbells back to shoulder height.",
      "Repeat for the desired number of repetitions."
    ]
}', 'https://youtu.be/i3TVr3y9tXw', 'https://www.google.com'); -- 5
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Bulgarian Split Squat', 1, 11, TRUE, '
{
    "what_is": "The Bulgarian split squat is a single-leg strength exercise that improves balance and lower-body strength.",
    "muscles_involved": "It primarily targets the quadriceps, glutes, and hamstrings, with additional core engagement for stability.",
    "steps": [
      "Stand a few feet in front of a bench and place one foot behind you on the bench.",
      "Hold a dumbbell in each hand for added resistance.",
      "Lower your body by bending the front knee until your thigh is parallel to the ground.",
      "Push through the front foot to return to the starting position.",
      "Repeat for the desired reps, then switch legs."
    ]
}', 'https://youtu.be/le5Te09G19o', 'https://www.google.com'); -- 6
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Dynamic Lunge', 1, 11, TRUE, '
{
    "what_is": "The dynamic lunge is a lower-body exercise that involves alternating lunges forward and backward to improve strength, balance, and coordination.",
    "muscles_involved": "It primarily works the quadriceps, hamstrings, glutes, and calves, with core engagement for stability.",
    "steps": [
      "Stand tall with your feet hip-width apart.",
      "Step forward with one leg and lower your body until both knees form 90-degree angles.",
      "Push off the front foot to return to the starting position.",
      "Immediately step back with the same leg into a reverse lunge.",
      "Return to the starting position and repeat on the other side."
    ]
}', 'https://youtu.be/-KqS7d--ihY', 'https://www.google.com'); -- 7
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Static Lunge', 1, 11, TRUE, '
{
    "what_is": "The static lunge is a lower-body exercise that builds leg and glute strength while improving balance and stability.",
    "muscles_involved": "It primarily targets the quadriceps, glutes, and hamstrings, with core activation for balance.",
    "steps": [
      "Stand with one foot forward and one foot back, keeping your feet hip-width apart.",
      "Hold a dumbbell in each hand or place your hands on your hips for stability.",
      "Lower your body by bending both knees until your back knee is just above the ground.",
      "Push through the front foot to return to the starting position.",
      "Repeat for the desired reps, then switch legs."
    ]
}', 'https://youtu.be/vicDgQNTxCI', 'https://www.google.com'); -- 8
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Intensive HIIT Cycling', 2, 4, TRUE, '
{
    "what_is": "Intensive HIIT cycling consists of short but very intense intervals, maximizing anaerobic power and improving VO2 max.",
    "muscles_involved": "It mainly works the quadriceps, hamstrings, glutes, and calves, with significant cardiovascular demand and lactate tolerance adaptation.",
    "steps": [
      "Warm up for 10-15 minutes at a moderate pace.",
      "Perform 6-12 intervals of 30-60 seconds at 90-100% of your maximum effort.",
      "Recover with 1-2 minutes of very light pedaling between intervals.",
      "Maintain high cadence and controlled power output.",
      "Cool down with 5-10 minutes of easy pedaling."
    ]
}', 'https://youtu.be/1f3eLJtjD3A', 'https://www.google.com'); -- 9
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Extensive HIIT Cycling', 2, 4, TRUE, '
{
    "what_is": "Extensive HIIT cycling is a high-intensity interval training session with moderate work intensity and longer intervals, designed to improve endurance and aerobic capacity.",
    "muscles_involved": "It primarily engages the quadriceps, hamstrings, glutes, and calves, with core activation for stability. The cardiovascular system is also heavily involved.",
    "steps": [
      "Warm up for 10-15 minutes at an easy pace.",
      "Perform 6-10 intervals of 2-4 minutes at 80-90% of your maximum effort.",
      "Recover with 1-2 minutes of low-intensity pedaling between intervals.",
      "Maintain good cycling posture and controlled breathing.",
      "Cool down with 5-10 minutes of light pedaling."
    ]
}', 'https://youtu.be/1f3eLJtjD3A', 'https://www.google.com'); -- 10
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Intensive HIIT Running', 2, 4, TRUE, '
{
    "what_is": "Intensive HIIT running involves short, high-intensity intervals at near-maximal effort, enhancing anaerobic power and VO2 max.",
    "muscles_involved": "It primarily targets the quadriceps, hamstrings, glutes, and calves, with significant cardiovascular and neuromuscular demands.",
    "steps": [
      "Warm up with 10-15 minutes of light jogging and dynamic mobility drills.",
      "Perform 6-12 intervals of 30-60 seconds at 90-100% of your maximum sprint speed.",
      "Recover with 1-2 minutes of walking or slow jogging between intervals.",
      "Maintain an upright posture and strong arm drive.",
      "Cool down with 5-10 minutes of easy jogging and stretching."
    ]
}', 'https://youtu.be/1f3eLJtjD3A', 'https://www.google.com'); -- 11
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Extensive HIIT Running', 2, 4, TRUE, '
{
    "what_is": "Extensive HIIT running consists of moderate-intensity intervals with longer durations, improving aerobic endurance and running economy.",
    "muscles_involved": "It primarily targets the quadriceps, hamstrings, glutes, and calves, with core activation for posture and stability.",
    "steps": [
      "Warm up with 10-15 minutes of light jogging and dynamic stretches.",
      "Perform 6-10 intervals of 2-4 minutes at 80-90% of your maximum speed.",
      "Recover with 1-2 minutes of slow jogging or walking between intervals.",
      "Focus on efficient running form and even pacing.",
      "Cool down with 5-10 minutes of easy jogging."
    ]
}', 'https://youtu.be/1f3eLJtjD3A', 'https://www.google.com'); -- 12
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Sprint Interval Training (SIT) Running', 2, 5, TRUE, '
{
    "what_is": "Sprint Interval Training (SIT) is an ultra-high-intensity workout consisting of all-out sprints with full recovery, maximizing anaerobic capacity and sprint power.",
    "muscles_involved": "It heavily engages the quadriceps, hamstrings, glutes, calves, and hip flexors, with extreme cardiovascular and neuromuscular demands.",
    "steps": [
      "Warm up with 15 minutes of light jogging and dynamic sprint drills.",
      "Perform 4-6 sprints of 20-30 seconds at 100% effort.",
      "Recover with 3-5 minutes of complete rest (walking or standing).",
      "Maintain explosive acceleration and maximum speed throughout each sprint.",
      "Cool down with 10 minutes of easy jogging and mobility exercises."
    ]
}', 'https://youtu.be/1f3eLJtjD3A', 'https://www.google.com'); -- 13
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Light jogging', 2, 6, TRUE, '
{
    "what_is": "Light jogging is a low-intensity aerobic exercise that involves running at a comfortable pace, suitable for recovery, warm-up, or active rest.",
    "muscles_involved": "It mainly works the quadriceps, hamstrings, glutes, and calves, with minimal impact on the joints and cardiovascular system.",
    "steps": [
      "Start with a brisk walk to warm up your muscles.",
      "Transition into a light jog at a pace where you can hold a conversation.",
      "Maintain good posture and relaxed breathing throughout the run.",
      "Gradually increase or decrease speed based on your fitness level and goals.",
      "Cool down with a slow walk and stretching."
    ]
}', 'https://youtu.be/1f3eLJtjD3A', 'https://www.google.com'); -- 14
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Hip Flexion Lying Down Stretching', 3, 7, TRUE, '
{
    "what_is": "The hip flexion lying down stretch targets the hip flexors and lower back, improving flexibility and reducing tightness in the hip area.",
    "muscles_involved": "It stretches the iliopsoas, rectus femoris, and other hip flexor muscles, with secondary engagement of the lower back and glutes.",
    "steps": [
      "Lie on your back with your legs extended and arms by your sides.",
      "Bend your right knee and hug it towards your chest, keeping the left leg straight.",
      "Hold the stretch for 20-30 seconds, feeling a gentle pull in the front of your hip.",
      "Switch legs and repeat the stretch on the other side.",
      "Perform 2-3 sets on each leg for optimal flexibility."
    ]
}', 'https://youtu.be/-9OrRjAnn5k', 'https://www.google.com'); -- 15
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Ankle Dorsiflexion Stretching', 3, 7, TRUE, '
{
    "what_is": "The ankle dorsiflexion stretch targets the calf muscles and Achilles tendon, improving ankle mobility and reducing stiffness.",
    "muscles_involved": "It stretches the gastrocnemius, soleus, and Achilles tendon, with secondary engagement of the shin muscles.",
    "steps": [
      "Stand facing a wall with your hands on the wall for support.",
      "Step back with one foot and keep it straight, heel on the ground.",
      "Bend the front knee and lean forward to stretch the back calf.",
      "Hold the stretch for 20-30 seconds, feeling a gentle pull in the calf.",
      "Switch legs and repeat the stretch on the other side."
    ]
}', 'https://youtu.be/XOu7AVuhB2k', 'https://www.google.com'); -- 16
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Hip Flexion With Stick Stretching', 3, 7, TRUE, '
{
    "what_is": "The hip flexion with stick stretch targets the hip flexors and quadriceps, improving flexibility and reducing tightness in the front of the hip.",
    "muscles_involved": "It stretches the iliopsoas, rectus femoris, and other hip flexor muscles, with secondary engagement of the quadriceps and lower back.",
    "steps": [
      "Kneel on the ground with a stick or dowel behind you.",
      "Place your right foot forward and hold the stick with both hands.",
      "Lean forward, pushing your hips towards the ground to stretch the front of the hip.",
      "Hold the stretch for 20-30 seconds, feeling a gentle pull in the hip and thigh.",
      "Switch legs and repeat the stretch on the other side."
    ]
}', 'https://youtu.be/zdPGE65iJEQ', 'https://www.google.com'); -- 17
INSERT INTO exercises (name, type_id, subtype_id, is_global, description, video_url, image_url) VALUES ('Hip Flexion Stretching', 3, 7, TRUE, '
{
    "what_is": "The hip flexion stretch targets the hip flexors and quadriceps, improving flexibility and reducing tightness in the front of the hip.",
    "muscles_involved": "It stretches the iliopsoas, rectus femoris, and other hip flexor muscles, with secondary engagement of the quadriceps and lower back.",
    "steps": [
      "Kneel on the ground with one knee down and the other foot forward.",
      "Shift your weight forward and push your hips down and forward to stretch the front of the hip.",
      "Hold the stretch for 20-30 seconds, feeling a gentle pull in the hip and thigh.",
      "Switch legs and repeat the stretch on the other side.",
      "Perform 2-3 sets on each leg for optimal flexibility."
    ]
}', 'https://youtu.be/W6E_xMCxomg', 'https://www.google.com'); -- 18
/*
ACCESS TO DESCRIPTIONS:

struct Exercise: Codable {
    let whatIs: String
    let musclesInvolved: String
    let steps: [String]
    
    enum CodingKeys: String, CodingKey {
        case whatIs = "what_is"
        case musclesInvolved = "muscles_involved"
        case steps
    }
}
*/

-- SESSIONS_EXERCISES
-- Session 1: Full-body
INSERT INTO sessions_exercises (session_id, exercise_id, num_sets, num_reps, rest_seconds) 
VALUES -- Full-Body Session
(1, 1, 4, 10, 60), -- Squat
(1, 2, 4, 8, 90),  -- Dumbbell Bench Press
(1, 3, 3, 12, 45), -- Single-Arm Dumbbell Row
(1, 4, 3, 10, 60), -- Dumbbell Fly
(1, 5, 3, 12, 45); -- Dumbbell Shoulder Press

-- Session 2: Upper-body
INSERT INTO sessions_exercises (session_id, exercise_id, num_sets, num_reps, rest_seconds)
VALUES
(2, 2, 4, 8, 90),  -- Dumbbell Bench Press
(2, 3, 4, 8, 75),  -- Single-Arm Dumbbell Row
(2, 4, 4, 10, 60), -- Dumbbell Fly
(2, 5, 3, 12, 45); -- Dumbbell Shoulder Press

-- Session 3: Lower-body
INSERT INTO sessions_exercises (session_id, exercise_id, num_sets, num_reps, rest_seconds)
VALUES
(3, 1, 4, 10, 60), -- Squat
(3, 6, 4, 10, 60), -- Bulgarian Split Squat
(3, 7, 4, 12, 45), -- Dynamic Lunge
(3, 8, 4, 12, 45); -- Static Lunge

-- Session 4: HIIT 1
INSERT INTO sessions_exercises (session_id, exercise_id, num_sets, num_reps, rest_seconds)
VALUES
(5, 14, 1, 10, 60); -- Light jogging
(4, 9, 6, 30, 60); -- Intensive HIIT Cycling
(5, 14, 1, 5, 60); -- Light jogging

-- Session 5: SIT 1
INSERT INTO sessions_exercises (session_id, exercise_id, num_sets, num_reps, rest_seconds)
VALUES
(5, 14, 1, 10, 60); -- Light jogging
(5, 13, 6, 20, 60); -- Sprint Interval Training (SIT) Running
(5, 14, 1, 5, 60); -- Light jogging

-- TRAININGS
INSERT INTO trainings (name, user_id, session_id, date_creation, training_duration_seconds)
VALUES
('Entrenamiento 1: Full-body resistance training', 1, 1, '2020-03-23 00:00:00', 3600), -- Full-body session
('Entrenamiento 2: Upper-body resistance training', 1, 2, '2020-03-24 00:00:00', 2700), -- Upper-body session
('Entrenamiento 1: Lower-body resistance training', 2, 3, '2020-04-24 00:00:00', 2700); -- Lower-body session