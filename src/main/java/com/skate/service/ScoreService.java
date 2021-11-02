package com.skate.service;

import com.skate.model.Score;
import com.skate.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int scoreId) {
        return scoreRepository.getScore(scoreId);
    }

    public Score save(Score score) {
        if (score.getStarts() >= 0 && score.getStarts() <= 5) {
            if (score.getId() == null) {
                return scoreRepository.save(score);
            } else {
                Optional<Score> e = scoreRepository.getScore(score.getId());
                if (e.isEmpty()) {
                    return scoreRepository.save(score);
                }
            }

        }
        return score;
    }

    public Score update(Score score) {
        if (score.getId()!= null) {
            Optional<Score> puntaje = scoreRepository.getScore(score.getId());
            if (!puntaje.isEmpty()) {
                if (score.getMessageText() != null) {
                    puntaje.get().setMessageText(score.getMessageText());
                }
                if (score.getStarts()!= null && score.getStarts() >= 0 && score.getStarts() <= 5) {
                    puntaje.get().setStarts(score.getStarts());
                }
                scoreRepository.save(puntaje.get());
                return puntaje.get();
            } else {
                return score;
            }
        } else {
            return score;
        }
    }
}
