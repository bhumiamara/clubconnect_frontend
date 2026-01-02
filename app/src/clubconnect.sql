-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2026 at 09:58 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clubconnect`
--

-- --------------------------------------------------------

--
-- Table structure for table `announcements`
--

CREATE TABLE `announcements` (
  `id` int(11) NOT NULL,
  `club_name` varchar(150) NOT NULL,
  `announcement_title` varchar(200) NOT NULL,
  `announcement_text` text NOT NULL,
  `event_date` date DEFAULT NULL,
  `campus_block` varchar(100) DEFAULT NULL,
  `room_or_area` varchar(100) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `announcements`
--

INSERT INTO `announcements` (`id`, `club_name`, `announcement_title`, `announcement_text`, `event_date`, `campus_block`, `room_or_area`, `created_at`) VALUES
(1, 'Coding Club', 'Tech Talk Event', 'AI seminar for all students.', '2025-12-10', 'Block A', 'Room 204', '2025-12-05 08:35:59'),
(2, 'Drama Club', 'Drama Practice Session', 'Practice for the annual stage performance.', '2025-12-11', 'Arts Building', 'Auditorium', '2025-12-05 08:36:38'),
(3, 'Football Club', 'Morning Football Training', 'Warm-up and drills session for team players.', '2025-12-12', 'Sports Complex', 'Outdoor Field', '2025-12-05 08:37:03'),
(4, 'Coding Club', 'Hackathon Preparation Meet', 'All members must attend the prep session for the upcoming hackathon.', '2025-12-15', 'Engineering Block', 'Lab 5', '2025-12-05 08:37:30'),
(5, 'Music Club', 'Acoustic Jam Session', 'Open jam session for singers and instrumentalists.', '2025-12-16', 'Arts Block', 'Music Studio', '2025-12-05 08:37:40'),
(6, 'Dance Club', 'Group Dance Rehearsal', 'Practice session for upcoming cultural fest performance.', '2025-12-17', 'Auditorium Block', 'Dance Hall', '2025-12-05 08:37:49');

-- --------------------------------------------------------

--
-- Table structure for table `clubs`
--

CREATE TABLE `clubs` (
  `club_id` int(11) NOT NULL,
  `club_name` varchar(150) NOT NULL,
  `description` text DEFAULT NULL,
  `mentor` varchar(150) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clubs`
--

INSERT INTO `clubs` (`club_id`, `club_name`, `description`, `mentor`, `logo`, `created_at`) VALUES
(4, 'Music Club', 'Music and instrument events.', 'Mr. John', 'music.png', '2025-12-04 04:07:32'),
(5, 'Dance Club', 'Club for dance lovers', 'Dr. Kumar', 'dance.png', '2025-12-04 04:45:09'),
(6, 'robotics Club', 'robotics club interested people', 'Dr. ravi Kumar Updated', 'robotics_club.png', '2025-12-04 04:46:59'),
(7, 'Dance Club', 'Club for dance lovers', 'Dr. Kumar', 'dance.png', '2025-12-04 08:04:55'),
(8, 'arts Club', 'Club for artist', 'Dr. Kumari', 'arts.png', '2025-12-06 04:08:27'),
(9, 'yoga Club', 'Club for who interest in yoga', 'Dr.joshna', 'yoga.png', '2025-12-06 04:10:20');

-- --------------------------------------------------------

--
-- Table structure for table `club_chats`
--

