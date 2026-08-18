package com.votingsystem.controller;

import com.votingsystem.model.Candidate;
import com.votingsystem.model.Voter;
import com.votingsystem.repository.CandidateRepository;
import com.votingsystem.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/voting")
public class VotingController {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private VoterRepository voterRepository;

    @PostMapping("/candidate")
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @GetMapping("/candidates")
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @PostMapping("/voter")
    public Voter registerVoter(@RequestBody Voter voter) {
        return voterRepository.save(voter);
    }

    @PostMapping("/vote")
    public String castVote(@RequestParam String voterIdNumber, @RequestParam Long candidateId) {
        Optional<Voter> voterOpt = voterRepository.findByVoterIdNumber(voterIdNumber);
        
        if (!voterOpt.isPresent()) {
            return "Error: Voter not registered!";
        }

        Voter voter = voterOpt.get();
        if (voter.isHasVoted()) {
            return "Error: You have already voted!";
        }

        Optional<Candidate> candidateOpt = candidateRepository.findById(candidateId);
        if (!candidateOpt.isPresent()) {
            return "Error: Candidate not found!";
        }

        Candidate candidate = candidateOpt.get();
        candidate.setVotes(candidate.getVotes() + 1);
        candidateRepository.save(candidate);

        voter.setHasVoted(true);
        voterRepository.save(voter);

        return "Success: Vote casted successfully to " + candidate.getName();
    }
}