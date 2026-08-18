# 🗳️ Online Voting System

A secure and robust backend REST API application built with **Spring Boot** to digitize and streamline the election voting process.

---

## 🚀 Features

* **Candidate Management:** Add new candidates with their respective names and political parties.
* **Voter Registration:** Register eligible voters uniquely using a Voter ID number.
* **Secure Voting Logic:** 
  * Validates if the voter is officially registered.
  * Ensures a single vote per voter by tracking their voting status (`hasVoted`).
* **Real-time Updates:** Automatically increments and records vote counts for candidates.

---

## 🛠️ Tech Stack

* **Language:** Java (JDK 21)
* **Framework:** Spring Boot, Spring Data JPA (Hibernate)
* **Database:** H2 Database (In-memory / Relational)
* **Build Tool:** Maven
* **IDE:** Eclipse

---

## ⚙️ Project Structure

```text
votingsystem
│
├── src/main/java/com/votingsystem
│   ├── OnlineVotingSystemApplication.java
│   ├── controller
│   │   └── VotingController.java
│   ├── model
│   │   ├── Candidate.java
│   │   └── Voter.java
│   └── repository
│       ├── CandidateRepository.java
│       └── VoterRepository.java
│
├── src/main/resources
│   └── application.properties
└── pom.xml
 API Endpoints Reference
 MethodEndpointDescription
POST/api/voting/candidateAdd a new candidate
GET/api/voting/candidatesRetrieve list of all candidates
POST/api/voting/voterRegister a new voter
POST/api/voting/vote?voterIdNumber=...&candidateId=...Cast a secure vote


 How to Run Locally
Clone the repository or open the project in Eclipse.
Ensure Maven dependencies are fully updated.
Run OnlineVotingSystemApplication.java as a Java Application.
The server will start on port 8080. Test the endpoints using Postman or your browser.