CREATE TABLE `club_chats` (
  `chat_id` int(11) NOT NULL,
  `club_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `message` text NOT NULL,
  `sent_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `club_chats`
--

INSERT INTO `club_chats` (`chat_id`, `club_id`, `member_id`, `message`, `sent_at`) VALUES
(2, 4, 1, 'Hello everyone! Are we ready for the coding workshop tomorrow?', '2025-12-04 08:58:38'),
(5, 5, 3, 'yes,I am ready', '2025-12-04 09:12:56');

-- --------------------------------------------------------

--
-- Table structure for table `club_locations`
--

CREATE TABLE `club_locations` (
  `id` int(11) NOT NULL,
  `club_name` varchar(150) NOT NULL,
  `campus_block` varchar(100) NOT NULL,
  `room_or_area` varchar(100) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `event_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `club_locations`
--

INSERT INTO `club_locations` (`id`, `club_name`, `campus_block`, `room_or_area`, `description`, `event_time`) VALUES
(1, 'Coding Club', 'Engineering Labs', 'Lab 2', 'Weekly coding sessions', '2025-12-10 16:00:00'),
(2, 'Drama Club', 'Arts Building', 'Auditorium', 'Practice for annual play', '2025-12-11 15:00:00'),
(3, 'Football Club', 'Sports Complex', 'Outdoor Field', 'Morning practice', '2025-12-12 07:00:00'),
(4, 'Debate Club', 'Admin Block', 'Conference Room 1', 'Monthly debate competition', '2025-12-13 14:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `club_members`
--

CREATE TABLE `club_members` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `regno` varchar(100) NOT NULL,
  `club_id` int(11) NOT NULL,
  `joined_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `club_members`
--

INSERT INTO `club_members` (`id`, `user_id`, `name`, `regno`, `club_id`, `joined_at`) VALUES
(1, 101, 'Amara Mani', 'REG2025001', 1, '2025-12-04 05:07:18'),
(3, 102, 'bhumika', 'REG2025003', 2, '2025-12-04 05:09:54');

-- --------------------------------------------------------

--
-- Table structure for table `collaborations`
--

CREATE TABLE `collaborations` (
  `collab_id` int(11) NOT NULL,
  `club_id_1` int(11) NOT NULL,
  `club_id_2` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `description` text DEFAULT NULL,
  `collab_date` datetime NOT NULL,
  `location` varchar(150) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `collaborations`
--

INSERT INTO `collaborations` (`collab_id`, `club_id_1`, `club_id_2`, `title`, `description`, `collab_date`, `location`, `created_at`) VALUES
(2, 4, 5, 'AI & Coding Meetup', 'Joint session to explore AI projects.', '2025-03-10 10:00:00', 'Tech Seminar Hall', '2025-12-04 08:01:26'),
(4, 5, 6, 'dance & music Meetup', 'for entertainment', '2025-12-20 11:00:00', 'infront of simats building', '2025-12-04 08:14:14');

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `event_id` int(11) NOT NULL,
  `club_id` int(11) NOT NULL,
  `event_name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `event_date` date NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`event_id`, `club_id`, `event_name`, `description`, `event_date`, `location`, `created_at`) VALUES
(3, 4, 'Tech Workshop', 'AI session', '2025-01-29', 'Hall-A', '2025-12-04 06:44:28'),
(5, 5, 'Hackathon 2025', 'A 24-hour coding marathon for beginners and experts.', '2025-02-15', 'Tech Block - Lab 3', '2025-12-04 07:17:33'),
(6, 6, 'Acoustic Night', 'A musical evening with unplugged live performances.', '2025-02-20', 'Open Auditorium', '2025-12-04 07:18:23');

-- --------------------------------------------------------

--
-- Table structure for table `event_locations`
--

CREATE TABLE `event_locations` (
  `id` int(11) NOT NULL,
  `event_name` varchar(150) NOT NULL,
  `club_name` varchar(150) NOT NULL,
  `campus_block` varchar(100) NOT NULL,
  `room_or_area` varchar(100) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `event_date` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event_locations`
--

INSERT INTO `event_locations` (`id`, `event_name`, `club_name`, `campus_block`, `room_or_area`, `description`, `event_date`, `start_time`, `end_time`) VALUES
(1, 'Tech Talk 2025', 'Coding Club', 'Block A', 'Room 204', 'A seminar on AI and ML', '2025-12-10', '10:00:00', '12:00:00'),
(2, 'Drama Practice', 'Drama Club', 'Arts Building', 'Auditorium', 'Practice session for annual drama performance', '2025-12-11', '15:00:00', '17:00:00'),
(3, 'Football Training', 'Football Club', 'Sports Complex', 'Outdoor Field', 'Morning football warm-up and drills', '2025-12-12', '07:00:00', '09:00:00'),
(4, 'Photography Workshop', 'Photography Club', 'Media Block', 'Studio 1', 'Camera basics and lighting techniques', '2025-12-13', '11:00:00', '13:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `id` int(11) NOT NULL,
  `student_name` varchar(100) NOT NULL,
  `reg_no` varchar(50) NOT NULL,
  `department` varchar(100) NOT NULL,
  `project_title` varchar(255) NOT NULL,
  `report_date` date NOT NULL,
  `progress` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reports`
--

INSERT INTO `reports` (`id`, `student_name`, `reg_no`, `department`, `project_title`, `report_date`, `progress`) VALUES
(1, 'Bhumika Amara', '21CSR778', 'CSE', 'Advanced Reporting System', '2025-01-29', 'Completed UI design and API setup'),
(2, 'Rahul Kumar', '21CSR789', 'CSE', 'AI Attendance System', '2025-01-30', 'Integrated face recognition module'),
(3, 'Priya Sharma', '21ECE452', 'ECE', 'Smart Health Tracker', '2025-01-28', 'Finished sensor data mapping');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `roll` varchar(50) DEFAULT NULL,
  `email` varchar(150) NOT NULL,
  `department` varchar(50) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','member') NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `roll`, `email`, `department`, `password`, `role`, `created_at`) VALUES
(1, 'bhumika', NULL, 'amara@gmail.com', NULL, '12345', 'admin', '2025-12-01 04:37:51'),
(2, 'sandeep', NULL, 'sandeep05@gmail.com', NULL, 'pass5678', '', '2025-12-08 07:18:23'),
(4, 'sindhu', NULL, 'sindhu2002@gmail.com', NULL, '5678', '', '2025-12-08 07:22:57'),
(6, 'bhavya', NULL, 'bhavya@gmail.com', NULL, '9985', '', '2025-12-08 07:28:45'),
(7, 'd', '2344566', 'dhatchu1810@gmail.com', 'MECH', '123', 'member', '2025-12-13 04:06:14'),
(8, 'Dhatchayani G', '12457', 'dhatchuma1802@gmail.com', 'Electronics', '123', 'member', '2025-12-13 04:30:01'),
(21, 'Bhumika', '22CS101', 'bhumika@gmail.com', 'CSE', '123456', 'member', '2025-12-15 15:19:12');

-- --------------------------------------------------------

--
-- Table structure for table `volunteers`
--

CREATE TABLE `volunteers` (
  `volunteer_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `regno` varchar(100) NOT NULL,
  `club_id` int(11) NOT NULL,
  `club_name` varchar(150) NOT NULL,
  `task` varchar(255) DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `event_date` datetime DEFAULT NULL,
  `joined_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `volunteers`
--

INSERT INTO `volunteers` (`volunteer_id`, `member_id`, `name`, `regno`, `club_id`, `club_name`, `task`, `event_name`, `event_date`, `joined_at`) VALUES
(1, 103, 'Rohit Sharma', '22CS050', 5, 'music Club', 'Logistics', 'Tech Expo 2025', '2025-02-15 10:00:00', '2025-12-04 16:14:05'),
(2, 104, 'Sahana R', '22IT014', 3, 'dance Club', 'Registration Desk', 'Annual Fest 2025', '2025-03-12 09:00:00', '2025-12-04 16:14:34'),
(3, 105, 'Aarav Kumar', '22ME023', 5, 'coding Club', 'Backend Development', 'Tech Expo 2025', '2025-02-15 10:00:00', '2025-12-04 16:15:16'),
(4, 106, 'Riya Sharma', '22CS078', 2, 'dance Club', 'Content Creation', 'Hackathon 2025', '2025-04-05 11:00:00', '2025-12-04 16:15:52');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `announcements`
--
ALTER TABLE `announcements`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `clubs`
--
ALTER TABLE `clubs`
  ADD PRIMARY KEY (`club_id`);

--
-- Indexes for table `club_chats`
--
ALTER TABLE `club_chats`
  ADD PRIMARY KEY (`chat_id`),
  ADD KEY `club_id` (`club_id`),
  ADD KEY `member_id` (`member_id`);

--
-- Indexes for table `club_locations`
--
ALTER TABLE `club_locations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `club_members`
--
ALTER TABLE `club_members`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `collaborations`
--
ALTER TABLE `collaborations`
  ADD PRIMARY KEY (`collab_id`),
  ADD KEY `fk_club1` (`club_id_1`),
  ADD KEY `fk_club2` (`club_id_2`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`event_id`),
  ADD KEY `fk_club` (`club_id`);

--
-- Indexes for table `event_locations`
--
ALTER TABLE `event_locations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `volunteers`
--
ALTER TABLE `volunteers`
  ADD PRIMARY KEY (`volunteer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `announcements`
--
ALTER TABLE `announcements`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `clubs`
--
ALTER TABLE `clubs`
  MODIFY `club_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `club_chats`
--
ALTER TABLE `club_chats`
  MODIFY `chat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `club_locations`
--
ALTER TABLE `club_locations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `club_members`
--
ALTER TABLE `club_members`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `collaborations`
--
ALTER TABLE `collaborations`
  MODIFY `collab_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `event_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `event_locations`
--
ALTER TABLE `event_locations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `reports`
--
ALTER TABLE `reports`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `volunteers`
--
ALTER TABLE `volunteers`
  MODIFY `volunteer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `club_chats`
--
ALTER TABLE `club_chats`
  ADD CONSTRAINT `club_chats_ibfk_1` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `club_chats_ibfk_2` FOREIGN KEY (`member_id`) REFERENCES `club_members` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `collaborations`
--
ALTER TABLE `collaborations`
  ADD CONSTRAINT `fk_club1` FOREIGN KEY (`club_id_1`) REFERENCES `clubs` (`club_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_club2` FOREIGN KEY (`club_id_2`) REFERENCES `clubs` (`club_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `fk_club` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
