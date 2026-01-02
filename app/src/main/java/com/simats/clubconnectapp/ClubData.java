package com.simats.clubconnectapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClubData {

    private static final Map<String, ClubModel> clubs = new HashMap<>();

    static {
        // Coding Club Data
        List<Member> codingClubMembers = new ArrayList<>();
        codingClubMembers.add(new Member("Rahul Kumar", "CS001", "President"));
        codingClubMembers.add(new Member("Priya Sharma", "CS002", "Vice President"));

        List<ChatMessage> codingClubChat = new ArrayList<>();
        codingClubChat.add(new ChatMessage("Rahul Kumar", "CS001", "Hey everyone! Welcome to our club chat.", "10:30 AM"));

        List<Event> codingClubEvents = new ArrayList<>();
        codingClubEvents.add(new Event("AI Workshop Series - Part 2", "Dec 5, 2025", "2:00 PM - 5:00 PM", "Lab 301", "Hands-on session on Machine Learning basics"));
        codingClubEvents.add(new Event("Hackathon 2025", "Dec 10, 2025", "9:00 AM - 6:00 PM", "Main Auditorium", "24-hour coding competition with amazing prizes"));

        List<Project> codingClubProjects = new ArrayList<>();
        codingClubProjects.add(new Project("Club Management App", "Developing a mobile app to manage club activities, events, and members."));
        codingClubProjects.add(new Project("AI Chatbot for FAQs", "Building a chatbot to answer frequently asked questions about the club."));

        List<GalleryItem> codingClubGallery = new ArrayList<>();
        codingClubGallery.add(new GalleryItem(R.drawable.ic_codingproject, "AI Workshop Series - Part 1", "Nov 28, 2025", "Students learning AI concepts"));

        clubs.put("Coding Club", new ClubModel(
                "Coding Club",
                "Learn to code",
                "Welcome to Coding Club! We are a vibrant community of students passionate about learn to code. Join us to learn, collaborate, and grow together.",
                R.drawable.ic_laptop,
                "Dr. Smith",
                codingClubMembers,
                codingClubChat,
                codingClubEvents,
                codingClubProjects,
                codingClubGallery
        ));

        // Robotics Club Data
        List<Member> roboticsClubMembers = new ArrayList<>();
        roboticsClubMembers.add(new Member("Amit Patel", "CS003", "President"));
        roboticsClubMembers.add(new Member("Sneha Reddy", "CS004", "Vice President"));

        List<ChatMessage> roboticsClubChat = new ArrayList<>();
        roboticsClubChat.add(new ChatMessage("Amit Patel", "CS003", "Welcome to the Robotics Club chat!", "11:00 AM"));

        List<Event> roboticsClubEvents = new ArrayList<>();
        roboticsClubEvents.add(new Event("Robo Soccer Competition", "Dec 15, 2025", "10:00 AM - 1:00 PM", "Indoor Stadium", "Build a robot to compete in a soccer match."));
        roboticsClubEvents.add(new Event("Workshop on Drone Building", "Dec 20, 2025", "3:00 PM - 5:00 PM", "Robotics Lab", "Learn the basics of building and flying a drone."));

        List<Project> roboticsClubProjects = new ArrayList<>();
        roboticsClubProjects.add(new Project("Line Follower Robot", "Building a robot that can follow a black line on a white surface."));
        roboticsClubProjects.add(new Project("Obstacle Avoidance Robot", "A robot that can navigate without hitting obstacles."));

        List<GalleryItem> roboticsClubGallery = new ArrayList<>();

        clubs.put("Robotics Club", new ClubModel(
                "Robotics Club",
                "Build robots",
                "Welcome to the Robotics Club! We design, build, and program robots for fun and competition.",
                R.drawable.ic_robot,
                "Dr. Jones",
                roboticsClubMembers,
                roboticsClubChat,
                roboticsClubEvents,
                roboticsClubProjects,
                roboticsClubGallery
        ));

        // Music Club Data
        List<Member> musicClubMembers = new ArrayList<>();
        musicClubMembers.add(new Member("Aarav Sharma", "MC001", "Lead Singer"));
        musicClubMembers.add(new Member("Zara Khan", "MC002", "Guitarist"));
        musicClubMembers.add(new Member("Kabir Singh", "MC003", "Drummer"));
        musicClubMembers.add(new Member("Diya Mehta", "MC004", "Keyboardist"));
        musicClubMembers.add(new Member("Rohan Ali", "MC005", "Bassist"));
        musicClubMembers.add(new Member("Anika Gupta", "MC006", "Vocalist"));
        musicClubMembers.add(new Member("Vihaan Verma", "MC007", "Guitarist"));
        musicClubMembers.add(new Member("Ishaan Patel", "MC008", "Drummer"));
        musicClubMembers.add(new Member("Myra Reddy", "MC009", "Vocalist"));
        musicClubMembers.add(new Member("Arjun Kumar", "MC010", "Keyboardist"));
        musicClubMembers.add(new Member("Saanvi Desai", "MC011", "Bassist"));

        List<ChatMessage> musicClubChat = new ArrayList<>();
        musicClubChat.add(new ChatMessage("Aarav Sharma", "MC001", "Hey everyone, let's get ready for the battle of the bands!", "12:00 PM"));

        List<Event> musicClubEvents = new ArrayList<>();
        musicClubEvents.add(new Event("Battle of the Bands", "Dec 18, 2025", "6:00 PM - 9:00 PM", "Amphitheater", "An inter-college music competition."));
        musicClubEvents.add(new Event("Acoustic Night", "Dec 22, 2025", "7:00 PM - 9:00 PM", "Cafeteria", "An evening of unplugged music."));

        List<Project> musicClubProjects = new ArrayList<>();
        musicClubProjects.add(new Project("Original Song Composition", "Composing and recording an original song for the college anthem."));
        musicClubProjects.add(new Project("Music Video Production", "Creating a music video for the original song."));

        List<GalleryItem> musicClubGallery = new ArrayList<>();

        clubs.put("Music Club", new ClubModel(
                "Music Club",
                "Learn to sing",
                "The Music Club is for anyone who loves to sing or play an instrument.",
                R.drawable.ic_music,
                "Dr. Melody",
                musicClubMembers,
                musicClubChat,
                musicClubEvents,
                musicClubProjects,
                musicClubGallery
        ));

        // Dance Club Data
        List<Member> danceClubMembers = new ArrayList<>();
        danceClubMembers.add(new Member("Riya Singh", "DC001", "President"));
        danceClubMembers.add(new Member("Arnav Mehta", "DC002", "Vice President"));
        danceClubMembers.add(new Member("Ananya Rao", "DC003", "Choreographer"));
        danceClubMembers.add(new Member("Aditya Joshi", "DC004", "Treasurer"));
        danceClubMembers.add(new Member("Isha Sharma", "DC005", "Member"));
        danceClubMembers.add(new Member("Yash Gupta", "DC006", "Member"));
        danceClubMembers.add(new Member("Sanya Khan", "DC007", "Member"));
        danceClubMembers.add(new Member("Dev Kumar", "DC008", "Member"));
        danceClubMembers.add(new Member("Kiara Patel", "DC009", "Member"));
        danceClubMembers.add(new Member("Vivaan Reddy", "DC010", "Member"));
        danceClubMembers.add(new Member("Tara Malhotra", "DC011", "Member"));

        List<ChatMessage> danceClubChat = new ArrayList<>();
        danceClubChat.add(new ChatMessage("Riya Singh", "DC001", "Hi team! Practice for the flash mob is tomorrow at 5.", "1:00 PM"));

        List<Event> danceClubEvents = new ArrayList<>();
        danceClubEvents.add(new Event("Inter-College Dance Off", "Dec 21, 2025", "5:00 PM - 8:00 PM", "Main Stage", "The biggest dance competition of the year."));
        danceClubEvents.add(new Event("Flash Mob", "Dec 24, 2025", "1:00 PM", "Central Plaza", "A surprise performance for the college."));

        List<Project> danceClubProjects = new ArrayList<>();
        danceClubProjects.add(new Project("Annual Day Choreography", "Choreographing the main dance for the college annual day."));
        danceClubProjects.add(new Project("Dance Workshop for Beginners", "A workshop to teach basic dance styles to new students."));

        List<GalleryItem> danceClubGallery = new ArrayList<>();

        clubs.put("Dance Club", new ClubModel(
                "Dance Club",
                "Learn to Dance",
                "The Dance Club is a fun and energetic club for all dance lovers.",
                R.drawable.ic_dances,
                "Ms. Rhythms",
                danceClubMembers,
                danceClubChat,
                danceClubEvents,
                danceClubProjects,
                danceClubGallery
        ));

        // Football Club Data
        List<Member> footballClubMembers = new ArrayList<>();
        footballClubMembers.add(new Member("Rohan Kumar", "FC001", "Captain"));
        footballClubMembers.add(new Member("Arjun Singh", "FC002", "Vice-Captain"));
        footballClubMembers.add(new Member("Vikram Mehta", "FC003", "Goalkeeper"));
        footballClubMembers.add(new Member("Siddharth Verma", "FC004", "Defender"));
        footballClubMembers.add(new Member("Aditya Rao", "FC005", "Midfielder"));
        footballClubMembers.add(new Member("Aarav Gupta", "FC006", "Forward"));
        footballClubMembers.add(new Member("Ishaan Sharma", "FC007", "Defender"));
        footballClubMembers.add(new Member("Dev Joshi", "FC008", "Midfielder"));
        footballClubMembers.add(new Member("Yash Patel", "FC009", "Forward"));
        footballClubMembers.add(new Member("Kabir Khan", "FC010", "Goalkeeper"));
        footballClubMembers.add(new Member("Aryan Reddy", "FC011", "Defender"));

        List<ChatMessage> footballClubChat = new ArrayList<>();
        footballClubChat.add(new ChatMessage("Rohan Kumar", "FC001", "Practice match on Saturday at 7 AM. Be there!", "2:00 PM"));

        List<Event> footballClubEvents = new ArrayList<>();
        footballClubEvents.add(new Event("Inter-Department Tournament", "Jan 5, 2026", "9:00 AM - 5:00 PM", "University Grounds", "The annual inter-department football tournament."));
        footballClubEvents.add(new Event("Friendly Match vs. Alumni", "Jan 12, 2026", "3:00 PM - 5:00 PM", "University Grounds", "A friendly match against the alumni team."));

        List<Project> footballClubProjects = new ArrayList<>();
        footballClubProjects.add(new Project("Youth Training Camp", "Organizing a football training camp for school children."));
        footballClubProjects.add(new Project("Charity Match", "A charity match to raise funds for a local cause."));

        List<GalleryItem> footballClubGallery = new ArrayList<>();

        clubs.put("Football Club", new ClubModel(
                "Football Club",
                "Football team",
                "The Football Club is for all football lovers.",
                R.drawable.ic_footballl,
                "Mr. Coach",
                footballClubMembers,
                footballClubChat,
                footballClubEvents,
                footballClubProjects,
                footballClubGallery
        ));

        // Cricket Club Data
        List<Member> cricketClubMembers = new ArrayList<>();
        cricketClubMembers.add(new Member("Virat Sharma", "CC001", "Captain"));
        cricketClubMembers.add(new Member("Rohit Kumar", "CC002", "Vice-Captain"));
        cricketClubMembers.add(new Member("Jasprit Singh", "CC003", "Bowler"));
        cricketClubMembers.add(new Member("Rishabh Mehta", "CC004", "Wicket-keeper"));
        cricketClubMembers.add(new Member("Shikhar Rao", "CC005", "Batsman"));
        cricketClubMembers.add(new Member("Hardik Gupta", "CC006", "All-rounder"));
        cricketClubMembers.add(new Member("Ravindra Patel", "CC007", "All-rounder"));
        cricketClubMembers.add(new Member("Mohammed Shami", "CC008", "Bowler"));
        cricketClubMembers.add(new Member("Yuzvendra Khan", "CC009", "Bowler"));
        cricketClubMembers.add(new Member("Suresh Reddy", "CC010", "Batsman"));
        cricketClubMembers.add(new Member("Dinesh Malhotra", "CC011", "Wicket-keeper"));

        List<ChatMessage> cricketClubChat = new ArrayList<>();
        cricketClubChat.add(new ChatMessage("Virat Sharma", "CC001", "Net practice tomorrow at 6 AM sharp.", "3:00 PM"));

        List<Event> cricketClubEvents = new ArrayList<>();
        cricketClubEvents.add(new Event("Intra-College Cricket League", "Jan 10, 2026", "10:00 AM - 4:00 PM", "Cricket Ground", "The annual intra-college cricket league."));
        cricketClubEvents.add(new Event("Practice Match", "Jan 15, 2026", "1:00 PM - 4:00 PM", "Cricket Ground", "A practice match against the senior team."));

        List<Project> cricketClubProjects = new ArrayList<>();
        cricketClubProjects.add(new Project("Cricket for a Cause", "A charity cricket match to raise funds for underprivileged children."));
        cricketClubProjects.add(new Project("Talent Hunt", "A talent hunt to find new players for the college team."));


        List<GalleryItem> cricketClubGallery = new ArrayList<>();

        clubs.put("Cricket Club", new ClubModel(
                "Cricket Club",
                "Cricket team",
                "The Cricket Club is for all cricket lovers.",
                R.drawable.ic_cricketbat,
                "Mr. Master",
                cricketClubMembers,
                cricketClubChat,
                cricketClubEvents,
                cricketClubProjects,
                cricketClubGallery
        ));

        // NSS Club Data
        List<Member> nssMembers = new ArrayList<>();
        nssMembers.add(new Member("Aditi Singh", "NSS001", "Coordinator"));
        nssMembers.add(new Member("Ravi Kumar", "NSS002", "Volunteer"));
        nssMembers.add(new Member("Sunita Sharma", "NSS003", "Volunteer"));
        nssMembers.add(new Member("Anil Mehra", "NSS004", "Volunteer"));
        nssMembers.add(new Member("Pooja Gupta", "NSS005", "Volunteer"));
        nssMembers.add(new Member("Sanjay Verma", "NSS006", "Volunteer"));
        nssMembers.add(new Member("Deepika Rao", "NSS007", "Volunteer"));
        nssMembers.add(new Member("Amitesh Patel", "NSS008", "Volunteer"));
        nssMembers.add(new Member("Kavita Joshi", "NSS009", "Volunteer"));
        nssMembers.add(new Member("Rajesh Kumar", "NSS010", "Volunteer"));
        nssMembers.add(new Member("Anita Desai", "NSS011", "Volunteer"));

        List<ChatMessage> nssChat = new ArrayList<>();
        nssChat.add(new ChatMessage("Aditi Singh", "NSS001", "Blood donation camp on Monday. Spread the word!", "6:00 PM"));

        List<Event> nssEvents = new ArrayList<>();
        nssEvents.add(new Event("Blood Donation Camp", "Feb 5, 2026", "10:00 AM - 4:00 PM", "College Auditorium", "A blood donation camp to save lives."));
        nssEvents.add(new Event("Tree Plantation Drive", "Feb 10, 2026", "9:00 AM - 12:00 PM", "Campus Grounds", "A drive to plant trees and make our campus greener."));

        List<Project> nssProjects = new ArrayList<>();
        nssProjects.add(new Project("Swachh Bharat Abhiyan", "A cleanliness drive to keep our surroundings clean."));
        nssProjects.add(new Project("Teach for India", "A program to teach underprivileged children."));


        List<GalleryItem> nssGallery = new ArrayList<>();

        clubs.put("NSS Club", new ClubModel(
                "NSS Club",
                "National Service Scheme",
                "The National Service Scheme (NSS) is an Indian government-sponsored public service program conducted by the Ministry of Youth Affairs and Sports of the Government of India.",
                R.drawable.ic_community,
                "Mr. Social",
                nssMembers,
                nssChat,
                nssEvents,
                nssProjects,
                nssGallery
        ));

        // Social Service Club Data
        List<Member> socialServiceMembers = new ArrayList<>();
        socialServiceMembers.add(new Member("Neha Singh", "SSC001", "President"));
        socialServiceMembers.add(new Member("Rohan Gupta", "SSC002", "Vice President"));
        socialServiceMembers.add(new Member("Sonia Mehta", "SSC003", "Treasurer"));
        socialServiceMembers.add(new Member("Arun Verma", "SSC004", "Member"));
        socialServiceMembers.add(new Member("Geeta Sharma", "SSC005", "Member"));
        socialServiceMembers.add(new Member("Mohit Kumar", "SSC006", "Member"));
        socialServiceMembers.add(new Member("Sheela Rao", "SSC007", "Member"));
        socialServiceMembers.add(new Member("Pankaj Joshi", "SSC008", "Member"));
        socialServiceMembers.add(new Member("Rani Khan", "SSC009", "Member"));
        socialServiceMembers.add(new Member("Sunil Reddy", "SSC010", "Member"));
        socialServiceMembers.add(new Member("Mona Malhotra", "SSC011", "Member"));

        List<ChatMessage> socialServiceChat = new ArrayList<>();
        socialServiceChat.add(new ChatMessage("Neha Singh", "SSC001", "Our visit to the old age home is scheduled for this Saturday.", "7:00 PM"));

        List<Event> socialServiceEvents = new ArrayList<>();
        socialServiceEvents.add(new Event("Visit to Old Age Home", "Feb 15, 2026", "10:00 AM - 1:00 PM", "Sunshine Old Age Home", "Spending time with the elderly and distributing essentials."));
        socialServiceEvents.add(new Event("Fundraising Bake Sale", "Feb 20, 2026", "12:00 PM - 4:00 PM", "College Cafeteria", "A bake sale to raise funds for the upcoming charity drive."));

        List<Project> socialServiceProjects = new ArrayList<>();
        socialServiceProjects.add(new Project("Charity Drive for Orphans", "A drive to collect clothes, books, and toys for orphans."));
        socialServiceProjects.add(new Project("Adult Literacy Program", "A program to teach basic literacy skills to adults in the nearby slum."));


        List<GalleryItem> socialServiceGallery = new ArrayList<>();

        clubs.put("Social Service Club", new ClubModel(
                "Social Service Club",
                "Helping the community",
                "The Social Service Club is dedicated to helping the local community through various initiatives.",
                R.drawable.ic_socialservice,
                "Ms. Helper",
                socialServiceMembers,
                socialServiceChat,
                socialServiceEvents,
                socialServiceProjects,
                socialServiceGallery
        ));

        // Photography Club Data
        List<Member> photographyClubMembers = new ArrayList<>();
        photographyClubMembers.add(new Member("Aisha Kapoor", "PC001", "President"));
        photographyClubMembers.add(new Member("Rohan Mehra", "PC002", "Vice President"));
        photographyClubMembers.add(new Member("Sameer Ali", "PC003", "Treasurer"));
        photographyClubMembers.add(new Member("Priya Verma", "PC004", "Member"));
        photographyClubMembers.add(new Member("Aditi Sharma", "PC005", "Member"));
        photographyClubMembers.add(new Member("Karan Singh", "PC006", "Member"));
        photographyClubMembers.add(new Member("Sneha Gupta", "PC007", "Member"));
        photographyClubMembers.add(new Member("Arjun Joshi", "PC008", "Member"));
        photographyClubMembers.add(new Member("Rhea Khan", "PC009", "Member"));
        photographyClubMembers.add(new Member("Dhruv Kumar", "PC010", "Member"));
        photographyClubMembers.add(new Member("Anjali Nair", "PC011", "Member"));

        List<ChatMessage> photographyClubChat = new ArrayList<>();
        photographyClubChat.add(new ChatMessage("Aisha Kapoor", "PC001", "Photo walk this Sunday at 6 AM. Don't be late!", "4:00 PM"));

        List<Event> photographyClubEvents = new ArrayList<>();
        photographyClubEvents.add(new Event("Photography Exhibition", "Jan 20, 2026", "11:00 AM - 5:00 PM", "Art Gallery", "An exhibition of the best photographs taken by our members."));
        photographyClubEvents.add(new Event("Workshop on Portrait Photography", "Jan 25, 2026", "2:00 PM - 4:00 PM", "Studio A", "Learn the art of taking stunning portraits."));

        List<Project> photographyClubProjects = new ArrayList<>();
        photographyClubProjects.add(new Project("Campus Photo Album", "Creating a photo album of our college campus."));
        photographyClubProjects.add(new Project("Documentary on College Life", "A documentary showcasing the vibrant life on our campus."));

        List<GalleryItem> photographyClubGallery = new ArrayList<>();

        clubs.put("Photography Club", new ClubModel(
                "Photography Club",
                "Capture moments and learn photography",
                "The Photography Club is for those who love to capture the world through a lens.",
                R.drawable.ic_camera,
                "Mr. Clicks",
                photographyClubMembers,
                photographyClubChat,
                photographyClubEvents,
                photographyClubProjects,
                photographyClubGallery
        ));

        // Gaming Club Data
        List<Member> gamingClubMembers = new ArrayList<>();
        gamingClubMembers.add(new Member("Arjun Gupta", "GC001", "President"));
        gamingClubMembers.add(new Member("Diya Singh", "GC002", "Vice President"));
        gamingClubMembers.add(new Member("Rohan Kapoor", "GC003", "Treasurer"));
        gamingClubMembers.add(new Member("Zara Reddy", "GC004", "Member"));
        gamingClubMembers.add(new Member("Kabir Mehta", "GC005", "Member"));
        gamingClubMembers.add(new Member("Anika Ali", "GC006", "Member"));
        gamingClubMembers.add(new Member("Vihaan Kumar", "GC007", "Member"));
        gamingClubMembers.add(new Member("Ishaan Rao", "GC008", "Member"));
        gamingClubMembers.add(new Member("Myra Verma", "GC009", "Member"));
        gamingClubMembers.add(new Member("Aarav Joshi", "GC010", "Member"));
        gamingClubMembers.add(new Member("Saanvi Sharma", "GC011", "Member"));

        List<ChatMessage> gamingClubChat = new ArrayList<>();
        gamingClubChat.add(new ChatMessage("Arjun Gupta", "GC001", "LAN party this weekend! Get ready to frag!", "5:00 PM"));

        List<Event> gamingClubEvents = new ArrayList<>();
        gamingClubEvents.add(new Event("Valorant Tournament", "Jan 28, 2026", "12:00 PM - 6:00 PM", "Gaming Arena", "The ultimate Valorant tournament."));
        gamingClubEvents.add(new Event("Among Us Night", "Feb 2, 2026", "8:00 PM - 10:00 PM", "Discord Server", "A night of deception and fun."));

        List<Project> gamingClubProjects = new ArrayList<>();
        gamingClubProjects.add(new Project("Game Development Workshop", "A workshop to teach the basics of game development using Unity."));
        gamingClubProjects.add(new Project("Esports Team Tryouts", "Tryouts for the official college esports team."));

        List<GalleryItem> gamingClubGallery = new ArrayList<>();

        clubs.put("Gaming Club", new ClubModel(
                "Gaming Club",
                "Competitive gaming and esports",
                "The Gaming Club is for competitive and casual gamers alike.",
                R.drawable.ic_game,
                "Mr. Gamer",
                gamingClubMembers,
                gamingClubChat,
                gamingClubEvents,
                gamingClubProjects,
                gamingClubGallery
        ));
    }

    public static ClubModel getClub(String clubName) {
        return clubs.get(clubName);
    }
}
